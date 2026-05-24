package proyecto;

import java.util.ArrayList;
import java.util.List;

import habilidades.*;

/**
 * Catálogo de enemigos disponibles en el juego organizados por facción.
 * Proporciona el método factory para instanciar enemigos con sus respectivos
 * equipos y conjuntos de habilidades (ORKOS, NECRONES, TIRÁNIDOS, etc.).
 */
public enum ListaEnemigos {

    // ORKOS
    /** Constante GRETCHIN */
    GRETCHIN("Orkos", "Gretchin", 60, ListaArmas.PIZTOILA, ListaArmaduras.CHATARRA),
    /** Constante GUERRERO_ORKO */
    GUERRERO_ORKO("Orkos", "Guerrero Orko", 120, ListaArmas.ACRIBILLADOR, ListaArmaduras.CUERO),
    /** Constante ZANGUINARIO */
    ZANGUINARIO("Orkos", "Zanguinario", 220, ListaArmas.REBANADORA, ListaArmaduras.COHETE_DORSAL),
    /** Constante ORKO_NOBLE */
    ORKO_NOBLE("Orkos", "Orko Noble", 300, ListaArmas.GARRA_DE_KOMBATE, ListaArmaduras.MEGA_CHATARRA),
    /** Constante MEKA_ORKO */
    MEKA_ORKO("Orkos", "Meka-Orko", 250, ListaArmas.MEGA_BLASTA, ListaArmaduras.ARNES_SOLDADO),
    /** Constante ACHICHARRADOR */
    ACHICHARRADOR("Orkos", "Achicharrador", 240, ListaArmas.QUEMADOR, ListaArmaduras.TRAJE_IGNIFUGO),

    // NECRONES
    /** Constante ENJAMBRE_CANOPTICO */
    ENJAMBRE_CANOPTICO("Necrones", "Enjambre Canóptico", 80, ListaArmas.MANDIBULAS, ListaArmaduras.BLINDAJE_LIGERO),
    /** Constante GUERRERO_NECRON */
    GUERRERO_NECRON("Necrones", "Guerrero Necrón", 220, ListaArmas.RIFLE_GAUSS, ListaArmaduras.METAL_VIVIENTE),
    /** Constante INMORTAL */
    INMORTAL("Necrones", "Inmortal", 300, ListaArmas.CARABINA_TESLA, ListaArmaduras.METAL_PESADO),
    /** Constante OMNICIDA */
    OMNICIDA("Necrones", "Omnicida", 200, ListaArmas.RIFLE_SINAPTICO, ListaArmaduras.CAPARAZON_SIGILO),
    /** Constante DESTRUCTOR */
    DESTRUCTOR("Necrones", "Destructor", 400, ListaArmas.CANON_GAUSS, ListaArmaduras.CHASIS_GRAVITICO),
    /** Constante LIDER_NECRON */
    LIDER_NECRON("Necrones", "Líder Necrón", 450, ListaArmas.BACULO_DE_LUZ, ListaArmaduras.ARMADURA_REGIA),

    // TIRANIDOS
    /** Constante TERMAGANTE */
    TERMAGANTE("Tiránidos", "Termagante", 70, ListaArmas.DERRUMBADOR, ListaArmaduras.QUITINA_FINA),
    /** Constante HORMAGANTE */
    HORMAGANTE("Tiránidos", "Hormagante", 80, ListaArmas.GARRAS_AFILADAS, ListaArmaduras.QUITINA_FINA),
    /** Constante GENESTEALER */
    GENESTEALER("Tiránidos", "Genestealer", 180, ListaArmas.GARRAS_LACERANTES, ListaArmaduras.QUITINA_REFORZADA),
    /** Constante GUERRERO_TIRANIDO */
    GUERRERO_TIRANIDO("Tiránidos", "Guerrero Tiránido", 350, ListaArmas.ESPADA_OSEA, ListaArmaduras.QUITINA_PESADA),
    /** Constante LICTOR */
    LICTOR("Tiránidos", "Lictor", 250, ListaArmas.GARRAS_GARFIO, ListaArmaduras.CAMUFLAJE),
    /** Constante ZOANTROPO */
    ZOANTROPO("Tiránidos", "Zoántropo", 200, ListaArmas.EXPLOSION_MENTAL, ListaArmaduras.ESCUDO_PSIQUICO),

