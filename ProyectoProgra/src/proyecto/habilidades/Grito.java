package proyecto.habilidades;


/**
 * Habilidad: Grito
 * Descripción: Grito ensordecedor que reduce la puntería.
 */
public class Grito extends EfectoDebufPrecisionArea {
    public Grito() {
        super("Grito", 3, "Grito ensordecedor que reduce la puntería.", true, "debuf", 15);
    }
}

