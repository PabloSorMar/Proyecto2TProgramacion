package proyecto.habilidades;

import java.util.List;
import java.util.Random;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto mecánico: Aumenta la precisión de un aliado aleatorio (autobuf generalmente).
 */
public class EfectoBufPrecision extends Habilidades {

    private final int aumentoPrecision;

    /**
     * Constructor de EfectoBufPrecision.
     * @param nombre parametro.
     * @param cooldownBase parametro.
     * @param efecto parametro.
     * @param distancia parametro.
     * @param tipo parametro.
     * @param aumento parametro.
     */
    public EfectoBufPrecision(String nombre, int cooldownBase, String efecto, boolean distancia, String tipo, int aumento) {
        super(nombre, cooldownBase, efecto, distancia, tipo);
        this.aumentoPrecision = aumento;
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            Entidad objetivo = objetivos.get(ran.nextInt(0, objetivos.size()));
            System.out.println("  La habilidad " + this.getNombre() + " aumenta la puntería de " + objetivo.getNombre() + " (+" + aumentoPrecision + ")");
            objetivo.getArma().setPrecision(objetivo.getArma().getPrecision() + aumentoPrecision);
            super.usarHabilidad();
        } else {
            System.out.println("  La habilidad " + this.getNombre() + " esta en cooldown");
            super.reducirCooldown();
        }
    }
}

