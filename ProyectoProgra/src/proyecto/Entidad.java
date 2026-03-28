package proyecto;

import java.util.List;
import java.util.Random;

public class Entidad {
    private String nombre;
    private String faccion;
    private int vida;
    private int turnoStun;
    private int turnoHemorragia;
    private int turnoVeneno;
    private int turnoCuracion;
    private boolean defendido;
    private Arma arma;
    private Armaduras armadura;
    private List<Habilidades> habilidades;

    Entidad(String nombre, String faccion, int vida, Arma arma, Armaduras armadura, List<Habilidades> habilidades) {
        this.nombre = nombre;
        this.faccion = faccion;
        this.vida = vida;
        this.turnoStun = 0;
        this.turnoHemorragia = 0;
        this.turnoVeneno = 0;
        this.turnoCuracion = 0;
        this.defendido = false;
        this.arma = arma;
        this.armadura = armadura;
        this.habilidades = habilidades;
    }

    // SETTERS Y GETTERS
    public String getNombre() {
        return this.nombre;
    }

    public String getFaccion() {
        return this.faccion;
    }

    public int getVida() {
        return this.vida;
    }

    public int getTurnoStun() {
        return this.turnoStun;
    }

    public int getTurnoHemorragia() {
        return this.turnoHemorragia;
    }

    public int getTurnoVeneno() {
        return this.turnoVeneno;
    }

    public int getTurnoCuracion() {
        return this.turnoCuracion;
    }

    public boolean getDefendido() {
        return this.defendido;
    }

    public Arma getArma() {
        return this.arma;
    }

    public Armaduras getArmadura() {
        return this.armadura;
    }

