package proyecto.habilidades;


/**
 * Habilidad: Sonda Tesla
 * Descripción: Lanza descargas eléctricas a objetivos aleatorios.
 */
public class Tesla extends EfectoDanoMultiple {
    public Tesla() {
        super("Sonda Tesla", 4, "Lanza descargas eléctricas a objetivos aleatorios.", true, "ofensiva", 3, 25);
    }
}

