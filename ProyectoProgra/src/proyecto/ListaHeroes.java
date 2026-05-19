package proyecto;

import java.util.ArrayList;
import java.util.List;

import proyecto.habilidades.*;

/**
 * Catálogo de héroes disponibles en el juego.
 * Cada entrada define la facción, estadísticas base y equipamiento inicial.
 * Incluye un método factory para crear instancias de la clase Heroe con sus
 * habilidades.
 */
public enum ListaHeroes {

    // ASTRA MILITARUM
    PSIQUICO("Astra Militarum", "Psíquico", 125, ListaArmas.BACULO, ListaArmaduras.TOGA, ListaArmas.NINGUNO),
    GUARDIA_IMPERIAL("Astra Militarum", "Guardia Imperial", 125, ListaArmas.FUSIL_LASER, ListaArmaduras.ARMADURA_FLAK,
            ListaArmas.NINGUNO),
    KASRKIN("Astra Militarum", "Kasrkin", 175, ListaArmas.CARABINA_BOLTER, ListaArmaduras.ARMADURA_CAPARAZON,
            ListaArmas.NINGUNO),
    COMISARIO_KRIEG("Astra Militarum", "Comisario Krieg", 175, ListaArmas.PISTOLA_BOLTER,
            ListaArmaduras.ARMADURA_DEATH_KORPS, ListaArmas.NINGUNO),
    SENTINEL("Astra Militarum", "Sentinel", 250, ListaArmas.CANON_DE_PLASMA, ListaArmaduras.BLINDAJE,
            ListaArmas.NINGUNO),
    TOROGRETE("Astra Militarum", "Torogrete", 225, ListaArmas.GUANTELETE_GRANADERO, ListaArmaduras.ARMADURA_DE_PLACAS,
            ListaArmas.NINGUNO),

    // DEATHWATCH
    DISRUPTOR("Deathwatch", "Disruptor (Salamandras)", 250, ListaArmas.CARABINA_BOLTER, ListaArmaduras.ARMADURA_PHOBOS,
            ListaArmas.PISTOLA_BOLTER),
    SACERDOTE_SANGUINARIO("Deathwatch", "Sacerdote Sanguinario (Ángel Sangriento)", 325, ListaArmas.CARABINA_BOLTER,
            ListaArmaduras.ARMADURA_TACTICUS, ListaArmas.NARTHECIUM),
    BIBLIOTECARIO("Deathwatch", "Bibliotecario (Ultramarine)", 375, ListaArmas.BASTON_DE_FUERZA,
            ListaArmaduras.ARMADURA_GRAVIS, ListaArmas.PISTOLA_BOLTER),
    CORTACABEZAS("Deathwatch", "Cortacabezas (Lobos Espaciales)", 325, ListaArmas.HACHA_DE_ENERGIA,
            ListaArmaduras.ARMADURA_TACTICUS, ListaArmas.ESCUDO_TORMENTA),
    SAQUEADOR("Deathwatch", "Saqueador (Puños Imperiales)", 250, ListaArmas.ESPADA_SIERRA,
            ListaArmaduras.ARMADURA_PHOBOS, ListaArmas.PISTOLA_DE_FUSION),
    ALA_DE_MUERTE("Deathwatch", "Ala de muerte (Ángeles Oscuros)", 400, ListaArmas.LANZAMISILES_CICLONICO,
            ListaArmaduras.ARMADURA_EXTERMINADOR, ListaArmas.CANON_DE_ASALTO);

    private final String faccion;
    private final String nombre;
    private final int vida;
    private final ListaArmas arma1;
    private final ListaArmaduras armadura;
    private final ListaArmas arma2;

    /**
     * Constructor interno para definir el perfil de datos de cada héroe.
     * * @param faccion Nombre de la facción (ej. "Deathwatch").
     * 
     * @param nombre   Nombre descriptivo del héroe.
     * @param vida     Salud base del personaje.
     * @param arma1    Constante de {@link ListaArmas} para el equipo principal.
     * @param armadura Constante de {@link ListaArmaduras} para la defensa.
     * @param arma2    Constante de {@link ListaArmas} para el equipo secundario.
     */
    ListaHeroes(String faccion, String nombre, int vida, ListaArmas arma1, ListaArmaduras armadura, ListaArmas arma2) {
        this.faccion = faccion;
        this.nombre = nombre;
        this.vida = vida;
        this.arma1 = arma1;
        this.armadura = armadura;
        this.arma2 = arma2;
    }

