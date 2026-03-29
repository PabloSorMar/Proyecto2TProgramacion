package proyecto.habilidades;


/**
 * Habilidad: Sobrecarga
 * Descripción: Aumenta el daño del arma a cambio de reducir la Precisión.
 */
public class Sobrecarga extends EfectoBufPrecision {
    public Sobrecarga() {
        super("Sobrecarga", 3, "Aumenta el daño del arma a cambio de reducir la Precisión.", true, "buf", 20);
    }
}

