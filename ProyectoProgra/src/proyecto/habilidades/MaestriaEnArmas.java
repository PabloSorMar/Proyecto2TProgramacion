package proyecto.habilidades;


/**
 * Habilidad: Maestría en Armas
 * Descripción: El personaje puede atacar sin gastar munición durante este turno.
 */
public class MaestriaEnArmas extends RecargarArma {
    public MaestriaEnArmas() {
        super("Maestría en Armas", 4, "El personaje puede atacar sin gastar munición durante este turno.", false, "buf");
    }
}

