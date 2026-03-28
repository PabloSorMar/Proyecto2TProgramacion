package proyecto;

public enum ListaHabilidades {
    APUNTAR("Apuntar", 2, "Mejora la probabilidad de impacto en un +20% para el siguiente ataque.", true, "buf"),
    COBERTURA("Cobertura", 2, "Reduce la probabilidad de impacto del enemigo en un -15% durante 2 turnos.", false, "buf"),
    CULATAZO("Culatazo", 3, "Ataque cuerpo a cuerpo (15 Daño) que provoca Stun durante 1 turno.", false, "ofensiva"),
    CARRERA("Carrera", 3, "Aumenta la velocidad en +50 puntos el siguiente turno.", false, "movimiento"),
    ALENTAR("Alentar", 4, "Potencia el daño de todos los aliados en un +15% durante ese turno.", false, "buf"),
    TIRO_CERTERO("Tiro certero", 3, "Un disparo con +30% de acierto y probabilidad de Crítico (Daño x2).", true, "ofensiva"),

    DISCURSO_DE_MIEDO("Discurso de Miedo", 4, "Reduce la probabilidad de impacto del objetivo en un -20% durante 3 turnos.", true, "debuf"),
    MURO_ANDANTE("Muro Andante", 5, "Se posiciona frente a un aliado; recibe el 100% de los ataques dirigidos a él (1T).", false, "buf"),
    CUBRIRSE("Cubrirse", 3, "Aumenta +30% la probabilidad de que los ataques den en armadura (2 turnos).", false, "buf"),
    DISPARO_DE_HUMO("Disparo de humo", 4, "Reduce el acierto enemigo en un -40% durante 1 turno.", true, "debuf"),
    PUNETAZO("Puñetazo", 2, "Golpe de 35 Daño que aplica Stun por 1 turno.", false, "ofensiva"),
    BARRERA_PSIQUICA("Barrera Psíquica", 5, "Niega el 100% del daño recibido a un objetivo durante 1 turno.", true, "buf"),

    EXPLOSION_PSIQUICA("Explosión Psíquica", 4, "Inflige 60 Daño psíquico a un solo objetivo (ignora armadura).", true, "ofensiva"),
    NERVIO_DE_ACERO("Nervio de acero", 3, "Aumenta la esquiva en +25% durante 2 turnos.", false, "buf"),
    HONDA_DE_ENERGIA("Honda de Energía", 4, "Daño general de 20 a todos los enemigos.", true, "ofensiva"),
    ALTERAR_SENTIDOS("Alterar sentidos", 3, "Confunde al enemigo disminuyendo su acierto en un -25% (2T).", true, "debuf"),
    VALOR_CADIANO("Valor Cadiano", 0, "Mejora la reducción de daño por armadura en un +20% (2 turnos).", false, "buf"),
    MAESTRIA_EN_ARMAS("Maestría en Armas", 4, "El personaje puede atacar sin gastar munición durante este turno.", false, "buf"),

    SENTINEL_PISOTON("Sentinel: Pisotón", 4, "Ataque de área (30 Daño). Aplica Stun si el enemigo tiene poca armadura.", false, "ofensiva"),
    REFLEJOS_RELAMPAGO("Reflejos relámpago", 3, "Aumenta la velocidad en +60 puntos el siguiente turno.", false, "buf"),
    SACRIFICIO("Sacrificio", 99, "Recupera 70 de Vida a un aliado eliminando al usuario.", false, "curacion"),
    FANATISMO("Fanatismo", 3, "Aumenta el Daño un 10% durante 2 turnos.", false, "buf"),
    PUNALADA("Puñalada", 3, "Ataque cuerpo a cuerpo con Sangrado (5D/2T).", false, "ofensiva"),
    OCULTARSE("Ocultarse", 3, "Aumenta la Esquiva significativamente durante 1 turno.", false, "buf"),

    GRANADA("Granada", 3, "Daño de área de 20 a 3 objetivos cercanos.", true, "ofensiva"),
    FURIA("Furia", 4, "Realiza un ataque extra en el turno actual.", false, "buf"),
    RECARGA_RAPIDA("Recarga Rápida", 3, "Recarga el arma sin gastar el turno completo.", false, "buf"),
    BAYONETA("Bayoneta", 0, "Ataque cuerpo a cuerpo básico de 15 Daño.", false, "ofensiva"),
    SANGRE_DIOS("Sangre Dios", 0, "Si elimina a un enemigo, recupera 30 de Vida.", false, "curacion"),
    CARGA("Carga", 3, "Se mueve hacia el objetivo y ataca con +10 de Daño.", false, "movimiento"),

