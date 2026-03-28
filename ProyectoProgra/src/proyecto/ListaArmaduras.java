package proyecto;

public enum ListaArmaduras {
    TOGA("Toga", 50, 150),
    ARMADURA_FLAK("Armadura Flak", 75, 100),
    ARMADURA_DEATH_KORPS("Armadura Death Korps", 100, 75),
    ARMADURA_CAPARAZON("Armadura Caparazón", 125, 75),
    ARMADURA_DE_PLACAS("Armadura de Placas", 175, 50),
    BLINDAJE("Blindaje", 200, 50),
    ARMADURA_PHOBOS("Armadura Phobos", 250, 200),
    ARMADURA_TACTICUS("Armadura Tacticus", 300, 150),
    ARMADURA_GRAVIS("Armadura Gravis", 350, 100),
    ARMADURA_EXTERMINADOR("Armadura Exterminador", 400, 75),
    CHATARRA("Chatarra", 60, 170),
    CUERO("Cuero", 100, 110),
    COHETE_DORSAL("Cohete Dorsal", 150, 180),
    MEGA_CHATARRA("Mega-chatarra", 350, 70),
    ARNES_SOLDADO("Arnés Soldado", 200, 90),
    TRAJE_IGNIFUGO("Traje Ignífugo", 180, 100),
    BLINDAJE_LIGERO("Blindaje Ligero", 50, 200),
    METAL_VIVIENTE("Metal Viviente", 300, 80),
    METAL_PESADO("Metal Pesado", 350, 70),
    CAPARAZON_SIGILO("Caparazón Sigilo", 150, 150),
    CHASIS_GRAVITICO("Chasis Gravítico", 300, 130),
    ARMADURA_REGIA("Armadura Regia", 400, 90),
    QUITINA_FINA("Quitina Fina", 40, 180),
    QUITINA_REFORZADA("Quitina Reforzada", 120, 170),
    QUITINA_PESADA("Quitina Pesada", 280, 110),
    CAMUFLAJE("Camuflaje", 100, 210),
    ESCUDO_PSIQUICO("Escudo Psíquico", 300, 80),
    MALLA_RUNICA("Malla Rúnica", 100, 180),
    ARMADURA_ESPECTRO("Armadura Espectro", 350, 70),
    A_PESADA_ELDAR("A. Pesada Eldar", 250, 120),
    TUNICA_RUNICA("Túnica Rúnica", 80, 160),
    ARMADURA_TAU("Armadura Tau", 125, 130),
    A_LIGERA_TAU("A. Ligera Tau", 90, 160),
    TRAJE_SIGILO("Traje Sigilo", 150, 180),
    TRAJE_COMBATE("Traje Combate", 250, 110),
    BLINDAJE_XV88("Blindaje XV88", 400, 50),
    TOGA_DEL_HONOR("Toga del Honor", 70, 150),
    HARAPOS_MALDITOS("Harapos Malditos", 30, 160),
    SERVO_TRAIDORA("Servo-Traidora", 250, 100),
    PLACAS_DE_SANGRE("Placas de Sangre", 280, 120),
    ARMADURA_OXIDADA("Armadura Oxidada", 350, 60),
    TUNICA_DISFORME("Túnica Disforme", 100, 150),
    PIEL_MUTADA("Piel Mutada", 150, 140);

    private  final String nombre;
    private  final int blindaje;
    private  final int velocidad;

    ListaArmaduras(String nombre, int blindaje, int velocidad) {
        this.nombre = nombre;
        this.blindaje = blindaje;
        this.velocidad = velocidad;
    }

    public Armaduras crearInstancia() {
        return new Armaduras(nombre, blindaje, velocidad);
    }
}
