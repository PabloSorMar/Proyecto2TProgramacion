package proyecto.habilidades;


/**
 * Habilidad: Culatazo
 * Descripción: Golpea con la culata del arma (1T stun).
 */
public class CulatazoSkill extends EfectoAturdimiento {
    public CulatazoSkill() {
        super("Culatazo", 3, "Golpea con la culata del arma (1T stun).", false, "ofensiva", 20, 1);
    }
}

