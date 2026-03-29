package proyecto;

import java.util.ArrayList;
import java.util.List;

import proyecto.habilidades.*;

/**
 * Catálogo de héroes disponibles en el juego.
 * Cada entrada define la facción, estadísticas base y equipamiento inicial.
 * Incluye un método factory para crear instancias de la clase Heroe con sus habilidades.
 */
public enum ListaHeroes {

    // ASTRA MILITARUM
    PSIQUICO("Astra Militarum", "Psíquico", 125, ListaArmas.BACULO, ListaArmaduras.TOGA, ListaArmas.NINGUNO),
    GUARDIA_IMPERIAL("Astra Militarum", "Guardia Imperial", 125, ListaArmas.FUSIL_LASER, ListaArmaduras.ARMADURA_FLAK, ListaArmas.NINGUNO),
    KASRKIN("Astra Militarum", "Kasrkin", 175, ListaArmas.CARABINA_BOLTER, ListaArmaduras.ARMADURA_CAPARAZON, ListaArmas.NINGUNO),
    COMISARIO_KRIEG("Astra Militarum", "Comisario Krieg", 175, ListaArmas.PISTOLA_BOLTER, ListaArmaduras.ARMADURA_DEATH_KORPS, ListaArmas.NINGUNO),
    SENTINEL("Astra Militarum", "Sentinel", 250, ListaArmas.CANON_DE_PLASMA, ListaArmaduras.BLINDAJE, ListaArmas.NINGUNO),
    TOROGRETE("Astra Militarum", "Torogrete", 225, ListaArmas.GUANTELETE_GRANADERO, ListaArmaduras.ARMADURA_DE_PLACAS, ListaArmas.NINGUNO),

    // DEATHWATCH
    DISRUPTOR("Deathwatch", "Disruptor (Salamandras)", 250, ListaArmas.CARABINA_BOLTER, ListaArmaduras.ARMADURA_PHOBOS, ListaArmas.PISTOLA_BOLTER),
    SACERDOTE_SANGUINARIO("Deathwatch", "Sacerdote Sanguinario (Ángel Sangriento)", 325, ListaArmas.CARABINA_BOLTER, ListaArmaduras.ARMADURA_TACTICUS, ListaArmas.NARTHECIUM),
    BIBLIOTECARIO("Deathwatch", "Bibliotecario (Ultramarine)", 375, ListaArmas.BASTON_DE_FUERZA, ListaArmaduras.ARMADURA_GRAVIS, ListaArmas.PISTOLA_BOLTER),
    CORTACABEZAS("Deathwatch", "Cortacabezas (Lobos Espaciales)", 325, ListaArmas.HACHA_DE_ENERGIA, ListaArmaduras.ARMADURA_TACTICUS, ListaArmas.ESCUDO_TORMENTA),
    SAQUEADOR("Deathwatch", "Saqueador (Puños Imperiales)", 250, ListaArmas.ESPADA_SIERRA, ListaArmaduras.ARMADURA_PHOBOS, ListaArmas.PISTOLA_DE_FUSION),
    ALA_DE_MUERTE("Deathwatch", "Ala de muerte (Ángeles Oscuros)", 400, ListaArmas.LANZAMISILES_CICLONICO, ListaArmaduras.ARMADURA_EXTERMINADOR, ListaArmas.CANON_DE_ASALTO);

    private final String faccion;
    private final String nombre;
    private final int vida;
    private final ListaArmas arma1;
    private final ListaArmaduras armadura;
    private final ListaArmas arma2;

    ListaHeroes(String faccion, String nombre, int vida, ListaArmas arma1, ListaArmaduras armadura, ListaArmas arma2) {
        this.faccion = faccion;
        this.nombre = nombre;
        this.vida = vida;
        this.arma1 = arma1;
        this.armadura = armadura;
        this.arma2 = arma2;
    }

    public Heroe crearInstancia() {
        List<Habilidades> habs = new ArrayList<>();
        switch (this) {
            case PSIQUICO:
                habs.add(new BarreraPsiquica());
                habs.add(new ExplosionPsiquica());
                habs.add(new HondaEnergia());
                habs.add(new AlterarSentidos());
                break;
            case GUARDIA_IMPERIAL:
                habs.add(new Apuntar());
                habs.add(new Cobertura());
                habs.add(new CulatazoSkill());
                habs.add(new Carrera());
                break;
            case KASRKIN:
                habs.add(new Apuntar());
                habs.add(new ValorCadiano());
                habs.add(new MaestriaEnArmas());
                habs.add(new GranadaPerforacion());
                break;
            case COMISARIO_KRIEG:
                habs.add(new Alentar());
                habs.add(new TiroCertero());
                habs.add(new NervioDeAcero());
                habs.add(new DiscursoDeMiedo());
                break;
            case SENTINEL:
                habs.add(new DisparoRepeticion());
                habs.add(new Reparacion());
                habs.add(new SentinelPisoton());
                habs.add(new Apuntar());
                break;
            case TOROGRETE:
                habs.add(new MuroAndante());
                habs.add(new Cubrirse());
                habs.add(new DisparoExplosivo());
                habs.add(new PunetazoSkill());
                break;
            case DISRUPTOR:
                habs.add(new Carga());
                habs.add(new ArponBrazo());
                habs.add(new Apuntar());
                habs.add(new ReflejosRelampago());
                break;
            case SACERDOTE_SANGUINARIO:
                habs.add(new CirugiaEnCombate());
                habs.add(new Eutanasia());
                habs.add(new Reconocimiento());
                habs.add(new PuntoDebil());
                break;
            case BIBLIOTECARIO:
                habs.add(new BarreraPsiquica());
                habs.add(new AlterarSentidos());
                habs.add(new HondaEnergia());
                habs.add(new ExplosionPsiquica());
                break;
            case CORTACABEZAS:
                habs.add(new GolpeEscudo());
                habs.add(new Cubrirse());
                habs.add(new LanzarHacha());
                habs.add(new Berserker());
                break;
            case SAQUEADOR:
                habs.add(new ReflejosRelampago());
                habs.add(new EnsanamientoSkill());
                habs.add(new Ruedo());
                habs.add(new Contusion());
                break;
            case ALA_DE_MUERTE:
                habs.add(new Barrido());
                habs.add(new AndanadaMisiles());
                habs.add(new MuroAndante());
                habs.add(new Teletransporte());
                break;
        }
        return new Heroe(nombre, faccion, vida, arma1.crearInstancia(), armadura.crearInstancia(), habs, arma2.crearInstancia());
    }

    public String getFaccion() { return this.faccion; }
    public String getNombre() { return this.nombre; }
}
