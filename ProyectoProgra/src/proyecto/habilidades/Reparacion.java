package proyecto.habilidades;


/**
 * Habilidad: Reparación
 * Descripción: Efectos de reparación continua en el objetivo (3T).
 */
public class Reparacion extends EfectoCuracionSostenida {
    public Reparacion() {
        super("Reparación", 4, "Efectos de reparación continua en el objetivo (3T).", true, "curacion", 3);
    }
}

