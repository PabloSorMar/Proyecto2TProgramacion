package proyecto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmaTest {

    @Test
    public void testArmaConstructorYGetters() {
        Arma arma = new Arma("Espada Sierra", 50, 85, true, 0, 1, 3);

        assertEquals("Espada Sierra", arma.getNombre());
        assertEquals(50, arma.getDaño());
        assertEquals(85, arma.getPrecision());
        assertTrue(arma.getEsMelee());
        assertEquals(0, arma.getMunicionMax());
        assertEquals(0, arma.getMunicionAct());
        assertEquals(1, arma.getCantidadObjetivos());
        assertEquals(3, arma.getNumAtaques());
    }

    @Test
    public void testSetters() {
        Arma arma = new Arma("Pistola Bolter", 30, 70, false, 10, 1, 2);

        arma.setNombre("Pistola Bolter Pesada");
        arma.setDaño(45);
        arma.setPrecision(60);
        arma.setEsMelee(false);
        arma.setMunicionMax(15);
        arma.setMunicionAct(5);
        arma.setCantidadObjetivos(2);
        arma.setNumAtaques(1);

        assertEquals("Pistola Bolter Pesada", arma.getNombre());
        assertEquals(45, arma.getDaño());
        assertEquals(60, arma.getPrecision());
        assertFalse(arma.getEsMelee());
        assertEquals(15, arma.getMunicionMax());
        assertEquals(5, arma.getMunicionAct());
        assertEquals(2, arma.getCantidadObjetivos());
        assertEquals(1, arma.getNumAtaques());
    }
}