    DESPEDAZAR("Despedazar", 3, "Aplica Sangrado Crítico (15D/2T) al objetivo.", false, "ofensiva"),
    AULLIDO("Aullido", 3, "Reduce la Precisión enemiga un 15% (2T).", true, "debuf"),
    COBARDIA("Cobardía", 0, "Si recibe daño, retrocede automáticamente una posición.", false, "movimiento"),
    ROBAR("Robar", 4, "Quita 2 puntos de Munición al objetivo.", true, "debuf"),
    ESCONDERSE("Esconderse", 4, "No puede ser objetivo de ataques a distancia (1 turno).", false, "buf"),
    WAAAGH("¡Waaagh!", 5, "Aumenta la Velocidad de los aliados en +30 por 1 turno.", false, "buf"),

    PEDRADA("Pedrada", 2, "Inflige 5 Daño con probabilidad de provocar Stun (1T).", true, "ofensiva"),
    CABEZAZO("Cabezazo", 3, "Ataque de 20 Daño que aplica Stun (1T) al usuario y al enemigo.", false, "ofensiva"),
    DISPARO_LOCO("Disparo Loco", 3, "Dispara toda la munición con -30 de Precisión.", true, "ofensiva"),
    SALTO("Salto", 3, "Salta sobre un enemigo ignorando cobertura.", false, "movimiento"),
    IMPACTO("Impacto", 3, "Al caer tras un salto, inflige 20 Daño a objetivos adyacentes.", false, "ofensiva"),
    DESCENSO("Descenso", 0, "Gana +20% de Esquiva durante el turno de caída.", false, "buf"),

    FURIA_AEREA("Furia Aérea", 4, "Realiza un ataque extra si ha saltado este turno.", false, "ofensiva"),
    RUGIDO("Rugido", 4, "Aumenta el Daño de los aliados en +10 durante 1 turno.", false, "buf"),
    INTIMIDAR("Intimidar", 3, "Reduce la Esquiva del enemigo un 20% durante 2 turnos.", true, "debuf"),
    APLASTAR("Aplastar", 4, "Ataque lento de 50 Daño que ignora la Armadura.", false, "ofensiva"),
    ORDENAR("Ordenar", 4, "Obliga a un aliado cercano a atacar inmediatamente.", false, "buf"),
    CAMPO_FUERZA("Campo Fuerza", 5, "Otorga +50 de Armadura en área durante 2 turnos.", false, "buf"),

    TORRETA("Torreta", 5, "Despliega una unidad estática que dispara cada turno.", false, "ofensiva"),
    CHISPAZO("Chispazo", 3, "Daño eléctrico de 15 con probabilidad de Stun (1T).", true, "ofensiva"),
    ENJAMBRAR("Enjambrar", 4, "Reduce la Velocidad enemiga a 0 durante 1 turno.", true, "debuf"),
    REPARAR_NECRON("Reparar (Necrón)", 99, "Se sacrifica para curar 40 de Vida a un Necrón aliado.", false, "curacion"),
    AUTORREPARACION("Autorreparación", 0, "Recupera 10 de Vida al inicio de cada turno de forma pasiva.", false, "curacion"),
    ESQUIVA_NECRON("Esquiva (Necrón)", 3, "Aumenta su propia Esquiva en un +30% por 1 turno.", false, "buf"),

    INSTINTO("Instinto", 0, "Gana +15 de Precisión si hay un Guerrero Tiránido cerca.", false, "buf"),
    MORDISCO("Mordisco", 2, "Ataque cuerpo a cuerpo que aplica Veneno (5D/3T).", false, "ofensiva"),
    SALTO_LARGO("Salto Largo", 3, "Salta sobre obstáculos o unidades para atacar.", false, "movimiento"),
    ENJAMBRE("Enjambre", 0, "Gana +5 de Daño por cada aliado adyacente al objetivo.", false, "buf"),
    FRENESI("Frenesí", 3, "Realiza un ataque extra a cambio de 10 de Vida.", false, "ofensiva"),
    MIEDO("Miedo", 0, "Probabilidad de provocar Stun (1T) en área al aparecer.", false, "debuf"),

    NEXO("Nexo", 0, "Otorga +10 Daño y Precisión a aliados menores en área.", false, "buf"),
    REGENERAR("Regenerar", 4, "Recupera 25 de Vida de forma instantánea.", false, "curacion"),
    TERROR("Terror", 4, "Reduce la Precisión enemiga en área en -20 (2T).", true, "debuf"),
    EMPALAR("Empalar", 4, "Ataque de 35 Daño que inmoviliza al objetivo.", false, "ofensiva"),
    DISCIPLINA("Disciplina", 0, "Gana +15 de Precisión si dispara desde cobertura.", false, "buf"),
    REUBICARSE("Reubicarse", 3, "Gana +30 de Velocidad inmediatamente tras atacar.", false, "movimiento"),

