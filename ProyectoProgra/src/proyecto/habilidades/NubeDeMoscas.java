package proyecto.habilidades;


/**
 * Habilidad: Nube de Moscas
 * Descripción: Rodea al enemigo con una nube que dificulta apuntar.
 */
public class NubeDeMoscas extends EfectoDebufPrecisionArea {
    public NubeDeMoscas() {
        super("Nube de Moscas", 4, "Rodea al enemigo con una nube que dificulta apuntar.", true, "debuf", 20);
    }
}

