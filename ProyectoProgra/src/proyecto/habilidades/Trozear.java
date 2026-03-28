package proyecto.habilidades;

import java.util.List;
import java.util.Random;

import proyecto.Entidad;
import proyecto.Habilidades;

public class Trozear extends Habilidades 
{
    public Trozear(String nombre, int cooldownBase, String efecto, String tipo, int precision) {
        super(nombre, cooldownBase, efecto, tipo, precision);
    }


    @Override
    public void EjecutarHabilidad(List<Entidad> objetivos)
    {
        if (super.estaDisponible()) 
        {
            Random ran = new Random();
            
                if (ran.nextInt(0,100) < this.getPrecision()) 
                {
                    Entidad objetivo = objetivos.get(ran.nextInt(0,objetivos.size()));
                    System.out.println("La habildiad "+ this.getNombre() + " impacta en "+ objetivo.getNombre());
                    objetivo.setTurnoHemorragia(4);
                }
                else
                {
                    System.out.println("La habildiad "+ this.getNombre() + " falla ");
                }
                
            
            super.usarHabilidad(); 
        }
        else
        {
            System.out.println("La habildiad "+ this.getNombre() + " esta en cooldown");
            super.reducirCooldown();
        }
    }
}