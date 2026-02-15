package proyecto;


public class Arma {
    private String nombre;
    private int daño;
    private int precision;
    private int cantidad_objetivos;
    private String efecto;
    private int num_ataques;
    


    Arma( String nombre,int daño, int precision, int cantidad_objetivos, String efecto, int num_ataques)
    {
        this.nombre = nombre;
        this.daño = daño;
        this.precision = precision;
        this.cantidad_objetivos = cantidad_objetivos;
        this.efecto = efecto;
        this.num_ataques = num_ataques;
    }

    //SETTERS Y GETTERS
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setDaño(int daño){this.daño = daño;}
    public void setPrecision(int precision){this.precision = precision;}
    public void setCantidadObj(int cantidad_objetivos){this.cantidad_objetivos = cantidad_objetivos;}
    public void setEfecto(String efecto){this.efecto = efecto;}
    public void setNumAtaques(int num_ataques){this.num_ataques = num_ataques;}

    public String getnombre(){ return this.nombre;}
    public int getDaño(){ return this.daño;}
    public int getPrecision(){ return this.precision;}
    public int getCantidadObj(){ return this.cantidad_objetivos;}
    public String getEfecto(){ return this.efecto;}
    public int getNumAtaques(){ return this.num_ataques;}

}
