package proyecto.habilidades;

import java.util.List;
import java.util.Random;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto mecÃ¡nico: Realiza daÃ±o directo restando el blindaje del objetivo.
 */
public class EfectoDanoDirecto extends Habilidades {

    private final int danoBase;

    public EfectoDanoDirecto(String nombre, int cooldownBase, String efecto, String tipo, int precision, int dano) {
        super(nombre, cooldownBase, efecto, tipo, precision);
        this.danoBase = dano;
    }

    public EfectoDanoDirecto(String nombre, int cooldownBase, String efecto, boolean aDistancia, String tipo, int dano) {
        super(nombre, cooldownBase, efecto, aDistancia, tipo);
        this.danoBase = dano;
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            if (ran.nextInt(0, 100) < this.getPrecision()) {
                Entidad objetivo = objetivos.get(ran.nextInt(0, objetivos.size()));
                System.out.println("La habilidad " + this.getNombre() + " impacta en " + objetivo.getNombre());
                int danoFinal = danoBase - objetivo.getArmadura().getBlindaje();
                if (danoFinal < 0) danoFinal = 0;
                objetivo.setVida(objetivo.getVida() - danoFinal);
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

