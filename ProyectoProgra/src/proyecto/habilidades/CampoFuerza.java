package proyecto.habilidades;


/**
 * Habilidad: Campo de Fuerza
 * Descripción: Protege a los aliados en un radio de 2 casillas con un escudo.
 */
public class CampoFuerza extends EfectoEscudoInvulnerable {
    public CampoFuerza() {
        super("Campo de Fuerza", 5, "Protege a los aliados en un radio de 2 casillas con un escudo.", false, "buf");
    }
}

