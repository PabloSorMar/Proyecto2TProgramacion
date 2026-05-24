package proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import utils.Utils;

/**
 * Clase principal que gestiona el ciclo de vida de la campaña Warhammer 40k.
 * Se encarga de la selección aleatoria de facciones, héroes y misiones.
 * Implementa el bucle de misiones y el sistema de combate por turnos basado en
 * velocidad.
 */
public class Main {

    /**
     * Punto de entrada principal del juego.
     * Gestiona el menú de inicio (Nueva Partida / Cargar Partida),
     * la inicialización del estado y el bucle principal de la campaña.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        Utils.imprimirAguila();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== MENÚ PRINCIPAL ===");
        System.out.println("1. Nueva Partida");
        System.out.println("2. Cargar Partida");

        int opcionMenu = 0;
        while (opcionMenu < 1 || opcionMenu > 2) {
            System.out.print("Ingrese una opcion (1-2): ");
            if (scanner.hasNextInt()) {
                opcionMenu = scanner.nextInt();
                if (opcionMenu < 1 || opcionMenu > 2) {
                    System.out.println("Opcion invalida, intentelo de nuevo.");
                }
            } else {
                System.out.println("Opcion invalida, intentelo de nuevo.");
                scanner.next();
            }
        }
        scanner.nextLine(); // Consumir el newline

        int opcionDificultad = 1;
        int maxEnemigos = 8;
        int tiposEnemigos = 6;
        int misionNumero = 1;
        int idPartida = 0;
        int numTurno = 1;
        Random ran = new Random();
        List<Entidad> aliados = new ArrayList<>();
        List<Entidad> enemigos = new ArrayList<>();
        List<Entidad> personajes = new ArrayList<>();
        List<ListaHeroes> heroesSeleccionados = new ArrayList<>();
        String[] facciones = { "Orkos", "Necrones", "Tiránidos", "Aeldari", "T'au", "Caos" };
        boolean cargandoPartida = false;
        boolean esPartidaCargada = false;

        /*
         * =========================================================================
         * LÓGICA DE CARGA DE PARTIDA (Opción 2)
         * Se encarga de recuperar el estado completo desde la base de datos:
         * 1. ID de Partida, Misión y Turno.
         * 2. Dificultad configurada.
         * 3. Estadísticas y equipo de aliados y enemigos supervivientes.
         * =========================================================================
         */
        if (opcionMenu == 2) {
            esPartidaCargada = true;

            // Permite al usuario seleccionar el ID, misión y turno desde la BD
            int[] seleccion = Utils.cargarPartidaGuardada();
            if (seleccion == null) {
                scanner.close();
                return; // Terminar la ejecucion si no hay seleccion válida o no hay partidas
            }

            idPartida = seleccion[0];
            misionNumero = seleccion[1];
            numTurno = seleccion[2];

            // Recupera la configuración de dificultad asociada a la partida
            opcionDificultad = Utils.obtenerDificultadPartida(idPartida);

            // Carga todos los personajes (héroes y enemigos) que estaban vivos en ese turno
            personajes = Utils.cargarPersonajesUsados(idPartida, misionNumero, numTurno);

            // Limpiar datos redundantes o futuros de esta partida en la base de datos
            Utils.limpiarTurnosFuturos(idPartida, misionNumero, numTurno);

            // Clasifica las entidades recuperadas en sus respectivas listas
            for (Entidad p : personajes) {
                if (p instanceof proyecto.Heroe) {
                    aliados.add(p); // Añadir a la lista de combate actual

                    // Reconstruir la lista de heroes originales (referencias al Enum)
                    // para que el juego sepa cuáles se eligieron al principio de la campaña
                    for (ListaHeroes lh : ListaHeroes.values()) {
                        if (lh.getNombre().equals(p.getNombre()) && !heroesSeleccionados.contains(lh)) {
                            heroesSeleccionados.add(lh);
                        }
                    }
                } else {
                    enemigos.add(p); // Añadir a los enemigos
                }
            }

            // Configurar los parámetros de balance del juego según la dificultad recuperada
            if (opcionDificultad == 1) {
                maxEnemigos = 4;
                tiposEnemigos = 2;
            } else if (opcionDificultad == 2) {
                maxEnemigos = 6;
                tiposEnemigos = 4;
            }

            cargandoPartida = true;
            System.out.println("\n--- PARTIDA CARGADA ---");
            System.out.println(
                    "Misión: " + misionNumero + " | Turno: " + numTurno + " | Dificultad: " + opcionDificultad);
        } else {

            System.out.println("=== SELECCIONE LA DIFICULTAD ===");
            System.out.println("1. Minima");
            System.out.println("2. Despiadada");
            System.out.println("3. Absoluta");

            opcionDificultad = 0;
            while (opcionDificultad < 1 || opcionDificultad > 3) {
                System.out.print("Ingrese una opcion (1-3): ");
                if (scanner.hasNextInt()) {
                    opcionDificultad = scanner.nextInt();
                    if (opcionDificultad < 1 || opcionDificultad > 3) {
                        System.out.println("Opcion invalida, intentelo de nuevo.");
                    }
                } else {
                    System.out.println("Opcion invalida, intentelo de nuevo.");
                    scanner.next();
                }
            }
            scanner.nextLine(); // Consumir el newline

            if (opcionDificultad == 1) {
                maxEnemigos = 4;
                tiposEnemigos = 2;
            } else if (opcionDificultad == 2) {
                maxEnemigos = 6;
                tiposEnemigos = 4;
            }

            // =============================================
            // 1. FACCION DE JUGADORES ALEATORIA (se elige una sola vez)
            // =============================================
            String nombreFaccion;
            int numHeroesAElegir;
            if (ran.nextInt(2) == 0) {
                nombreFaccion = "Astra Militarum";
                numHeroesAElegir = 4;
            } else {
                nombreFaccion = "Deathwatch";
                numHeroesAElegir = 2;
            }
            System.out.println("=== FACCION DE JUGADORES: " + nombreFaccion.toUpperCase() + " ===");

            // Obtener heroes de esa faccion en lista mutable para poder quitarlos al elegir
            List<ListaHeroes> heroesDeFaccion = ListaHeroes.obtenerPorFaccion(nombreFaccion);

            // =============================================
            // 2. SELECCION ALEATORIA DE HEROES (sin repeticion, se guarda para restaurar)
            // =============================================
            System.out.println("Heroes elegidos:");
            for (int i = 0; i < numHeroesAElegir; i++) {
                int indice = ran.nextInt(heroesDeFaccion.size());
                ListaHeroes heroElegido = heroesDeFaccion.get(indice);
                heroesDeFaccion.remove(indice); // Se elimina para no repetir
                heroesSeleccionados.add(heroElegido); // Guardar para restaurar entre misiones
                System.out.println("  " + (i + 1) + ". " + heroElegido.getNombre());
            }

            idPartida = Utils.obtenerSiguienteIdPartida();
        }

