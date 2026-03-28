package proyecto;
import java.util.List;

public class Heroe extends Entidad{
    private Arma arma2;


Heroe(String nombre, String faccion, int vida,  Arma arma, Armaduras armadura, List<Habilidades> habilidades, Arma arma2 )
{
super( nombre,faccion,  vida,   arma,  armadura, habilidades);
this.arma2 = arma2;  
}

    public Arma getArma2() { return this.arma2; }
    public void setArma2(Arma arma2) { this.arma2 = arma2; }

    @Override
    public void RealizarTurno(List<Entidad> aliados, List<Entidad> enemigos, Entidad personaje) {
        // Por ahora, el Héroe realiza el turno exactamente igual que una Entidad (de forma aleatoria).
        // Al usar super.RealizarTurno() estamos llamando a la función padre que ya contiene toda la lógica.
        super.RealizarTurno(aliados, enemigos, personaje);
    }
}