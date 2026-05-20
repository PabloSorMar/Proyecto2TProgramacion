package proyecto.habilidades;

import java.util.List;
import java.util.Random;

import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Golpe ejecutor: elimina al instante a un objetivo si su vida es baja (menor o igual a 60).
 * Si el objetivo tiene mas vida, inflige 35 de daño ignorando blindaje.
 * Usado para Eutanasia, Odio Eterno, etc.
 */
public class GolpeEjecutor extends Habilidades {

    /**
     * Constructor de GolpeEjecutor.
     * @param nombre parametro.
     * @param cooldownBase parametro.
     * @param efecto parametro.
     * @param tipo parametro.
     * @param precision parametro.
     */
    public GolpeEjecutor(String nombre, int cooldownBase, String efecto, String tipo, int precision) {
        super(nombre, cooldownBase, efecto, tipo, precision);
    }

    /**
     * Constructor de GolpeEjecutor.
     * @param nombre parametro.
     * @param cooldownBase parametro.
     * @param efecto parametro.
     * @param aDistancia parametro.
     * @param tipo parametro.
     */
    public GolpeEjecutor(String nombre, int cooldownBase, String efecto, boolean aDistancia, String tipo) {
        super(nombre, cooldownBase, efecto, aDistancia, tipo);
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            if (ran.nextInt(0, 100) < this.getPrecision()) {
                Entidad objetivo = objetivos.get(ran.nextInt(0, objetivos.size()));
                if (objetivo.getVida() <= 60) {
                    System.out.println("La habilidad " + this.getNombre() + " EJECUTA a " + objetivo.getNombre() + "!");
                    objetivo.setVida(0);
                } else {
                    System.out.println("La habilidad " + this.getNombre() + " golpea a " + objetivo.getNombre() + " (vida demasiado alta para ejecutar, 35 de dano)");
                    objetivo.setVida(objetivo.getVida() - 35);
                }
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

