package proyecto.habilidades;


/**
 * Habilidad: Ataque Tres Objetivos
 * Descripción: Ataca a 3 objetivos aleatorios (20 de da?o cada uno).
 */
public class AtaqueTresObjetivos extends EfectoDanoMultiple {
    public AtaqueTresObjetivos() {
        super("Ataque Tres Objetivos", 3, "Ataca a 3 objetivos aleatorios (20 de da?o cada uno).", true, "ofensiva", 3, 20);
    }
}

