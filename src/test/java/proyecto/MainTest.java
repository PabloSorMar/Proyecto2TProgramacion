package proyecto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private Entidad eLenta;
    private Entidad eMedia;
    private Entidad eRapida;

    @BeforeEach
    public void setUp() {
        Arma armaFalsa = new Arma("Falsa", 10, 100, true, 0, 1, 1);
        List<Habilidades> habs = new ArrayList<>();

        Armaduras armaduraLenta = new Armaduras("Lenta", 10, -20);
        Armaduras armaduraMedia = new Armaduras("Media", 10, 0);
        Armaduras armaduraRapida = new Armaduras("Rapida", 10, 20);

        eLenta = new Entidad("Lento", "Faccion", 100, armaFalsa, armaduraLenta, habs);
        eMedia = new Entidad("Medio", "Faccion", 100, armaFalsa, armaduraMedia, habs);
        eRapida = new Entidad("Rapido", "Faccion", 100, armaFalsa, armaduraRapida, habs);
    }

    @Test
    public void testAgregarOrdenadoPorVelocidad() {
        List<Entidad> personajesTurno = new ArrayList<>();
        List<Entidad> grupoAAnadir = new ArrayList<>();

        // Añadimos en orden desordenado
        grupoAAnadir.add(eMedia);
        grupoAAnadir.add(eLenta);
        grupoAAnadir.add(eRapida);

        Main.agregarOrdenadoPorVelocidad(personajesTurno, grupoAAnadir);

        // Comprobamos que el tamaño es correcto
        assertEquals(3, personajesTurno.size());

        // El de mayor velocidad debe ir primero, luego el medio, luego el lento
        assertEquals("Rapido", personajesTurno.get(0).getNombre());
        assertEquals("Medio", personajesTurno.get(1).getNombre());
        assertEquals("Lento", personajesTurno.get(2).getNombre());
    }

    @Test
    public void testEliminarMuertos() {
        List<Entidad> grupo = new ArrayList<>();

        // Le quitamos la vida a uno de ellos
        eMedia.setVida(0);

        grupo.add(eLenta);
        grupo.add(eMedia);
        grupo.add(eRapida);

        // Comprobamos tamaño inicial
        assertEquals(3, grupo.size());

        // Ejecutamos la función (false para no ensuciar la consola de los tests)
        Main.eliminarMuertos(grupo, false);

        // Comprobamos tamaño tras eliminar
        assertEquals(2, grupo.size());

        // Comprobamos que el que falta es el Medio
        assertEquals("Lento", grupo.get(0).getNombre());
        assertEquals("Rapido", grupo.get(1).getNombre());
    }
    @Test
    public void testEliminarMuertos_TodosMuertos() {
        List<Entidad> grupo = new ArrayList<>();
        eLenta.setVida(0);
        eMedia.setVida(0);
        eRapida.setVida(0);

        grupo.add(eLenta);
        grupo.add(eMedia);
        grupo.add(eRapida);

        Main.eliminarMuertos(grupo, false);

        assertEquals(0, grupo.size());
    }

    @Test
    public void testEliminarMuertos_NingunMuerto() {
        List<Entidad> grupo = new ArrayList<>();
        grupo.add(eLenta);
        grupo.add(eMedia);
        grupo.add(eRapida);

        Main.eliminarMuertos(grupo, false);

        assertEquals(3, grupo.size());
    }

    @Test
    public void testAgregarOrdenadoPorVelocidad_YaConElementos() {
        List<Entidad> personajesTurno = new ArrayList<>();
        // Supongamos que ya hay alguien muy rápido en la lista
        Armaduras armaduraSuperRapida = new Armaduras("SuperRapida", 10, 50);
        Entidad eSuperRapida = new Entidad("SuperRapido", "Faccion", 100, eLenta.getArma(), armaduraSuperRapida, eLenta.getHabilidades());
        personajesTurno.add(eSuperRapida);

        List<Entidad> grupoAAnadir = new ArrayList<>();
        grupoAAnadir.add(eMedia);
        grupoAAnadir.add(eLenta);

        Main.agregarOrdenadoPorVelocidad(personajesTurno, grupoAAnadir);

        assertEquals(3, personajesTurno.size());
        assertEquals("SuperRapido", personajesTurno.get(0).getNombre());
        assertEquals("Medio", personajesTurno.get(1).getNombre());
        assertEquals("Lento", personajesTurno.get(2).getNombre());
    }

    @Test
    public void testAgregarOrdenadoPorVelocidad_MismaVelocidad() {
        List<Entidad> personajesTurno = new ArrayList<>();
        
        // Creamos una entidad con la misma velocidad que eMedia (0)
        Armaduras armaduraMedia2 = new Armaduras("Media2", 10, 0);
        Entidad eMedia2 = new Entidad("Medio2", "Faccion", 100, eLenta.getArma(), armaduraMedia2, eLenta.getHabilidades());

        List<Entidad> grupoAAnadir = new ArrayList<>();
        grupoAAnadir.add(eMedia);
        grupoAAnadir.add(eMedia2);

        Main.agregarOrdenadoPorVelocidad(personajesTurno, grupoAAnadir);

        assertEquals(2, personajesTurno.size());
        // Ambos deben estar en la lista y su velocidad será la misma
        assertTrue(personajesTurno.contains(eMedia));
        assertTrue(personajesTurno.contains(eMedia2));
    }
}
