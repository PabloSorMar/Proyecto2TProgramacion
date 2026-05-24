package proyecto;

/**
 * Representa un arma en el juego.
 * Gestiona estadísticas de daño, precisión, tipo (melee/rango) y munición.
 * Define cuántos ataques realiza y a cuántos objetivos puede golpear.
 */
public class Arma {

    private String nombre;
    private int daño;
    private int precision;
    private boolean esMelee;
    private int municionAct;
    private int municionMax;
    private int cantidadObjetivos;
    private int numAtaques;

    /**
     * Constructor para crear una nueva instancia de la clase Arma.
     * 
     * @param nombre            El nombre identificativo del arma.
     * @param daño              La cantidad de puntos de daño que inflige el arma
     *                          por impacto.
     * @param precision         El porcentaje o valor de probabilidad de acierto del
     *                          arma.
     * @param esMelee           Indica si el arma es de cuerpo a cuerpo o a
     *                          distancia.
     * @param municionMax       La capacidad máxima de proyectiles o usos que puede
     *                          almacenar el arma.
     * @param cantidadObjetivos El número máximo de enemigos que pueden ser
     *                          alcanzados en un solo ataque.
     * @param numAtaques        La cantidad de veces que el arma puede atacar en un
     *                          mismo turno o acción.
     */

    public Arma(String nombre, int daño, int precision, boolean esMelee, int municionMax, int cantidadObjetivos,
            int numAtaques) {
        this.nombre = nombre;
        this.daño = daño;
        this.precision = precision;
        this.esMelee = esMelee;
        this.municionMax = municionMax;
        this.municionAct = municionMax;
        this.cantidadObjetivos = cantidadObjetivos;
        this.numAtaques = numAtaques;
    }

    // SETTER Y GETTERS
    /**
     * Metodo setNombre.
     * 
     * @param nombre parametro.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo setDaño.
     * 
     * @param daño parametro.
     */
    public void setDaño(int daño) {
        this.daño = daño;
    }

    /**
     * Metodo setPrecision.
     * 
     * @param precision parametro.
     */
    public void setPrecision(int precision) {
        this.precision = precision;
    }

    /**
     * Metodo setEsMelee.
     * 
     * @param esMelee parametro.
     */
    public void setEsMelee(boolean esMelee) {
        this.esMelee = esMelee;
    }

    /**
     * Metodo setMunicionAct.
     * 
     * @param municionAct parametro.
     */
    public void setMunicionAct(int municionAct) {
        this.municionAct = municionAct;
    }

    /**
     * Metodo setMunicionMax.
     * 
     * @param municionMax parametro.
     */
    public void setMunicionMax(int municionMax) {
        this.municionMax = municionMax;
    }

    /**
     * Metodo setCantidadObjetivos.
     * 
     * @param cantidadObjetivos parametro.
     */
    public void setCantidadObjetivos(int cantidadObjetivos) {
        this.cantidadObjetivos = cantidadObjetivos;
    }

    /**
     * Metodo setNumAtaques.
     * 
     * @param numAtaques parametro.
     */
    public void setNumAtaques(int numAtaques) {
        this.numAtaques = numAtaques;
    }

    /**
     * Metodo getNombre.
     * 
     * @return getNombre valor.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo getDaño.
     * 
     * @return getDaño valor.
     */
    public int getDaño() {
        return this.daño;
    }

    /**
     * Metodo getPrecision.
     * 
     * @return getPrecision valor.
     */
    public int getPrecision() {
        return this.precision;
    }

    /**
     * Metodo getEsMelee.
     * 
     * @return getEsMelee valor.
     */
    public boolean getEsMelee() {
        return this.esMelee;
    }

    /**
     * Metodo getMunicionAct.
     * 
     * @return getMunicionAct valor.
     */
    public int getMunicionAct() {
        return this.municionAct;
    }

    /**
     * Metodo getMunicionMax.
     * 
     * @return getMunicionMax valor.
     */
    public int getMunicionMax() {
        return this.municionMax;
    }

    /**
     * Metodo getCantidadObjetivos.
     * 
     * @return getCantidadObjetivos valor.
     */
    public int getCantidadObjetivos() {
        return this.cantidadObjetivos;
    }

    /**
     * Metodo getNumAtaques.
     * 
     * @return getNumAtaques valor.
     */
    public int getNumAtaques() {
        return this.numAtaques;
    }

}