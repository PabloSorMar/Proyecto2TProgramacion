package proyecto.habilidades;


/**
 * Habilidad: Combustible
 * Descripción: Recarga el lanzallamas aumentando el daño del siguiente ataque.
 */
public class Combustible extends EfectoBufPrecision {
    public Combustible() {
        super("Combustible", 2, "Recarga el lanzallamas aumentando el daño del siguiente ataque.", false, "buf", 20);
    }
}

