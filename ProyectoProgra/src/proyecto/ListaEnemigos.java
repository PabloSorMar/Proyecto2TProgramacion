package proyecto;

import java.util.ArrayList;
import java.util.List;

import proyecto.habilidades.*;

/**
 * Catálogo de enemigos disponibles en el juego organizados por facción.
 * Proporciona el método factory para instanciar enemigos con sus respectivos
 * equipos y conjuntos de habilidades (ORKOS, NECRONES, TIRÁNIDOS, etc.).
 */
public enum ListaEnemigos {

    // ORKOS
    GRETCHIN("Orkos", "Gretchin", 60, ListaArmas.PIZTOILA, ListaArmaduras.CHATARRA),
    GUERRERO_ORKO("Orkos", "Guerrero Orko", 120, ListaArmas.ACRIBILLADOR, ListaArmaduras.CUERO),
    ZANGUINARIO("Orkos", "Zanguinario", 220, ListaArmas.REBANADORA, ListaArmaduras.COHETE_DORSAL),
    ORKO_NOBLE("Orkos", "Orko Noble", 300, ListaArmas.GARRA_DE_KOMBATE, ListaArmaduras.MEGA_CHATARRA),
    MEKA_ORKO("Orkos", "Meka-Orko", 250, ListaArmas.MEGA_BLASTA, ListaArmaduras.ARNES_SOLDADO),
    ACHICHARRADOR("Orkos", "Achicharrador", 240, ListaArmas.QUEMADOR, ListaArmaduras.TRAJE_IGNIFUGO),

    // NECRONES
    ENJAMBRE_CANOPTICO("Necrones", "Enjambre Canóptico", 80, ListaArmas.MANDIBULAS, ListaArmaduras.BLINDAJE_LIGERO),
    GUERRERO_NECRON("Necrones", "Guerrero Necrón", 220, ListaArmas.RIFLE_GAUSS, ListaArmaduras.METAL_VIVIENTE),
    INMORTAL("Necrones", "Inmortal", 300, ListaArmas.CARABINA_TESLA, ListaArmaduras.METAL_PESADO),
    OMNICIDA("Necrones", "Omnicida", 200, ListaArmas.RIFLE_SINAPTICO, ListaArmaduras.CAPARAZON_SIGILO),
    DESTRUCTOR("Necrones", "Destructor", 400, ListaArmas.CANON_GAUSS, ListaArmaduras.CHASIS_GRAVITICO),
    LIDER_NECRON("Necrones", "Líder Necrón", 450, ListaArmas.BACULO_DE_LUZ, ListaArmaduras.ARMADURA_REGIA),

    // TIRANIDOS
    TERMAGANTE("Tiránidos", "Termagante", 70, ListaArmas.DERRUMBADOR, ListaArmaduras.QUITINA_FINA),
    HORMAGANTE("Tiránidos", "Hormagante", 80, ListaArmas.GARRAS_AFILADAS, ListaArmaduras.QUITINA_FINA),
    GENESTEALER("Tiránidos", "Genestealer", 180, ListaArmas.GARRAS_LACERANTES, ListaArmaduras.QUITINA_REFORZADA),
    GUERRERO_TIRANIDO("Tiránidos", "Guerrero Tiránido", 350, ListaArmas.ESPADA_OSEA, ListaArmaduras.QUITINA_PESADA),
    LICTOR("Tiránidos", "Lictor", 250, ListaArmas.GARRAS_GARFIO, ListaArmaduras.CAMUFLAJE),
    ZOANTROPO("Tiránidos", "Zoántropo", 200, ListaArmas.EXPLOSION_MENTAL, ListaArmaduras.ESCUDO_PSIQUICO),

    // AELDARI
    GUARDIAN("Aeldari", "Guardián", 120, ListaArmas.CATAPULTA_SHURIKEN, ListaArmaduras.MALLA_RUNICA),
    VENGADOR_TENEBROSO("Aeldari", "Vengador Tenebroso", 180, ListaArmas.CATAPULTA_VENGADORA, ListaArmaduras.MALLA_RUNICA),
    ESPECTRO_AULLANTE("Aeldari", "Espectro Aullante", 150, ListaArmas.ESPADA_ENERGIA, ListaArmaduras.ARMADURA_ESPECTRO),
    ESCORPION_ASESINO("Aeldari", "Escorpión Asesino", 175, ListaArmas.SIERRA_ESCORPION, ListaArmaduras.A_PESADA_ELDAR),
    VIDENTE("Aeldari", "Vidente", 200, ListaArmas.LANZA_CANTANTE, ListaArmaduras.TUNICA_RUNICA),
    GUARDIA_ESPECTRAL("Aeldari", "Guardia Espectral", 400, ListaArmas.CANON_DISTORSION, ListaArmaduras.ARMADURA_ESPECTRO),

