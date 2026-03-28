package proyecto;

public enum ListaArmas {
    NINGUNO("Ninguno", 0, 0, true, 0, 0, "Ninguno", 0),
    ESCUDO_TORMENTA("Escudo de Tormenta", 10, 95, true, 0, 1, "Defensa+", 1),
    ESPADA_SIERRA("Espada Sierra", 45, 85, true, 0, 1, "Sangrado 5D/2T", 2),
    HACHA_DE_ENERGIA("Hacha de energía", 65, 80, true, 0, 1, "Antiarmor 50", 1),
    BACULO("Báculo", 12, 90, true, 0, 1, "Ninguno", 1),
    BASTON_DE_FUERZA("Bastón de fuerza", 35, 85, true, 0, 1, "Ninguno", 2),
    NARTHECIUM("Narthecium", 20, 95, true, 0, 1, "Sangrado 5D/2T", 2),
    FUSIL_LASER("Fusil Láser", 15, 95, false, 8, 1, "Ninguno", 2),

    PISTOLA_BOLTER("Pistola Bolter", 35, 65, false, 3, 1, "Ninguno", 1),
    CARABINA_BOLTER("Carabina Bolter", 40, 80, false, 6, 1, "Ninguno", 4),
    GUANTELETE_GRANADERO("Guantelete Granadero", 55, 75, false, 5, 99, "Stun 2T", 1),
    CANON_DE_PLASMA("Cañón de plasma", 80, 70, false, 4, 1, "Antiarmor 50", 1),
    PISTOLA_DE_FUSION("Pistola de Fusión", 45, 85, false, 2, 99, "Fusión (Ign. Arm)", 1),
    LANZAMISILES_CICLONICO("Lanzamisiles Ciclónico", 85, 70, false, 1, 99, "Stun 2T", 2),

    CANON_DE_ASALTO("Cañón de Asalto", 30, 75, false, 4, 1, "Ninguno", 8),

    PIZTOILA("Piztoila", 15, 60, false, 2, 1, "Ninguno", 1),
    ACRIBILLADOR("Acribillador", 35, 65, false, 3, 1, "Ninguno", 5),
    REBANADORA("Rebanadora", 45, 80, true, 0, 1, "Sangrado 5D/2T", 1),
    GARRA_DE_KOMBATE("Garra de Kombate", 75, 75, true, 0, 1, "Antiarmor 50", 1),
    MEGA_BLASTA("Mega-Blasta", 65, 60, false, 2, 1, "Explosivo", 1),
    QUEMADOR("Quemador", 40, 95, false, 4, 99, "Quema 8D/2T", 1),

    MANDIBULAS("Mandíbulas", 20, 90, true, 0, 1, "Antiarmor 25", 2),
    RIFLE_GAUSS("Rifle Gauss", 45, 85, false, 4, 1, "Desintegrar", 2),
    CARABINA_TESLA("Carabina Tesla", 50, 90, false, 1, 3, "Cadena Rayos", 2),
    RIFLE_SINAPTICO("Rifle Sináptico", 60, 98, false, 1, 1, "Crítico x2", 1),
    CANON_GAUSS("Cañón Gauss", 80, 75, false, 2, 1, "Desintegrar", 3),
    BACULO_DE_LUZ("Báculo de Luz", 55, 90, true, 0, 1, "Aturdir 1T", 2),

    DERRUMBADOR("Derrumbador", 20, 75, false, 3, 1, "Veneno 5D/3T", 4),
    GARRAS_AFILADAS("Garras Afiladas", 30, 85, true, 0, 1, "Sangrado 5D/2T", 4),
    GARRAS_LACERANTES("Garras Lacerantes", 55, 90, true, 0, 1, "Antiarmor 50", 3),
    ESPADA_OSEA("Espada Ósea", 65, 85, true, 0, 1, "Drenar Vida 10%", 2),
    GARRAS_GARFIO("Garras Garfio", 70, 95, true, 0, 1, "Crítico", 2),
    EXPLOSION_MENTAL("Explosión Mental", 75, 90, false, 2, 99, "Aturdir 1T", 1),

    CATAPULTA_SHURIKEN("Catapulta Shuriken", 35, 90, false, 5, 1, "Perforación 10", 4),
    CATAPULTA_VENGADORA("Catapulta Vengadora", 40, 95, false, 5, 1, "Perforación 15", 4),
    ESPADA_ENERGIA("Espada Energía", 55, 95, true, 0, 1, "Antiarmor 50", 2),
    SIERRA_ESCORPION("Sierra Escorpión", 50, 85, true, 0, 1, "Sangrado 5D/2T", 3),
    LANZA_CANTANTE("Lanza Cantante", 50, 95, true, 0, 1, "Psíquico", 1),
    CANON_DISTORSION("Cañón Distorsión", 90, 75, false, 2, 1, "Muerte Inst(5%)", 1),

    RIFLE_DE_PULSO("Rifle de Pulso", 45, 95, false, 6, 1, "Ninguno", 2),
    CARABINA_PULSO("Carabina Pulso", 40, 90, false, 5, 1, "Aturdir (50%)", 2),
    CANON_ROTATIVO("Cañón Rotativo", 30, 80, false, 10, 99, "Supresión", 6),
    RIFLE_PLASMA_TAU("Rifle Plasma Tau", 60, 85, false, 4, 1, "Calor(Ign 20A)", 2),
    RIFLE_FERROVIARIO("Rifle Ferroviario", 100, 98, false, 1, 1, "Antiarmor 100", 1),
    BASTON_DEL_HONOR("Bastón del Honor", 30, 90, true, 0, 1, "Buff Aliado", 2),

    AUTOPISTOLA("Autopistola", 25, 80, false, 4, 1, "Ninguno", 4),
    BOLTER_PESADO("Bólter Pesado", 45, 75, false, 5, 1, "Ninguno", 5),
    HACHA_SIERRA("Hacha Sierra", 60, 85, true, 0, 1, "Sangrado 10D/2T", 2),
    LANZA_PLAGAS("Lanza-plagas", 40, 70, false, 3, 99, "Veneno 10D/3T", 1),
    BACULO_DE_CAMBIO("Báculo de Cambio", 35, 90, false, 0, 99, "Aturdir 1T", 1),
    GARRAS_MUTADAS("Garras Mutadas", 55, 65, true, 0, 99, "Miedo", 3);

    private final String nombre;
    private final int dañoBase;
    private final int precision;
    private final boolean esMelee;
    private final int municionMax;
    private final int cantidadObjetivos;
    private final String efecto;
    private final int numAtaques;

    ListaArmas(String nombre, int dañoBase, int precision, boolean esMelee, int municionMax, int cantidadObjetivos, String efecto, int numAtaques) {
        this.nombre = nombre;
        this.dañoBase = dañoBase;
        this.precision = precision;
        this.esMelee = esMelee;
        this.municionMax = municionMax;
        this.cantidadObjetivos = cantidadObjetivos;
        this.efecto = efecto;
        this.numAtaques = numAtaques;
    }

    public Arma crearInstancia() {
        return new Arma(nombre, dañoBase, precision, esMelee, municionMax, cantidadObjetivos, efecto, numAtaques);
    }
}
