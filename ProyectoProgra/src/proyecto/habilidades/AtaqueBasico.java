package proyecto.habilidades;


/**
 * Habilidad: Ataque Básico
 * Descripción: Realiza un ataque simple que resta blindaje (30 daño).
 */
public class AtaqueBasico extends EfectoDanoDirecto {
    public AtaqueBasico() {
        super("Ataque Básico", 0, "Realiza un ataque simple que resta blindaje (30 daño).", false, "ofensiva", 30);
    }
}

