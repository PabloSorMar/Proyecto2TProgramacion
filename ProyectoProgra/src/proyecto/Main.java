package proyecto;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        List<Entidad> enemigos = new ArrayList<>();
        List<Entidad> aliados = new ArrayList<>();
        List<Entidad> personajes = new ArrayList<>();
        Armaduras armadura1 = new Armaduras("Ligera", 20, 20);
        Arma arma1 = new Arma("Espada Sierra", 20, 100, false, 2, 1, null, 1);

        Habilidades hab1 = new Habilidades("hab1",2," ",true,"ofensiva");     
        List<Habilidades> habilidades = new ArrayList<>();
        habilidades.add(hab1);

        Entidad aliado1 = new Entidad("aliado 1","fac1" ,100,arma1,armadura1,habilidades);
        Entidad enemigo1 = new Entidad("enemigo 1","fac2",100,arma1,armadura1,habilidades);

        aliados.add(aliado1);
        enemigos.add(enemigo1);
        personajes.add(aliado1);personajes.add(enemigo1);

        for(Entidad perso:personajes)
        {
            perso.RealizarTurno(aliados, enemigos, perso);
        }


    } 
}
