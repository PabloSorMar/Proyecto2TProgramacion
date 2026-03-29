package proyecto.habilidades;

/**
 * Habilidad: Valor Cadiano
 * Descripción: Mejora la reducción de daño por armadura en un +20% (2 turnos).
 */
public class ValorCadiano extends EfectoEscudoInvulnerable {
    public ValorCadiano() {
        super("Valor Cadiano", 0, "Mejora la reducción de daño por armadura en un +20% (2 turnos).", false, "buf");
    }
}
