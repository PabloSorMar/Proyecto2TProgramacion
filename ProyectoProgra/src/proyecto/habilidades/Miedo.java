package proyecto.habilidades;


/**
 * Habilidad: Miedo
 * Descripción: Causa miedo en los enemigos.
 */
public class Miedo extends EfectoDebufPrecisionArea {
    public Miedo() {
        super("Miedo", 3, "Causa miedo en los enemigos.", true, "debuf", 10);
    }
}

