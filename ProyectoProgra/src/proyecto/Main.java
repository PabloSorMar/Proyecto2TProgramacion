package proyecto;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    private boolean esAutomatico;
    private List<Entidad> ordenTurnos;

    public Main() {
        this.esAutomatico = false;
        this.ordenTurnos = new ArrayList<>();
    }

    public void rellenarEquipo() {
        // Inicializa Héroes y Enemigos
    }

    public void iniciarMision() {
        // Bucle principal de combate
    }

    public int tirarD20() {
        Random ran = new Random();
        return ran.nextInt(20) + 1; // 1-20
    }

    public boolean chequearCritico(int dado) {
        return dado == 20;
    }

    public boolean chequearDistancia() {
        return true; 
    }

    public boolean calcLocalizacion() {
        return true;
    }

    public void procesarEfectos(Entidad e) {
        if (e.getTurnosStun() > 0) {
            e.setTurnosStun(e.getTurnosStun() - 1);
        }
        if (e.getTurnosHemorragia() > 0) {
            e.setTurnosHemorragia(e.getTurnosHemorragia() - 1);
            e.recibirDaño(10, false); 
        }
        if (e.getTurnosVeneno() > 0) {
            e.setTurnosVeneno(e.getTurnosVeneno() - 1);
            e.recibirDaño(10, false);
        }
        
        if(e.getHabilidades() != null) {
            for(Habilidades h : e.getHabilidades()) {
                h.reducirCooldown();
            }
        }
    }

    public static void main(String[] args) {
        Main motor = new Main();
        motor.rellenarEquipo();
        motor.iniciarMision();
    } 
}