    // AELDARI
    /** Constante GUARDIAN */
    GUARDIAN("Aeldari", "Guardián", 120, ListaArmas.CATAPULTA_SHURIKEN, ListaArmaduras.MALLA_RUNICA),
    /** Constante VENGADOR_TENEBROSO */
    VENGADOR_TENEBROSO("Aeldari", "Vengador Tenebroso", 180, ListaArmas.CATAPULTA_VENGADORA,
            ListaArmaduras.MALLA_RUNICA),
    /** Constante ESPECTRO_AULLANTE */
    ESPECTRO_AULLANTE("Aeldari", "Espectro Aullante", 150, ListaArmas.ESPADA_ENERGIA, ListaArmaduras.ARMADURA_ESPECTRO),
    /** Constante ESCORPION_ASESINO */
    ESCORPION_ASESINO("Aeldari", "Escorpión Asesino", 175, ListaArmas.SIERRA_ESCORPION, ListaArmaduras.A_PESADA_ELDAR),
    /** Constante VIDENTE */
    VIDENTE("Aeldari", "Vidente", 200, ListaArmas.LANZA_CANTANTE, ListaArmaduras.TUNICA_RUNICA),
    /** Constante GUARDIA_ESPECTRAL */
    GUARDIA_ESPECTRAL("Aeldari", "Guardia Espectral", 400, ListaArmas.CANON_DISTORSION,
            ListaArmaduras.ARMADURA_ESPECTRO),

    // T'AU
    /** Constante CASTA_DEL_FUEGO */
    CASTA_DEL_FUEGO("T'au", "Casta del Fuego", 125, ListaArmas.RIFLE_DE_PULSO, ListaArmaduras.ARMADURA_TAU),
    /** Constante RASTREADOR */
    RASTREADOR("T'au", "Rastreador", 100, ListaArmas.CARABINA_PULSO, ListaArmaduras.A_LIGERA_TAU),
    /** Constante XV25_SIGILO */
    XV25_SIGILO("T'au", "XV25 Sigilo", 220, ListaArmas.CANON_ROTATIVO, ListaArmaduras.TRAJE_SIGILO),
    /** Constante XV8_CRISIS */
    XV8_CRISIS("T'au", "XV8 Crisis", 350, ListaArmas.RIFLE_PLASMA_TAU, ListaArmaduras.TRAJE_COMBATE),
    /** Constante XV88_APOCALIPSIS */
    XV88_APOCALIPSIS("T'au", "XV88 Apocalipsis", 450, ListaArmas.RIFLE_FERROVIARIO, ListaArmaduras.BLINDAJE_XV88),
    /** Constante ETEREO */
    ETEREO("T'au", "Etéreo", 200, ListaArmas.BASTON_DEL_HONOR, ListaArmaduras.TOGA_DEL_HONOR),

    // CAOS
    /** Constante CULTISTA */
    CULTISTA("Caos", "Cultista", 100, ListaArmas.AUTOPISTOLA, ListaArmaduras.HARAPOS_MALDITOS),
    /** Constante MARINE_TRAIDOR */
    MARINE_TRAIDOR("Caos", "Marine Traidor", 300, ListaArmas.BOLTER_PESADO, ListaArmaduras.SERVO_TRAIDORA),
    /** Constante BERSERKER_CAOS */
    BERSERKER_CAOS("Caos", "Berserker", 350, ListaArmas.HACHA_SIERRA, ListaArmaduras.PLACAS_DE_SANGRE),
    /** Constante MARINE_PLAGA */
    MARINE_PLAGA("Caos", "Marine Plaga", 450, ListaArmas.LANZA_PLAGAS, ListaArmaduras.ARMADURA_OXIDADA),
    /** Constante HECHICERO */
    HECHICERO("Caos", "Hechicero", 300, ListaArmas.BACULO_DE_CAMBIO, ListaArmaduras.TUNICA_DISFORME),
    /** Constante ENGENDRO */
    ENGENDRO("Caos", "Engendro", 500, ListaArmas.GARRAS_MUTADAS, ListaArmaduras.PIEL_MUTADA);

    private final String faccion;
    private final String nombre;
    private final int vida;
    private final ListaArmas arma;
    private final ListaArmaduras armadura;

