package proyecto;

public enum ListaHabilidades {
    // ALIADAS
    APUNTAR("Apuntar", 0, "Habilidad de preparación básica", true, "buf"),
    COBERTURA("Cobertura", 2, "Útil para avanzar bajo fuego", false, "buf"),
    CULATAZO("Culatazo", 3, "El Stun es potente en CC", false, "ofensiva"),
    CARRERA("Carrera", 2, "Mejora de posicionamiento", false, "movimiento"),
    ALENTAR("Alentar", 4, "Buff de daño grupal", true, "buf"),
    TIRO_CERTERO("Tiro certero", 3, "Daño crítico asegurado", true, "ofensiva"),
    NERVIO_DE_ACERO("Nervio de acero", 3, "Supervivencia táctica", false, "buf"),
    DISCURSO_DE_MIEDO("Discurso de Miedo", 4, "Debuff de área masivo", true, "debuf"),
    MURO_ANDANTE("Muro Andante", 5, "Protección total de un aliado", false, "buf"),
    CUBRIRSE("Cubrirse (Torogrete)", 3, "Bono de armadura", false, "buf"),
    DISPARO_DE_HUMO("Disparo de humo", 4, "Gran reducción de acierto enemigo", true, "debuf"),
    PUNETAZO("Puñetazo", 3, "Control de masas melee", false, "ofensiva"),
    BARRERA_PSIQUICA("Barrera Psíquica", 6, "Inmunidad temporal", false, "buf"),
    EXPLOSION_PSIQUICA("Explosión Psíquica", 4, "Daño puro que ignora defensas", true, "ofensiva"),
    HONDA_DE_ENERGIA("Honda de Energía", 3, "Daño constante en área", true, "ofensiva"),
    ALTERAR_SENTIDOS("Alterar sentidos", 3, "Confusión táctica", true, "debuf"),
    VALOR_CADIANO("Valor Cadiano", 4, "Reducción de daño pasiva", false, "buf"),
    MAESTRIA_EN_ARMAS("Maestría en Armas", 5, "Permite disparar sin gastar munición", false, "buf"),
    SENTINEL_PISOTON("Sentinel: Pisotón", 4, "Control de área pesado", false, "ofensiva"),
    REFLEJOS_RELAMPAGO("Reflejos relámpago", 3, "Velocidad de reacción", false, "buf"),
    CIRUGIA_EN_COMBATE("Cirugía en Combate", 5, "Curación necesaria pero limitada", false, "curacion"),
    EUTANASIA("Eutanasia", 2, "Remate táctico", false, "ofensiva"),
    RECONOCIMIENTO("Reconocimiento", 2, "Visión y utilidad", false, "buf"),
    PUNTO_DEBIL("Punto débil", 3, "Preparación para asesinato", true, "debuf"),

    // ENEMIGOS
    WAAAGH("¡Waaagh!", 6, "Orkos", false, "buf"),
    CABEZAZO("Cabezazo", 3, "Orkos", false, "ofensiva"),
    DISPARO_LOCO("Disparo loco", 2, "Orkos", true, "ofensiva"),
    CARGA("Carga", 3, "Orkos", false, "movimiento"),
    SALTO_IMPACTO("Salto / Impacto", 3, "Orkos", false, "ofensiva"),
    INCENDIO_GAS("Incendio / Gas", 4, "Orkos", true, "ofensiva"),
    PROTOCOLO("Protocolo", 5, "Necrones", false, "buf"),
    ENFOQUE("Enfoque", 2, "Necrones", false, "buf"),
    AUTORREPARACION("Autorreparación", 0, "Necrones (Pasiva)", false, "curacion"),
    RAYO_SOLAR("Rayo Solar", 5, "Necrones", true, "ofensiva"),
    TELETRANSPORTE("Teletransporte", 4, "Necrones", false, "movimiento"),
    ODIO_ETERNO("Odio Eterno", 4, "Necrones", false, "buf"),
    INFILTRAR_SIGILO("Infiltrar / Sigilo", 3, "Tiránidos", false, "buf"),
    MORDISCO_VENENO("Mordisco (Veneno)", 2, "Tiránidos", false, "ofensiva"),
    NEXO("Nexo", 0, "Tiránidos (Pasiva)", false, "buf"),
    EMBOSCADA("Emboscada", 5, "Tiránidos", false, "ofensiva"),
    EXPLOSION_MENTAL("Explosión Mental", 4, "Tiránidos", true, "ofensiva"),
    SACRIFICIO("Sacrificio", 99, "Caos (Un solo uso)", false, "ofensiva"),
    FANATISMO("Fanatismo", 3, "Caos", false, "buf"),
    NUBE_DE_MOSCAS("Nube de moscas", 5, "Caos", false, "debuf"),
    VOMITO_CORROSIVO("Vómito Corrosivo", 4, "Caos", true, "ofensiva"),
    RAYO_DE_CAMBIO("Rayo de Cambio", 3, "Caos", true, "ofensiva"),
    MUTACION("Mutación", 6, "Caos", false, "buf");

    private final String nombre;
    private final int cooldownBase;
    private final String efecto;
    private final boolean aDistancia;
    private final String tipo;

    ListaHabilidades(String nombre, int cooldownBase, String efecto, boolean aDistancia, String tipo) {
        this.nombre = nombre;
        this.cooldownBase = cooldownBase;
        this.efecto = efecto;
        this.aDistancia = aDistancia;
        this.tipo = tipo;
    }

    public Habilidades crearInstancia() {
        return new Habilidades(nombre, cooldownBase, efecto, aDistancia, tipo);
    }
}
