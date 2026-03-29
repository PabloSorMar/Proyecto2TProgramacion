package proyecto.habilidades;


/**
 * Habilidad: Regenerar
 * Descripción: Aplica regeneración constante de tejidos.
 */
public class Regenerar extends EfectoCuracionSostenida {
    public Regenerar() {
        super("Regenerar", 4, "Aplica regeneración constante de tejidos.", true, "curacion", 4);
    }
}

