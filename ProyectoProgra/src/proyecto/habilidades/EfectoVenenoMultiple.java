package proyecto.habilidades;

import java.util.List;
import java.util.Random;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto mecánico: Aplica veneno varias veces a objetivos aleatorios.
 */
public class EfectoVenenoMultiple extends Habilidades {

    private final int numObjetivos;
    private final int turnosVeneno;

    /**
     * Constructor de EfectoVenenoMultiple.
     * @param nombre parametro.
     * @param cooldownBase parametro.
     * @param efecto parametro.
     * @param tipo parametro.
     * @param precision parametro.
     * @param num parametro.
     * @param turnos parametro.
     */
    public EfectoVenenoMultiple(String nombre, int cooldownBase, String efecto, String tipo, int precision, int num, int turnos) {
        super(nombre, cooldownBase, efecto, tipo, precision);
        this.numObjetivos = num;
        this.turnosVeneno = turnos;
    }

    /**
     * Constructor de EfectoVenenoMultiple.
     * @param nombre parametro.
     * @param cooldownBase parametro.
     * @param efecto parametro.
     * @param aDistancia parametro.
     * @param tipo parametro.
     * @param num parametro.
     * @param turnos parametro.
     */
    public EfectoVenenoMultiple(String nombre, int cooldownBase, String efecto, boolean aDistancia, String tipo, int num, int turnos) {
        super(nombre, cooldownBase, efecto, aDistancia, tipo);
        this.numObjetivos = num;
        this.turnosVeneno = turnos;
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            for (int i = 0; i < numObjetivos; i++) {
                if (ran.nextInt(0, 100) < this.getPrecision()) {
                    Entidad objetivo = objetivos.get(ran.nextInt(0, objetivos.size()));
                    System.out.println("  La habilidad " + this.getNombre() + " envenena a " + objetivo.getNombre());
                    objetivo.setTurnoVeneno(turnosVeneno);
                } else {
                    System.out.println("  La habilidad " + this.getNombre() + " falla el veneno " + (i + 1));
                }
            }
            super.usarHabilidad();
        } else {
            System.out.println("  La habilidad " + this.getNombre() + " esta en cooldown");
            super.reducirCooldown();
        }
    }
}

