package proyecto;

public abstract class Entidad{
    private String nombre;
    private int vida;
    private boolean distancia;
    private int turnoStun;
    private int turnoHemorragia;
    private int turnoVeneno;
    public boolean defendido;

    entidad(String nombre, int vida, boolean distancia, int turnoStun, int turnoHemorragia, int turnoVeneno, boolean defendido){
        this.nombre = nombre;
        this.vida = vida;
        this.distancia = distancia;
        this.turnoStun = turnoStun;
        this.turnoHemorragia = turnoHemorragia;
        this. turnoVeneno = turnoVeneno;
        this.defendido = defendido;
    }
    
    public void getNombre(String nombre){this.nombre = nombre;}
    public void getVida(int vida){this.vida = vida;}
    public void getDistancia(boolean distancia){this.distancia = distancia;}
    public void getTurnoStun(int turnoStun){this.turnoStun = turnoStun;}
    public void getTurnoHemorragia(int turnoHemorragia){this.turnoHemorragia = turnoHemorragia;}
    public void getTurnoVeneno(int turnoVeneno){this.turnoVeneno = turnoVeneno;}
    public void getDefendido(boolean defendido){this.defendido = defendido;}

    public void setNombre(){this.nombre = nombre;}
    public void setVida(){this.vida = vida;}
    public void setDistancia(){this.distancia = distancia;}
    public void setTurnoStun(){this.turnoStun = turnoStun;}
    public void setTurnoHemorragia(){this.turnoHemorragia = turnoHemorragia;}
    public void setTurnoVeneno(){this.turnoVeneno = turnoVeneno;}
    public void setDefendido(){this.defendido = defendido;}
}