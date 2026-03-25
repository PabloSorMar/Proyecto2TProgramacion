package proyecto;

import java.util.List;

public class Heroe extends Entidad {
    private String faccion;

    public Heroe(String nombre, int vidaMax, boolean esDistancia, String faccion) {
        super(nombre, vidaMax, esDistancia);
        this.faccion = faccion;
    }

    public String getFaccion() { return this.faccion; }
    public void setFaccion(String faccion) { this.faccion = faccion; }

    public int elegirAccion() {
        return 0; 
    }

    public void restaurarPostCombate() {
        
    }
}