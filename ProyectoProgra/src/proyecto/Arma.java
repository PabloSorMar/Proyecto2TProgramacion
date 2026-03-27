package proyecto;

public class Arma {
    private String nombre;
    private int daño;
    private int precision;
    private boolean esMelee;
    private int municionAct;
    private int municionMax;
    private int cantidadObjetivos;
    private String efecto;
    private int numAtaques;

    Arma(String nombre, int daño, int precision, boolean esMelee, int municionMax, int cantidadObjetivos, String efecto, int numAtaques) {
        this.nombre = nombre;
        this.daño = daño;
        this.precision = precision;
        this.esMelee = esMelee;
        this.municionMax = municionMax;
        this.municionAct = municionMax;
        this.cantidadObjetivos = cantidadObjetivos;
        this.efecto = efecto;
        this.numAtaques = numAtaques;
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDaño(int daño) { this.daño = daño; }
    public void setPrecision(int precision) { this.precision = precision; }
    public void setEsMelee(boolean esMelee) { this.esMelee = esMelee; }
    public void setMunicionAct(int municionAct) { this.municionAct = municionAct; }
    public void setMunicionMax(int municionMax) { this.municionMax = municionMax; }
    public void setCantidadObjetivos(int cantidadObjetivos) { this.cantidadObjetivos = cantidadObjetivos; }
    public void setEfecto(String efecto) { this.efecto = efecto; }
    public void setNumAtaques(int numAtaques) { this.numAtaques = numAtaques; }

    public String getNombre() { return this.nombre; }
    public int getDaño() { return this.daño; }
    public int getPrecision() { return this.precision; }
    public boolean getEsMelee() { return this.esMelee; }
    public int getMunicionAct() { return this.municionAct; }
    public int getMunicionMax() { return this.municionMax; }
    public int getCantidadObjetivos() { return this.cantidadObjetivos; }
    public String getEfecto() { return this.efecto; }
    public int getNumAtaques() { return this.numAtaques; }

    public int disparar() {
        if (this.esMelee) {
            return this.daño;
        } else if (this.municionAct > 0) {
            gastarMunicion();
            return this.daño;
        }
        return 0; // Sin munición
    }

    public void gastarMunicion() {
        if (this.municionAct > 0) {
            this.municionAct--;
        }
    }
}
