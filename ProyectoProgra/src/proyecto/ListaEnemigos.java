package proyecto;

import java.util.Arrays;
import java.util.List;

public enum ListaEnemigos {
    // ORKOS
    GRETCHIN("Orkos", "Gretchin", 60, ListaArmas.PIZTOILA, ListaArmaduras.CHATARRA, Arrays.asList(ListaHabilidades.COBARDIA, ListaHabilidades.ROBAR, ListaHabilidades.ESCONDERSE, ListaHabilidades.PEDRADA)),
    GUERRERO_ORKO("Orkos", "Guerrero Orko", 120, ListaArmas.ACRIBILLADOR, ListaArmaduras.CUERO, Arrays.asList(ListaHabilidades.WAAAGH, ListaHabilidades.CABEZAZO, ListaHabilidades.DISPARO_LOCO, ListaHabilidades.CARGA)),
    ZANGUINARIO("Orkos", "Zanguinario", 220, ListaArmas.REBANADORA, ListaArmaduras.COHETE_DORSAL, Arrays.asList(ListaHabilidades.SALTO, ListaHabilidades.IMPACTO, ListaHabilidades.DESCENSO, ListaHabilidades.FURIA_AEREA)),
    ORKO_NOBLE("Orkos", "Orko Noble", 300, ListaArmas.GARRA_DE_KOMBATE, ListaArmaduras.MEGA_CHATARRA, Arrays.asList(ListaHabilidades.RUGIDO, ListaHabilidades.INTIMIDAR, ListaHabilidades.APLASTAR, ListaHabilidades.ORDENAR)),
    MEKA_ORKO("Orkos", "Meka-Orko", 250, ListaArmas.MEGA_BLASTA, ListaArmaduras.ARNES_SOLDADO, Arrays.asList(ListaHabilidades.REPARACION, ListaHabilidades.CAMPO_FUERZA, ListaHabilidades.TORRETA, ListaHabilidades.CHISPAZO)),
    ACHICHARRADOR("Orkos", "Achicharrador", 240, ListaArmas.QUEMADOR, ListaArmaduras.TRAJE_IGNIFUGO, Arrays.asList(ListaHabilidades.INCENDIO, ListaHabilidades.MURO_FUEGO, ListaHabilidades.GAS, ListaHabilidades.COMBUSTIBLE)),

    // NECRONES
    ENJAMBRE_CANOPTICO("Necrones", "Enjambre Canóptico", 80, ListaArmas.MANDIBULAS, ListaArmaduras.BLINDAJE_LIGERO, Arrays.asList(ListaHabilidades.ENJAMBRAR, ListaHabilidades.REPARAR_NECRON, ListaHabilidades.AUTORREPARACION, ListaHabilidades.ESQUIVA_NECRON)),
    GUERRERO_NECRON("Necrones", "Guerrero Necrón", 220, ListaArmas.RIFLE_GAUSS, ListaArmaduras.METAL_VIVIENTE, Arrays.asList(ListaHabilidades.PROTOCOLO, ListaHabilidades.ENFOQUE, ListaHabilidades.DISPARO_GAUSS, ListaHabilidades.AGUANTE)),
    INMORTAL("Necrones", "Inmortal", 300, ListaArmas.CARABINA_TESLA, ListaArmaduras.METAL_PESADO, Arrays.asList(ListaHabilidades.SOBRECARGA, ListaHabilidades.ESCUDO, ListaHabilidades.TESLA, ListaHabilidades.INAMOVIBLE)),
    OMNICIDA("Necrones", "Omnicida", 200, ListaArmas.RIFLE_SINAPTICO, ListaArmaduras.CAPARAZON_SIGILO, Arrays.asList(ListaHabilidades.TELETRANSPORTE, ListaHabilidades.MARCA, ListaHabilidades.FRANCOTIRADOR, ListaHabilidades.INVISIBILIDAD)),
    DESTRUCTOR("Necrones", "Destructor", 400, ListaArmas.CANON_GAUSS, ListaArmaduras.CHASIS_GRAVITICO, Arrays.asList(ListaHabilidades.ODIO_ETERNO, ListaHabilidades.VUELO, ListaHabilidades.OPTIMIZAR, ListaHabilidades.RAFAGA)),
    LIDER_NECRON("Necrones", "Líder Necrón", 450, ListaArmas.BACULO_DE_LUZ, ListaArmaduras.ARMADURA_REGIA, Arrays.asList(ListaHabilidades.COMANDO, ListaHabilidades.RAYO_SOLAR, ListaHabilidades.INVULNERABLE)),

