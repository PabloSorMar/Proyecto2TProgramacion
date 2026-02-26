package proyecto;
public class Habilidades{
    private String nombre;
    private int cooldown;
    private String efecto;

    habilidad(String nombre, int cooldown, String efecto){
        this.nombre = nombre;
        this.cooldown = cooldown;
        this.efecto = efecto;
    }

    public void getNombre(String nombre){this.nombre = nombre;}
    public void getCooldown(int cooldown){this.cooldown = cooldown;}
    public void getEfecto(String efecto){this.efecto = efecto;}

    public void setNombre(){this.nombre = nombre;}
    public void setCooldown(){this.cooldown = cooldown;}
    public void setEfecto(){this.efecto = efecto;}
}