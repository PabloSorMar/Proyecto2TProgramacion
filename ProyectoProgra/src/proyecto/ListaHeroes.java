package proyecto;

import java.util.Arrays;
import java.util.List;

public enum ListaHeroes {
    // ASTRA MILITARUM
    PSIQUICO("Astra Militarum", "Psíquico", 125, ListaArmas.BACULO, ListaArmaduras.TOGA, Arrays.asList(ListaHabilidades.BARRERA_PSIQUICA, ListaHabilidades.EXPLOSION_PSIQUICA, ListaHabilidades.HONDA_DE_ENERGIA, ListaHabilidades.ALTERAR_SENTIDOS), ListaArmas.NINGUNO),
    GUARDIA_IMPERIAL("Astra Militarum", "Guardia Imperial", 125, ListaArmas.FUSIL_LASER, ListaArmaduras.ARMADURA_FLAK, Arrays.asList(ListaHabilidades.APUNTAR, ListaHabilidades.COBERTURA, ListaHabilidades.CULATAZO, ListaHabilidades.CARRERA), ListaArmas.NINGUNO),
    KASRKIN("Astra Militarum", "Kasrkin", 175, ListaArmas.CARABINA_BOLTER, ListaArmaduras.ARMADURA_CAPARAZON, Arrays.asList(ListaHabilidades.APUNTAR, ListaHabilidades.VALOR_CADIANO, ListaHabilidades.MAESTRIA_EN_ARMAS, ListaHabilidades.GRANADA_PERFORACION), ListaArmas.NINGUNO),
    COMISARIO_KRIEG("Astra Militarum", "Comisario Krieg", 175, ListaArmas.PISTOLA_BOLTER, ListaArmaduras.ARMADURA_DEATH_KORPS, Arrays.asList(ListaHabilidades.ALENTAR, ListaHabilidades.TIRO_CERTERO, ListaHabilidades.NERVIO_DE_ACERO, ListaHabilidades.DISCURSO_DE_MIEDO), ListaArmas.NINGUNO),
    SENTINEL("Astra Militarum", "Sentinel", 250, ListaArmas.CANON_DE_PLASMA, ListaArmaduras.BLINDAJE, Arrays.asList(ListaHabilidades.DISPARO_REPETICION, ListaHabilidades.REPARACION, ListaHabilidades.SENTINEL_PISOTON, ListaHabilidades.APUNTAR), ListaArmas.NINGUNO), // Sentinel Pisotón exists!
    TOROGRETE("Astra Militarum", "Torogrete", 225, ListaArmas.GUANTELETE_GRANADERO, ListaArmaduras.ARMADURA_DE_PLACAS, Arrays.asList(ListaHabilidades.MURO_ANDANTE, ListaHabilidades.CUBRIRSE, ListaHabilidades.DISPARO_EXPLOSIVO, ListaHabilidades.PUNETAZO), ListaArmas.NINGUNO),

    // DEATHWATCH
    DISRUPTOR("Deathwatch", "Disruptor (Salamandras)", 250, ListaArmas.CARABINA_BOLTER, ListaArmaduras.ARMADURA_PHOBOS, Arrays.asList(ListaHabilidades.CARGA, ListaHabilidades.ARPON_BRAZO, ListaHabilidades.APUNTAR, ListaHabilidades.REFLEJOS_RELAMPAGO), ListaArmas.PISTOLA_BOLTER),
    SACERDOTE_SANGUINARIO("Deathwatch", "Sacerdote Sanguinario (Ángel Sangriento)", 325, ListaArmas.CARABINA_BOLTER, ListaArmaduras.ARMADURA_TACTICUS, Arrays.asList(ListaHabilidades.CIRUGIA_EN_COMBATE, ListaHabilidades.EUTANASIA, ListaHabilidades.RECONOCIMIENTO, ListaHabilidades.PUNTO_DEBIL), ListaArmas.NARTHECIUM),
    BIBLIOTECARIO("Deathwatch", "Bibliotecario (Ultramarine)", 375, ListaArmas.BASTON_DE_FUERZA, ListaArmaduras.ARMADURA_GRAVIS, Arrays.asList(ListaHabilidades.BARRERA_PSIQUICA, ListaHabilidades.ALTERAR_SENTIDOS, ListaHabilidades.HONDA_DE_ENERGIA, ListaHabilidades.EXPLOSION_PSIQUICA), ListaArmas.PISTOLA_BOLTER),
    CORTACABEZAS("Deathwatch", "Cortacabezas (Lobos Espaciales)", 325, ListaArmas.HACHA_DE_ENERGIA, ListaArmaduras.ARMADURA_TACTICUS, Arrays.asList(ListaHabilidades.GOLPE_ESCUDO, ListaHabilidades.CUBRIRSE, ListaHabilidades.LANZAR_HACHA, ListaHabilidades.BERSERKER), ListaArmas.ESCUDO_TORMENTA),
    SAQUEADOR("Deathwatch", "Saqueador (Puños Imperiales)", 250, ListaArmas.ESPADA_SIERRA, ListaArmaduras.ARMADURA_PHOBOS, Arrays.asList(ListaHabilidades.REFLEJOS_RELAMPAGO, ListaHabilidades.ENSANAMIENTO, ListaHabilidades.RUEDO, ListaHabilidades.CONTUSION), ListaArmas.PISTOLA_DE_FUSION),
    ALA_DE_MUERTE("Deathwatch", "Ala de muerte (Ángeles Oscuros)", 400, ListaArmas.LANZAMISILES_CICLONICO, ListaArmaduras.ARMADURA_EXTERMINADOR, Arrays.asList(ListaHabilidades.BARRIDO, ListaHabilidades.ANDANADA_MISILES, ListaHabilidades.MURO_ANDANTE, ListaHabilidades.TELETRANSPORTE), ListaArmas.CANON_DE_ASALTO);

    private final String faccion;
    private final String nombre;
    private final int vida;
    private final ListaArmas arma1;
    private final ListaArmaduras armadura;
    private final List<ListaHabilidades> habilidades;
    private final ListaArmas arma2;

    ListaHeroes(String faccion, String nombre, int vida, ListaArmas arma1, ListaArmaduras armadura, List<ListaHabilidades> habilidades, ListaArmas arma2) {
        this.faccion = faccion;
        this.nombre = nombre;
        this.vida = vida;
        this.arma1 = arma1;
        this.armadura = armadura;
        this.habilidades = habilidades;
        this.arma2 = arma2;
    }

    public Heroe crearInstancia() {
        List<Habilidades> habsGeneradas = habilidades.stream().map(ListaHabilidades::crearInstancia).toList();
        return new Heroe(nombre, faccion, vida, arma1.crearInstancia(), armadura.crearInstancia(), habsGeneradas, arma2.crearInstancia());
    }
}