    // TIRANIDOS
    TERMAGANTE("Tiránidos", "Termagante", 70, ListaArmas.DERRUMBADOR, ListaArmaduras.QUITINA_FINA, Arrays.asList(ListaHabilidades.INSTINTO, ListaHabilidades.SIGILO, ListaHabilidades.SALTO, ListaHabilidades.MORDISCO)),
    HORMAGANTE("Tiránidos", "Hormagante", 80, ListaArmas.GARRAS_AFILADAS, ListaArmaduras.QUITINA_FINA, Arrays.asList(ListaHabilidades.CARRERA, ListaHabilidades.SALTO_LARGO, ListaHabilidades.ENJAMBRE, ListaHabilidades.FRENESI)),
    GENESTEALER("Tiránidos", "Genestealer", 180, ListaArmas.GARRAS_LACERANTES, ListaArmaduras.QUITINA_REFORZADA, Arrays.asList(ListaHabilidades.INFILTRAR, ListaHabilidades.REFLEJOS_RELAMPAGO, ListaHabilidades.DESPEDAZAR, ListaHabilidades.MIEDO)),
    GUERRERO_TIRANIDO("Tiránidos", "Guerrero Tiránido", 350, ListaArmas.ESPADA_OSEA, ListaArmaduras.QUITINA_PESADA, Arrays.asList(ListaHabilidades.NEXO, ListaHabilidades.RUGIDO, ListaHabilidades.REGENERAR, ListaHabilidades.CARGA)),
    LICTOR("Tiránidos", "Lictor", 250, ListaArmas.GARRAS_GARFIO, ListaArmaduras.CAMUFLAJE, Arrays.asList(ListaHabilidades.CAMALEON, ListaHabilidades.EMBOSCADA, ListaHabilidades.TERROR, ListaHabilidades.EMPALAR)),
    ZOANTROPO("Tiránidos", "Zoántropo", 200, ListaArmas.EXPLOSION_MENTAL, ListaArmaduras.ESCUDO_PSIQUICO, Arrays.asList(ListaHabilidades.BARRERA_PSIQUICA, ListaHabilidades.MENTE_COLMENA, ListaHabilidades.RAYO_MENTAL, ListaHabilidades.LEVITACION)),

    // AELDARI
    GUARDIAN("Aeldari", "Guardián", 120, ListaArmas.CATAPULTA_SHURIKEN, ListaArmaduras.MALLA_RUNICA, Arrays.asList(ListaHabilidades.DISCIPLINA, ListaHabilidades.GRANADA, ListaHabilidades.COBERTURA, ListaHabilidades.REUBICARSE)),
    VENGADOR_TENEBROSO("Aeldari", "Vengador Tenebroso", 180, ListaArmas.CATAPULTA_VENGADORA, ListaArmaduras.MALLA_RUNICA, Arrays.asList(ListaHabilidades.TORMENTA, ListaHabilidades.DEFENSA, ListaHabilidades.PUNTERIA, ListaHabilidades.RETIRADA)),
    ESPECTRO_AULLANTE("Aeldari", "Espectro Aullante", 150, ListaArmas.ESPADA_ENERGIA, ListaArmaduras.ARMADURA_ESPECTRO, Arrays.asList(ListaHabilidades.GRITO, ListaHabilidades.ACROBACIA, ListaHabilidades.CARGA_VELOZ, ListaHabilidades.DANZA)),
    ESCORPION_ASESINO("Aeldari", "Escorpión Asesino", 175, ListaArmas.SIERRA_ESCORPION, ListaArmaduras.A_PESADA_ELDAR, Arrays.asList(ListaHabilidades.SIGILO, ListaHabilidades.MORDISCO, ListaHabilidades.INFILTRAR, ListaHabilidades.EMBOSCADA)),
    VIDENTE("Aeldari", "Vidente", 200, ListaArmas.LANZA_CANTANTE, ListaArmaduras.TUNICA_RUNICA, Arrays.asList(ListaHabilidades.GUIA, ListaHabilidades.DESTINO, ListaHabilidades.RAYO_MENTAL, ListaHabilidades.NEXO)),
    GUARDIA_ESPECTRAL("Aeldari", "Guardia Espectral", 400, ListaArmas.CANON_DISTORSION, ListaArmaduras.ARMADURA_ESPECTRO, Arrays.asList(ListaHabilidades.VACIO, ListaHabilidades.IMPERTURBABLE, ListaHabilidades.ESCUDO_RUNICO, ListaHabilidades.GOLPE_PESADO)),