    /**
     * Construye y devuelve una instancia operativa de la clase {@link Heroe}.
     * <p>
     * El proceso de creación incluye:
     * 1. La inicialización de una lista de habilidades específicas según el caso
     * ({@code switch}).
     * 2. La transformación de las constantes de equipo en objetos reales mediante
     * {@code crearInstancia()}.
     * 3. La instanciación del objeto {@code Heroe} con soporte para doble
     * armamento.
     * * @return Un objeto {@link Heroe} completamente equipado y con sus
     * habilidades aprendidas.
     */
    public Heroe crearInstancia() {
        List<Habilidades> habs = new ArrayList<>();
        switch (this) {
            case PSIQUICO:
                habs.add(new EfectoEscudoInvulnerable("Barrera Psíquica", 5, "Genera un escudo de energía disforme.", true, "defensiva"));
                habs.add(new EfectoDanoPerforante("Explosión Psíquica", 5, "Explosión mental que ignora protecciones físicas.", true, "ofensiva", 65));
                habs.add(new EfectoDanoArea("Honda de Energía", 4, "Explosión global que daña a todos los enemigos.", true, "ofensiva", 30));
                habs.add(new DebufPrecisionIndividual("Alterar sentidos", 3, "Confunde al enemigo disminuyendo su acierto en un -25% (2T).", true, "debuf"));
                break;
            case GUARDIA_IMPERIAL:
                habs.add(new EfectoBufPrecision("Apuntar", 2, "Se toma un tiempo para apuntar mejor.", true, "buf", 20));
                habs.add(new EfectoEscudoInvulnerable("Cobertura", 2, "Reduce la probabilidad de impacto del enemigo en un -15% durante 2 turnos.", false, "buf"));
                habs.add(new EfectoAturdimiento("Culatazo", 3, "Golpea con la culata del arma (1T stun).", false, "ofensiva", 20, 1));
                habs.add(new EfectoBufVelocidad("Carrera", 3, "Aumenta la velocidad del aliado (30).", true, "buf", 30));
                break;
            case KASRKIN:
                habs.add(new EfectoBufPrecision("Apuntar", 2, "Se toma un tiempo para apuntar mejor.", true, "buf", 20));
                habs.add(new EfectoEscudoInvulnerable("Valor Cadiano", 0, "Mejora la reducción de daño por armadura en un +20% (2 turnos).", false, "buf"));
                habs.add(new RecargarArma("Maestría en Armas", 4, "El personaje puede atacar sin gastar munición durante este turno.", false, "buf"));
                habs.add(new EfectoDanoPerforante("Granada Perforante", 4, "Lanza una granada diseñada para atravesar blindajes.", true, "ofensiva", 50));
                break;
            case COMISARIO_KRIEG:
                habs.add(new EfectoBufVelocidad("Alentar", 4, "Potencia el daño de todos los aliados en un +15% durante ese turno.", false, "buf", 30));
                habs.add(new EfectoBufPrecision("Tiro certero", 3, "Un disparo con +30% de acierto y probabilidad de Crítico (Daño x2).", true, "ofensiva", 20));
                habs.add(new EfectoBufVelocidad("Nervio de acero", 3, "Aumenta la esquiva en +25% durante 2 turnos.", false, "buf", 30));
                habs.add(new DiscursoDeMiedo());
                break;
            case SENTINEL:
                habs.add(new EfectoDanoMultiple("Disparo de repetición", 3, "Realiza varios disparos consecutivos.", true, "ofensiva", 3, 20));
                habs.add(new EfectoCuracionSostenida("Reparación", 4, "Efectos de reparación continua en el objetivo (3T).", true, "curacion", 3));
                habs.add(new EfectoDanoArea("Pisotón de Sentinel", 4, "El Sentinel aplasta el suelo dañando a todos.", false, "ofensiva", 40));
                habs.add(new EfectoBufPrecision("Apuntar", 2, "Se toma un tiempo para apuntar mejor.", true, "buf", 20));
                break;
            case TOROGRETE:
                habs.add(new EfectoEscudoInvulnerable("Muro Andante", 5, "Se posiciona frente a un aliado; recibe el 100% de los ataques dirigidos a él (1T).", false, "buf"));
                habs.add(new EfectoEscudoInvulnerable("Cubrirse", 3, "Aumenta +30% la probabilidad de que los ataques den en armadura (2 turnos).", false, "buf"));
                habs.add(new EfectoDanoArea("Disparo Explosivo", 4, "Munición que explota al impactar, dañando el área.", true, "ofensiva", 40));
                habs.add(new EfectoAturdimiento("Puñetazo", 2, "Un fuerte golpe que puede aturdir (1T).", false, "ofensiva", 15, 1));
                break;
            case DISRUPTOR:
                habs.add(new EfectoDanoDirecto("Carga", 3, "Carga contra el enemigo infligiendo daño.", false, "ofensiva", 40));
                habs.add(new EfectoDanoDirecto("Arpón de Brazo", 4, "Lanza un arpón desde el brazo mecánico.", true, "ofensiva", 40));
                habs.add(new EfectoBufPrecision("Apuntar", 2, "Se toma un tiempo para apuntar mejor.", true, "buf", 20));
                habs.add(new EfectoBufVelocidad("Reflejos Relámpago", 3, "Mejora los reflejos aumentando la velocidad (40).", true, "buf", 40));
                break;
            case SACERDOTE_SANGUINARIO:
                habs.add(new EfectoCuracionSostenida("Cirugía en Combate", 5, "Realiza curas rápidas que se mantienen.", true, "curacion", 5));
                habs.add(new GolpeEjecutor("Eutanasia", 4, "Ejecuta a un objetivo con menos del 20% de salud", false, "ofensiva"));
                habs.add(new EfectoBufPrecision("Reconocimiento", 2, "Aumenta la precisión de todo el equipo contra un objetivo", false, "buf", 20));
                habs.add(new EfectoDanoPerforante("Punto Débil", 3, "Apurta a los puntos débiles de la armadura.", true, "ofensiva", 40));
                break;
            case BIBLIOTECARIO:
                habs.add(new EfectoEscudoInvulnerable("Barrera Psíquica", 5, "Genera un escudo de energía disforme.", true, "defensiva"));
                habs.add(new DebufPrecisionIndividual("Alterar sentidos", 3, "Confunde al enemigo disminuyendo su acierto en un -25% (2T).", true, "debuf"));
                habs.add(new EfectoDanoArea("Honda de Energía", 4, "Explosión global que daña a todos los enemigos.", true, "ofensiva", 30));
                habs.add(new EfectoDanoPerforante("Explosión Psíquica", 5, "Explosión mental que ignora protecciones físicas.", true, "ofensiva", 65));
                break;
            case CORTACABEZAS:
                habs.add(new EfectoAturdimiento("Golpe con Escudo", 3, "Golpea con el escudo para aturdir al enemigo.", false, "ofensiva", 15, 1));
                habs.add(new EfectoEscudoInvulnerable("Cubrirse", 3, "Aumenta +30% la probabilidad de que los ataques den en armadura (2 turnos).", false, "buf"));
                habs.add(new EfectoDanoDirecto("Lanzamiento de Hacha", 2, "Lanza un hacha de combate (30 daño).", true, "ofensiva", 30));
                habs.add(new EfectoDanoDirecto("Berserker", 5, "Furia asesina que realiza un ataque devastador (50 daño).", false, "ofensiva", 50));
                break;
            case SAQUEADOR:
                habs.add(new EfectoBufVelocidad("Reflejos Relámpago", 3, "Mejora los reflejos aumentando la velocidad (40).", true, "buf", 40));
                habs.add(new EfectoHemorragia("Ensañamiento", 4, "Daño continuado muy alto", false, "ofensiva", 3));
                habs.add(new EfectoBufVelocidad("Ruedo", 3, "Esquiva los siguientes ataques", false, "buf", 30));
                habs.add(new EfectoAturdimiento("Contusión", 4, "Provoca una fuerte contusión al enemigo.", false, "ofensiva", 25, 1));
                break;
            case ALA_DE_MUERTE:
                habs.add(new EfectoDanoArea("Barrido", 3, "Realiza un barrido circular con el arma.", false, "ofensiva", 20));
                habs.add(new EfectoDanoArea("Andanada de Misiles", 5, "Lluvia masiva de misiles sobre el campo de batalla.", true, "ofensiva", 50));
                habs.add(new EfectoEscudoInvulnerable("Muro Andante", 5, "Se posiciona frente a un aliado; recibe el 100% de los ataques dirigidos a él (1T).", false, "buf"));
                habs.add(new EfectoBufVelocidad("Teletransporte", 5, "Se desplaza instantáneamente a otra posición.", false, "movimiento", 30));
                break;
        }
        return new Heroe(nombre, faccion, vida, arma1.crearInstancia(), armadura.crearInstancia(), habs,
                arma2.crearInstancia());
    }

    public String getFaccion() {
        return this.faccion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public static List<ListaHeroes> obtenerPorFaccion(String faccion) {
        List<ListaHeroes> lista = new ArrayList<>();
        for (ListaHeroes h : ListaHeroes.values()) {
            if (h.getFaccion().equals(faccion)) {
                lista.add(h);
            }
        }
        return lista;
    }
}
