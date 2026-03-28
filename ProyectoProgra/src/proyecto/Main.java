package proyecto;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<Entidad> enemigos = new ArrayList<>();
        List<Entidad> aliados = new ArrayList<>();
        List<Entidad> personajes = new ArrayList<>();
        Armaduras armadura1 = new Armaduras("Ligera", 20, 20);
        Arma arma1 = new Arma("Espada Sierra", 20, 100, false, 2, 1, 1);

        Habilidades hab1 = new Habilidades("hab1", 2, " ", true, "ofensiva");
        List<Habilidades> habilidades = new ArrayList<>();
        habilidades.add(hab1);

        Entidad aliado1 = new Entidad("aliado 1", "Aliados", 100, arma1, armadura1, habilidades);
        Entidad enemigo1 = new Entidad("enemigo 1", "Enemigos", 100, arma1, armadura1, habilidades);

        aliados.add(aliado1);
        enemigos.add(enemigo1);
        personajes.add(aliado1);
        personajes.add(enemigo1);
        while (aliados.size() > 0 && enemigos.size() > 0) {
            for (int i = 0; i < personajes.size(); i++) {
                Entidad perso = personajes.get(i);

                // Solo si el personaje está vivo y la batalla no ha acabado
                if (perso.getVida() > 0 && aliados.size() > 0 && enemigos.size() > 0) {
                    perso.RealizarTurno(aliados, enemigos, perso);

                    // Limpiamos los muertos de las listas aliado a aliado y enemigo a enemigo
                    /*
                     * Se recorre al revés (desde el final hacia el principio 0) para no afectar las
                     * posiciones al borrar
                     */
                    for (int j = aliados.size() - 1; j >= 0; j--) {
                        if (aliados.get(j).getVida() <= 0) {
                            aliados.remove(j);
                        }
                    }

                    for (int j = enemigos.size() - 1; j >= 0; j--) {
                        if (enemigos.get(j).getVida() <= 0) {
                            enemigos.remove(j);
                        }
                    }
                }
            }

            // Finalmente, borramos también a los muertos de la lista general de turnos
            for (int j = personajes.size() - 1; j >= 0; j--) {
                if (personajes.get(j).getVida() <= 0) {
                    personajes.remove(j);
                }
            }
        }

        System.out.println("--- FIN DEL COMBATE ---");
        if (aliados.size() > 0) {
            System.out.println("¡Victoria para los Aliados!");
        } else if (enemigos.size() > 0) {
            System.out.println("¡Victoria para los Enemigos!");
        } else {
            System.out.println("Todos han muerto. Es un empate.");
        }

    }
}