        // =============================================
        // BUCLE DE CAMPAÑA: se repite hasta que los heroes mueran
        // =============================================
        while (true) {

            if (!cargandoPartida) {
                System.out.println("\n========================================");
                System.out.println("          MISION " + misionNumero);
                System.out.println("========================================");

                // Restaurar heroes al completo (vida y revivir muertos)
                aliados.clear();
                for (ListaHeroes h : heroesSeleccionados) {
                    aliados.add(h.crearInstancia());
                }

                // =============================================
                // 3. FACCION ENEMIGA ALEATORIA (nueva cada mision)
                // =============================================
                String faccionEnemiga = facciones[ran.nextInt(facciones.length)];
                System.out.println("Faccion enemiga: " + faccionEnemiga.toUpperCase());

                List<ListaEnemigos> enemigosDeFaccionTotal = ListaEnemigos.obtenerPorFaccion(faccionEnemiga);
                List<ListaEnemigos> enemigosDeFaccion = enemigosDeFaccionTotal;
                if (tiposEnemigos < enemigosDeFaccionTotal.size()) {
                    enemigosDeFaccion = enemigosDeFaccionTotal.subList(0, tiposEnemigos);
                }

                // =============================================
                // 4. NUMERO ALEATORIO DE ENEMIGOS SEGUN DIFICULTAD
                // =============================================
                int numEnemigos = ran.nextInt(1, maxEnemigos + 1);
                enemigos.clear();
                System.out.println("Numero de enemigos: " + numEnemigos);
                for (int i = 0; i < numEnemigos; i++) {
                    ListaEnemigos enemigoAleatorio = enemigosDeFaccion.get(ran.nextInt(enemigosDeFaccion.size()));
                    enemigos.add(enemigoAleatorio.crearInstancia());
                    System.out.println("  Enemigo " + (i + 1) + ": " + enemigoAleatorio.getNombre());
                }
                numTurno = 1;
            }

            // =============================================
            // 5. COMBATE
            // =============================================
            System.out.println("\n--- INICIO DEL COMBATE ---");
            if (cargandoPartida) {
                System.out.println("(Reanudando combate en la Misión " + misionNumero + ", Turno " + numTurno + ")");
            }

            while (aliados.size() > 0 && enemigos.size() > 0) {
                // Reconstruir personajes ordenado por velocidad (mayor = primero)
                personajes.clear();
                agregarOrdenadoPorVelocidad(personajes, aliados);
                agregarOrdenadoPorVelocidad(personajes, enemigos);

                for (int i = 0; i < personajes.size(); i++) {
                    Entidad perso = personajes.get(i);

                    if (perso.getVida() > 0 && aliados.size() > 0 && enemigos.size() > 0) {
                        perso.RealizarTurno(aliados, enemigos, perso);

                        Utils.registrarKills(personajes, perso);

                        eliminarMuertos(aliados, true);
                        eliminarMuertos(enemigos, true);
                    }
                }

                Utils.guardarPersonajesUsados(personajes, idPartida, misionNumero, numTurno);
                numTurno++;

                eliminarMuertos(personajes, false);
            }

            cargandoPartida = false; // El combate cargado terminó, la siguiente misión será normal.

            // =============================================
            // 6. RESULTADO DE LA MISION
            // =============================================
            if (enemigos.size() == 0 && aliados.size() > 0) {
                misionNumero++;
                // VICTORIA: los heroes han ganado esta mision
                System.out.println("\n--- MISION COMPLETADA ---");
                System.out.println("Mision completada, volviendo a orbita...");
                System.out.println("Supervivientes:");
                for (Entidad e : aliados) {
                    System.out.println("  - " + e.getNombre() + " (Vida restante: " + e.getVida() + ")");
                }
                System.out.println("Los heroes se recuperan para la siguiente mision.");

                // El bucle continua: nueva mision con heroes restaurados
            } else {
                // DERROTA: los heroes han muerto
                System.out.println("\n================================================");
                System.out.println("  MISION FALLIDA, EL PLANETA HA CAIDO.");
                System.out.println("  Misiones completadas: " + (misionNumero - 1));
                System.out.println("  COMENZANDO EXTERMINATUS");
                System.out.println("================================================");

                // Mostrar gráfico con la vida de los enemigos restantes
                Utils.mostrarGraficoEnemigosVivos(enemigos);

                if (esPartidaCargada) {
                    System.out.println("Actualizando el registro de la partida guardada...");
                    Utils.actualizarPartida(idPartida, misionNumero, numTurno);
                } else {
                    System.out.print("Introduce tu nombre para guardar la partida: ");
                    String nombreJugador = scanner.nextLine();
                    if (nombreJugador.length() > 50) {
                        nombreJugador = nombreJugador.substring(0, 50);
                    }
                    Utils.guardarPartida(nombreJugador, misionNumero, numTurno, opcionDificultad);
                }

                // Mostrar gráfico con el Top 5 de las mejores partidas
                Utils.mostrarGraficoMejoresPartidas();

                scanner.close();
                break; // Fin del juego
            }
        }
    }

    // Agrega entidades a la lista de personajes ordenándolas de mayor a menor
    // velocidad.
    public static void agregarOrdenadoPorVelocidad(List<Entidad> personajes, List<Entidad> grupo) {
        for (Entidad e : grupo) {
            int pos = 0;
            while (pos < personajes.size()
                    && personajes.get(pos).getArmadura().getVelocidad() >= e.getArmadura().getVelocidad()) {
                pos++;
            }
            personajes.add(pos, e);
        }
    }

    // Elimina de la lista a las entidades cuya vida sea 0 o inferior.
    public static void eliminarMuertos(List<Entidad> grupo, boolean mostrarMensaje) {
        for (int j = grupo.size() - 1; j >= 0; j--) {
            if (grupo.get(j).getVida() <= 0) {
                if (mostrarMensaje) {
                    System.out.println("  [MUERTO] " + grupo.get(j).getNombre());
                }

                grupo.remove(j);
            }
        }
    }
}
