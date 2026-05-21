package proyecto;

import java.util.List;

/**
 * Especialización de Entidad para los personajes jugadores.
 * Soporta un arma secundaria (arma2) adicional.
 */
public class Heroe extends Entidad {

    private Arma arma2;

    /**
     * Constructor para la clase Heroe.
     * * Este método extiende la funcionalidad de la clase bas añadiendo una segunda
     * arma específica para el héroe.
     * 
     * @param nombre      El nombre propio o alias del héroe.
     * @param faccion     El bando o grupo al que pertenece el héroe (ej. "Alianza",
     *                    "Horda").
     * @param vida        Los puntos de salud máximos iniciales del héroe.
     * @param arma        El arma principal equipada.
     * @param armadura    La pieza de equipo defensivo que porta el héroe.
     * @param habilidades La lista de técnicas o poderes especiales disponibles para
     *                    el héroe.
     * @param arma2       El arma secundaria o adicional que posee el héroe.
     */
    Heroe(String nombre, String faccion, int vida, Arma arma, Armaduras armadura, List<Habilidades> habilidades,
            Arma arma2) {
        super(nombre, faccion, vida, arma, armadura, habilidades);
        this.arma2 = arma2;
    }

    /**
     * Metodo getArma2.
     * 
     * @return getArma2 valor.
     */
    public Arma getArma2() {
        return this.arma2;
    }

    /**
     * Metodo setArma2.
     * 
     * @param arma2 parametro.
     */
    public void setArma2(Arma arma2) {
        this.arma2 = arma2;
    }

    /**
     * Ejecuta la lógica de combate correspondiente al turno del Héroe.
     * * Este método está marcado con {@code @Override} ya que redefine el
     * comportamiento
     * de la clase base. Actualmente, delega toda la ejecución a
     * {@code super.RealizarTurno},
     * lo que implica que el Héroe actuará siguiendo la lógica automatizada
     * (aleatoria)
     * definida para cualquier entidad general del juego.
     *
     * @param aliados   Una lista de objetos {@code Entidad} que forman parte del
     *                  bando del Héroe.
     * @param enemigos  Una lista de objetos {@code Entidad} identificados como
     *                  objetivos hostiles.
     * @param personaje La instancia específica de la entidad que está ejecutando la
     *                  acción
     *                  (usualmente el propio Héroe).
     */
    @Override
    public void RealizarTurno(List<Entidad> aliados, List<Entidad> enemigos, Entidad personaje) {
        // Por ahora, el Héroe realiza el turno exactamente igual que una Entidad (de
        // forma aleatoria).
        // Al usar super.RealizarTurno() estamos llamando a la función padre que ya
        // contiene toda la lógica.
        super.RealizarTurno(aliados, enemigos, personaje);
    }
}
