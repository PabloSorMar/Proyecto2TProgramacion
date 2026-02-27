package proyecto;
public class Habilidades{
    private String nombre;
    private int cooldown;
    private String efecto;
    private boolean distancia;

    Habilidades(String nombre, int cooldown, String efecto, boolean distancia){
        this.nombre = nombre;
        this.cooldown = cooldown;
        this.efecto = efecto;
        this.distancia = distancia;
    }

    public String getNombre(){return this.nombre;}
    public int getCooldown(){return this.cooldown;}
    public String getEfecto(){return this.efecto;}
    public boolean getDistancia(){return this.distancia;}

    public void setNombre(String nombre){this.nombre = nombre;}
    public void setCooldown(int cooldown){this.cooldown = cooldown;}
    public void setEfecto(String efecto){this.efecto = efecto;}
    public void setDistancia(boolean distancia){this.distancia = cooldown;}
}