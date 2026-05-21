package proyecto.habilidades;

import java.util.List;
import java.util.Random;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto: Realiza múltiples ataques aleatorios que infligen hemorragia.
 */
public class HemorragiaMultiple extends Habilidades {

    /**
     * Constructor de HemorragiaMultiple.
     * @param nombre parametro.
     * @param cooldownBase parametro.
     * @param efecto parametro.
     * @param tipo parametro.
     * @param precision parametro.
     */
    public HemorragiaMultiple(String nombre, int cooldownBase, String efecto, String tipo, int precision) {
        super(nombre, cooldownBase, efecto, tipo, precision);
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            for (int i = 0; i < 4; i++) {
                if (ran.nextInt(0, 100) < this.getPrecision()) {
                    Entidad objetivo = objetivos.get(ran.nextInt(0, objetivos.size()));
                    System.out.println("  La habilidad " + this.getNombre() + " impacta en " + objetivo.getNombre());
                    objetivo.setTurnoHemorragia(1);
                } else {
                    System.out.println("  La habilidad " + this.getNombre() + " falla el impacto " + (i + 1));
                }
            }
            super.usarHabilidad();
        } else {
            System.out.println("  La habilidad " + this.getNombre() + " esta en cooldown");
            super.reducirCooldown();
        }
    }
}

