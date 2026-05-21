package habilidades;

import java.util.List;
import java.util.Random;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto: Reduce la precisiÃ³n de un solo objetivo aleatorio.
 */
public class DebufPrecisionIndividual extends Habilidades {

    public DebufPrecisionIndividual(String nombre, int cooldownBase, String efecto, boolean distancia, String tipo) {
        super(nombre, cooldownBase, efecto, distancia, tipo);
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            if (ran.nextInt(0, 100) < this.getPrecision()) {
                Entidad objetivo = objetivos.get(ran.nextInt(0, objetivos.size()));
                System.out.println("La habilidad " + this.getNombre() + " impacta en " + objetivo.getNombre());
                objetivo.getArma().setPrecision(objetivo.getArma().getPrecision() - 15);
            } else {
                System.out.println("La habilidad " + this.getNombre() + " falla");
            }
            super.usarHabilidad();
        } else {
            System.out.println("La habilidad " + this.getNombre() + " esta en cooldown");
            super.reducirCooldown();
        }
    }
}

