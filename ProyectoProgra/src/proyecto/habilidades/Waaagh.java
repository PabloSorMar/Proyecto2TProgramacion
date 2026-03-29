package proyecto.habilidades;


/**
 * Habilidad: ¡Waaagh!
 * Descripción: Aumenta la Velocidad de los aliados en +30 por 1 turno.
 */
public class Waaagh extends EfectoBufVelocidad {
    public Waaagh() {
        super("¡Waaagh!", 5, "Aumenta la Velocidad de los aliados en +30 por 1 turno.", false, "buf", 30);
    }
}