    TORMENTA("Tormenta", 3, "Dispara 2 veces con un penalizador de -10 de Precisión.", true, "ofensiva"),
    RETIRADA("Retirada", 0, "Se mueve una posición tras recibir daño.", false, "movimiento"),
    ACROBACIA("Acrobacia", 0, "Puede moverse a través de celdas ocupadas por enemigos.", false, "movimiento"),
    BIEN_SUPERIOR("Bien Superior", 0, "Dispara automáticamente a quien ataque a un aliado cercano.", true, "ofensiva"),
    MARCADOR("Marcador", 2, "Otorga +20 de Precisión a aliados contra el objetivo.", true, "buf"),
    FOTONICA("Fotónica", 4, "Provoca Stun (1T) en área (Granada cegadora).", true, "debuf"),

    DESIGNAR("Designar", 3, "Marca a un objetivo; este no podrá realizar Esquiva.", true, "debuf"),
    HOSTIGAR("Hostigar", 4, "Permite Mover - Atacar - Mover en el mismo turno.", false, "movimiento"),
    RETROCOHETES("Retrocohetes", 3, "Permite saltar y alejarse tras realizar un ataque.", false, "movimiento"),
    MISILES("Misiles", 4, "Daño de área de 40 repartido entre los enemigos.", true, "ofensiva"),
    
    // EXTRAS Y FALTANTES (Deathwatch, Astra, Orkos, Necrones, T'au, Aeldari, Chaos, etc.)
    ARPON_BRAZO("Arpón de brazo", 3, "Atrae al enemigo para cuerpo a cuerpo", false, "ofensiva"),
    GOLPE_ESCUDO("Golpe de escudo", 3, "Golpea y puede causar Stun", false, "ofensiva"),
    LANZAR_HACHA("Lanzar Hacha", 2, "Ataque a distancia fuerte", true, "ofensiva"),
    BERSERKER("Berserker", 5, "Furia asesina que suma muchísimo daño", false, "buf"),
    ENSANAMIENTO("Ensañamiento", 4, "Daño continuado muy alto", false, "ofensiva"),
    RUEDO("Ruedo", 3, "Esquiva los siguientes ataques", false, "buf"),
    CONTUSION("Contusión", 3, "Stun garantizado al objetivo", false, "debuf"),
    BARRIDO("Barrido", 3, "Ataque a todos los enemigos cercanos", false, "ofensiva"),
    ANDANADA_MISILES("Andanada de misiles", 4, "Lluvia de misiles potente", true, "ofensiva"),
    GRANADA_PERFORACION("Granada de Perforación", 3, "Atraviesa armadura", true, "ofensiva"),
    DISPARO_REPETICION("Disparo Repetición", 3, "Dispara dos veces seguidas", true, "ofensiva"),
    REPARACION("Reparación", 3, "Repara un vehículo aliado", false, "curacion"),
    DISPARO_EXPLOSIVO("Disparo explosivo", 4, "Ataque en área poderoso", true, "ofensiva"),

    INCENDIO("Incendio", 4, "Quema a un área completa", true, "ofensiva"),
    MURO_FUEGO("Muro fuego", 5, "Crea daño de fuego en área", true, "ofensiva"),
    GAS("Gas", 3, "Veneno prolongado en área", true, "ofensiva"),
    COMBUSTIBLE("Combustible", 2, "Aumenta el daño de llama", false, "buf"),

    DISPARO_GAUSS("Disparo Gauss", 3, "Disparo de energía perforante", true, "ofensiva"),
    AGUANTE("Aguante", 4, "Mejora defensa considerablemente", false, "buf"),
    SOBRECARGA("Sobrecarga", 3, "Más daño temporal a cambio de defensa", false, "buf"),
    ESCUDO("Escudo", 4, "Escudo extra por varios turnos", false, "buf"),
    TESLA("Tesla", 3, "Rayo rebotador a 3 objetivos", true, "ofensiva"),
    INAMOVIBLE("Inamovible", 5, "Fija su posición e ignora stun o pushes", false, "buf"),
    MARCA("Marca", 2, "Señala objetivo vulnerable", true, "debuf"),
    FRANCOTIRADOR("Francotirador", 4, "Disparo extremadamente preciso", true, "ofensiva"),
    INVISIBILIDAD("Invisibilidad", 4, "Inmune a disparo por 1 turno", false, "buf"),
    ODIO_ETERNO("Odio eterno", 3, "Pasiva: Daño crónico al morir", false, "ofensiva"),
    VUELO("Vuelo", 3, "Alza el vuelo y evita ataques de melé bajos", false, "buf"),
    OPTIMIZAR("Optimizar", 2, "Reduce todos los cooldowns en 1", false, "buf"),
    RAFAGA("Ráfaga", 3, "Varios disparos rápidos en área pequeña", true, "ofensiva"),
    COMANDO("Comando", 3, "Bufa a los necrones cercanos", false, "buf"),
    INVULNERABLE("Invulnerable", 5, "Inmune a daño letal 1T", false, "buf"),

