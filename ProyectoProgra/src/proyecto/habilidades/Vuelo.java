package proyecto.habilidades;


/**
 * Habilidad: Vuelo
 * Descripción: Permite ignorar el terreno y moverse con mayor libertad.
 */
public class Vuelo extends EfectoBufVelocidad {
    public Vuelo() {
        super("Vuelo", 3, "Permite ignorar el terreno y moverse con mayor libertad.", false, "buf", 30);
    }
}

