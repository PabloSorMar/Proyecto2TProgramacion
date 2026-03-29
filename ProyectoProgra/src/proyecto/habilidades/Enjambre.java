package proyecto.habilidades;


/**
 * Habilidad: Enjambre
 * Descripción: Aumenta la Precisión si hay aliados cerca.
 */
public class Enjambre extends EfectoBufPrecision {
    public Enjambre() {
        super("Enjambre", 3, "Aumenta la Precisión si hay aliados cerca.", false, "buf", 20);
    }
}

