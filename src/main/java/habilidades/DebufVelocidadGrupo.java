package habilidades;

import java.util.List;
import java.util.Random;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto: Reduce la velocidad de todos los objetivos.
 */
public class DebufVelocidadGrupo extends Habilidades {

    public DebufVelocidadGrupo(String nombre, int cooldownBase, String efecto, boolean distancia, String tipo) {
        super(nombre, cooldownBase, efecto, distancia, tipo);
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            for (Entidad objetivo : objetivos) {
                if (ran.nextInt(0, 100) < this.getPrecision()) {
                    System.out.println("La habilidad " + this.getNombre() + " impacta en " + objetivo.getNombre());
                    objetivo.getArmadura().setVelocidad(objetivo.getArmadura().getVelocidad() - 5);
                } else {
                    System.out.println("La habilidad " + this.getNombre() + " falla contra " + objetivo.getNombre());
                }
            }
            super.usarHabilidad();
        } else {
            System.out.println("La habilidad " + this.getNombre() + " esta en cooldown");
            super.reducirCooldown();
        }
    }
}

