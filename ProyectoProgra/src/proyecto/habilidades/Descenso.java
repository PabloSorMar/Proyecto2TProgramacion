package proyecto.habilidades;


/**
 * Habilidad: Descenso
 * Descripción: Permite moverse 3 casillas adicionales tras un salto.
 */
public class Descenso extends EfectoBufVelocidad {
    public Descenso() {
        super("Descenso", 3, "Permite moverse 3 casillas adicionales tras un salto.", false, "movimiento", 30);
    }
}

