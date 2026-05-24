package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;

import proyecto.Arma;
import proyecto.Armaduras;
import proyecto.Entidad;
import proyecto.Habilidades;
import proyecto.Heroe;

/**
 * Clase de utilidades que proporciona métodos estáticos para la interacción
 * con la base de datos (guardado, carga, recuperación de entidades) y la
 * generación de gráficos mediante la librería XChart.
 */
public class Utils {
	private final static String stringConnector = "jdbc:mysql://localhost:3306/progra3t";
	private final static String user = "root";
	private final static String pass = "";

	/**
	 * Establece y devuelve una conexión a la base de datos MySQL.
	 * 
	 * @return Objeto Connection activo, o null si hay un error.
	 */
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

	/**
	 * Recupera un arma de la base de datos a partir de su ID.
	 * 
	 * @param id El identificador único del arma en la base de datos.
	 * @return Una instancia de la clase Arma con los datos recuperados, o null si
	 *         no se encuentra.
	 */
	public static Arma obtenerArma(int id) {
		Arma arma = null;
		String query = "SELECT * FROM arma WHERE id_arma = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {

					String nombre = rs.getString("nombre");
					int dano = rs.getInt("dano");
					int precision = rs.getInt("precision_arma");
					boolean esMelee = rs.getBoolean("esMeele");
					int municionMax = rs.getInt("municionMax");
					int cantidadObjetivos = rs.getInt("cantidadObjetivo");
					int numAtaques = rs.getInt("numAtaque");

					arma = new Arma(nombre, dano, precision, esMelee, municionMax, cantidadObjetivos, numAtaques);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arma;
	}

