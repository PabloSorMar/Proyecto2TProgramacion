package proyecto.habilidades;


/**
 * Habilidad: Despliegue de Torreta
 * Descripción: Despliega una torreta defensiva que barre el área.
 */
public class Torreta extends EfectoDanoArea {
    public Torreta() {
        super("Despliegue de Torreta", 5, "Despliega una torreta defensiva que barre el área.", true, "ofensiva", 35);
    }
}

