package proyecto.habilidades;


/**
 * Habilidad: Alarido
 * Descripción: Grito aterrador que desmoraliza al enemigo.
 */
public class Alarido extends EfectoDebufPrecisionArea {
    public Alarido() {
        super("Alarido", 3, "Grito aterrador que desmoraliza al enemigo.", true, "debuf", 15);
    }
}

