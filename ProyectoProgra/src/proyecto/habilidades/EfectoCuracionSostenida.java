package proyecto.habilidades;

import java.util.List;
import java.util.Random;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto mecánico: Aplica curación sostenida (HoT) por varios turnos.
 */
public class EfectoCuracionSostenida extends Habilidades {

    private final int turnosCuracion;

    /**
     * Constructor de EfectoCuracionSostenida.
     * @param nombre parametro.
     * @param cooldownBase parametro.
     * @param efecto parametro.
     * @param distancia parametro.
     * @param tipo parametro.
     * @param turnos parametro.
     */
    public EfectoCuracionSostenida(String nombre, int cooldownBase, String efecto, boolean distancia, String tipo, int turnos) {
        super(nombre, cooldownBase, efecto, distancia, tipo);
        this.turnosCuracion = turnos;
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            if (ran.nextInt(0, 100) < this.getPrecision()) {
                Entidad objetivo = objetivos.get(ran.nextInt(0, objetivos.size()));
                System.out.println("La habilidad " + this.getNombre() + " impacta en " + objetivo.getNombre());
                objetivo.setTurnoCuracion(turnosCuracion);
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

