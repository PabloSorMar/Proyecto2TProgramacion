package proyecto.habilidades;


/**
 * Habilidad: Esconderse
 * Descripción: No puede ser objetivo de ataques a distancia (1 turno).
 */
public class Esconderse extends EfectoEscudoInvulnerable {
    public Esconderse() {
        super("Esconderse", 4, "No puede ser objetivo de ataques a distancia (1 turno).", false, "buf");
    }
}

