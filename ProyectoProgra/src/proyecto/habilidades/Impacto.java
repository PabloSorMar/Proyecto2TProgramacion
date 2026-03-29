package proyecto.habilidades;


/**
 * Habilidad: Impacto
 * Descripción: Al caer tras un salto, inflige 20 Daño a objetivos adyacentes.
 */
public class Impacto extends EfectoDanoArea {
    public Impacto() {
        super("Impacto", 3, "Al caer tras un salto, inflige 20 Daño a objetivos adyacentes.", false, "ofensiva", 20);
    }
}

