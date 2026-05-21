package habilidades;

import java.util.List;
import java.util.Random;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto mecÃ¡nico: Recupera una cantidad fija de vida instantÃ¡neamente.
 */
public class EfectoCuracionIndividual extends Habilidades {

    private final int curacionBase;

    public EfectoCuracionIndividual(String nombre, int cooldownBase, String efecto, boolean distancia, String tipo, int curacion) {
        super(nombre, cooldownBase, efecto, distancia, tipo);
        this.curacionBase = curacion;
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            if (ran.nextInt(0, 100) < this.getPrecision()) {
                Entidad objetivo = objetivos.get(ran.nextInt(0, objetivos.size()));
                System.out.println("La habilidad " + this.getNombre() + " cura a " + objetivo.getNombre() + " (+" + curacionBase + " vida)");
                objetivo.setVida(objetivo.getVida() + curacionBase);
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

