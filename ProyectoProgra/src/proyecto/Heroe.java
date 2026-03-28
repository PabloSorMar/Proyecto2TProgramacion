package proyecto;
import java.util.List;

public class Heroe extends Entidad{
    private Arma arma2;


Heroe(String nombre, int vida, boolean distancia, int turnoStun, int turnoHemorragia, int turnoVeneno, boolean defendido, Arma arma, Armaduras armadura, List<Habilidades> habilidades, Arma arma2 )
{
super( nombre,  vida,  distancia,  turnoStun, turnoHemorragia,  turnoVeneno,  defendido,  arma,  armadura, habilidades);
this.arma2 = arma2;  
}

    public Arma getArma2() { return this.arma2; }
    public void setArma2(Arma arma2) { this.arma2 = arma2; }
}