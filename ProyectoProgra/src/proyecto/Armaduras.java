package proyecto;
public class Armaduras {
    private String nombre;
    private int armadura;
    private int velocidad;


    Armaduras( String nombre,int armadura, int velocidad)
    {
        this.nombre = nombre;
        this.armadura = armadura;
        this.velocidad = velocidad;
    }

    //SETERS Y GETTERS
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setArmadura(int armadura){this.armadura = armadura;}
    public void setVelocidad(int velocidad){this.velocidad = velocidad;}
   
    public String getnombre(){ return this.nombre;}
    public int getArmadura(){ return this.armadura;}
    public int getVelocidad(){ return this.velocidad;}
}