    // T'AU
    CASTA_DEL_FUEGO("T'au", "Casta del Fuego", 125, ListaArmas.RIFLE_DE_PULSO, ListaArmaduras.ARMADURA_TAU),
    RASTREADOR("T'au", "Rastreador", 100, ListaArmas.CARABINA_PULSO, ListaArmaduras.A_LIGERA_TAU),
    XV25_SIGILO("T'au", "XV25 Sigilo", 220, ListaArmas.CANON_ROTATIVO, ListaArmaduras.TRAJE_SIGILO),
    XV8_CRISIS("T'au", "XV8 Crisis", 350, ListaArmas.RIFLE_PLASMA_TAU, ListaArmaduras.TRAJE_COMBATE),
    XV88_APOCALIPSIS("T'au", "XV88 Apocalipsis", 450, ListaArmas.RIFLE_FERROVIARIO, ListaArmaduras.BLINDAJE_XV88),
    ETEREO("T'au", "Etéreo", 200, ListaArmas.BASTON_DEL_HONOR, ListaArmaduras.TOGA_DEL_HONOR),

    // CAOS
    CULTISTA("Caos", "Cultista", 100, ListaArmas.AUTOPISTOLA, ListaArmaduras.HARAPOS_MALDITOS),
    MARINE_TRAIDOR("Caos", "Marine Traidor", 300, ListaArmas.BOLTER_PESADO, ListaArmaduras.SERVO_TRAIDORA),
    BERSERKER_CAOS("Caos", "Berserker", 350, ListaArmas.HACHA_SIERRA, ListaArmaduras.PLACAS_DE_SANGRE),
    MARINE_PLAGA("Caos", "Marine Plaga", 450, ListaArmas.LANZA_PLAGAS, ListaArmaduras.ARMADURA_OXIDADA),
    HECHICERO("Caos", "Hechicero", 300, ListaArmas.BACULO_DE_CAMBIO, ListaArmaduras.TUNICA_DISFORME),
    ENGENDRO("Caos", "Engendro", 500, ListaArmas.GARRAS_MUTADAS, ListaArmaduras.PIEL_MUTADA);

    private final String faccion;
    private final String nombre;
    private final int vida;
    private final ListaArmas arma;
    private final ListaArmaduras armadura;