	/**
	 * Recupera una armadura de la base de datos a partir de su ID.
	 * 
	 * @param id El identificador único de la armadura en la base de datos.
	 * @return Una instancia de la clase Armaduras con los datos recuperados, o null
	 *         si no se encuentra.
	 */
	public static Armaduras obtenerArmadura(int id) {
		Armaduras armadura = null;
		String query = "SELECT * FROM armadura WHERE id_armadura = ?";
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

	/**
	 * Obtiene los IDs del arma y la armadura asociados a un personaje específico en
	 * la base de datos.
	 * 
	 * @param nombrePersonaje El nombre del personaje a buscar.
	 * @return Un array de enteros de tamaño 2 donde el índice 0 es el id_arma y el
	 *         índice 1 es el id_armadura.
	 */
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

	/**
	 * Guarda el estado actual de una lista de personajes (vida, turnos de efectos,
	 * etc.)
	 * en la base de datos, asociándolo a una partida, misión y turno específicos.
	 * 
	 * @param personajes Lista de entidades (héroes o enemigos) a guardar.
	 * @param idPartida  El identificador de la partida actual.
	 * @param numMision  El número de la misión en curso.
	 * @param numTurno   El número del turno actual dentro del combate.
	 */
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

	/**
	 * Elimina registros futuros de personajes usados en la base de datos al cargar
	 * una partida.
	 * Esto evita inconsistencias borrando cualquier turno que haya ocurrido después
	 * del punto de guardado.
	 * 
	 * @param idPartida El ID de la partida a limpiar.
	 * @param numMision El número de la misión cargada.
	 * @param numTurno  El número del turno cargado.
	 */
	public static void limpiarTurnosFuturos(int idPartida, int numMision, int numTurno) {
		String query = "DELETE FROM personajes_usados WHERE id_partida = ? AND (num_mision > ? OR (num_mision = ? AND num_turno >= ?))";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idPartida);
			ps.setInt(2, numMision);
			ps.setInt(3, numMision);
			ps.setInt(4, numTurno);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Actualiza el registro de asesinatos (kills) en la base de datos.
	 * Verifica si algún objetivo en la lista ha muerto y le suma la muerte al
	 * atacante.
	 * 
	 * @param posiblesMuertos Lista de entidades que acaban de recibir daño.
	 * @param atacante        La entidad que realizó el ataque.
	 */
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

	/**
	 * Reconstruye y carga una lista de entidades (héroes y enemigos) a partir de
	 * su estado guardado en la base de datos para una partida, misión y turno
	 * exactos.
	 * 
	 * @param idPartida El ID de la partida.
	 * @param numMision El número de la misión a cargar.
	 * @param numTurno  El número del turno específico a cargar.
	 * @return Lista con los personajes instanciados y con sus estadísticas
	 *         restauradas.
	 */
	public static List<Entidad> cargarPersonajesUsados(int idPartida, int numMision, int numTurno) {
		List<Entidad> personajesCargados = new ArrayList<>();
		String query = "SELECT pu.VidaActual, pu.turnoStun, pu.turnoHemorragia, pu.turnoVeneno, pu.turnoCuracion, " +
				"pu.defendido, pu.esHeroe, e.nombre, e.faccion, e.id_arma, e.id_armadura, e.id_arma2 " +
				"FROM personajes_usados pu " +
				"JOIN entidad e ON pu.id_entidad = e.id_entidad " +
				"WHERE pu.id_partida = ? AND pu.num_mision = ? AND pu.num_turno = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idPartida);
			ps.setInt(2, numMision);
			ps.setInt(3, numTurno);
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

	/**
	 * Registra el resultado final de una partida en la base de datos cuando el
	 * jugador pierde.
	 * 
	 * @param nombreJugador El nombre que el usuario introduce al perder.
	 * @param numMision     El total de misiones a las que logró sobrevivir.
	 * @param numTurno      El turno de la misión actual en la que fue derrotado.
	 * @param dificultad    La dificultad elegida para la partida (1, 2 o 3).
	 */
	public static void guardarPartida(String nombreJugador, int numMision, int numTurno, int dificultad) {
		String query = "INSERT INTO partidas (nombre_jugador, num_mision, num_turno, dificultad) VALUES (?, ?, ?, ?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, nombreJugador);
			ps.setInt(2, numMision);
			ps.setInt(3, numTurno);
			ps.setInt(4, dificultad);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Actualiza los datos finales (misión y turno de muerte) de una partida
	 * que fue cargada desde un guardado anterior.
	 * 
	 * @param idPartida El ID de la partida cargada que se va a actualizar.
	 * @param numMision La misión en la que finalmente murió el jugador.
	 * @param numTurno  El turno en el que finalmente murió el jugador.
	 */
	public static void actualizarPartida(int idPartida, int numMision, int numTurno) {
		String query = "UPDATE partidas SET num_mision = ?, num_turno = ? WHERE id_partida = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, numMision);
			ps.setInt(2, numTurno);
			ps.setInt(3, idPartida);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Calcula cuál será el ID de la próxima partida a crear.
	 * Útil para reservar el ID de partida antes de guardarla definitivamente.
	 * 
	 * @return El siguiente ID disponible (max_id + 1).
	 */
	public static int obtenerSiguienteIdPartida() {
		int nextId = 1;
		String query = "SELECT MAX(id_partida) AS max_id FROM partidas";
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				nextId = rs.getInt("max_id") + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nextId;
	}

	/**
	 * Recupera el nivel de dificultad asociado a una partida específica.
	 * 
	 * @param idPartida El ID de la partida a consultar.
	 * @return Un entero representando la dificultad, por defecto 1 si no se
	 *         encuentra.
	 */
	public static int obtenerDificultadPartida(int idPartida) {
		int dificultad = 1;
		String query = "SELECT dificultad FROM partidas WHERE id_partida = ? LIMIT 1";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idPartida);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					dificultad = rs.getInt("dificultad");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dificultad;
	}

	/**
	 * Imprime en la consola un diseño en ASCII art del Águila Imperial de Warhammer
	 * 40k.
	 */
	public static void imprimirAguila() {
		System.out.print("\u001B[32m"); // Color verde (Adeptus Mechanicus)
		System.out.println("Bienvenido al RPG de Warhammer 40k");
		System.out.println(
				"@@@@@@@@@@@@@@@@@@%@@%@@@@%@@@@@@@@@@@@@@@@@@@@@@%@%@@*                                         %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@@@@@@@@@  ");
		System.out.println(
				"    #@@@@@@@@@@@@@@@@@@@@@%@@@@@@@%@@@@@@%%@@@@@*    @@#                                             %%#    %%%%%%%%%%%%%%%%%%%%%%%%%%%@%%%%%%@%@%@@@@@@#    ");
		System.out.println(
				"      @@@                                            %                                                %%                                           :@@@      ");
		System.out.println(
				"                                                    %%            @%%@                 %%%%            %%                                                    ");
		System.out.println(
				"                                    #%@@@%@@@+     @%         -@%   %-  %.         +%  #%   %%.         %%     %%%%%%%%%=                                    ");
		System.out.println(
				"                   *@@@@@@@@@@@@@@@%=             .%%         %%:      %%%%+     %%%%%      #%%         %%              %%%%%%%%%%%%%%%%%:                   ");
		System.out.println(
				"            @@@@@@@@@@@@@@%-                    +%%%%                  %%%%%%   %%%%%*                  %%%%                     #%%%%%@%@@@%%%@%            ");
		System.out.println(
				"             -@@@@-                       %%%@    #%%                    %%%  %  %%%                    %%     %%%+                       #%%%%              ");
		System.out.println(
				"                                    @@@%%:        *@@                     %   %  %                     %%%         %%%%%%                                    ");
		System.out.println(
				"                             .@%@%%@%          #%   @%.             %@%      %%%      %%%             %%%   %           %%%%%%@                              ");
		System.out.println(
				"                       #@@@@@%@@.           @@      @%%%%%    %%%%%%%%%%    -%%%    %%%%%%%%%%%    %%%%%%     #%#           #%%%%%%%%.                       ");
		System.out.println(
				"                     @@%@@@@             %%@      %%   %%%%%%%%%%%%   %%%%  %%%%@  %%%+  #%%%%%%%%%%%%  %%=      %%%             @%%%@%@                     ");
		System.out.println(
				"                                      @%%       -%%    %   %      %+  %%%  %%%%%%   %%   %=  %   %   %    %%       #%%%              #                       ");
		System.out.println(
				"                                  #@@@%        %%:    %    -   %      %%+  %%%%%%%  %%%      %   %   #     %%%        %%%%                                   ");
		System.out.println(
				"                               @%@@%         %%@     %%   %   @%     %%%  %%%%%%%%   %%      %    %   %      %%%        #%%%%*                               ");
		System.out.println(
				"                             @%@@%         #%%+     %%   -%   %%=   %%%   %%%%%%%%%  #%%    %%%   %    %      %%%          %%%%%                             ");
		System.out.println(
				"                                          @%@      @%    %.   %    %%%%  %%%%%%%%%%=  %%%%    %   %%   :%       %%%          +                               ");
		System.out.println(
				"                                        %@%%      @%+   #@   #   -%%%%   %%%%%%%%%%%   %%%%        %    %%       %%%%                                        ");
		System.out.println(
				"                                      @%%@       %%%    %%        %%@   %%%%%%%%%%%%%  %%%%        %%    %%        %%%-                                      ");
		System.out.println(
				"                                      %@@       @%@    @@           %   %%%%%%@%%%%%%   -          %%     %%        %%%                                      ");
		System.out.println(
				"                                               %@@     *               %@%%%%%%%%%%%%%               %    %%%                                                ");
		System.out.println(
				"                                              @%%@                    :%%%%%%%%%@%%%%%                     %%%                                               ");
		System.out.println(
				"                                                                       =@%@%%%%%%%%%%                                                                        ");
		System.out.println(
				"                                                                          %%@%%%%%%                                                                          ");
		System.out.println(
				"                                                                     @%     %%%%% :  #%                                                                      ");
		System.out.println(
				"                                                                    %%   = .  % %  %   %                                                                     ");
		System.out.println(
				"                                                                   *%   %  %  %  %  %   %                                                                    ");
		System.out.println(
				"                                                                  -*   %  %# %%  %  .%   %%    %                                                             ");
		System.out.println(
				"                                                             %   %=       %  %@# #@      %:    %                                                             ");
		System.out.println(
				"                                                                    *    %%  %@@  %     %                                                                    ");
		System.out.println(
				"                                                               %    %%      +%%%      .@%   #                                                                ");
		System.out.println(
				"                                                              %             %%%%             %                                                               ");
		System.out.println(
				"                                                             @@               %               %                                                              ");
		System.out.println(
				"                                                              @                               #                                                              ");
		System.out.println();
	}

	/**
	 * Muestra por consola las partidas, misiones y turnos guardados disponibles y
	 * guía
	 * al usuario a través del proceso interactivo para seleccionar un punto de
	 * guardado.
	 * 
	 * @return Un array de enteros de tamaño 3 con el formato: [idPartida,
	 *         numMision, numTurno],
	 *         o null si el jugador no hace una selección válida o no hay partidas.
	 */
	public static int[] cargarPartidaGuardada() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n=== PARTIDAS GUARDADAS ===");
		String queryPartidas = "SELECT DISTINCT id_partida FROM personajes_usados ORDER BY id_partida";
		List<Integer> partidasIds = new ArrayList<>();
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(queryPartidas);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("id_partida");
				partidasIds.add(id);
				System.out.println("- Partida ID: " + id);
			}
		} catch (SQLException e) {
			System.out.println("Error al recuperar las partidas: " + e.getMessage());
		}

		if (partidasIds.isEmpty()) {
			System.out.println("No hay partidas guardadas.");
			return null;
		}

		int idSeleccionado = -1;
		while (true) {
			System.out.print("\nIntroduzca el ID de la partida que desea cargar: ");
			if (scanner.hasNextInt()) {
				idSeleccionado = scanner.nextInt();
				if (partidasIds.contains(idSeleccionado)) {
					break;
				} else {
					System.out.println("ID no encontrado. Inténtelo de nuevo.");
				}
			} else {
				System.out.println("Entrada inválida. Debe ser un número entero.");
				scanner.next(); // Limpiar entrada incorrecta
			}
		}

		System.out.println("\n=== MISIONES DISPONIBLES PARA LA PARTIDA " + idSeleccionado + " ===");
		String queryMisiones = "SELECT DISTINCT num_mision FROM personajes_usados WHERE id_partida = ? ORDER BY num_mision";
		List<Integer> misionesDisponibles = new ArrayList<>();
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(queryMisiones)) {
			ps.setInt(1, idSeleccionado);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					int mision = rs.getInt("num_mision");
					misionesDisponibles.add(mision);
					System.out.println("- Misión: " + mision);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al recuperar las misiones: " + e.getMessage());
		}

