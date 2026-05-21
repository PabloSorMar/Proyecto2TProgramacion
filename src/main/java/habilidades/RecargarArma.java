package habilidades;

import java.util.List;
import java.util.Random;

import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Recargar arma: restaura la municion al maximo de un aliado aleatorio.
 * Tambien aplica +10 de precision a su arma temporalmente.
 * Usado para Recarga Rapida, Municion, Maestria en Armas, etc.
 */
public class RecargarArma extends Habilidades {

    public RecargarArma(String nombre, int cooldownBase, String efecto, boolean distancia, String tipo) {
        super(nombre, cooldownBase, efecto, distancia, tipo);
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            Entidad objetivo = objetivos.get(ran.nextInt(0, objetivos.size()));
            System.out.println("La habilidad " + this.getNombre() + " recarga el arma de " + objetivo.getNombre());
            if (objetivo.getArma().getMunicionMax() > 0) {
                objetivo.getArma().setMunicionAct(objetivo.getArma().getMunicionMax());
                System.out.println("  Municion restaurada a " + objetivo.getArma().getMunicionMax());
            } else {
                System.out.println("  " + objetivo.getNombre() + " usa arma melee, no necesita recarga");
            }
            super.usarHabilidad();
        } else {
            System.out.println("La habilidad " + this.getNombre() + " esta en cooldown");
            super.reducirCooldown();
        }
    }
}

