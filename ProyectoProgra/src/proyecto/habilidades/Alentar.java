package proyecto.habilidades;


/**
 * Habilidad: Alentar
 * Descripción: Potencia el daño de todos los aliados en un +15% durante ese turno.
 */
public class Alentar extends EfectoBufVelocidad {
    public Alentar() {
        super("Alentar", 4, "Potencia el daño de todos los aliados en un +15% durante ese turno.", false, "buf", 30);
    }
}

