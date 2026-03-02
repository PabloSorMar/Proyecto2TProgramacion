package proyecto;
public class Habilidades{
    private String nombre;
    private int cooldown;
    private String efecto;
    private boolean distancia;
    private String tipo;

    Habilidades(String nombre, int cooldown, String efecto, boolean distancia, String tipo){
        this.nombre = nombre;
        this.cooldown = cooldown;
        this.efecto = efecto;
        this.distancia = distancia;
        this.tipo = tipo;
    }

    public String getNombre(){return this.nombre;}
    public int getCooldown(){return this.cooldown;}
    public String getEfecto(){return this.efecto;}
    public boolean getDistancia(){return this.distancia;}
    public String getTipo(){return this.tipo;}

    public void setNombre(String nombre){this.nombre = nombre;}
    public void setCooldown(int cooldown){this.cooldown = cooldown;}
    public void setEfecto(String efecto){this.efecto = efecto;}
    public void setDistancia(boolean distancia){this.distancia = cooldown;}
    public void setTipo(String tipo){this.tipo = tipo;}

}