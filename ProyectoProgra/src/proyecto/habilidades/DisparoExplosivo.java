package proyecto.habilidades;


/**
 * Habilidad: Disparo Explosivo
 * Descripción: Munición que explota al impactar, dañando el área.
 */
public class DisparoExplosivo extends EfectoDanoArea {
    public DisparoExplosivo() {
        super("Disparo Explosivo", 4, "Munición que explota al impactar, dañando el área.", true, "ofensiva", 40);
    }
}

