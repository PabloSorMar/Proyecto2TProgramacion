package proyecto.habilidades;

import java.util.List;
import java.util.Random;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto mecánico: Aplica sangrado (hemorragia) por un número determinado de turnos.
 */
public class EfectoHemorragia extends Habilidades {

    private final int turnosHemorragia;

    /**
     * Constructor de EfectoHemorragia.
     * @param nombre parametro.
     * @param cooldownBase parametro.
     * @param efecto parametro.
     * @param tipo parametro.
     * @param precision parametro.
     * @param turnos parametro.
     */
    public EfectoHemorragia(String nombre, int cooldownBase, String efecto, String tipo, int precision, int turnos) {
        super(nombre, cooldownBase, efecto, tipo, precision);
        this.turnosHemorragia = turnos;
    }

    /**
     * Constructor de EfectoHemorragia.
     * @param nombre parametro.
     * @param cooldownBase parametro.
     * @param efecto parametro.
     * @param aDistancia parametro.
     * @param tipo parametro.
     * @param turnos parametro.
     */
    public EfectoHemorragia(String nombre, int cooldownBase, String efecto, boolean aDistancia, String tipo, int turnos) {
        super(nombre, cooldownBase, efecto, aDistancia, tipo);
        this.turnosHemorragia = turnos;
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            if (ran.nextInt(0, 100) < this.getPrecision()) {
                Entidad objetivo = objetivos.get(ran.nextInt(0, objetivos.size()));
                System.out.println("La habilidad " + this.getNombre() + " impacta en " + objetivo.getNombre());
                objetivo.setTurnoHemorragia(turnosHemorragia);
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

