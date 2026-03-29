package proyecto.habilidades;


/**
 * Habilidad: Tiro certero
 * Descripción: Un disparo con +30% de acierto y probabilidad de Crítico (Daño x2).
 */
public class TiroCertero extends EfectoBufPrecision {
    public TiroCertero() {
        super("Tiro certero", 3, "Un disparo con +30% de acierto y probabilidad de Crítico (Daño x2).", true, "ofensiva", 20);
    }
}

