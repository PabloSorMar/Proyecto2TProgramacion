package proyecto;

import java.util.List;
import java.util.Random;

public class Entidad {
    private String nombre;
    private int vidaActual;
    private int vidaMax;
    private boolean esDistancia;
    private int turnosStun;
    private int turnosHemorragia;
    private int turnosVeneno;
    private boolean estaDefendido;

    public Entidad(String nombre, int vidaMax, boolean esDistancia) {
        this.nombre = nombre;
        this.vidaMax = vidaMax;
        this.vidaActual = vidaMax;
        this.esDistancia = esDistancia;
        this.turnosStun = 0;
        this.turnosHemorragia = 0;
        this.turnosVeneno = 0;
        this.estaDefendido = false;
    }

    public String getNombre() { return this.nombre; }
    public int getVidaActual() { return this.vidaActual; }
    public int getVidaMax() { return this.vidaMax; }

    public void recibirDaño(int cant) {
        this.vidaActual -= cant;
        if(this.vidaActual < 0) this.vidaActual = 0;
    }

    public boolean estaVivo() {
        return this.vidaActual > 0;
    }

    public void ejecutarIA() {
        System.out.println(this.nombre + " decide pasar turno hoy.");
    }
}