    /**
     * Constructor interno para definir la plantilla de cada enemigo.
     * * @param faccion Nombre de la facción.
     * 
     * @param nombre   Nombre de la unidad.
     * @param vida     Salud base.
     * @param arma     Constante de {@link ListaArmas} asociada.
     * @param armadura Constante de {@link ListaArmaduras} asociada.
     */
    ListaEnemigos(String faccion, String nombre, int vida, ListaArmas arma, ListaArmaduras armadura) {
        this.faccion = faccion;
        this.nombre = nombre;
        this.vida = vida;
        this.arma = arma;
        this.armadura = armadura;
    }

    /**
     * Metodo crearInstancia.
     * 
     * @return crearInstancia valor.
     */
    public Entidad crearInstancia() {
        List<Habilidades> habs = new ArrayList<>();
        switch (this) {
            case GRETCHIN:
                habs.add(new EfectoBufVelocidad("Cobardía", 0,
                        "Si recibe daño, retrocede automáticamente una posición.", false, "movimiento", 30));
                habs.add(new DebufVelocidadIndividual("Robar", 3, "Roba suministros, ralentizando al enemigo.", false,
                        "debuf"));
                habs.add(new EfectoEscudoInvulnerable("Esconderse", 4,
                        "No puede ser objetivo de ataques a distancia (1 turno).", false, "buf"));
                habs.add(new EfectoAturdimiento("Pedrada", 2, "Lanza una piedra con fuerza para aturdir.", true,
                        "ofensiva", 10, 1));
                break;
            case GUERRERO_ORKO:
                habs.add(new EfectoBufVelocidad("¡Waaagh!", 5,
                        "Aumenta la Velocidad de los aliados en +30 por 1 turno.", false, "buf", 30));
                habs.add(new EfectoAturdimiento("Cabezazo", 3, "Propinas un cabezazo brutal (1T stun).", false,
                        "ofensiva", 20, 1));
                habs.add(new EfectoDanoArea("Disparo Loco", 3, "Dispara en todas direcciones sin apuntar.", true,
                        "ofensiva", 25));
                habs.add(new EfectoDanoDirecto("Carga", 3, "Carga contra el enemigo infligiendo daño.", false,
                        "ofensiva", 40));
                break;
            case ZANGUINARIO:
                habs.add(new EfectoBufVelocidad("Salto", 3, "Salta sobre un enemigo ignorando cobertura.", false,
                        "movimiento", 30));
                habs.add(new EfectoDanoArea("Impacto", 3,
                        "Al caer tras un salto, inflige 20 Daño a objetivos adyacentes.", false, "ofensiva", 20));
                habs.add(new EfectoBufVelocidad("Descenso", 3, "Permite moverse 3 casillas adicionales tras un salto.",
                        false, "movimiento", 30));
                habs.add(new EfectoDanoDirecto("Furia Aérea", 3, "Ataque descendente con gran potencia.", false,
                        "ofensiva", 45));
                break;
            case ORKO_NOBLE:
                habs.add(new EfectoBufVelocidad("Rugido", 5, "Unifica a los aliados, aumentando su Precisión en +10.",
                        false, "buf", 30));
                habs.add(new EfectoDebufPrecisionArea("Intimidar", 3,
                        "Reduce la Precisión de los enemigos en un -20% durante 1 turno.", true, "debuf", 20));
                habs.add(new EfectoDanoPerforante("Aplastar", 5,
                        "Aplastamiento masivo que ignora la armadura del objetivo.", false, "ofensiva", 70));
                habs.add(new EfectoBufPrecision("Ordenar", 2, "Indica a un aliado que ataque inmediatamente.", false,
                        "buf", 20));
                break;
            case MEKA_ORKO:
                habs.add(new EfectoCuracionSostenida("Reparación", 4,
                        "Efectos de reparación continua en el objetivo (3T).", true, "curacion", 3));
                habs.add(new EfectoEscudoInvulnerable("Campo de Fuerza", 5,
                        "Protege a los aliados en un radio de 2 casillas con un escudo.", false, "buf"));
                habs.add(new EfectoDanoArea("Despliegue de Torreta", 5,
                        "Despliega una torreta defensiva que barre el área.", true, "ofensiva", 35));
                habs.add(new EfectoAturdimiento("Chispazo", 3, "Descarga eléctrica que paraliza (1T).", true,
                        "ofensiva", 15, 1));
                break;
            case ACHICHARRADOR:
                habs.add(new VenenoAreaGlobal("Incendio", 4,
                        "Prende fuego a un área de 3 casillas (15 Daño por turno).", true, "ofensiva"));
                habs.add(new VenenoAreaGlobal("Muro de Fuego", 4, "Crea una barrera de llamas que bloquea el paso.",
                        false, "ofensiva"));
                habs.add(new EfectoVenenoMultiple("Nube de Gas", 4, "Lanza una nube de gas tóxico a varios objetivos.",
                        true, "ofensiva", 3, 2));
                habs.add(new EfectoBufPrecision("Combustible", 2,
                        "Recarga el lanzallamas aumentando el daño del siguiente ataque.", false, "buf", 20));
                break;
            case ENJAMBRE_CANOPTICO:
                habs.add(new DebufVelocidadGrupo("Enjambrar", 4, "Rodea a los enemigos ralentizando a todo el grupo.",
                        true, "debuf"));
                habs.add(new EfectoCuracionIndividual("Protocolos de Reparación", 4,
                        "Activa nanomáquinas para reparar el chasis.", true, "curacion", 40));
                habs.add(new CuracionSostenidaMultiple("Autorreparación", 4,
                        "Activa protocolos de autorreparación sostenida.", true, "buf"));
                habs.add(new EfectoBufVelocidad("Esquiva Necrona", 3, "Aumenta la esquiva de la unidad en un +20%.",
                        false, "buf", 30));
                break;
            case GUERRERO_NECRON:
                habs.add(new EfectoEscudoInvulnerable("Protocolo", 4, "Aumenta la defensa por armadura de la unidad.",
                        false, "buf"));
                habs.add(new EfectoBufPrecision("Enfoque", 2, "Aumenta la precisión para el siguiente disparo.", true,
                        "buf", 20));
                habs.add(new EfectoDanoPerforante("Disparo Gauss", 4,
                        "Proyectil de alta velocidad que atraviesa blindajes.", true, "ofensiva", 55));
                habs.add(
                        new EfectoEscudoInvulnerable("Aguante", 4, "Aumenta la resistencia del Necrón.", false, "buf"));
                break;
            case INMORTAL:
                habs.add(new EfectoBufPrecision("Sobrecarga", 3,
                        "Aumenta el daño del arma a cambio de reducir la Precisión.", true, "buf", 20));
                habs.add(new EfectoEscudoInvulnerable("Escudo", 4, "Activa un escudo de energía.", false, "buf"));
                habs.add(new EfectoDanoMultiple("Sonda Tesla", 4, "Lanza descargas eléctricas a objetivos aleatorios.",
                        true, "ofensiva", 3, 25));
                habs.add(new EfectoEscudoInvulnerable("Inamovible", 5,
                        "La unidad no puede ser desplazada ni aturdida (2 turnos).", false, "buf"));
                break;
            case OMNICIDA:
                habs.add(new EfectoBufVelocidad("Teletransporte", 5, "Se desplaza instantáneamente a otra posición.",
                        false, "movimiento", 30));
                habs.add(new EfectoBufPrecision("Marca", 3, "Marca al objetivo para facilitar el impacto.", true, "buf",
                        25));
                habs.add(new EfectoBufPrecision("Francotirador", 3, "Realiza un disparo extremadamente preciso.", true,
                        "ofensiva", 20));
                habs.add(new EfectoEscudoInvulnerable("Invisibilidad", 5,
                        "Se vuelve prácticamente imposible de impactar (1 turno).", false, "buf"));
                break;
            case DESTRUCTOR:
                habs.add(new GolpeEjecutor("Odio Eterno", 4,
                        "Aumenta drásticamente el daño contra un enemigo específico.", false, "ofensiva"));
                habs.add(new EfectoBufVelocidad("Vuelo", 3, "Permite ignorar el terreno y moverse con mayor libertad.",
                        false, "buf", 30));
                habs.add(new RecargarArma("Optimizar", 4, "Reduce los tiempos de reutilización de las habilidades.",
                        false, "buf"));
                habs.add(new EfectoDanoMultiple("Ráfaga", 3, "Dispara una ráfaga de proyectiles sobre el enemigo.",
                        true, "ofensiva", 3, 20));
                break;
            case LIDER_NECRON:
                habs.add(new EfectoBufPrecision("Comando", 5,
                        "Ordena a los aliados cercanos atacar a un objetivo marcado.", false, "buf", 20));
                habs.add(new EfectoDanoArea("Rayo Solar", 4, "Un haz de luz cegadora que daña a los enemigos.", true,
                        "ofensiva", 50));
                habs.add(new EfectoEscudoInvulnerable("Invulnerable", 5,
                        "La unidad se vuelve invulnerable por un breve periodo.", false, "buf"));
                habs.add(new EfectoEscudoInvulnerable("Escudo", 4, "Activa un escudo de energía.", false, "buf"));
                break;
            case TERMAGANTE:
                habs.add(new EfectoBufPrecision("Instinto", 0, "Ataque instintivo rápido.", false, "buf", 20));
                habs.add(
                        new EfectoBufVelocidad("Sigilo", 3, "La unidad se mueve sin ser detectada.", false, "buf", 30));
                habs.add(new EfectoBufVelocidad("Salto", 3, "Salta sobre un enemigo ignorando cobertura.", false,
                        "movimiento", 30));
                habs.add(new EfectoVenenoMultiple("Mordisco Venenoso", 2, "Muerde al enemigo inyectando veneno.", false,
                        "ofensiva", 1, 3));
                break;
            case HORMAGANTE:
                habs.add(
                        new EfectoBufVelocidad("Carrera", 3, "Aumenta la velocidad del aliado (30).", true, "buf", 30));
                habs.add(new EfectoBufVelocidad("Salto Largo", 4, "Un salto de gran distancia.", false, "movimiento",
                        30));
                habs.add(new EfectoBufPrecision("Enjambre", 3, "Aumenta la Precisión si hay aliados cerca.", false,
                        "buf", 20));
                habs.add(new EfectoBufVelocidad("Frenesí", 4, "Ataques más rápidos y furiosos.", false, "buf", 30));
                break;
            case GENESTEALER:
                habs.add(new EfectoBufVelocidad("Infiltrar", 4, "Aparece detrás de las líneas enemigas.", false,
                        "movimiento", 30));
                habs.add(new EfectoBufVelocidad("Reflejos Relámpago", 3,
                        "Mejora los reflejos aumentando la velocidad (40).", true, "buf", 40));
                habs.add(new EfectoHemorragia("Despedazar", 5,
                        "Un ataque feroz que desgarra al objetivo (4T hemorragia).", false, "ofensiva", 4));
                habs.add(new EfectoDebufPrecisionArea("Miedo", 3, "Causa miedo en los enemigos.", true, "debuf", 10));
                break;
            case GUERRERO_TIRANIDO:
                habs.add(new EfectoBufPrecision("Nexo", 3, "Conexión psíquica que mejora el rendimiento del equipo.",
                        false, "buf", 20));
                habs.add(new EfectoBufVelocidad("Rugido", 5, "Unifica a los aliados, aumentando su Precisión en +10.",
                        false, "buf", 30));
                habs.add(new EfectoCuracionSostenida("Regenerar", 4, "Aplica regeneración constante de tejidos.", true,
                        "curacion", 4));
                habs.add(new EfectoDanoDirecto("Carga", 3, "Carga contra el enemigo infligiendo daño.", false,
                        "ofensiva", 40));
                break;
            case LICTOR:
                habs.add(new EfectoBufVelocidad("Camaleón", 3, "Se camufla con el entorno.", false, "buf", 30));
                habs.add(new EfectoBufPrecision("Emboscada", 4, "Ataque por sorpresa con alta probabilidad de Crítico.",
                        false, "ofensiva", 20));
                habs.add(new EfectoDebufPrecisionArea("Terror", 5,
                        "Provoca terror en el enemigo, bajando su precisión.", true, "debuf", 20));
                habs.add(
                        new EfectoDanoDirecto("Empalar", 4, "Ataque que atraviesa al enemigo.", false, "ofensiva", 40));
                break;
            case ZOANTROPO:
                habs.add(new EfectoEscudoInvulnerable("Barrera Psíquica", 5, "Genera un escudo de energía disforme.",
                        true, "defensiva"));
                habs.add(new EfectoBufPrecision("Mente Colmena", 5, "Coordina a todos los Tiránidos cercanos.", false,
                        "buf", 20));
                habs.add(new EfectoDanoPerforante("Rayo Mental", 3,
                        "Ataque psíquico directo a la mente (ignora armadura).", true, "ofensiva", 45));
                habs.add(new EfectoBufVelocidad("Levitación", 3, "Se eleva sobre el suelo para ganar velocidad.", false,
                        "buf", 30));
                break;
            case GUARDIAN:
                habs.add(new EfectoBufPrecision("Disciplina", 2, "Aumenta la Precisión a través del entrenamiento.",
                        false, "buf", 20));
                habs.add(new EfectoDanoArea("Granada", 3, "Lanzamiento de una granada explosiva.", true, "ofensiva",
                        25));
                habs.add(new EfectoEscudoInvulnerable("Cobertura", 2,
                        "Reduce la probabilidad de impacto del enemigo en un -15% durante 2 turnos.", false, "buf"));
                habs.add(new EfectoBufVelocidad("Reubicarse", 4, "Aumenta la movilidad del escuadrón.", true, "buf",
                        35));
                break;
            case VENGADOR_TENEBROSO:
                habs.add(new EfectoDanoMultiple("Tormenta de Disparos", 4,
                        "Desata una tormenta de fuego sobre las líneas enemigas.", true, "ofensiva", 3, 25));
                habs.add(new EfectoEscudoInvulnerable("Defensa", 3, "Postura defensiva Aeldari.", false, "buf"));
                habs.add(new EfectoBufPrecision("Puntería", 2, "Aumento de Precisión temporal.", true, "buf", 20));
                habs.add(new EfectoBufVelocidad("Retirada", 3, "Movimiento táctico hacia atrás.", false, "movimiento",
                        30));
                break;
            case ESPECTRO_AULLANTE:
                habs.add(new EfectoDebufPrecisionArea("Grito", 3, "Grito ensordecedor que reduce la puntería.", true,
                        "debuf", 15));
                habs.add(new EfectoBufVelocidad("Acrobacia", 2, "Movimientos ágiles para evitar el daño.", false, "buf",
                        30));
                habs.add(new EfectoDanoDirecto("Carga Veloz", 2, "Carga rápida hacia el enemigo (35 daño).", false,
                        "ofensiva", 35));
                habs.add(new EfectoBufVelocidad("Danza", 4, "Danza de combate que aumenta la Velocidad y Esquiva.",
                        false, "buf", 30));
                break;
            case ESCORPION_ASESINO:
                habs.add(
                        new EfectoBufVelocidad("Sigilo", 3, "La unidad se mueve sin ser detectada.", false, "buf", 30));
                habs.add(new EfectoVenenoMultiple("Mordisco Venenoso", 2, "Muerde al enemigo inyectando veneno.", false,
                        "ofensiva", 1, 3));
                habs.add(new EfectoBufVelocidad("Infiltrar", 4, "Aparece detrás de las líneas enemigas.", false,
                        "movimiento", 30));
                habs.add(new EfectoBufPrecision("Emboscada", 4, "Ataque por sorpresa con alta probabilidad de Crítico.",
                        false, "ofensiva", 20));
                break;
            case VIDENTE:
                habs.add(new EfectoBufPrecision("Guía", 4, "Guía los ataques de un aliado psíquicamente.", false, "buf",
                        20));
                habs.add(new EfectoBufPrecision("Destino", 4, "Aclara la visión para ataques perfectos.", true, "buf",
                        30));
                habs.add(new EfectoDanoPerforante("Rayo Mental", 3,
                        "Ataque psíquico directo a la mente (ignora armadura).", true, "ofensiva", 45));
                habs.add(new EfectoBufPrecision("Nexo", 3, "Conexión psíquica que mejora el rendimiento del equipo.",
                        false, "buf", 20));
                break;
            case GUARDIA_ESPECTRAL:
                habs.add(new EfectoEscudoInvulnerable("Vacío", 5, "La unidad se vuelve intangible temporalmente.",
                        false, "buf"));
                habs.add(
                        new EfectoEscudoInvulnerable("Imperturbable", 5, "Resistencia extrema al daño.", false, "buf"));
                habs.add(new EfectoEscudoInvulnerable("Escudo Rúnico", 5, "Protección basada en runas Aeldari.", false,
                        "buf"));
                habs.add(new EfectoDanoPerforante("Golpe Pesado", 4, "Un golpe con gran fuerza que ignora el blindaje.",
                        false, "ofensiva", 50));
                break;
            case CASTA_DEL_FUEGO:
                habs.add(new EfectoBufPrecision("Bien Superior", 4, "Aumenta la eficacia de los aliados cercanos.",
                        false, "buf", 20));
                habs.add(new EfectoBufPrecision("Marcador", 2, "Marca al objetivo para el fuego de apoyo.", true,
                        "debuf", 20));
                habs.add(new EfectoDebufPrecisionArea("Granada Fotónica", 4, "Ciega a los enemigos con un destello.",
                        true, "debuf", 30));
                habs.add(new CuracionSostenidaMultiple("Reagrupar", 5,
                        "Ordena un reagrupamiento curando al equipo con el tiempo.", true, "buf"));
                break;
            case RASTREADOR:
                habs.add(new EfectoBufPrecision("Designar", 2, "Designa un objetivo para ataques de Precisión.", true,
                        "debuf", 20));
                habs.add(new EfectoBufPrecision("Recon", 3, "Exploración del terreno.", false, "buf", 20));
                habs.add(new EfectoBufPrecision("Precisión", 0, "Aumenta la Precisión del disparo.", true, "buf", 20));
                habs.add(new EfectoEscudoInvulnerable("Dron", 4, "Despliega un dron de defensa.", false, "buf"));
                break;
            case XV25_SIGILO:
                habs.add(new EfectoBufVelocidad("Camuflaje", 3, "Usa la armadura para mimetizarse.", false, "buf", 30));
                habs.add(new EfectoBufVelocidad("Despliegue", 4, "Posicionamiento rápido tras infiltration.", false,
                        "movimiento", 30));
                habs.add(new EfectoBufPrecision("Sensores", 3, "Aumenta la Precisión detectando enemigos ocultos.",
                        false, "buf", 20));
                habs.add(new EfectoDanoMultiple("Hostigar", 2,
                        "Realiza breves ataques de hostigamiento a varios enemigos.", true, "ofensiva", 3, 15));
                break;
            case XV8_CRISIS:
                habs.add(new EfectoBufVelocidad("Retrocohetes", 3, "Permite saltar y alejarse tras realizar un ataque.",
                        false, "movimiento", 30));
                habs.add(new EfectoBufPrecision("Multiblanco", 3, "Permite atacar a varios objetivos simultáneamente.",
                        false, "buf", 20));
                habs.add(new RecargarArma("Munición", 3, "Suministro extra de munición.", false, "buf"));
                habs.add(new EfectoEscudoInvulnerable("Escudo", 4, "Activa un escudo de energía.", false, "buf"));
                break;
            case XV88_APOCALIPSIS:
                habs.add(new EfectoBufPrecision("Anclaje", 4,
                        "Ancla la unidad al suelo para aumentar drásticamente la Precisión.", false, "buf", 20));
                habs.add(new EfectoBufPrecision("Larga Distancia", 3, "Aumenta el alcance efectivo del arma.", false,
                        "buf", 20));
                habs.add(new EfectoBufBlindaje("Blindaje Plus", 4, "Refuerza la armadura del aliado.", true, "buf", 5));
                habs.add(
                        new EfectoDanoArea("Misiles", 4, "Lanzamiento de una salva de misiles.", true, "ofensiva", 45));
                break;
            case ETEREO:
                habs.add(new EfectoDanoArea("Invocación", 5,
                        "Invoca el apoyo de la casta para realizar un ataque de área.", true, "ofensiva", 40));
                habs.add(new EfectoBufPrecision("Liderazgo", 4,
                        "Aumenta la moral y efectividad de las unidades cercanas.", false, "buf", 20));
                habs.add(new EfectoCuracionIndividual("Sacrificio", 3, "Sacrifica energía para sanar a un aliado.",
                        true, "curacion", 35));
                habs.add(new EfectoDanoArea("Castigo", 5, "Castigo divino/psíquico que golpea a todos los infieles.",
                        true, "ofensiva", 45));
                break;
            case CULTISTA:
                habs.add(new EfectoCuracionIndividual("Sacrificio", 3, "Sacrifica energía para sanar a un aliado.",
                        true, "curacion", 35));
                habs.add(new EfectoBufPrecision("Fanatismo", 3, "Aumenta el daño de los ataques temporalmente.", false,
                        "buf", 20));
                habs.add(new EfectoHemorragia("Puñalada", 2, "Ataque rápido que provoca hemorragia leve (1T).", false,
                        "ofensiva", 1));
                habs.add(new EfectoBufVelocidad("Ocultarse", 4, "Se esconde entre las sombras.", false, "buf", 30));
                break;
            case MARINE_TRAIDOR:
                habs.add(new EfectoDanoArea("Granada", 3, "Lanzamiento de una granada explosiva.", true, "ofensiva",
                        25));
                habs.add(new EfectoBufVelocidad("Furia", 3, "Estado de rabia ciega.", false, "buf", 30));
                habs.add(new RecargarArma("Recarga Rápida", 3, "Habilidad para recargar velozmente.", false, "buf"));
                habs.add(new EfectoDanoDirecto("Carga de Bayoneta", 0, "Ataque cuerpo a cuerpo con bayoneta.", false,
                        "ofensiva", 25));
                break;
            case BERSERKER_CAOS:
                habs.add(new EfectoCuracionIndividual("Sangre del Dios-Máquina", 5,
                        "Sana milagrosamente las heridas más graves.", true, "curacion", 50));
                habs.add(new EfectoDanoDirecto("Carga", 3, "Carga contra el enemigo infligiendo daño.", false,
                        "ofensiva", 40));
                habs.add(new EfectoHemorragia("Despedazar", 5,
                        "Un ataque feroz que desgarra al objetivo (4T hemorragia).", false, "ofensiva", 4));
                habs.add(new EfectoDebufPrecisionArea("Aullido", 3, "Grito aterrador que desmoraliza al enemigo.", true,
                        "debuf", 15));
                break;
            case MARINE_PLAGA:
                habs.add(new EfectoDebufPrecisionArea("Nube de Moscas", 4,
                        "Rodea al enemigo con una nube que dificulta apuntar.", true, "debuf", 20));
                habs.add(new EfectoCuracionSostenida("Regeneración", 4, "El organismo se regenera con el tiempo (4T).",
                        true, "curacion", 4));
                habs.add(new VenenoAreaGlobal("Vómito Corrosivo", 4,
                        "Lanza jugos gásticos que disuelven armaduras y carne.", true, "ofensiva"));
                habs.add(new EfectoEscudoInvulnerable("Tenacidad", 5, "Resistencia inhumana al dolor.", false, "buf"));
                break;
            case HECHICERO:
                habs.add(new EfectoDanoArea("Rayo de Cambio", 5, "Un rayo de energía de Tzeentch que afecta a todos.",
                        true, "ofensiva", 55));
                habs.add(new EfectoEscudoInvulnerable("Escudo Disforme", 5, "Crea una barrera de energía caótica.",
                        false, "buf"));
                habs.add(new EfectoBufVelocidad("Teletransporte", 5, "Se desplaza instantáneamente a otra posición.",
                        false, "movimiento", 30));
                habs.add(new EfectoDebufPrecisionArea("Ilusión", 4, "Engaña los sentidos del enemigo.", true, "debuf",
                        15));
                break;
            case ENGENDRO:
                habs.add(new EfectoCuracionIndividual("Mutación", 3, "El cuerpo muta rápidamente para sanar heridas.",
                        true, "curacion", 25));
                habs.add(new EfectoDanoArea("Embestida", 4, "Carga con fuerza bruta contra toda la línea enemiga.",
                        false, "ofensiva", 35));
                habs.add(new EfectoCuracionSostenida("Regeneración", 4, "El organismo se regenera con el tiempo (4T).",
                        true, "curacion", 4));
                habs.add(new EfectoDebufPrecisionArea("Alarido", 3, "Grito aterrador que desmoraliza al enemigo.", true,
                        "debuf", 15));
                break;
        }
        return new Entidad(nombre, faccion, vida, arma.crearInstancia(), armadura.crearInstancia(), habs);
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
     * Metodo getNombre.
     * 
     * @return getNombre valor.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo obtenerPorFaccion.
     * 
     * @param faccion parametro.
     * @return obtenerPorFaccion valor.
     */
    public static List<ListaEnemigos> obtenerPorFaccion(String faccion) {
        List<ListaEnemigos> lista = new ArrayList<>();
        for (ListaEnemigos e : ListaEnemigos.values()) {
            if (e.getFaccion().equals(faccion)) {
                lista.add(e);
            }
        }
        return lista;
    }
}