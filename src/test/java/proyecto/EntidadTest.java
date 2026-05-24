package proyecto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EntidadTest {

    private Entidad entidad;
    private Arma arma;
    private Armaduras armadura;
    private List<Habilidades> habilidades;

    @BeforeEach
    public void setUp() {
        arma = new Arma("Rifle", 20, 80, false, 30, 1, 2);
        armadura = new Armaduras("Armadura Ligera", 10, 50);
        habilidades = new ArrayList<>();
        habilidades.add(new Habilidades("Dummy", 0, "Nada", "buff", 100));
        entidad = new Entidad("Soldado", "Astra Militarum", 100, arma, armadura, habilidades);
    }

    @Test
    public void testEntidadConstructorYGetters() {
        assertEquals("Soldado", entidad.getNombre());
        assertEquals("Astra Militarum", entidad.getFaccion());
        assertEquals(100, entidad.getVida());
        assertEquals(0, entidad.getTurnoStun());
        assertEquals(0, entidad.getTurnoHemorragia());
        assertEquals(0, entidad.getTurnoVeneno());
        assertEquals(0, entidad.getTurnoCuracion());
        assertFalse(entidad.getDefendido());
        assertEquals(arma, entidad.getArma());
        assertEquals(armadura, entidad.getArmadura());
        assertEquals(habilidades, entidad.getHabilidades());
    }

    @Test
    public void testSettersYEstados() {
        entidad.setVida(80);
        entidad.setTurnoStun(2);
        entidad.setTurnoVeneno(3);
        entidad.setDefendido(true);

        assertEquals(80, entidad.getVida());
        assertEquals(2, entidad.getTurnoStun());
        assertEquals(3, entidad.getTurnoVeneno());
        assertTrue(entidad.getDefendido());
    }

    @Test
    public void testColorFaccion() {
        assertEquals("\u001B[32m", entidad.getColorFaccion()); // Astra Militarum -> Verde

        entidad.setFaccion("Caos");
        assertEquals("\u001B[31m", entidad.getColorFaccion()); // Caos -> Rojo
    }

    @Test
    public void testEfectoStun() {
        entidad.setTurnoStun(2);
        int vidaInicial = entidad.getVida();
        
        List<Entidad> aliados = new ArrayList<>();
        aliados.add(entidad);
        List<Entidad> enemigos = new ArrayList<>();
        
        entidad.RealizarTurno(aliados, enemigos, entidad);
        
        // Al estar aturdido, el turno de stun debe bajar en 1
        assertEquals(1, entidad.getTurnoStun());
        // Y su vida debe mantenerse intacta (no ataca, no se aplica veneno/hemorragia ese turno)
        assertEquals(vidaInicial, entidad.getVida());
    }

    @Test
    public void testEfectoHemorragia() {
        entidad.setTurnoHemorragia(2);
        int vidaInicial = entidad.getVida();
        
        List<Entidad> aliados = new ArrayList<>();
        aliados.add(entidad);
        List<Entidad> enemigos = new ArrayList<>();
        
        entidad.RealizarTurno(aliados, enemigos, entidad);
        
        // La hemorragia resta 10 de vida y su contador baja en 1
        assertEquals(1, entidad.getTurnoHemorragia());
        assertEquals(vidaInicial - 10, entidad.getVida());
    }

    @Test
    public void testEfectoVeneno() {
        entidad.setTurnoVeneno(1);
        int vidaInicial = entidad.getVida();
        
        List<Entidad> aliados = new ArrayList<>();
        aliados.add(entidad);
        List<Entidad> enemigos = new ArrayList<>();
        
        entidad.RealizarTurno(aliados, enemigos, entidad);
        
        // El veneno resta 10 de vida y su contador baja en 1
        assertEquals(0, entidad.getTurnoVeneno());
        assertEquals(vidaInicial - 10, entidad.getVida());
    }

    @Test
    public void testDesactivarDefensaAlInicioDelTurno() {
        entidad.setDefendido(true);
        
        List<Entidad> aliados = new ArrayList<>();
        aliados.add(entidad);
        List<Entidad> enemigos = new ArrayList<>();
        
        entidad.RealizarTurno(aliados, enemigos, entidad);
        
        // La defensa se desactiva siempre al principio del turno
        assertFalse(entidad.getDefendido());
    }

    @Test
    public void testSinObjetivosNoFalla() {
        List<Entidad> aliados = new ArrayList<>();
        aliados.add(entidad);
        List<Entidad> enemigos = new ArrayList<>();
        
        // Bucle para forzar varias acciones aleatorias y asegurar que no lance excepción
        // si intenta atacar a una lista vacía.
        for (int i = 0; i < 10; i++) {
            assertDoesNotThrow(() -> {
                entidad.RealizarTurno(aliados, enemigos, entidad);
            });
        }
    }

    @Test
    public void testColoresDeOtrasFacciones() {
        entidad.setFaccion("Orkos");
        assertEquals("\u001B[93m", entidad.getColorFaccion());
        
        entidad.setFaccion("Aeldari");
        assertEquals("\u001B[94m", entidad.getColorFaccion());
        
        entidad.setFaccion("Facción Inventada");
        assertEquals("\u001B[37m", entidad.getColorFaccion()); // Blanco por defecto
    }

    @Test
    public void testUsoDeMunicionYRecarga() {
        // Le vaciamos el cargador al arma
        arma.setMunicionAct(0);
        
        List<Entidad> aliados = new ArrayList<>();
        aliados.add(entidad);
        
        // Le ponemos un enemigo de prueba para que tenga un objetivo válido
        Entidad enemigo = new Entidad("Enemigo de prueba", "Caos", 100, arma, armadura, habilidades);
        List<Entidad> enemigos = new ArrayList<>();
        enemigos.add(enemigo);
        
        // La IA funciona con aleatoriedad (Random), así que le damos varios turnos
        // Tarde o temprano decidirá "Atacar" (acción 0) o "Recargar" (acción 3).
        // Si intenta atacar sin munición, recargará automáticamente y pasará turno.
        boolean haRecargado = false;
        for (int i = 0; i < 20; i++) {
            entidad.RealizarTurno(aliados, enemigos, entidad);
            if (arma.getMunicionAct() > 0) {
                haRecargado = true;
                break; // Ya recargó, el test es exitoso
            }
        }
        
        // Comprobamos que efectivamente recuperó las balas en algún momento
        assertTrue(haRecargado, "El personaje debería haber recargado su arma al quedarse sin balas durante 20 turnos.");
        // Como recarga al máximo, comprobamos que sus balas actuales coinciden con las máximas (o son máximas -1 si justo atacó en el mismo turno)
        // En nuestro código, cuando intenta atacar sin balas, recarga al MAX y pierde el turno, por lo que será igual al MAX.
        assertEquals(arma.getMunicionMax(), arma.getMunicionAct());
    }
}
