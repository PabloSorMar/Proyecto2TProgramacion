package proyecto.habilidades;

import java.util.List;
import java.util.Random;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto: Aplica curación sostenida (HoT) a múltiples aliados aleatorios.
 */
public class CuracionSostenidaMultiple extends Habilidades {

    /**
     * Constructor de CuracionSostenidaMultiple.
     * @param nombre parametro.
     * @param cooldownBase parametro.
     * @param efecto parametro.
     * @param distancia parametro.
     * @param tipo parametro.
     */
    public CuracionSostenidaMultiple(String nombre, int cooldownBase, String efecto, boolean distancia, String tipo) {
        super(nombre, cooldownBase, efecto, distancia, tipo);
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            for (int i = 0; i < 4; i++) {
                if (ran.nextInt(0, 100) < this.getPrecision()) {
                    Entidad objetivo = objetivos.get(ran.nextInt(0, objetivos.size()));
                    System.out.println("La habilidad " + this.getNombre() + " impacta en " + objetivo.getNombre());
                    objetivo.setTurnoCuracion(1);
                } else {
                    System.out.println("La habilidad " + this.getNombre() + " falla el impacto " + (i + 1));
                }
            }
            super.usarHabilidad();
        } else {
            System.out.println("La habilidad " + this.getNombre() + " esta en cooldown");
            super.reducirCooldown();
        }
    }
}

