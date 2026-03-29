package proyecto.habilidades;


/**
 * Habilidad: Curación Inmediata
 * Descripción: Restaura 30 puntos de vida al instante.
 */
public class CuracionInmediata extends EfectoCuracionIndividual {
    public CuracionInmediata() {
        super("Curación Inmediata", 3, "Restaura 30 puntos de vida al instante.", true, "curacion", 30);
    }
}

