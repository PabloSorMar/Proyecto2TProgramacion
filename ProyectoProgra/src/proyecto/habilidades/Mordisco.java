package proyecto.habilidades;


/**
 * Habilidad: Mordisco Venenoso
 * Descripción: Muerde al enemigo inyectando veneno.
 */
public class Mordisco extends EfectoVenenoMultiple {
    public Mordisco() {
        super("Mordisco Venenoso", 2, "Muerde al enemigo inyectando veneno.", false, "ofensiva", 1, 3);
    }
}

