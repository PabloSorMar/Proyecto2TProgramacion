package proyecto.habilidades;

import java.util.List;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto mecánico: Aturde a todos los enemigos.
 */
public class EfectoStunArea extends Habilidades {

    private final int turnosStun;

    /**
     * Constructor de EfectoStunArea.
     * @param nombre parametro.
     * @param cooldownBase parametro.
     * @param efecto parametro.
     * @param distancia parametro.
     * @param tipo parametro.
     * @param turnos parametro.
     */
    public EfectoStunArea(String nombre, int cooldownBase, String efecto, boolean distancia, String tipo, int turnos) {
        super(nombre, cooldownBase, efecto, distancia, tipo);
        this.turnosStun = turnos;
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            System.out.println("La habilidad " + this.getNombre() + " aturde a todo el escuadrón enemigo.");
            for (Entidad objetivo : objetivos) {
                objetivo.setTurnoStun(turnosStun);
            }
            super.usarHabilidad();
        } else {
            System.out.println("La habilidad " + this.getNombre() + " esta en cooldown");
            super.reducirCooldown();
        }
    }
}

