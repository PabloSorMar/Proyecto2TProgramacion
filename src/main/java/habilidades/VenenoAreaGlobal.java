package habilidades;

import java.util.List;
import java.util.Random;

import proyecto.Entidad;
import proyecto.Habilidades;

/**
 * Veneno en area: aplica veneno (2 turnos) a TODOS los objetivos.
 * Usado para Gas, Vomito Corrosivo en area, Nube de Moscas, Lanza de Plagas, etc.
 */
public class VenenoAreaGlobal extends Habilidades {

    public VenenoAreaGlobal(String nombre, int cooldownBase, String efecto, boolean distancia, String tipo) {
        super(nombre, cooldownBase, efecto, distancia, tipo);
    }

    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        if (super.estaDisponible()) {
            Random ran = new Random();
            System.out.println("La habilidad " + this.getNombre() + " envenena el area!");
            for (Entidad objetivo : objetivos) {
                if (ran.nextInt(0, 100) < this.getPrecision()) {
                    System.out.println("  " + objetivo.getNombre() + " queda envenenado!");
                    objetivo.setTurnoVeneno(2);
                }
            }
            super.usarHabilidad();
        } else {
            System.out.println("La habilidad " + this.getNombre() + " esta en cooldown");
            super.reducirCooldown();
        }
    }
}

