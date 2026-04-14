package proyecto.habilidades;

import java.util.List;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto mecánico: Aumenta el blindaje de un aliado.
 */
public class EfectoBufBlindaje extends Habilidades {

    private final int aumentoBlindaje;

    public EfectoBufBlindaje(String nombre, int cooldownBase, String efecto, boolean distancia, String tipo, int aumento) {
        super(nombre, cooldownBase, efecto, distancia, tipo);
        this.aumentoBlindaje = aumento;
    }

    @Override
    public void ejecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            for (Entidad objetivo : objetivos) {
                System.out.println("La habilidad " + this.getNombre() + " aumenta el blindaje de " + objetivo.getNombre());
                objetivo.getArmadura().setBlindaje(objetivo.getArmadura().getBlindaje() + aumentoBlindaje);
            }
            super.usarHabilidad();
        } else {
            System.out.println("La habilidad " + this.getNombre() + " esta en cooldown");
            super.reducirCooldown();
        }
    }
}

