package proyecto.habilidades;


/**
 * Habilidad: Lanzamiento de Hacha
 * Descripción: Lanza un hacha de combate (30 daño).
 */
public class LanzarHacha extends EfectoDanoDirecto {
    public LanzarHacha() {
        super("Lanzamiento de Hacha", 2, "Lanza un hacha de combate (30 daño).", true, "ofensiva", 30);
    }
}

