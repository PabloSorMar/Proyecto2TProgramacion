package proyecto.habilidades;


/**
 * Habilidad: Carrera
 * Descripción: Aumenta la velocidad del aliado (30).
 */
public class Carrera extends EfectoBufVelocidad {
    public Carrera() {
        super("Carrera", 3, "Aumenta la velocidad del aliado (30).", true, "buf", 30);
    }
}

