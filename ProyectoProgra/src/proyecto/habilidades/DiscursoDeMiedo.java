package proyecto.habilidades;

/**
 * Habilidad: Discurso de Miedo
 * Descripción: Reduce la probabilidad de impacto del objetivo en un -20%
 * durante 3 turnos.
 */
public class DiscursoDeMiedo extends EfectoDebufPrecisionArea {
    /**
     * Constructor de DiscursoDeMiedo.
     */
    public DiscursoDeMiedo() {
        super("Discurso de Miedo", 4, "Reduce la probabilidad de impacto del objetivo en un -20% durante 3 turnos.",
                true, "debuf", 20);
    }
}


                
