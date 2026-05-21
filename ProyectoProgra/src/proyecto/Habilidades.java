package proyecto;

import java.util.List;

/**
 * Clase base para todas las habilidades del juego.
 * Gestiona el cooldown, la precisión, el tipo de habilidad y su ejecución.
 * Las habilidades específicas heredan de esta clase o de sus especializaciones
 * mecánicas.
 */
public class Habilidades {

    private String nombre;
    private int cooldownBase;
    private int cooldownActual;
    private String efecto;
    private String tipo;
    private int precision;

    // Constructor nuevo (del compañero): tipo y precision explícitos
    /**
     * Constructor para la clase Habilidades.
     * 
     * @param nombre       El nombre de la habilidad (ej. "Tajo Mortal",
     *                     "Curación").
     * @param cooldownBase El tiempo de espera estándar (en turnos o segundos) antes
     *                     de poder reusar la habilidad.
     * @param efecto       Una descripción textual o identificador de la acción que
     *                     realiza la habilidad.
     * @param tipo         La categoría de la habilidad (ej. "Ofensiva",
     *                     "Defensiva", "Buff").
     * @param precision    El valor de probabilidad de éxito para que el efecto de
     *                     la habilidad se aplique.
     */
    public Habilidades(String nombre, int cooldownBase, String efecto, String tipo, int precision) {
        this.nombre = nombre;
        this.cooldownBase = cooldownBase;
        this.cooldownActual = 0;
        this.efecto = efecto;
        this.tipo = tipo;
        this.precision = precision;
    }

    // Constructor antiguo (compatibilidad con ListaHabilidades): aDistancia se
    // ignora, precision por defecto 80
    /**
     * Constructor alternativo para compatibilidad (antes existia un
     * ListaHabilidades donde se usaba distancia).
     * * Este constructor permite instanciar una habilidad sin especificar la
     * precisión,
     * asignando un valor predeterminado del 80%. El parámetro {@code aDistancia} se
     * incluye por motivos de compatibilidad con versiones antiguas, pero no afecta
     * a la lógica interna actual del objeto.
     *
     * @param nombre       El nombre identificativo de la habilidad.
     * @param cooldownBase El tiempo de espera base antes de que la habilidad pueda
     *                     reutilizarse.
     * @param efecto       La descripción o identificador de la acción que realiza.
     * @param aDistancia   Parámetro de legado (actualmente ignorado por el
     *                     sistema).
     * @param tipo         La categoría o clasificación de la habilidad.
     */
    public Habilidades(String nombre, int cooldownBase, String efecto, boolean aDistancia, String tipo) {
        this(nombre, cooldownBase, efecto, tipo, 80);
    }

    // SETTERS Y GETTERS
    /**
     * Metodo getNombre.
     * 
     * @return getNombre valor.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo getCooldownBase.
     * 
     * @return getCooldownBase valor.
     */
    public int getCooldownBase() {
        return this.cooldownBase;
    }

    /**
     * Metodo getCooldownActual.
     * 
     * @return getCooldownActual valor.
     */
    public int getCooldownActual() {
        return this.cooldownActual;
    }

    /**
     * Metodo getEfecto.
     * 
     * @return getEfecto valor.
     */
    public String getEfecto() {
        return this.efecto;
    }

    /**
     * Metodo getTipo.
     * 
     * @return getTipo valor.
     */
    public String getTipo() {
        return this.tipo;
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
     * Metodo setNombre.
     * 
     * @param nombre parametro.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo setCooldownBase.
     * 
     * @param cooldownBase parametro.
     */
    public void setCooldownBase(int cooldownBase) {
        this.cooldownBase = cooldownBase;
    }

    /**
     * Metodo setCooldownActual.
     * 
     * @param cooldownActual parametro.
     */
    public void setCooldownActual(int cooldownActual) {
        this.cooldownActual = cooldownActual;
    }

    /**
     * Metodo setEfecto.
     * 
     * @param efecto parametro.
     */
    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    /**
     * Metodo setTipo.
     * 
     * @param tipo parametro.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * Metodo reducirCooldown.
     */
    public void reducirCooldown() {
        if (this.cooldownActual > 0) {
            this.cooldownActual--;
        }
    }

    /**
     * Metodo estaDisponible.
     * 
     * @return estaDisponible valor.
     */
    public boolean estaDisponible() {
        return this.cooldownActual == 0;
    }

    /**
     * Metodo usarHabilidad.
     */
    public void usarHabilidad() {
        this.cooldownActual = this.cooldownBase;
    }

    /**
     * Metodo EjecutarHabilidad.
     * 
     * @param objetivos parametro.
     */
    public void EjecutarHabilidad(List<Entidad> objetivos) {
        usarHabilidad();
    }
}
