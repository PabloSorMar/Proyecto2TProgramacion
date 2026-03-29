package proyecto.habilidades;


/**
 * Habilidad: Cubrirse
 * Descripción: Aumenta +30% la probabilidad de que los ataques den en armadura (2 turnos).
 */
public class Cubrirse extends EfectoEscudoInvulnerable {
    public Cubrirse() {
        super("Cubrirse", 3, "Aumenta +30% la probabilidad de que los ataques den en armadura (2 turnos).", false, "buf");
    }
}

