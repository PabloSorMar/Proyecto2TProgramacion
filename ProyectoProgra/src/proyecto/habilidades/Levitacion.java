package proyecto.habilidades;


/**
 * Habilidad: Levitación
 * Descripción: Se eleva sobre el suelo para ganar velocidad.
 */
public class Levitacion extends EfectoBufVelocidad {
    public Levitacion() {
        super("Levitación", 3, "Se eleva sobre el suelo para ganar velocidad.", false, "buf", 30);
    }
}

