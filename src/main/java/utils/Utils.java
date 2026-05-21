package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto.Arma;
import proyecto.Armaduras;
import proyecto.Entidad;
import proyecto.Habilidades;
import proyecto.Heroe;

public class Utils {
	private final static String stringConnector = "jdbc:mysql://localhost:3306/progra3t";
	private final static String user = "root";
	private final static String pass = "";

	private static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(stringConnector, user, pass);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Arma obtenerArma(int id) {
		Arma arma = null;
		String query = "SELECT * FROM armas WHERE id = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {

					String nombre = rs.getString("nombre");
					int dano = rs.getInt("dano");
					int precision = rs.getInt("precision");
					boolean esMelee = rs.getBoolean("esMelee");
					int municionMax = rs.getInt("municionMax");
					int cantidadObjetivos = rs.getInt("cantidadObjetivos");
					int numAtaques = rs.getInt("numAtaques");

					arma = new Arma(nombre, dano, precision, esMelee, municionMax, cantidadObjetivos, numAtaques);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arma;
	}

	public static Armaduras obtenerArmadura(int id) {
		Armaduras armadura = null;
		String query = "SELECT * FROM armaduras WHERE id = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					String nombre = rs.getString("nombre");
					int blindaje = rs.getInt("blindaje");
					int velocidad = rs.getInt("velocidad");

					armadura = new Armaduras(nombre, blindaje, velocidad);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return armadura;
	}

	public static int[] obtenerIdsEquipamientoPersonaje(String nombrePersonaje) {
		int[] ids = new int[2];
		String query = "SELECT id_arma, id_armadura FROM personajes WHERE nombre = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, nombrePersonaje);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {

					ids[0] = rs.getInt("id_arma");
					ids[1] = rs.getInt("id_armadura");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ids;
	}

