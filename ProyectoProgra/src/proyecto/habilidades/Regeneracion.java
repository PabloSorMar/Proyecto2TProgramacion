package proyecto.habilidades;


/**
 * Habilidad: Regeneración
 * Descripción: El organismo se regenera con el tiempo (4T).
 */
public class Regeneracion extends EfectoCuracionSostenida {
    public Regeneracion() {
        super("Regeneración", 4, "El organismo se regenera con el tiempo (4T).", true, "curacion", 4);
    }
}