    // T'AU
    CASTA_DEL_FUEGO("T'au", "Casta del Fuego", 125, ListaArmas.RIFLE_DE_PULSO, ListaArmaduras.ARMADURA_TAU, Arrays.asList(ListaHabilidades.BIEN_SUPERIOR, ListaHabilidades.MARCADOR, ListaHabilidades.FOTONICA, ListaHabilidades.REAGRUPAR)),
    RASTREADOR("T'au", "Rastreador", 100, ListaArmas.CARABINA_PULSO, ListaArmaduras.A_LIGERA_TAU, Arrays.asList(ListaHabilidades.DESIGNAR, ListaHabilidades.RECON, ListaHabilidades.PRECISION, ListaHabilidades.DRON)),
    XV25_SIGILO("T'au", "XV25 Sigilo", 220, ListaArmas.CANON_ROTATIVO, ListaArmaduras.TRAJE_SIGILO, Arrays.asList(ListaHabilidades.CAMUFLAJE, ListaHabilidades.DESPLIEGUE, ListaHabilidades.SENSORES, ListaHabilidades.HOSTIGAR)),
    XV8_CRISIS("T'au", "XV8 Crisis", 350, ListaArmas.RIFLE_PLASMA_TAU, ListaArmaduras.TRAJE_COMBATE, Arrays.asList(ListaHabilidades.RETROCOHETES, ListaHabilidades.MULTIBLANCO, ListaHabilidades.MUNICION, ListaHabilidades.ESCUDO)),
    XV88_APOCALIPSIS("T'au", "XV88 Apocalipsis", 450, ListaArmas.RIFLE_FERROVIARIO, ListaArmaduras.BLINDAJE_XV88, Arrays.asList(ListaHabilidades.ANCLAJE, ListaHabilidades.LARGA_DISTANCIA, ListaHabilidades.BLINDAJE_PLUS, ListaHabilidades.MISILES)),
    ETEREO("T'au", "Etéreo", 200, ListaArmas.BASTON_DEL_HONOR, ListaArmaduras.TOGA_DEL_HONOR, Arrays.asList(ListaHabilidades.INVOCACION, ListaHabilidades.LIDERAZGO, ListaHabilidades.SACRIFICIO, ListaHabilidades.CASTIGO)),

    // CAOS
    CULTISTA("Caos", "Cultista", 100, ListaArmas.AUTOPISTOLA, ListaArmaduras.HARAPOS_MALDITOS, Arrays.asList(ListaHabilidades.SACRIFICIO, ListaHabilidades.FANATISMO, ListaHabilidades.PUNALADA, ListaHabilidades.OCULTARSE)),
    MARINE_TRAIDOR("Caos", "Marine Traidor", 300, ListaArmas.BOLTER_PESADO, ListaArmaduras.SERVO_TRAIDORA, Arrays.asList(ListaHabilidades.GRANADA, ListaHabilidades.FURIA, ListaHabilidades.RECARGA_RAPIDA, ListaHabilidades.BAYONETA)),
    BERSERKER_CAOS("Caos", "Berserker", 350, ListaArmas.HACHA_SIERRA, ListaArmaduras.PLACAS_DE_SANGRE, Arrays.asList(ListaHabilidades.SANGRE_DIOS, ListaHabilidades.CARGA, ListaHabilidades.DESPEDAZAR, ListaHabilidades.AULLIDO)),
    MARINE_PLAGA("Caos", "Marine Plaga", 450, ListaArmas.LANZA_PLAGAS, ListaArmaduras.ARMADURA_OXIDADA, Arrays.asList(ListaHabilidades.NUBE_DE_MOSCAS, ListaHabilidades.REGENERACION, ListaHabilidades.VOMITO_CORROSIVO, ListaHabilidades.TENACIDAD)),
    HECHICERO("Caos", "Hechicero", 300, ListaArmas.BACULO_DE_CAMBIO, ListaArmaduras.TUNICA_DISFORME, Arrays.asList(ListaHabilidades.RAYO_DE_CAMBIO, ListaHabilidades.ESCUDO_DISFORME, ListaHabilidades.TELETRANSPORTE, ListaHabilidades.ILUSION)),
    ENGENDRO("Caos", "Engendro", 500, ListaArmas.GARRAS_MUTADAS, ListaArmaduras.PIEL_MUTADA, Arrays.asList(ListaHabilidades.MUTACION, ListaHabilidades.EMBESTIDA, ListaHabilidades.REGENERACION, ListaHabilidades.ALARIDO));

    private final String faccion;
    private final String nombre;
    private final int vida;
    private final ListaArmas arma;
    private final ListaArmaduras armadura;
    private final List<ListaHabilidades> habilidades;

    ListaEnemigos(String faccion, String nombre, int vida, ListaArmas arma, ListaArmaduras armadura, List<ListaHabilidades> habilidades) {
        this.faccion = faccion;
        this.nombre = nombre;
        this.vida = vida;
        this.arma = arma;
        this.armadura = armadura;
        this.habilidades = habilidades;
    }

    public Entidad crearInstancia() {
        List<Habilidades> habsGeneradas = habilidades.stream().map(ListaHabilidades::crearInstancia).toList();
        return new Entidad(nombre, faccion, vida, arma.crearInstancia(), armadura.crearInstancia(), habsGeneradas);
    }
}
