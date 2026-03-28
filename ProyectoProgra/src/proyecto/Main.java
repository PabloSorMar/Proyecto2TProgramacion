package proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random ran = new Random();

        List<Entidad> aliados = new ArrayList<>();
        List<Entidad> enemigos = new ArrayList<>();
        List<Entidad> personajes = new ArrayList<>();

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
        List<ListaHeroes> heroesDeFaccion = new ArrayList<>();
        for (ListaHeroes h : ListaHeroes.values()) {
            if (h.getFaccion().equals(nombreFaccion)) {
                heroesDeFaccion.add(h);
            }
        }

        // =============================================
        // 2. SELECCION ALEATORIA DE HEROES (sin repeticion, se guarda para restaurar)
        // =============================================
        List<ListaHeroes> heroesSeleccionados = new ArrayList<>();
        System.out.println("Heroes elegidos:");
        for (int i = 0; i < numHeroesAElegir; i++) {
            int indice = ran.nextInt(heroesDeFaccion.size());
            ListaHeroes heroElegido = heroesDeFaccion.get(indice);
            heroesDeFaccion.remove(indice); // Se elimina para no repetir
            heroesSeleccionados.add(heroElegido); // Guardar para restaurar entre misiones
            System.out.println("  " + (i + 1) + ". " + heroElegido.getNombre());
        }

        String[] facciones = { "Orkos", "Necrones", "Tiránidos", "Aeldari", "T'au", "Caos" };
        int misionNumero = 1;

        // =============================================
        // BUCLE DE CAMPAÑA: se repite hasta que los heroes mueran
        // =============================================
        while (true) {
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

            List<ListaEnemigos> enemigosDeFaccion = new ArrayList<>();
            for (ListaEnemigos e : ListaEnemigos.values()) {
                if (e.getFaccion().equals(faccionEnemiga)) {
                    enemigosDeFaccion.add(e);
                }
            }

            // =============================================
            // 4. NUMERO ALEATORIO DE ENEMIGOS (1-8)
            // =============================================
            int numEnemigos = ran.nextInt(1, 9);
            enemigos.clear();
            System.out.println("Numero de enemigos: " + numEnemigos);
            for (int i = 0; i < numEnemigos; i++) {
                ListaEnemigos enemigoAleatorio = enemigosDeFaccion.get(ran.nextInt(enemigosDeFaccion.size()));
                enemigos.add(enemigoAleatorio.crearInstancia());
                System.out.println("  Enemigo " + (i + 1) + ": " + enemigoAleatorio.getNombre());
            }

            // =============================================
            // 5. COMBATE
            // =============================================
            System.out.println("\n--- INICIO DEL COMBATE ---");

            while (aliados.size() > 0 && enemigos.size() > 0) {
                // Reconstruir personajes ordenado por velocidad (mayor = primero)
                personajes.clear();
                for (Entidad e : aliados) {
                    int pos = 0;
                    while (pos < personajes.size()
                            && personajes.get(pos).getArmadura().getVelocidad() >= e.getArmadura().getVelocidad()) {
                        pos++;
                    }
                    personajes.add(pos, e);
                }
                for (Entidad e : enemigos) {
                    int pos = 0;
                    while (pos < personajes.size()
                            && personajes.get(pos).getArmadura().getVelocidad() >= e.getArmadura().getVelocidad()) {
                        pos++;
                    }
                    personajes.add(pos, e);
                }

                for (int i = 0; i < personajes.size(); i++) {
                    Entidad perso = personajes.get(i);

                    if (perso.getVida() > 0 && aliados.size() > 0 && enemigos.size() > 0) {
                        perso.RealizarTurno(aliados, enemigos, perso);

                        for (int j = aliados.size() - 1; j >= 0; j--) {
                            if (aliados.get(j).getVida() <= 0) {
                                System.out.println("  [MUERTO] " + aliados.get(j).getNombre());
                                aliados.remove(j);
                            }
                        }
                        for (int j = enemigos.size() - 1; j >= 0; j--) {
                            if (enemigos.get(j).getVida() <= 0) {
                                System.out.println("  [MUERTO] " + enemigos.get(j).getNombre());
                                enemigos.remove(j);
                            }
                        }
                    }
                }

                for (int j = personajes.size() - 1; j >= 0; j--) {
                    if (personajes.get(j).getVida() <= 0) {
                        personajes.remove(j);
                    }
                }
            }

            // =============================================
            // 6. RESULTADO DE LA MISION
            // =============================================
            if (enemigos.size() == 0 && aliados.size() > 0) {
                // VICTORIA: los heroes han ganado esta mision
                System.out.println("\n--- MISION COMPLETADA ---");
                System.out.println("Mision completada, volviendo a orbita...");
                System.out.println("Supervivientes:");
                for (Entidad e : aliados) {
                    System.out.println("  - " + e.getNombre() + " (Vida restante: " + e.getVida() + ")");
                }
                System.out.println("Los heroes se recuperan para la siguiente mision.");
                misionNumero++;
                // El bucle continua: nueva mision con heroes restaurados
            } else {
                // DERROTA: los heroes han muerto
                System.out.println("\n================================================");
                System.out.println("  MISION FALLIDA, EL PLANETA HA CAIDO.");
                System.out.println("  COMENZANDO EXTERMINATUS");
                System.out.println("================================================");
                break; // Fin del juego
            }
        }
    }
}
