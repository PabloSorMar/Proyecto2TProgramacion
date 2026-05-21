package habilidades;

import java.util.List;
import java.util.Random;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto mecÃ¡nico: Realiza daÃ±o ignorando el blindaje del objetivo.
 */
public class EfectoDanoPerforante extends Habilidades {

    private final int danoPerforante;

    public EfectoDanoPerforante(String nombre, int cooldownBase, String efecto, String tipo, int precision, int dano) {
        super(nombre, cooldownBase, efecto, tipo, precision);
        this.danoPerforante = dano;
    }

    public EfectoDanoPerforante(String nombre, int cooldownBase, String efecto, boolean aDistancia, String tipo, int dano) {
        super(nombre, cooldownBase, efecto, aDistancia, tipo);
        this.danoPerforante = dano;
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            if (ran.nextInt(0, 100) < this.getPrecision()) {
                Entidad objetivo = objetivos.get(ran.nextInt(0, objetivos.size()));
                System.out.println("La habilidad " + this.getNombre() + " impacta en " + objetivo.getNombre() + " (ignora armadura)");
                objetivo.setVida(objetivo.getVida() - danoPerforante);
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