    /**
     * Constructor interno para definir la plantilla de cada enemigo.
     * * @param faccion  Nombre de la facción.
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

    public Entidad crearInstancia() {
        List<Habilidades> habs = new ArrayList<>();
        switch (this) {
            case GRETCHIN:
                habs.add(new Cobardia());
                habs.add(new Robar());
                habs.add(new Esconderse());
                habs.add(new Pedrada());
                break;
            case GUERRERO_ORKO:
                habs.add(new Waaagh());
                habs.add(new Cabezazo());
                habs.add(new DisparoLoco());
                habs.add(new Carga());
                break;
            case ZANGUINARIO:
                habs.add(new Salto());
                habs.add(new Impacto());
                habs.add(new Descenso());
                habs.add(new FuriaAerea());
                break;
            case ORKO_NOBLE:
                habs.add(new Rugido());
                habs.add(new Intimidar());
                habs.add(new Aplastar());
                habs.add(new Ordenar());
                break;
            case MEKA_ORKO:
                habs.add(new Reparacion());
                habs.add(new CampoFuerza());
                habs.add(new Torreta());
                habs.add(new Chispazo());
                break;
            case ACHICHARRADOR:
                habs.add(new Incendio());
                habs.add(new MuroFuego());
                habs.add(new Gas());
                habs.add(new Combustible());
                break;
            case ENJAMBRE_CANOPTICO:
                habs.add(new Enjambrar());
                habs.add(new RepararNecron());
                habs.add(new Autorreparacion());
                habs.add(new EsquivaNecron());
                break;
            case GUERRERO_NECRON:
                habs.add(new Protocolo());
                habs.add(new Enfoque());
                habs.add(new DisparoGauss());
                habs.add(new Aguante());
                break;
            case INMORTAL:
                habs.add(new Sobrecarga());
                habs.add(new Escudo());
                habs.add(new Tesla());
                habs.add(new Inamovible());
                break;
            case OMNICIDA:
                habs.add(new Teletransporte());
                habs.add(new Marca());
                habs.add(new Francotirador());
                habs.add(new Invisibilidad());
                break;
            case DESTRUCTOR:
                habs.add(new OdioEterno());
                habs.add(new Vuelo());
                habs.add(new Optimizar());
                habs.add(new Rafaga());
                break;
            case LIDER_NECRON:
                habs.add(new Comando());
                habs.add(new RayoSolar());
                habs.add(new Invulnerable());
                habs.add(new Escudo());
                break;
            case TERMAGANTE:
                habs.add(new Instinto());
                habs.add(new Sigilo());
                habs.add(new Salto());
                habs.add(new Mordisco());
                break;
            case HORMAGANTE:
                habs.add(new Carrera());
                habs.add(new SaltoLargo());
                habs.add(new Enjambre());
                habs.add(new Frenesi());
                break;
            case GENESTEALER:
                habs.add(new Infiltrar());
                habs.add(new ReflejosRelampago());
                habs.add(new Despedazar());
                habs.add(new Miedo());
                break;
            case GUERRERO_TIRANIDO:
                habs.add(new Nexo());
                habs.add(new Rugido());
                habs.add(new Regenerar());
                habs.add(new Carga());
                break;
            case LICTOR:
                habs.add(new Camaleon());
                habs.add(new Emboscada());
                habs.add(new Terror());
                habs.add(new Empalar());
                break;
            case ZOANTROPO:
                habs.add(new BarreraPsiquica());
                habs.add(new MenteColmena());
                habs.add(new RayoMental());
                habs.add(new Levitacion());
                break;
            case GUARDIAN:
                habs.add(new Disciplina());
                habs.add(new Granada());
                habs.add(new Cobertura());
                habs.add(new Reubicarse());
                break;
            case VENGADOR_TENEBROSO:
                habs.add(new Tormenta());
                habs.add(new Defensa());
                habs.add(new Punteria());
                habs.add(new Retirada());
                break;
            case ESPECTRO_AULLANTE:
                habs.add(new Grito());
                habs.add(new Acrobacia());
                habs.add(new CargaVeloz());
                habs.add(new Danza());
                break;
            case ESCORPION_ASESINO:
                habs.add(new Sigilo());
                habs.add(new Mordisco());
                habs.add(new Infiltrar());
                habs.add(new Emboscada());
                break;
            case VIDENTE:
                habs.add(new Guia());
                habs.add(new Destino());
                habs.add(new RayoMental());
                habs.add(new Nexo());
                break;
            case GUARDIA_ESPECTRAL:
                habs.add(new Vacio());
                habs.add(new Imperturbable());
                habs.add(new EscudoRunico());
                habs.add(new GolpePesado());
                break;
            case CASTA_DEL_FUEGO:
                habs.add(new BienSuperior());
                habs.add(new Marcador());
                habs.add(new Fotonica());
                habs.add(new Reagrupar());
                break;
            case RASTREADOR:
                habs.add(new Designar());
                habs.add(new Recon());
                habs.add(new Precision());
                habs.add(new Dron());
                break;
            case XV25_SIGILO:
                habs.add(new Camuflaje());
                habs.add(new Despliegue());
                habs.add(new Sensores());
                habs.add(new Hostigar());
                break;
            case XV8_CRISIS:
                habs.add(new Retrocohetes());
                habs.add(new Multiblanco());
                habs.add(new Municion());
                habs.add(new Escudo());
                break;
            case XV88_APOCALIPSIS:
                habs.add(new Anclaje());
                habs.add(new LargaDistancia());
                habs.add(new BlindajePlus());
                habs.add(new Misiles());
                break;
            case ETEREO:
                habs.add(new Invocacion());
                habs.add(new Liderazgo());
                habs.add(new Sacrificio());
                habs.add(new Castigo());
                break;
            case CULTISTA:
                habs.add(new Sacrificio());
                habs.add(new Fanatismo());
                habs.add(new Punalada());
                habs.add(new Ocultarse());
                break;
            case MARINE_TRAIDOR:
                habs.add(new Granada());
                habs.add(new Furia());
                habs.add(new RecargaRapida());
                habs.add(new Bayoneta());
                break;
            case BERSERKER_CAOS:
                habs.add(new SangreDios());
                habs.add(new Carga());
                habs.add(new Despedazar());
                habs.add(new Aullido());
                break;
            case MARINE_PLAGA:
                habs.add(new NubeDeMoscas());
                habs.add(new Regeneracion());
                habs.add(new VomitoCorrosivo());
                habs.add(new Tenacidad());
                break;
            case HECHICERO:
                habs.add(new RayoDeCambio());
                habs.add(new EscudoDisforme());
                habs.add(new Teletransporte());
                habs.add(new Ilusion());
                break;
            case ENGENDRO:
                habs.add(new Mutacion());
                habs.add(new Embestida());
                habs.add(new Regeneracion());
                habs.add(new Alarido());
                break;
        }
        return new Entidad(nombre, faccion, vida, arma.crearInstancia(), armadura.crearInstancia(), habs);
    }

    public String getFaccion() { return this.faccion; }
    public String getNombre() { return this.nombre; }
}
