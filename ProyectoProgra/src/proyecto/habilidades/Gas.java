package proyecto.habilidades;


/**
 * Habilidad: Nube de Gas
 * Descripción: Lanza una nube de gas tóxico a varios objetivos.
 */
public class Gas extends EfectoVenenoMultiple {
    public Gas() {
        super("Nube de Gas", 4, "Lanza una nube de gas tóxico a varios objetivos.", true, "ofensiva", 3, 2);
    }
}