    CAMALEON("Camaleón", 4, "Sube la capacidad de evadir", false, "buf"),
    MENTE_COLMENA("Mente Colmena", 0, "Comparte bonos con todos los tiránidos", false, "buf"),
    RAYO_MENTAL("Rayo Mental", 3, "Daño Psíquico severo", true, "ofensiva"),
    LEVITACION("Levitación", 0, "Evita obstáculos terrestres", false, "buf"),
    INFILTRAR("Infiltrar", 3, "Aparece de imprevisto por la espalda", false, "movimiento"),
    SIGILO("Sigilo", 2, "Reduce radicalmente visibilidad lejana", false, "buf"),

    DEFENSA("Defensa", 2, "Mejora de armadura psíquica", false, "buf"),
    PUNTERIA("Puntería", 2, "Sube precisión considerablemente", false, "buf"),
    GRITO("Grito", 3, "Causa estragos en la moral (debuf en área)", true, "debuf"),
    CARGA_VELOZ("Carga veloz", 2, "Mueve + Ataca rápidamente", false, "movimiento"),
    DANZA("Danza", 2, "Sube masivamente la esquiva", false, "buf"),
    GUIA("Guía", 2, "Guía ataques aliados haciéndolos infalibles", false, "buf"),
    DESTINO("Destino", 3, "Impone una maldición de daño inevitable", true, "debuf"),
    VACIO("Vacío", 4, "Teletransporte breve que anula ataques", false, "buf"),
    IMPERTURBABLE("Imperturbable", 0, "Inmune incondicional al MIEDO y stuns", false, "buf"),
    ESCUDO_RUNICO("Escudo rúnico", 3, "Absorbe daños pesados a coste psíquico", false, "buf"),
    GOLPE_PESADO("Golpe Pesado", 3, "Ataque asombrosamente destructivo pero lento", false, "ofensiva"),

    REAGRUPAR("Reagrupar", 3, "Devuelve al grupo la moral unificando salud relativa", false, "movimiento"),
    RECON("Recon", 2, "Descubre a todas las unidades infiltradas o invisibles", false, "buf"),
    PRECISION("Precisión", 2, "Aumenta brutalmente la efectividad del disparo", false, "buf"),
    DRON("Dron", 3, "Añade un Dron de escolta a la unidad", false, "ofensiva"),
    DESPLIEGUE("Despliegue", 4, "Sube a reserva para caer en otro turno", false, "movimiento"),
    SENSORES("Sensores", 2, "Niega bonus de cobertura al enemigo", false, "buf"),
    MULTIBLANCO("Multiblanco", 3, "Permite que el arma principal dispare a varios sin penalía", true, "buf"),
    MUNICION("Munición", 2, "Restaura la munición a 100% de la unidad y los aliados", false, "buf"),
    ANCLAJE("Anclaje", 0, "Fija el arma pesada imposibilitando el movimiento a cambio de precisión total", false, "buf"),
    LARGA_DISTANCIA("Larga distancia", 3, "Disparo desde zonas no alcanzables temporalmente", true, "ofensiva"),
    BLINDAJE_PLUS("Blindaje+", 4, "Aumenta pasivamente la negación de golpe crítico de forma brutal", false, "buf"),
    INVOCACION("Invocación", 5, "Genera unidades amigas de apoyo menor cerca de él", false, "ofensiva"),
    LIDERAZGO("Liderazgo", 0, "Aura inamovible que beneficia a los aliados próximos permanentemente", false, "buf"),
    CASTIGO("Castigo", 4, "Descarga total psíquica o elemental devastadora", false, "ofensiva"),

    TENACIDAD("Tenacidad", 3, "Provee armadura pesada breve tras un impacto", false, "buf"),
    REGENERACION("Regeneración", 4, "Se cura un alto volumen pasivamente mientras esté viva", false, "curacion"),
    ESCUDO_DISFORME("Escudo Disforme", 4, "Escudo demoníaco que rebota letalidad a distancia corta", false, "buf"),
    ILUSION("Ilusión", 3, "Reescribe estadísticamente fallos forzados en enemigos al atacar", false, "debuf"),
    EMBESTIDA("Embestida", 3, "Atropella por completo a las filas aplastando coberturas", false, "ofensiva"),
    ALARIDO("Alarido", 3, "Anula la capacidad de ataque (silencio/terror) en área masiva durante el turno", true, "debuf");

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
