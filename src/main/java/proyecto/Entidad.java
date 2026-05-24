package proyecto;

import java.util.List;
import java.util.Random;

/**
 * Representa cualquier personaje (Héroe o Enemigo) en el juego.
 * Gestiona estadísticas como vida, estados alterados (stun, hemorragia,
 * veneno),
 * equipamiento (arma, armadura) y el inventario de habilidades.
 * Contiene la lógica principal de la IA para realizar turnos de combate.
 */
public class Entidad {

    private String nombre;
    private String faccion;
    private int vida;
    private int turnoStun;
    private int turnoHemorragia;
    private int turnoVeneno;
    private int turnoCuracion;
    private boolean defendido;
    private Arma arma;
    private Armaduras armadura;
    private List<Habilidades> habilidades;

    /**
     * Constructor para la clase Entidad.
     * Inicializa una unidad de combate con sus estadísticas básicas, equipo y
     * habilidades.
     * Además, resetea todos los estados alterados y contadores de efectos
     * temporales
     * (stun, hemorragia, veneno, curación) a su valor inicial (0 o falso),
     * garantizando
     * que la entidad comience el encuentro en un estado neutral.
     * 
     * @param nombre      El nombre identificativo de la entidad.
     * @param faccion     La facción o bando al que pertenece (afecta a la selección
     *                    de objetivos).
     * @param vida        Los puntos de salud máximos iniciales.
     * @param arma        El objeto {@link Arma} que portará la entidad para sus
     *                    ataques básicos.
     * @param armadura    El objeto {@link Armaduras} que define su capacidad
     *                    defensiva.
     * @param habilidades Una lista de objetos {@link Habilidades} disponibles para
     *                    esta unidad.
     */
    public Entidad(String nombre, String faccion, int vida, Arma arma, Armaduras armadura,
            List<Habilidades> habilidades) {
        this.nombre = nombre;
        this.faccion = faccion;
        this.vida = vida;
        this.turnoStun = 0;
        this.turnoHemorragia = 0;
        this.turnoVeneno = 0;
        this.turnoCuracion = 0;
        this.defendido = false;
        this.arma = arma;
        this.armadura = armadura;
        this.habilidades = habilidades;
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
     * Metodo getFaccion.
     * 
     * @return getFaccion valor.
     */
    public String getFaccion() {
        return this.faccion;
    }

    /**
     * Metodo getVida.
     * 
     * @return getVida valor.
     */
    public int getVida() {
        return this.vida;
    }

    /**
     * Metodo getTurnoStun.
     * 
     * @return getTurnoStun valor.
     */
    public int getTurnoStun() {
        return this.turnoStun;
    }

    /**
     * Metodo getTurnoHemorragia.
     * 
     * @return getTurnoHemorragia valor.
     */
    public int getTurnoHemorragia() {
        return this.turnoHemorragia;
    }

    /**
     * Metodo getTurnoVeneno.
     * 
     * @return getTurnoVeneno valor.
     */
    public int getTurnoVeneno() {
        return this.turnoVeneno;
    }

    /**
     * Metodo getTurnoCuracion.
     * 
     * @return getTurnoCuracion valor.
     */
    public int getTurnoCuracion() {
        return this.turnoCuracion;
    }

    /**
     * Metodo getDefendido.
     * 
     * @return getDefendido valor.
     */
    public boolean getDefendido() {
        return this.defendido;
    }

    /**
     * Metodo getArma.
     * 
     * @return getArma valor.
     */
    public Arma getArma() {
        return this.arma;
    }

    /**
     * Metodo getArmadura.
     * 
     * @return getArmadura valor.
     */
    public Armaduras getArmadura() {
        return this.armadura;
    }

    /**
     * Metodo getHabilidades.
     * 
     * @return getHabilidades valor.
     */
    public List<Habilidades> getHabilidades() {
        return this.habilidades;
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
     * Metodo setFaccion.
     * 
     * @param faccion parametro.
     */
    public void setFaccion(String faccion) {
        this.faccion = faccion;
    }

    /**
     * Metodo setVida.
     * 
     * @param vida parametro.
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * Metodo setTurnoStun.
     * 
     * @param turnoStun parametro.
     */
    public void setTurnoStun(int turnoStun) {
        this.turnoStun = turnoStun;
    }

    /**
     * Metodo setTurnoHemorragia.
     * 
     * @param turnoHemorragia parametro.
     */
    public void setTurnoHemorragia(int turnoHemorragia) {
        this.turnoHemorragia = turnoHemorragia;
    }

    /**
     * Metodo setTurnoVeneno.
     * 
     * @param turnoVeneno parametro.
     */
    public void setTurnoVeneno(int turnoVeneno) {
        this.turnoVeneno = turnoVeneno;
    }

    /**
     * Metodo setTurnoCuracion.
     * 
     * @param turnoCuracion parametro.
     */
    public void setTurnoCuracion(int turnoCuracion) {
        this.turnoCuracion = turnoCuracion;
    }

    /**
     * Metodo setDefendido.
     * 
     * @param defendido parametro.
     */
    public void setDefendido(boolean defendido) {
        this.defendido = defendido;
    }

    /**
     * Metodo setArma.
     * 
     * @param arma parametro.
     */
    public void setArma(Arma arma) {
        this.arma = arma;
    }

    /**
     * Metodo setArmadura.
     * 
     * @param armadura parametro.
     */
    public void setArmadura(Armaduras armadura) {
        this.armadura = armadura;
    }

    /**
     * Metodo setHabilidades.
     * 
     * @param habilidades parametro.
     */
    public void setHabilidades(List<Habilidades> habilidades) {
        this.habilidades = habilidades;
    }

    // Devuelve el codigo ANSI de color segun la faccion de la entidad
    /**
     * Metodo getColorFaccion.
     * 
     * @return getColorFaccion valor.
     */
    public String getColorFaccion() {
        switch (this.faccion) {
            case "Astra Militarum":
                return "\u001B[32m"; // Verde
            case "Deathwatch":
                return "\u001B[96m"; // Cian brillante
            case "Orkos":
                return "\u001B[93m"; // Amarillo
            case "Necrones":
                return "\u001B[34m"; // Azul
            case "Tiránidos":
                return "\u001B[35m"; // Magenta
            case "Aeldari":
                return "\u001B[94m"; // Azul brillante
            case "T'au":
                return "\u001B[33m"; // Naranja/Amarillo
            case "Caos":
                return "\u001B[31m"; // Rojo
            default:
                return "\u001B[37m"; // Blanco
        }
    }

    /**
     * Gestiona la lógica completa del turno de una entidad controlada por la IA.
     * El flujo de ejecución sigue este orden estrictamente:
     * Limpieza de estados: Se desactiva el estado defensivo del turno anterior.
     * Verificación de incapacidad: Si la entidad está aturdida
     * ({@code turnoStun > 0}),
     * pierde el turno y reduce el contador.
     * Daño recurrente: Se aplica daño por hemorragia o veneno si los contadores son
     * activos.
     * Selección de acción aleatoria: Si puede actuar, elige una de las siguientes
     * opciones:
     * <b>Ataque (0):Selecciona un arma (incluyendo secundaria si es {@link Heroe}),
     * busca objetivos vivos y calcula daño, críticos y consumo de munición.
     * Defender (1): Aumenta el blindaje efectivo para el siguiente turno.
     * Habilidad (2): Elige una habilidad al azar y la ejecuta sobre el bando
     * apropiado
     * según el tipo (ofensiva/buf).
     * Recargar (3): Restaura la munición del arma actual.
     * Pasar (4):</b>
     *
     * @param aliados   Lista de entidades que comparten bando con el ejecutor.
     * @param enemigos  Lista de entidades hostiles para el ejecutor.
     * @param personaje Referencia a la entidad que está actuando (usado para
     *                  determinar bando).
     */
    public void RealizarTurno(List<Entidad> aliados, List<Entidad> enemigos, Entidad personaje) {
        // Poner color segun la faccion del perosnaje
        String COLOR = getColorFaccion();
        String RESET = "\u001B[0m";
        System.out.println(COLOR + "Turno de " + this.getNombre() + RESET);

        this.setDefendido(false);
        // Primero efectos activo de daño en si mismo
        if (this.getTurnoStun() > 0) {
            System.out.println("  " + this.getNombre() + " esta arturdido");
            setTurnoStun(getTurnoStun() - 1);
        } else {
            aplicarEstadosAlterados();

            // Aleatorio para ver que hace
            Random ran = new Random();
            int accion = ran.nextInt(0, 5);
            // Primera opcion, atacar con arma
            if (accion == 0) {
                Arma armaAUsar = seleccionarArma(ran);
                // Comprobamos de qué bando es el personaje para elegir sus objetivos
                if (aliados.contains(personaje)) {
                    // Heroe ataca a enemigos (multiplicador de defensa 3)
                    ejecutarAtaque(enemigos, armaAUsar, ran, 3);
                } else {
                    // Enemigo ataca a aliados (multiplicador de defensa 2)
                    ejecutarAtaque(aliados, armaAUsar, ran, 2);
                }
            } else if (accion == 1) {// Activa posicion defensiva y recibir menos daño
                System.out.println("  " + this.getNombre() + " decide  colocarse en posicion defensiva");
                this.setDefendido(true);
            } else if (accion == 2) {// caso de utilizar habilidades
                ejecutarHabilidadAleatoria(aliados, enemigos, personaje, ran);
            } else if (accion == 3) {// Accion de recargas las balas del arma
                Arma armaRecarga = this.getArma();
                if (armaRecarga.getMunicionMax() > 0) {
                    System.out.println("  " + this.getNombre() + " recarga su arma: " + armaRecarga.getNombre()
                            + " (" + armaRecarga.getMunicionAct() + " -> " + armaRecarga.getMunicionMax() + ")");
                    armaRecarga.setMunicionAct(armaRecarga.getMunicionMax());
                } else {
                    System.out.println("  " + this.getNombre() + " no necesita recargar (arma melee), pasa turno");
                }
            } else {
                System.out.println("  " + this.getNombre() + " decide pasar turno sin realizar ninguna accion");
            }

        }
    }

    private void aplicarEstadosAlterados() {
        if (this.getTurnoHemorragia() > 0) {
            setVida(getVida() - 10);
            setTurnoHemorragia(getTurnoHemorragia() - 1);
        }
        if (this.getTurnoVeneno() > 0) {
            setVida(getVida() - 10);
            setTurnoVeneno(getTurnoVeneno() - 1);
        }
    }

    private Arma seleccionarArma(Random ran) {
        Arma armaAUsar = this.getArma();
        if (this instanceof Heroe) {
            Heroe heroeActual = (Heroe) this;
            if (heroeActual.getArma2() != null) {
                if (ran.nextBoolean()) {
                    armaAUsar = heroeActual.getArma2();
                    System.out.println(
                            "  " + this.getNombre() + " decide atacar con su ARMA SECUNDARIA: "
                                    + armaAUsar.getNombre());
                    return armaAUsar;
                } else {
                    System.out.println(
                            "  " + this.getNombre() + " decide atacar con su ARMA PRINCIPAL: " + armaAUsar.getNombre());
                    return armaAUsar;
                }
            }
        }
        System.out.println("  " + this.getNombre() + " decide atacar con su arma: " + armaAUsar.getNombre());
        return armaAUsar;
    }

    private void ejecutarHabilidadAleatoria(List<Entidad> aliados, List<Entidad> enemigos, Entidad personaje,
            Random ran) {
        int habilidad_aleatoria = ran.nextInt(0, this.getHabilidades().size());
        Habilidades habilidadElegida = this.getHabilidades().get(habilidad_aleatoria);
        String tipoHab = habilidadElegida.getTipo();
        System.out.println("  " + this.getNombre() + " decide usar una habilidad: " + habilidadElegida.getNombre());

        boolean dirigidaAEnemigos = tipoHab.equals("ofensiva") || tipoHab.equals("debuf");
        List<Entidad> objetivos = (aliados.contains(personaje) == dirigidaAEnemigos) ? enemigos : aliados;
        habilidadElegida.EjecutarHabilidad(objetivos);
    }

    /**
     * Ejecuta la lógica de ataque con el arma seleccionada contra una lista de
     * objetivos.
     */
    private void ejecutarAtaque(List<Entidad> objetivos, Arma armaAUsar, Random ran, int multiplicadorDefensa) {
        if (objetivos.isEmpty()) {
            System.out.println("  No hay objetivos disponibles.");
            return;
        }
        for (int i = 0; i < armaAUsar.getCantidadObjetivos(); i++) {
            if (objetivos.isEmpty())
                break;

            // Elegir un objetivo vivo aleatoriamente
            int objetivo_aleatorio = ran.nextInt(0, objetivos.size());
            int intentos = 0;
            while (objetivos.get(objetivo_aleatorio).getVida() <= 0 && intentos < objetivos.size()) {
                objetivo_aleatorio = (objetivo_aleatorio + 1) % objetivos.size();
                intentos++;
            }
            if (objetivos.get(objetivo_aleatorio).getVida() <= 0)
                break; // Todos muertos

            Entidad objetivo = objetivos.get(objetivo_aleatorio);
            System.out.print("  Objetivo " + (i + 1) + ": " + objetivo.getNombre() + "\n");

            for (int j = 0; j < armaAUsar.getNumAtaques(); j++) {
                System.out.println("    Ataque numero " + (j + 1));

                int blindajeEfectivo = objetivo.getArmadura().getBlindaje();
                if (objetivo.getDefendido()) {
                    blindajeEfectivo *= multiplicadorDefensa;
                }

                if (!armaAUsar.getEsMelee()) {
                    if (armaAUsar.getMunicionAct() <= 0) {
                        System.out
                                .println("    " + armaAUsar.getNombre() + " sin municion, recargando y fin de turno!");
                        armaAUsar.setMunicionAct(armaAUsar.getMunicionMax());
                        return; // Termina el turno
                    }
                    armaAUsar.setMunicionAct(armaAUsar.getMunicionAct() - 1);
                }

                if (ran.nextInt(0, 100) < armaAUsar.getPrecision()) {
                    boolean esCritico = ran.nextInt(1, 7) == 1;
                    if (esCritico) {
                        System.out.println("    CRITICO");
                    } else {
                        System.out.println("    Golpe normal");
                    }

                    int daño = armaAUsar.getDaño();
                    int daño_final = (esCritico ? daño * 2 : daño) - blindajeEfectivo;
                    if (daño_final < 0) {
                        daño_final = 0; // Evita curar al objetivo
                    }
                    objetivo.setVida(objetivo.getVida() - daño_final);
                } else {
                    System.out.println("    No golpea al objetivo el ataque ");
                }
            }
        }
    }
}