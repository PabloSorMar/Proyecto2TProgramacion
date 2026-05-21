package proyecto.habilidades;

import java.util.List;
import java.util.Random;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto mecánico: Daño en área que afecta a todos los objetivos.
 */
public class EfectoDanoArea extends Habilidades {

    private final int danoArea;

    /**
     * Constructor de EfectoDanoArea.
     * @param nombre parametro.
     * @param cooldownBase parametro.
     * @param efecto parametro.
     * @param tipo parametro.
     * @param precision parametro.
     * @param dano parametro.
     */
    public EfectoDanoArea(String nombre, int cooldownBase, String efecto, String tipo, int precision, int dano) {
        super(nombre, cooldownBase, efecto, tipo, precision);
        this.danoArea = dano;
    }

    /**
     * Constructor de EfectoDanoArea.
     * @param nombre parametro.
     * @param cooldownBase parametro.
     * @param efecto parametro.
     * @param aDistancia parametro.
     * @param tipo parametro.
     * @param dano parametro.
     */
    public EfectoDanoArea(String nombre, int cooldownBase, String efecto, boolean aDistancia, String tipo, int dano) {
        super(nombre, cooldownBase, efecto, aDistancia, tipo);
        this.danoArea = dano;
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            if (ran.nextInt(0, 100) < this.getPrecision()) {
                System.out.println("  La habilidad " + this.getNombre() + " impacta en todos los objetivos");
                for (Entidad objetivo : objetivos) {
                    objetivo.setVida(objetivo.getVida() - danoArea);
                }
            } else {
                System.out.println("  La habilidad " + this.getNombre() + " falla");
            }
            super.usarHabilidad();
        } else {
            System.out.println("  La habilidad " + this.getNombre() + " esta en cooldown");
            super.reducirCooldown();
        }
    }
}

