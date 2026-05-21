package proyecto;

/**
 * Enum ListaArmas.
 */
public enum ListaArmas {
    /** Constante NINGUNO */
    NINGUNO("Ninguno", 0, 0, true, 0, 0, 0),
    /** Constante ESCUDO_TORMENTA */
    ESCUDO_TORMENTA("Escudo de Tormenta", 10, 95, true, 0, 1, 1),
    /** Constante ESPADA_SIERRA */
    ESPADA_SIERRA("Espada Sierra", 45, 85, true, 0, 1, 2),
    /** Constante HACHA_DE_ENERGIA */
    HACHA_DE_ENERGIA("Hacha de energía", 65, 80, true, 0, 1, 1),
    /** Constante BACULO */
    BACULO("Báculo", 12, 90, true, 0, 1, 1),
    /** Constante BASTON_DE_FUERZA */
    BASTON_DE_FUERZA("Bastón de fuerza", 35, 85, true, 0, 1, 2),
    /** Constante NARTHECIUM */
    NARTHECIUM("Narthecium", 20, 95, true, 0, 1, 2),
    /** Constante FUSIL_LASER */
    FUSIL_LASER("Fusil Láser", 15, 95, false, 8, 1, 2),

    /** Constante PISTOLA_BOLTER */
    PISTOLA_BOLTER("Pistola Bolter", 35, 65, false, 3, 1, 1),
    /** Constante CARABINA_BOLTER */
    CARABINA_BOLTER("Carabina Bolter", 40, 80, false, 6, 1, 4),
    /** Constante GUANTELETE_GRANADERO */
    GUANTELETE_GRANADERO("Guantelete Granadero", 55, 75, false, 5, 3, 1),
    /** Constante CANON_DE_PLASMA */
    CANON_DE_PLASMA("Cañón de plasma", 80, 70, false, 4, 1, 1),
    /** Constante PISTOLA_DE_FUSION */
    PISTOLA_DE_FUSION("Pistola de Fusión", 45, 85, false, 2, 2, 1),
    /** Constante LANZAMISILES_CICLONICO */
    LANZAMISILES_CICLONICO("Lanzamisiles Ciclónico", 85, 70, false, 1, 5, 2),

    /** Constante CANON_DE_ASALTO */
    CANON_DE_ASALTO("Cañón de Asalto", 30, 75, false, 4, 1, 8),

    /** Constante PIZTOILA */
    PIZTOILA("Piztoila", 15, 60, false, 2, 1, 1),
    /** Constante ACRIBILLADOR */
    ACRIBILLADOR("Acribillador", 35, 65, false, 3, 1, 5),
    /** Constante REBANADORA */
    REBANADORA("Rebanadora", 45, 80, true, 0, 1, 1),
    /** Constante GARRA_DE_KOMBATE */
    GARRA_DE_KOMBATE("Garra de Kombate", 75, 75, true, 0, 1, 1),
    /** Constante MEGA_BLASTA */
    MEGA_BLASTA("Mega-Blasta", 65, 60, false, 2, 1, 1),
    /** Constante QUEMADOR */
    QUEMADOR("Quemador", 40, 95, false, 4, 4, 1),

    /** Constante MANDIBULAS */
    MANDIBULAS("Mandíbulas", 20, 90, true, 0, 1, 2),
    /** Constante RIFLE_GAUSS */
    RIFLE_GAUSS("Rifle Gauss", 45, 85, false, 4, 1, 2),
    /** Constante CARABINA_TESLA */
    CARABINA_TESLA("Carabina Tesla", 50, 90, false, 1, 3, 2),
    /** Constante RIFLE_SINAPTICO */
    RIFLE_SINAPTICO("Rifle Sináptico", 60, 98, false, 1, 1, 1),
    /** Constante CANON_GAUSS */
    CANON_GAUSS("Cañón Gauss", 80, 75, false, 2, 1, 3),
    /** Constante BACULO_DE_LUZ */
    BACULO_DE_LUZ("Báculo de Luz", 55, 90, true, 0, 1, 2),

    /** Constante DERRUMBADOR */
    DERRUMBADOR("Derrumbador", 20, 75, false, 3, 1, 4),
    /** Constante GARRAS_AFILADAS */
    GARRAS_AFILADAS("Garras Afiladas", 30, 85, true, 0, 1, 4),
    /** Constante GARRAS_LACERANTES */
    GARRAS_LACERANTES("Garras Lacerantes", 55, 90, true, 0, 1, 3),
    /** Constante ESPADA_OSEA */
    ESPADA_OSEA("Espada Ósea", 65, 85, true, 0, 1, 2),
    /** Constante GARRAS_GARFIO */
    GARRAS_GARFIO("Garras Garfio", 70, 95, true, 0, 1, 2),
    /** Constante EXPLOSION_MENTAL */
    EXPLOSION_MENTAL("Explosión Mental", 75, 90, false, 2, 4, 1),

