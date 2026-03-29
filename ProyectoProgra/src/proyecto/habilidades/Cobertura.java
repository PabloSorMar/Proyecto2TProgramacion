package proyecto.habilidades;


/**
 * Habilidad: Cobertura
 * Descripción: Reduce la probabilidad de impacto del enemigo en un -15% durante 2 turnos.
 */
public class Cobertura extends EfectoEscudoInvulnerable {
    public Cobertura() {
        super("Cobertura", 2, "Reduce la probabilidad de impacto del enemigo en un -15% durante 2 turnos.", false, "buf");
    }
}