	public static void guardarPersonajesUsados(List<Entidad> personajes, int idPartida, int numMision, int numTurno) {
		String queryInsert = "INSERT INTO personajes_usados (id_partida, id_entidad, VidaActual, turnoStun, turnoHemorragia, turnoVeneno, turnoCuracion, defendido, esHeroe, num_mision, num_turno) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String queryId = "SELECT id_entidad FROM entidad WHERE nombre = ?";

		try (Connection con = getConnection();
				PreparedStatement psInsert = con.prepareStatement(queryInsert);
				PreparedStatement psId = con.prepareStatement(queryId)) {

			for (Entidad personaje : personajes) {
				int idEntidad = -1;
				psId.setString(1, personaje.getNombre());
				try (ResultSet rs = psId.executeQuery()) {
					if (rs.next()) {
						idEntidad = rs.getInt("id_entidad");
					}
				}

				if (idEntidad != -1) {
					psInsert.setInt(1, idPartida);
					psInsert.setInt(2, idEntidad);
					psInsert.setInt(3, personaje.getVida());
					psInsert.setInt(4, personaje.getTurnoStun());
					psInsert.setInt(5, personaje.getTurnoHemorragia());
					psInsert.setInt(6, personaje.getTurnoVeneno());
					psInsert.setInt(7, personaje.getTurnoCuracion());
					psInsert.setBoolean(8, personaje.getDefendido());
					psInsert.setBoolean(9, personaje instanceof Heroe);
					psInsert.setInt(10, numMision);
					psInsert.setInt(11, numTurno);

					psInsert.executeUpdate();
				} else {
					System.out.println(
							"No se encontró el ID en la base de datos para el personaje: " + personaje.getNombre());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void registrarKills(List<Entidad> posiblesMuertos, Entidad atacante) {
		String queryId = "SELECT id_entidad FROM entidad WHERE nombre = ?";
		String queryUpdate = "UPDATE registro_kills SET cantidad = cantidad + 1 WHERE id_entidad = ? AND id_victima = ?";

		try (Connection con = getConnection();
				PreparedStatement psId = con.prepareStatement(queryId);
				PreparedStatement psUpdate = con.prepareStatement(queryUpdate)) {

			// Obtener ID del atacante
			int idAtacante = -1;
			psId.setString(1, atacante.getNombre());
			try (ResultSet rs = psId.executeQuery()) {
				if (rs.next()) {
					idAtacante = rs.getInt("id_entidad");
				}
			}

			if (idAtacante == -1)
				return;

			for (Entidad objetivo : posiblesMuertos) {
				if (objetivo.getVida() <= 0) {
					// Obtener ID del victima
					int idVictima = -1;
					psId.setString(1, objetivo.getNombre());
					try (ResultSet rs = psId.executeQuery()) {
						if (rs.next()) {
							idVictima = rs.getInt("id_entidad");
						}
					}

					if (idVictima != -1) {
						psUpdate.setInt(1, idAtacante);
						psUpdate.setInt(2, idVictima);
						psUpdate.executeUpdate();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Entidad> cargarPersonajesUsados(int idPartida, int numTurno) {
		List<Entidad> personajesCargados = new ArrayList<>();
		String query = "SELECT pu.VidaActual, pu.turnoStun, pu.turnoHemorragia, pu.turnoVeneno, pu.turnoCuracion, " +
				"pu.defendido, pu.esHeroe, e.nombre, e.faccion, e.id_arma, e.id_armadura, e.id_arma2 " +
				"FROM personajes_usados pu " +
				"JOIN entidad e ON pu.id_entidad = e.id_entidad " +
				"WHERE pu.id_partida = ? AND pu.num_turno = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idPartida);
			ps.setInt(2, numTurno);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					int vidaActual = rs.getInt("VidaActual");
					int turnoStun = rs.getInt("turnoStun");
					int turnoHemorragia = rs.getInt("turnoHemorragia");
					int turnoVeneno = rs.getInt("turnoVeneno");
					int turnoCuracion = rs.getInt("turnoCuracion");
					boolean defendido = rs.getBoolean("defendido");
					boolean esHeroe = rs.getBoolean("esHeroe");

					String nombre = rs.getString("nombre");
					String faccion = rs.getString("faccion");
					int idArma = rs.getInt("id_arma");
					int idArmadura = rs.getInt("id_armadura");
					int idArma2 = rs.getInt("id_arma2");

					Arma arma = obtenerArma(idArma);
					Armaduras armadura = obtenerArmadura(idArmadura);
					List<Habilidades> habilidades = new ArrayList<>();
					Arma arma2 = null;
					if (idArma2 > 0) {
						arma2 = obtenerArma(idArma2);
					}

					Entidad personaje;
					if (esHeroe) {
						for (proyecto.ListaHeroes h : proyecto.ListaHeroes.values()) {
							if (h.getNombre().equals(nombre)) {
								Heroe temp = h.crearInstancia();
								habilidades = temp.getHabilidades();
								break;
							}
						}
						personaje = new Heroe(nombre, faccion, vidaActual, arma, armadura, habilidades, arma2);
					} else {
						for (proyecto.ListaEnemigos e : proyecto.ListaEnemigos.values()) {
							if (e.getNombre().equals(nombre)) {
								Entidad temp = e.crearInstancia();
								habilidades = temp.getHabilidades();
								break;
							}
						}
						personaje = new Entidad(nombre, faccion, vidaActual, arma, armadura, habilidades);
					}

					personaje.setTurnoStun(turnoStun);
					personaje.setTurnoHemorragia(turnoHemorragia);
					personaje.setTurnoVeneno(turnoVeneno);
					personaje.setTurnoCuracion(turnoCuracion);
					personaje.setDefendido(defendido);

					personajesCargados.add(personaje);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personajesCargados;
	}

	public static void guardarPartida(String nombreJugador, int numMision, int numTurno) {
		String query = "INSERT INTO partidas (nombre_jugador, num_mision, num_turno) VALUES (?, ?, ?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, nombreJugador);
			ps.setInt(2, numMision);
			ps.setInt(3, numTurno);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
