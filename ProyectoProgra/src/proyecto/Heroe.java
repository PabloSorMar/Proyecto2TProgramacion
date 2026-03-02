package proyecto;

public class Heroe extends Entidad{
private Arma arma2;


Heroe(String nombre, int vida, boolean distancia, int turnoStun, int turnoHemorragia, int turnoVeneno, boolean defendido, Arma arma, Armaduras armadura, List<Habilidades> habilidades, Arma arma2 )
{
super(String nombre, int vida, boolean distancia, int turnoStun, int turnoHemorragia, int turnoVeneno, boolean defendido, Arma arma, Armaduras armadura, List<Habilidades> habilidades)
this.arma2 = arma2;  
}

public Arma getArma(){return this.arma2;}
public void setArma(Arma arma2){this.arma2 = arma2;}

}