    /** Constante CATAPULTA_SHURIKEN */
    CATAPULTA_SHURIKEN("Catapulta Shuriken", 35, 90, false, 5, 1, 4),
    /** Constante CATAPULTA_VENGADORA */
    CATAPULTA_VENGADORA("Catapulta Vengadora", 40, 95, false, 5, 1, 4),
    /** Constante ESPADA_ENERGIA */
    ESPADA_ENERGIA("Espada Energía", 55, 95, true, 0, 1, 2),
    /** Constante SIERRA_ESCORPION */
    SIERRA_ESCORPION("Sierra Escorpión", 50, 85, true, 0, 1, 3),
    /** Constante LANZA_CANTANTE */
    LANZA_CANTANTE("Lanza Cantante", 50, 95, true, 0, 1, 1),
    /** Constante CANON_DISTORSION */
    CANON_DISTORSION("Cañón Distorsión", 90, 75, false, 2, 1, 1),

    /** Constante RIFLE_DE_PULSO */
    RIFLE_DE_PULSO("Rifle de Pulso", 45, 95, false, 6, 1, 2),
    /** Constante CARABINA_PULSO */
    CARABINA_PULSO("Carabina Pulso", 40, 90, false, 5, 1, 2),
    /** Constante CANON_ROTATIVO */
    CANON_ROTATIVO("Cañón Rotativo", 30, 80, false, 10, 5, 6),
    /** Constante RIFLE_PLASMA_TAU */
    RIFLE_PLASMA_TAU("Rifle Plasma Tau", 60, 85, false, 4, 1, 2),
    /** Constante RIFLE_FERROVIARIO */
    RIFLE_FERROVIARIO("Rifle Ferroviario", 100, 98, false, 1, 1, 1),
    /** Constante BASTON_DEL_HONOR */
    BASTON_DEL_HONOR("Bastón del Honor", 30, 90, true, 0, 1, 2),

    /** Constante AUTOPISTOLA */
    AUTOPISTOLA("Autopistola", 25, 80, false, 4, 1, 4),
    /** Constante BOLTER_PESADO */
    BOLTER_PESADO("Bólter Pesado", 45, 75, false, 5, 1, 5),
    /** Constante HACHA_SIERRA */
    HACHA_SIERRA("Hacha Sierra", 60, 85, true, 0, 1, 2),
    /** Constante LANZA_PLAGAS */
    LANZA_PLAGAS("Lanza-plagas", 40, 70, false, 3, 3, 1),
    /** Constante BACULO_DE_CAMBIO */
    BACULO_DE_CAMBIO("Báculo de Cambio", 35, 90, false, 0, 3, 1),
    /** Constante GARRAS_MUTADAS */
    GARRAS_MUTADAS("Garras Mutadas", 55, 65, true, 0, 3, 3);

    private final String nombre;
    private final int dañoBase;
    private final int precision;
    private final boolean esMelee;
    private final int municionMax;
    private final int cantidadObjetivos;
    private final int numAtaques;

    /**
     * Constructor interno para definir las estadísticas de cada arma en el catálogo.
     * @param nombre            Nombre visual del arma.
     * @param dañoBase          Daño bruto por impacto.
     * @param precision         Probabilidad de acierto.
     * @param esMelee           {@code true} si es cuerpo a cuerpo, {@code false} si es a distancia.
     * @param municionMax       Límite de munición disponible.
     * @param cantidadObjetivos Máximo de objetivos simultáneos.
     * @param numAtaques        Número de impactos por ráfaga o ataque.
     */
    ListaArmas(String nombre, int dañoBase, int precision, boolean esMelee, int municionMax, int cantidadObjetivos,
            int numAtaques) {
        this.nombre = nombre;
        this.dañoBase = dañoBase;
        this.precision = precision;
        this.esMelee = esMelee;
        this.municionMax = municionMax;
        this.cantidadObjetivos = cantidadObjetivos;
        this.numAtaques = numAtaques;
    }
/**
     * Crea y devuelve una nueva instancia de la clase {@code Arma} 
     * utilizando los valores configurados en este elemento del catálogo.
     *
     * @return Un objeto de tipo {@link Arma} configurado y listo para su uso en combate.
     */
    public Arma crearInstancia() {
        return new Arma(nombre, dañoBase, precision, esMelee, municionMax, cantidadObjetivos, numAtaques);
    }
}
