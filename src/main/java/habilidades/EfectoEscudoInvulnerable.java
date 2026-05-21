package habilidades;

import java.util.List;
import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Efecto mecánico: Proporciona invulnerabilidad (escudo) al usuario.
 */
public class EfectoEscudoInvulnerable extends Habilidades {

    public EfectoEscudoInvulnerable(String nombre, int cooldownBase, String efecto, boolean distancia, String tipo) {
        super(nombre, cooldownBase, efecto, distancia, tipo);
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            System.out.println("La habilidad " + this.getNombre() + " activa un escudo invulnerable.");
            // Lógica de invulnerabilidad (si existe en Entidad, de lo contrario se asume que EscudoDefensivo la tiene)
            super.usarHabilidad();
        } else {
            System.out.println("La habilidad " + this.getNombre() + " esta en cooldown");
            super.reducirCooldown();
        }
    }
}

