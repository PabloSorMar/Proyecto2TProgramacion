package proyecto.habilidades;

import java.util.List;
import java.util.Random;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto mecÃ¡nico: Realiza daÃ±o y aplica aturdimiento (stun).
 */
public class EfectoAturdimiento extends Habilidades {

    private final int danoBase;
    private final int turnosStun;

    public EfectoAturdimiento(String nombre, int cooldownBase, String efecto, String tipo, int precision, int dano, int turnos) {
        super(nombre, cooldownBase, efecto, tipo, precision);
        this.danoBase = dano;
        this.turnosStun = turnos;
    }

    public EfectoAturdimiento(String nombre, int cooldownBase, String efecto, boolean aDistancia, String tipo, int dano, int turnos) {
        super(nombre, cooldownBase, efecto, aDistancia, tipo);
        this.danoBase = dano;
        this.turnosStun = turnos;
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            if (ran.nextInt(0, 100) < this.getPrecision()) {
                Entidad objetivo = objetivos.get(ran.nextInt(0, objetivos.size()));
                System.out.println("La habilidad " + this.getNombre() + " impacta en " + objetivo.getNombre());
                objetivo.setVida(objetivo.getVida() - danoBase);
                objetivo.setTurnoStun(turnosStun);
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

