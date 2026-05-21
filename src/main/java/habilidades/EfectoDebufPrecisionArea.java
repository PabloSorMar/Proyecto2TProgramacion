package habilidades;

import java.util.List;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto mecánico: Reduce la precisión de todos los enemigos.
 */
public class EfectoDebufPrecisionArea extends Habilidades {

    private final int reduccionPrecision;

    public EfectoDebufPrecisionArea(String nombre, int cooldownBase, String efecto, boolean distancia, String tipo,
            int reduccion) {
        super(nombre, cooldownBase, efecto, distancia, tipo);
        this.reduccionPrecision = reduccion;
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            System.out.println("La habilidad " + this.getNombre() + " reduce la precisión de todos los enemigos.");
            for (Entidad objetivo : objetivos) {
                objetivo.getArma().setPrecision(objetivo.getArma().getPrecision() - reduccionPrecision);
            }
            super.usarHabilidad();
        } else {
            System.out.println("La habilidad " + this.getNombre() + " esta en cooldown");
            super.reducirCooldown();
        }
    }
}

