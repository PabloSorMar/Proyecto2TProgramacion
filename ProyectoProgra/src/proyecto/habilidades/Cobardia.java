package proyecto.habilidades;


/**
 * Habilidad: Cobardía
 * Descripción: Si recibe daño, retrocede automáticamente una posición.
 */
public class Cobardia extends EfectoBufVelocidad {
    public Cobardia() {
        super("Cobardía", 0, "Si recibe daño, retrocede automáticamente una posición.", false, "movimiento", 30);
    }
}

