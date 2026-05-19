package proyecto.habilidades;

import java.util.List;
import java.util.Random;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto mecánico: Aumenta la velocidad de un aliado aleatorio.
 */
public class EfectoBufVelocidad extends Habilidades {

    private final int aumentoVelocidad;

    public EfectoBufVelocidad(String nombre, int cooldownBase, String efecto, boolean distancia, String tipo, int aumento) {
        super(nombre, cooldownBase, efecto, distancia, tipo);
        this.aumentoVelocidad = aumento;
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            Entidad objetivo = objetivos.get(ran.nextInt(0, objetivos.size()));
            System.out.println("La habilidad " + this.getNombre() + " aumenta la velocidad de " + objetivo.getNombre() + " (+" + aumentoVelocidad + ")");
            objetivo.getArmadura().setVelocidad(objetivo.getArmadura().getVelocidad() + aumentoVelocidad);
            super.usarHabilidad();
        } else {
            System.out.println("La habilidad " + this.getNombre() + " esta en cooldown");
            super.reducirCooldown();
        }
    }
}

