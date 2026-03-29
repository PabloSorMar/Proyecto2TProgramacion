package proyecto.habilidades;


/**
 * Habilidad: Inamovible
 * Descripción: La unidad no puede ser desplazada ni aturdida (2 turnos).
 */
public class Inamovible extends EfectoEscudoInvulnerable {
    public Inamovible() {
        super("Inamovible", 5, "La unidad no puede ser desplazada ni aturdida (2 turnos).", false, "buf");
    }
}