		if (misionesDisponibles.isEmpty()) {
			System.out.println("No hay misiones guardadas para esta partida.");
			return null;
		}

		int misionSeleccionada = -1;
		while (true) {
			System.out.print("\nIntroduzca el número de la misión que desea cargar: ");
			if (scanner.hasNextInt()) {
				misionSeleccionada = scanner.nextInt();
				if (misionesDisponibles.contains(misionSeleccionada)) {
					break;
				} else {
					System.out.println("Misión no encontrada. Inténtelo de nuevo.");
				}
			} else {
				System.out.println("Entrada inválida. Debe ser un número entero.");
				scanner.next(); // Limpiar entrada incorrecta
			}
		}

		System.out.println("\n=== TURNOS DISPONIBLES PARA LA MISIÓN " + misionSeleccionada + " ===");
		String queryTurnos = "SELECT DISTINCT num_turno FROM personajes_usados WHERE id_partida = ? AND num_mision = ? ORDER BY num_turno";
		List<Integer> turnosDisponibles = new ArrayList<>();
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(queryTurnos)) {
			ps.setInt(1, idSeleccionado);
			ps.setInt(2, misionSeleccionada);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					int turno = rs.getInt("num_turno");
					turnosDisponibles.add(turno);
					System.out.println("- Turno: " + turno);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al recuperar los turnos: " + e.getMessage());
		}

		if (turnosDisponibles.isEmpty()) {
			System.out.println("No hay turnos guardados para esta misión.");
			return null;
		}

		int turnoSeleccionado = -1;
		while (true) {
			System.out.print("\nIntroduzca el número del turno que desea cargar: ");
			if (scanner.hasNextInt()) {
				turnoSeleccionado = scanner.nextInt();
				if (turnosDisponibles.contains(turnoSeleccionado)) {
					break;
				} else {
					System.out.println("Turno no encontrado. Inténtelo de nuevo.");
				}
			} else {
				System.out.println("Entrada inválida. Debe ser un número entero.");
				scanner.next(); // Limpiar entrada incorrecta
			}
		}

		System.out.println("\nCargando partida " + idSeleccionado + ", misión " + misionSeleccionada + ", turno "
				+ turnoSeleccionado + "...");
		scanner.close();
		return new int[] { idSeleccionado, misionSeleccionada, turnoSeleccionado };
	}

	/**
	 * Genera y muestra un gráfico de barras utilizando XChart con la vida
	 * restante de los enemigos que han sobrevivido a la última misión.
	 * 
	 * @param enemigos La lista de enemigos supervivientes.
	 */
	public static void mostrarGraficoEnemigosVivos(List<Entidad> enemigos) {
		if (enemigos == null || enemigos.isEmpty()) {
			System.out.println("No hay enemigos vivos para mostrar en el gráfico.");
			return;
		}
		try {
			CategoryChart chart = new CategoryChartBuilder()
					.width(800)
					.height(600)
					.title("Vida de Enemigos Supervivientes")
					.xAxisTitle("Enemigo")
					.yAxisTitle("Vida")
					.build();

			chart.getStyler().setLabelsVisible(true);

			List<String> nombres = new ArrayList<>();
			List<Number> vidas = new ArrayList<>();

			for (int i = 0; i < enemigos.size(); i++) {
				Entidad e = enemigos.get(i);
				nombres.add(e.getNombre() + " (" + (i + 1) + ")");
				vidas.add(e.getVida());
			}

			chart.addSeries("Vida restante", nombres, vidas);

			new SwingWrapper<>(chart).displayChart();
		} catch (Exception e) {
			System.out.println("Error al mostrar el gráfico: " + e.getMessage());
		}
	}

	/**
	 * Genera y muestra un gráfico de barras utilizando XChart con el Top 5
	 * de las mejores partidas registradas (ordenadas por misiones completadas y
	 * turnos).
	 */
	public static void mostrarGraficoMejoresPartidas() {
		String query = "SELECT nombre_jugador, num_mision, num_turno FROM partidas ORDER BY num_mision DESC, num_turno DESC LIMIT 5";
		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			List<String> nombres = new ArrayList<>();
			List<Number> misiones = new ArrayList<>();
			List<Number> turnos = new ArrayList<>();

			int posicion = 1;
			while (rs.next()) {
				String nombre = rs.getString("nombre_jugador");
				if (nombre == null || nombre.isEmpty()) {
					nombre = "Anónimo";
				}
				int mision = rs.getInt("num_mision");
				int turno = rs.getInt("num_turno");

				// Nos aseguramos de que el nombre de la categoría sea único
				nombres.add(posicion + ". " + nombre);
				misiones.add(mision);
				turnos.add(turno);
				posicion++;
			}

			if (nombres.isEmpty()) {
				System.out.println("No hay partidas registradas para mostrar en el gráfico.");
				return;
			}

			CategoryChart chart = new CategoryChartBuilder()
					.width(800)
					.height(600)
					.title("Top 5 Mejores Partidas")
					.xAxisTitle("Jugador")
					.yAxisTitle("Cantidad")
					.build();

			chart.getStyler().setLabelsVisible(true);

			chart.addSeries("Misiones Alcanzadas", nombres, misiones);
			chart.addSeries("Turnos Sobrevividos", nombres, turnos);

			new SwingWrapper<>(chart).displayChart();

		} catch (SQLException e) {
			System.out.println("Error al recuperar las mejores partidas: " + e.getMessage());
		}
	}
}
