package proyecto.habilidades;


/**
 * Habilidad: Disparo de repetición
 * Descripción: Realiza varios disparos consecutivos.
 */
public class DisparoRepeticion extends EfectoDanoMultiple {
    public DisparoRepeticion() {
        super("Disparo de repetición", 3, "Realiza varios disparos consecutivos.", true, "ofensiva", 3, 20);
    }
}

