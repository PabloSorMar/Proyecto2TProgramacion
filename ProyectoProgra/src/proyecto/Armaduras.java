package proyecto;

public class Armaduras {
    private String nombre;
    private int puntosDefensa;
    private int bonoVelocidad;

    public Armaduras(String nombre, int puntosDefensa, int bonoVelocidad) {
        this.nombre = nombre;
        this.puntosDefensa = puntosDefensa;
        this.bonoVelocidad = bonoVelocidad;
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPuntosDefensa(int puntosDefensa) { this.puntosDefensa = puntosDefensa; }
    public void setBonoVelocidad(int bonoVelocidad) { this.bonoVelocidad = bonoVelocidad; }
   
    public String getNombre() { return this.nombre; }
    public int getPuntosDefensa() { return this.puntosDefensa; }
    public int getBonoVelocidad() { return this.bonoVelocidad; }
}
