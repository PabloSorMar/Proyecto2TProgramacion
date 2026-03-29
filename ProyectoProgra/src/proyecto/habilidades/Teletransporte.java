package proyecto.habilidades;


/**
 * Habilidad: Teletransporte
 * Descripción: Se desplaza instantáneamente a otra posición.
 */
public class Teletransporte extends EfectoBufVelocidad {
    public Teletransporte() {
        super("Teletransporte", 5, "Se desplaza instantáneamente a otra posición.", false, "movimiento", 30);
    }
}

