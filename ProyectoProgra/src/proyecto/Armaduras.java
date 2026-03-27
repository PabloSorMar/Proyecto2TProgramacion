package proyecto;
public class Armaduras {
    private String nombre;
    private int blindaje;
    private int velocidad;


    Armaduras( String nombre,int armadura, int velocidad)
    {
        this.nombre = nombre;
        this.armadura = armadura;
        this.velocidad = velocidad;
    }

    //SETERS Y GETTERS
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setArmadura(int blindaje){this.blindaje = blindaje;}
    public void setVelocidad(int velocidad){this.velocidad = velocidad;}
   
    public String getnombre(){ return this.nombre;}
    public int getBlindaje(){ return this.blindaje;}
    public int getVelocidad(){ return this.velocidad;}
}