    public List<Habilidades> getHabilidades() {
        return this.habilidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFaccion(String faccion) {
        this.faccion = faccion;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setTurnoStun(int turnoStun) {
        this.turnoStun = turnoStun;
    }

    public void setTurnoHemorragia(int turnoHemorragia) {
        this.turnoHemorragia = turnoHemorragia;
    }

    public void setTurnoVeneno(int turnoVeneno) {
        this.turnoVeneno = turnoVeneno;
    }

    public void setTurnoCuracion(int turnoCuracion) {
        this.turnoCuracion = turnoCuracion;
    }

    public void setDefendido(boolean defendido) {
        this.defendido = defendido;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void setArmadura(Armaduras armadura) {
        this.armadura = armadura;
    }

    public void setHabilidades(List<Habilidades> habilidades) {
        this.habilidades = habilidades;
    }

    public void RealizarTurno(List<Entidad> aliados, List<Entidad> enemigos, Entidad personaje) {
        System.out.println("Turno de " + this.getNombre());
        if (this.getDefendido()) {
            this.setDefendido(false);
        }
        // Primero efectos acvito de daño en si mismo
        if (this.getTurnoStun() > 0) {
            System.out.println(this.getNombre() + " esta arturdido");
            setTurnoStun(getTurnoStun() - 1);
        } else {
            if (this.getTurnoHemorragia() > 0) {
                setVida(getVida() - 10);
                setTurnoHemorragia(getTurnoHemorragia() - 1);
            }
            if (this.getTurnoVeneno() > 0) {
                setVida(getVida() - 10);
                setTurnoVeneno(getTurnoVeneno() - 1);
            }
            // Aleatorio para ver que hace
            Random ran = new Random();
            int accion = ran.nextInt(0, 4);

            if (accion == 0) {
                // Comprobar si es héroe y tiene segunda arma para decidir
                Arma armaAUsar = this.getArma();

                if (this instanceof Heroe) {
                    Heroe heroeActual = (Heroe) this;
                    if (heroeActual.getArma2() != null) {
                        if (ran.nextBoolean()) {
                            armaAUsar = heroeActual.getArma2();
                            System.out.println(this.getNombre() + " decide atacar con su ARMA SECUNDARIA: "
                                    + armaAUsar.getNombre());
                        } else {
                            System.out.println(this.getNombre() + " decide atacar con su ARMA PRINCIPAL: "
                                    + armaAUsar.getNombre());
                        }
                    } else {
                        System.out.println(this.getNombre() + " decide atacar con su arma: " + armaAUsar.getNombre());
                    }
                } else {
                    System.out.println(this.getNombre() + " decide atacar con su arma: " + armaAUsar.getNombre());
                }

                if (aliados.contains(personaje)) {
                    for (int i = 0; i < armaAUsar.getCantidadObjetivos(); i++) {
                        int objetivo_aleatorio = ran.nextInt(0, enemigos.size());
                        System.out.print("Objetivo " + i + 1 + ": " + enemigos.get(objetivo_aleatorio).getNombre());
                        if (enemigos.get(objetivo_aleatorio).getDefendido()) {
                            System.out.println("El objetivo esta defendido, no puede recibir daño");
                            continue;
                        }
                        for (int j = 0; j < armaAUsar.getNumAtaques(); j++) {
                            System.out.println("Ataque numero " + j);
                            Entidad objetivo = enemigos.get(objetivo_aleatorio);
                            if (!armaAUsar.getEsMelee()) {
                                if (ran.nextInt(0, 100) < armaAUsar.getPrecision()) {
                                    if (ran.nextInt(1, 7) == 1) {
                                        System.out.println("CRITICO");
                                        int daño = armaAUsar.getDaño();
                                        int daño_final = daño * 2 - objetivo.getArmadura().getBlindaje();
                                        if (daño_final < 0) {
                                            daño_final = 0;
                                        }
                                        objetivo.setVida(objetivo.getVida() - daño_final);
                                    } else {
                                        System.out.println("Golpe normal");
                                        int daño = armaAUsar.getDaño();
                                        int daño_final = daño - objetivo.getArmadura().getBlindaje();
                                        if (daño_final < 0) {
                                            daño_final = 0;
                                        }
                                        objetivo.setVida(objetivo.getVida() - daño_final);
                                    }
                                } else {
                                    System.out.println("No golpea al objetivo el ataque ");
                                }
                            } else {
                                if (!objetivo.getArma().getEsMelee()) {
                                    System.out.println("EL objetivo esta a distancia, so le puede atacar");
                                } else {
                                    if (ran.nextInt(0, 100) < armaAUsar.getPrecision()) {
                                        if (ran.nextInt(1, 7) == 1) {
                                            System.out.println("CRITICO");
                                            int daño = armaAUsar.getDaño();
                                            int daño_final = daño * 2 - objetivo.getArmadura().getBlindaje();
                                            if (daño_final < 0) {
                                                daño_final = 0;
                                            }
                                            objetivo.setVida(objetivo.getVida() - daño_final);
                                        } else {
                                            System.out.println("Golpe normal");
                                            int daño = armaAUsar.getDaño();
                                            int daño_final = daño - objetivo.getArmadura().getBlindaje();
                                            if (daño_final < 0) {
                                                daño_final = 0;
                                            }
                                            objetivo.setVida(objetivo.getVida() - daño_final);
                                        }
                                    } else {
                                        System.out.println("No golpea al objetivo el ataque ");
                                    }
                                }
                            }

                        }
                    }
                } else {
                    for (int i = 0; i < armaAUsar.getCantidadObjetivos(); i++) {
                        int objetivo_aleatorio = ran.nextInt(0, aliados.size());
                        System.out.print("Objetivo " + i + 1 + ": " + aliados.get(objetivo_aleatorio).getNombre());
                        if (aliados.get(objetivo_aleatorio).getDefendido()) {
                            System.out.println("El objetivo esta defendido, no puede recibir daño");
                            continue;
                        }
                        for (int j = 0; j < armaAUsar.getNumAtaques(); j++) {
                            System.out.println("Ataque numero " + j);
                            Entidad objetivo = aliados.get(objetivo_aleatorio);
                            if (!armaAUsar.getEsMelee()) {
                                if (ran.nextInt(0, 100) < armaAUsar.getPrecision()) {
                                    if (ran.nextInt(1, 7) == 1) {
                                        System.out.println("CRITICO");
                                        int daño = armaAUsar.getDaño();
                                        int daño_final = daño * 2 - objetivo.getArmadura().getBlindaje();
                                        if (daño_final < 0) {
                                            daño_final = 0;
                                        }
                                        objetivo.setVida(objetivo.getVida() - daño_final);
                                    } else {
                                        System.out.println("Golpe normal");
                                        int daño = armaAUsar.getDaño();
                                        int daño_final = daño - objetivo.getArmadura().getBlindaje();
                                        if (daño_final < 0) {
                                            daño_final = 0;
                                        }
                                        objetivo.setVida(objetivo.getVida() - daño_final);
                                    }
                                } else {
                                    System.out.println("No golpea al objetivo el ataque ");
                                }
                            } else {
                                if (!objetivo.getArma().getEsMelee()) {
                                    System.out.println("EL objetivo esta a distancia, so le puede atacar");
                                } else {
                                    if (ran.nextInt(0, 100) < armaAUsar.getPrecision()) {
                                        if (ran.nextInt(1, 7) == 1) {
                                            System.out.println("CRITICO");
                                            int daño = armaAUsar.getDaño();
                                            int daño_final = daño * 2 - objetivo.getArmadura().getBlindaje();
                                            if (daño_final < 0) {
                                                daño_final = 0;
                                            }
                                            objetivo.setVida(objetivo.getVida() - daño_final);
                                        } else {
                                            System.out.println("Golpe normal");
                                            int daño = armaAUsar.getDaño();
                                            int daño_final = daño - objetivo.getArmadura().getBlindaje();
                                            if (daño_final < 0) {
                                                daño_final = 0;
                                            }
                                            objetivo.setVida(objetivo.getVida() - daño_final);
                                        }
                                    } else {
                                        System.out.println("No golpea al objetivo el ataque ");
                                    }
                                }
                            }

                        }
                    }
                }
            } else if (accion == 1) {
                System.out.println(this.getNombre() + " decide  colocarse en posicion defensiva");
                this.setDefendido(true);
            } else if (accion == 2) {
                int habilidad_aleatoria = ran.nextInt(0, this.getHabilidades().size());
                System.out.println(this.getNombre() + " decide usar una habilidad "
                        + this.getHabilidades().get(habilidad_aleatoria).getNombre());
                if (aliados.contains(personaje)) {
                    if (this.getHabilidades().get(habilidad_aleatoria).getTipo() == "ofensiva") {
                        this.getHabilidades().get(habilidad_aleatoria).EjecutarHabilidad(enemigos);
                    } else {
                        this.getHabilidades().get(habilidad_aleatoria).EjecutarHabilidad(aliados);
                    }
                } else {
                    if (this.getHabilidades().get(habilidad_aleatoria).getTipo() == "ofensiva") {
                        this.getHabilidades().get(habilidad_aleatoria).EjecutarHabilidad(aliados);
                    } else {
                        this.getHabilidades().get(habilidad_aleatoria).EjecutarHabilidad(enemigos);
                    }
                }
            } else {
                System.out.println(this.getNombre() + " decide pasar turno sin realizar ninguna accion");
            }

        }

    }
}