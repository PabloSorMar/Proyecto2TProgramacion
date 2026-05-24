package proyecto;

/**
 * Representa la armadura de una entidad.
 * Define el nivel de protección (blindaje) y la iniciativa en combate
 * (velocidad).
 */
public class Armaduras {

    private String nombre;
    private int blindaje;
    private int velocidad;

    /**
     * onstructor para la clase Armaduras.
     * 
     * @param nombre    El nombre descriptivo de la armadura (ej. "Cota de malla",
     *                  "Peto de acero").
     * @param blindaje  El valor numérico que indica la reducción de daño o nivel de
     *                  defensa.
     * @param velocidad El modificador que afecta el movimiento del personaje al
     *                  portar la armadura.
     */
    public Armaduras(String nombre, int blindaje, int velocidad) {
        this.nombre = nombre;
        this.blindaje = blindaje;
        this.velocidad = velocidad;
    }

    // SETERS Y GETTERS
    /**
     * Metodo setNombre.
     * 
     * @param nombre parametro.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo setBlindaje.
     * 
     * @param blindaje parametro.
     */
    public void setBlindaje(int blindaje) {
        this.blindaje = blindaje;
    }

    /**
     * Metodo setVelocidad.
     * 
     * @param velocidad parametro.
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Metodo getnombre.
     * 
     * @return getnombre valor.
     */
    public String getnombre() {
        return this.nombre;
    }

    /**
     * Metodo getBlindaje.
     * 
     * @return getBlindaje valor.
     */
    public int getBlindaje() {
        return this.blindaje;
    }

    /**
     * Metodo getVelocidad.
     * 
     * @return getVelocidad valor.
     */
    public int getVelocidad() {
        return this.velocidad;
    }
}