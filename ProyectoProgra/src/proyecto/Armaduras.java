package proyecto;
/**
 * Representa la armadura de una entidad.
 * Define el nivel de protección (blindaje) y la iniciativa en combate (velocidad).
 */
public class Armaduras {

    private String nombre;
    private int blindaje;
    private int velocidad;


    /**
     * onstructor para la clase Armaduras.
     * @param nombre    El nombre descriptivo de la armadura (ej. "Cota de malla", "Peto de acero").
     * @param blindaje  El valor numérico que indica la reducción de daño o nivel de defensa.
     * @param velocidad El modificador que afecta el movimiento del personaje al portar la armadura.
     */
    Armaduras( String nombre,int blindaje, int velocidad)
    {
        this.nombre = nombre;
        this.blindaje = blindaje;
        this.velocidad = velocidad;
    }

    //SETERS Y GETTERS
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setBlindaje(int blindaje){this.blindaje = blindaje;}
    public void setVelocidad(int velocidad){this.velocidad = velocidad;}
   
    public String getnombre(){ return this.nombre;}
    public int getBlindaje(){ return this.blindaje;}
    public int getVelocidad(){ return this.velocidad;}
}
