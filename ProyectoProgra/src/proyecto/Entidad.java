package proyecto;

public  class Entidad{
    private String nombre;
    private int vida;
    private boolean distancia;
    private int turnoStun;
    private int turnoHemorragia;
    private int turnoVeneno;
    private boolean defendido;
    private Arma arma;
    private Armaduras armadura;
    private List<Habilidades> habilidades;

    Entidad(String nombre, int vida, boolean distancia, int turnoStun, int turnoHemorragia, int turnoVeneno, boolean defendido, Arma arma, Armaduras armadura, List<Habilidades> habilidades){
        this.nombre = nombre;
        this.vida = vida;
        this.distancia = distancia;
        this.turnoStun = turnoStun;
        this.turnoHemorragia = turnoHemorragia;
        this.turnoVeneno = turnoVeneno;
        this.defendido = defendido;
        this.arma = arma;
        this.armadura = armadura;
        this.habilidades = habilidades;
    }
    
    //SETTERS Y GETTERS
    public String getNombre(){return this.nombre;}
    public int getVida(){return this.vida;}
    public boolean getDistancia(){return this.distancia;}
    public int getTurnoStun(){return his.turnoStun;}
    public int getTurnoHemorragia(){return this.turnoHemorragia;}
    public int getTurnoVeneno(){return this.turnoVeneno;}
    public boolean getDefendido(){return this.defendido;}
    public Arma getArma(){return this.arma;}
    public Armaduras getArmadura(){return this.armadura;}
    public List<Habilidades> getHabilidades(){return this.habilidades;}

    public void setNombre(String nombre){this.nombre = nombre;}
    public void setVida(int vida){this.vida = vida;}
    public void setDistancia(boolean distancia){this.distancia = distancia;}
    public void setTurnoStun(int turnoStun){this.turnoStun = turnoStun;}
    public void setTurnoHemorragia(int turnoHemorragia){this.turnoHemorragia = turnoHemorragia;}
    public void setTurnoVeneno(int turnoVeneno){this.turnoVeneno = turnoVeneno;}
    public void setDefendido(boolean defendido){this.defendido = defendido;}
    public void setArma(Arma arma){this.arma = arma;}
    public void setArmadura(Armaduras armadura){this.armadura = armadura;}
    public void setHabilidades(List<Habilidades> habilidades){this.habilidades = habilidades;}

    public void RealizarTurno(List<Habilidades> aliados, List<Habilidades> enemigos, Entidad personaje)
    {
        system.out.prinln("Turno de " + this.getNombre());
        
        //Primero efectos acvito de daño en si mismo
        if(this.getTurnoStun() > 0)
        {
            system.out.prinln(this.getNombre() +" esta arturdido")
            setTurnoStun(getTurnoStun()-1);
        }
        else
        {
            if(this.getTurnoHemorragia() > 0)
            {
                setVida(getVida()-10);
                setTurnoHemorragia(getTurnoHemorragia()-1);
            }
            if(this.getTurnoVeneno() > 0)
            {
                setVida(getVida()-10);
                setTurnoVeneno(getTurnoVeneno()-1);
            }
            //Aleatorio para ver que hace
            Random ran = new Random();
             int accion =  ran.nextInt(0,4);
            if(accion == 0)
            {
                system.out.prinln(this.getNombre() + " decide atacar con su arma")
                if(aliados.contains(personaje))
                {
                    for(int i = 0; i < this.getArma().getCantidadObj())
                    {
                        Random ran = new Random;
                        int objetivo_aleatorio = ran.nextInt(0,enemigos.size())
                        for(int i = 0; i < this.getArma().getNumAtaques())
                        {
                            enemigos.at(objetivo_aleatorio).setVida(enemigos.at(objetivo_aleatorio).getVida() - this.getArma().getDaño())
                        }
                    }
                }
                else
                {
                 for(int i = 0; i < this.getArma().getCantidadObj())
                    {
                        Random ran = new Random;
                        int objetivo_aleatorio = ran.nextInt(0,aliados.size())
                        for(int i = 0; i < this.getArma().getNumAtaques())
                        {
                            aliados.at(objetivo_aleatorio).setVida(aliados.at(objetivo_aleatorio).getVida() - this.getArma().getDaño())
                        }
                    }   
                }
            }
            else if(accion == 1)
            {
                this.setDefendido(true);
            }
            else if (accion == 2)
            {
                Random ran = new Random;
                int habilidad_aleatoria = ran.nextInt(0,this.getHabilidades().size())
                if(aliados.contains(personaje))
                {
                    if(this.getHabilidades().at(habilidad_aleatoria).getTipo() == "ofensiva")
                    {
                       this.getHabilidades().at(habilidad_aleatoria).EjecutarHabilidad(enemigos); 
                    }
                    else
                    {
                        this.getHabilidades().at(habilidad_aleatoria).EjecutarHabilidad(aliados); 
                    }
                }
                else
                {
                    if(this.getHabilidades().at(habilidad_aleatoria).getTipo() == "ofensiva")
                    {
                       this.getHabilidades().at(habilidad_aleatoria).EjecutarHabilidad(aliados); 
                    }
                    else
                    {
                        this.getHabilidades().at(habilidad_aleatoria).EjecutarHabilidad(enemigos); 
                    }
                }
            }
            else
            {
                system.out.prinln(this.getNombre() + " decide pasar turno sin realizar ninguna accion");
            }

        }
    }

}