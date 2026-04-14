package proyecto.habilidades;

import java.util.List;
import java.util.Random;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto mecÃ¡nico: DaÃ±o a mÃºltiples objetivos aleatorios.
 */
public class EfectoDanoMultiple extends Habilidades {

    private final int numObjetivos;
    private final int danoPorObjetivo;

    public EfectoDanoMultiple(String nombre, int cooldownBase, String efecto, String tipo, int precision, int num, int dano) {
        super(nombre, cooldownBase, efecto, tipo, precision);
        this.numObjetivos = num;
        this.danoPorObjetivo = dano;
    }

    public EfectoDanoMultiple(String nombre, int cooldownBase, String efecto, boolean aDistancia, String tipo, int num, int dano) {
        super(nombre, cooldownBase, efecto, aDistancia, tipo);
        this.numObjetivos = num;
        this.danoPorObjetivo = dano;
    }

    @Override
    public void ejecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            for (int i = 0; i < numObjetivos; i++) {
                if (ran.nextInt(0, 100) < this.getPrecision()) {
                    Entidad objetivo = objetivos.get(ran.nextInt(0, objetivos.size()));
                    System.out.println("La habilidad " + this.getNombre() + " golpea a " + objetivo.getNombre());
                    int danoFinal = danoPorObjetivo - objetivo.getArmadura().getBlindaje();
                    if (danoFinal < 0) danoFinal = 0;
                    objetivo.setVida(objetivo.getVida() - danoFinal);
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

