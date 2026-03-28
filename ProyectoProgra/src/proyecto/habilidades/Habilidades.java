package proyecto;

public class Habilidades {
    private String nombre;
    private int cooldownBase;
    private int cooldownActual;
    private String efecto;

    private String tipo;
    private int precision;

    public Habilidades(String nombre, int cooldownBase, String efecto,  String tipo, int precision) {
        this.nombre = nombre;
        this.cooldownBase = cooldownBase;
        this.cooldownActual = 0; // Starts ready
        this.efecto = efecto;

        this.tipo = tipo;
        this.precision = precision;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getCooldownBase() {
        return this.cooldownBase;
    }

    public int getCooldownActual() {
        return this.cooldownActual;
    }

    public String getEfecto() {
        return this.efecto;
    }



    public String getTipo() {
        return this.tipo;
    }
    public int getPrecision() {
        return this.precision;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCooldownBase(int cooldownBase) {
        this.cooldownBase = cooldownBase;
    }

    public void setCooldownActual(int cooldownActual) {
        this.cooldownActual = cooldownActual;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }



    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
      public void setPrecision(int precision) {
        this.precision = precision;
    }


    public void reducirCooldown() {
        if (this.cooldownActual > 0) {
            this.cooldownActual--;
        }
    }

    public boolean estaDisponible() {
        return this.cooldownActual == 0;
    }

    public void usarHabilidad() {
        this.cooldownActual = this.cooldownBase;
    }

    public void EjecutarHabilidad(java.util.List<Entidad> objetivos) {
        usarHabilidad();
    }
}