package proyecto.habilidades;


/**
 * Habilidad: Invulnerable
 * Descripción: La unidad se vuelve invulnerable por un breve periodo.
 */
public class Invulnerable extends EfectoEscudoInvulnerable {
    public Invulnerable() {
        super("Invulnerable", 5, "La unidad se vuelve invulnerable por un breve periodo.", false, "buf");
    }
}

