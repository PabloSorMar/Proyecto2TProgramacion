package proyecto.habilidades;


/**
 * Habilidad: Muro Andante
 * Descripción: Se posiciona frente a un aliado; recibe el 100% de los ataques dirigidos a él (1T).
 */
public class MuroAndante extends EfectoEscudoInvulnerable {
    public MuroAndante() {
        super("Muro Andante", 5, "Se posiciona frente a un aliado; recibe el 100% de los ataques dirigidos a él (1T).", false, "buf");
    }
}

