package proyecto.habilidades;


/**
 * Habilidad: Incendio
 * Descripción: Prende fuego a un área de 3 casillas (15 Daño por turno).
 */
public class Incendio extends VenenoAreaGlobal {
    public Incendio() {
        super("Incendio", 4, "Prende fuego a un área de 3 casillas (15 Daño por turno).", true, "ofensiva");
    }
}

