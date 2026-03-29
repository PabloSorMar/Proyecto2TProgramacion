package proyecto.habilidades;


/**
 * Habilidad: Salto
 * Descripción: Salta sobre un enemigo ignorando cobertura.
 */
public class Salto extends EfectoBufVelocidad {
    public Salto() {
        super("Salto", 3, "Salta sobre un enemigo ignorando cobertura.", false, "movimiento", 30);
    }
}

