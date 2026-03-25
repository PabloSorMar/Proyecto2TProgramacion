package proyecto;

public enum ListaArmaduras {
    LIGERA("Ligera", 5, 2),
    MEDIA("Media", 10, 0),
    PESADA("Pesada", 20, -2),
    ENERGIA("Energía", 25, 1);

    private final String nombre;
    private final int puntosDefensa;
    private final int bonoVelocidad;

    ListaArmaduras(String nombre, int puntosDefensa, int bonoVelocidad) {
        this.nombre = nombre;
        this.puntosDefensa = puntosDefensa;
        this.bonoVelocidad = bonoVelocidad;
    }

    public Armaduras crearInstancia() {
        return new Armaduras(nombre, puntosDefensa, bonoVelocidad);
    }
}
