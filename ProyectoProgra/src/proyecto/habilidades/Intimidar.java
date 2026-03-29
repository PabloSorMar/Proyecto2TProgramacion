package proyecto.habilidades;


/**
 * Habilidad: Intimidar
 * Descripción: Reduce la Precisión de los enemigos en un -20% durante 1 turno.
 */
public class Intimidar extends EfectoDebufPrecisionArea {
    public Intimidar() {
        super("Intimidar", 3, "Reduce la Precisión de los enemigos en un -20% durante 1 turno.", true, "debuf", 20);
    }
}

