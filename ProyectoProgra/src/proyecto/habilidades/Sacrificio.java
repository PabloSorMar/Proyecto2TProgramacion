package proyecto.habilidades;


/**
 * Habilidad: Sacrificio
 * Descripción: Sacrifica energía para sanar a un aliado.
 */
public class Sacrificio extends EfectoCuracionIndividual {
    public Sacrificio() {
        super("Sacrificio", 3, "Sacrifica energía para sanar a un aliado.", true, "curacion", 35);
    }
}

