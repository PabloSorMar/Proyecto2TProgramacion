package proyecto.habilidades;


/**
 * Habilidad: Invisibilidad
 * Descripción: Se vuelve prácticamente imposible de impactar (1 turno).
 */
public class Invisibilidad extends EfectoEscudoInvulnerable {
    public Invisibilidad() {
        super("Invisibilidad", 5, "Se vuelve prácticamente imposible de impactar (1 turno).", false, "buf");
    }
}

