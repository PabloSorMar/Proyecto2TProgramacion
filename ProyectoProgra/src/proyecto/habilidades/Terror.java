package proyecto.habilidades;


/**
 * Habilidad: Terror
 * Descripción: Provoca terror en el enemigo, bajando su precisión.
 */
public class Terror extends EfectoDebufPrecisionArea {
    public Terror() {
        super("Terror", 5, "Provoca terror en el enemigo, bajando su precisión.", true, "debuf", 20);
    }
}

