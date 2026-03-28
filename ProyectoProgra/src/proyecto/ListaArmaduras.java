package proyecto;

public enum ListaArmaduras {
    TOGA("Toga", 10, 150),
    ARMADURA_FLAK("Armadura Flak", 20, 100),
    ARMADURA_DEATH_KORPS("Armadura Death Korps", 25, 75),
    ARMADURA_CAPARAZON("Armadura Caparazón", 30, 75),
    ARMADURA_DE_PLACAS("Armadura de Placas", 40, 50),
    BLINDAJE("Blindaje", 50, 50),
    ARMADURA_PHOBOS("Armadura Phobos", 60, 200),
    ARMADURA_TACTICUS("Armadura Tacticus", 75, 150),
    ARMADURA_GRAVIS("Armadura Gravis", 90, 100),
    ARMADURA_EXTERMINADOR("Armadura Exterminador", 100, 75),
    CHATARRA("Chatarra", 15, 170),
    CUERO("Cuero", 25, 110),
    COHETE_DORSAL("Cohete Dorsal", 35, 180),
    MEGA_CHATARRA("Mega-chatarra", 85, 70),
    ARNES_SOLDADO("Arnés Soldado", 50, 90),
    TRAJE_IGNIFUGO("Traje Ignífugo", 45, 100),
    BLINDAJE_LIGERO("Blindaje Ligero", 12, 200),
    METAL_VIVIENTE("Metal Viviente", 75, 80),
    METAL_PESADO("Metal Pesado", 85, 70),
    CAPARAZON_SIGILO("Caparazón Sigilo", 35, 150),
    CHASIS_GRAVITICO("Chasis Gravítico", 75, 130),
    ARMADURA_REGIA("Armadura Regia", 100, 90),
    QUITINA_FINA("Quitina Fina", 10, 180),
    QUITINA_REFORZADA("Quitina Reforzada", 30, 170),
    QUITINA_PESADA("Quitina Pesada", 70, 110),
    CAMUFLAJE("Camuflaje", 25, 210),
    ESCUDO_PSIQUICO("Escudo Psíquico", 75, 80),
    MALLA_RUNICA("Malla Rúnica", 25, 180),
    ARMADURA_ESPECTRO("Armadura Espectro", 85, 70),
    A_PESADA_ELDAR("A. Pesada Eldar", 60, 120),
    TUNICA_RUNICA("Túnica Rúnica", 20, 160),
    ARMADURA_TAU("Armadura Tau", 30, 130),
    A_LIGERA_TAU("A. Ligera Tau", 22, 160),
    TRAJE_SIGILO("Traje Sigilo", 35, 180),
    TRAJE_COMBATE("Traje Combate", 60, 110),
    BLINDAJE_XV88("Blindaje XV88", 100, 50),
    TOGA_DEL_HONOR("Toga del Honor", 18, 150),
    HARAPOS_MALDITOS("Harapos Malditos", 8, 160),
    SERVO_TRAIDORA("Servo-Traidora", 60, 100),
    PLACAS_DE_SANGRE("Placas de Sangre", 70, 120),
    ARMADURA_OXIDADA("Armadura Oxidada", 85, 60),
    TUNICA_DISFORME("Túnica Disforme", 25, 150),
    PIEL_MUTADA("Piel Mutada", 35, 140);

    private final String nombre;
    private final int blindaje;
    private final int velocidad;

    ListaArmaduras(String nombre, int blindaje, int velocidad) {
        this.nombre = nombre;
        this.blindaje = blindaje;
        this.velocidad = velocidad;
    }

    public Armaduras crearInstancia() {
        return new Armaduras(nombre, blindaje, velocidad);
    }
}
