package proyecto;

public abstract class Entidad{
    private String nombre;
    private int vida;
    private boolean distancia;
    private int turnoStun;
    private int turnoHemorragia;
    private int turnoVeneno;
    public boolean defendido;

    Entidad(String nombre, int vida, boolean distancia, int turnoStun, int turnoHemorragia, int turnoVeneno, boolean defendido){
        this.nombre = nombre;
        this.vida = vida;
        this.distancia = distancia;
        this.turnoStun = turnoStun;
        this.turnoHemorragia = turnoHemorragia;
        this.turnoVeneno = turnoVeneno;
        this.defendido = defendido;
    }
    
    public String getNombre(){return this.nombre;}
    public int getVida(){return this.vida;}
    public boolean getDistancia(){return this.distancia;}
    public int getTurnoStun(){return his.turnoStun;}
    public int getTurnoHemorragia(){return this.turnoHemorragia;}
    public int getTurnoVeneno(){return this.turnoVeneno;}
    public boolean getDefendido(){return this.defendido;}

    public void setNombre(String nombre){this.nombre = nombre;}
    public void setVida(int vida){this.vida = vida;}
    public void setDistancia(boolean distancia){this.distancia = distancia;}
    public void setTurnoStun(int turnoStun){this.turnoStun = turnoStun;}
    public void setTurnoHemorragia(int turnoHemorragia){this.turnoHemorragia = turnoHemorragia;}
    public void setTurnoVeneno(int turnoVeneno){this.turnoVeneno = turnoVeneno;}
    public void setDefendido(boolean defendido){this.defendido = defendido;}
}