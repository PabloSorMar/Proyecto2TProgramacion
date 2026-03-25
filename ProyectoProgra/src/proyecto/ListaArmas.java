package proyecto;

public enum ListaArmas {
    // Ejemplo basado en las armas especiales con efecto del prompt, más armas estándar
    ESPADA_SIERRA("Espada Sierra", 15, 80, true, 0, 1, "Rending", 2),
    BIFERRO("BíFérro", 12, 75, false, 30, 1, "Perforante", 1),
    
    // Armas especiales del cuadro
    GUANTELETE_GRANADERO("Guantelete Granadero", 20, 70, true, 0, 1, "Stun 2T (CD 4)", 1),
    LANZAMISILES_CICLONICO("Lanzamisiles Ciclónico", 40, 60, false, 4, 3, "Stun 2T / Área (CD 5)", 1),
    PISTOLA_MUSION("Pistola de Fusión", 35, 85, false, 6, 1, "Ignorar Armadura (CD 3)", 1),
    CANON_PLASMA("Cañón de Plasma", 50, 70, false, 10, 1, "Anti-Armadura (CD 2)", 1),
    CARABINA_TESLA("Carabina Tesla", 25, 90, false, 20, 2, "Cadena de Rayos (CD 2)", 1);

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
