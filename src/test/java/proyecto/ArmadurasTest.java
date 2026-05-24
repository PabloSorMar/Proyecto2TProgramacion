package proyecto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmadurasTest {

    @Test
    public void testArmadurasConstructorYGetters() {
        Armaduras armadura = new Armaduras("Armadura de Exterminador", 80, -20);

        assertEquals("Armadura de Exterminador", armadura.getnombre());
        assertEquals(80, armadura.getBlindaje());
        assertEquals(-20, armadura.getVelocidad());
    }

    @Test
    public void testSetters() {
        Armaduras armadura = new Armaduras("Caparazón", 40, -5);

        armadura.setNombre("Servoarmadura");
        armadura.setBlindaje(60);
        armadura.setVelocidad(-10);

        assertEquals("Servoarmadura", armadura.getnombre());
        assertEquals(60, armadura.getBlindaje());
        assertEquals(-10, armadura.getVelocidad());
    }

    @Test
    public void testArmaduraValoresNegativos() {
        // En algunos casos (como debufos), el blindaje podría llegar a ser negativo.
        // Verificamos que el objeto soporte almacenar estos valores sin lanzar errores.
        Armaduras armadura = new Armaduras("Armadura Rota", -10, 0);

        assertEquals("Armadura Rota", armadura.getnombre());
        assertEquals(-10, armadura.getBlindaje());
        assertEquals(0, armadura.getVelocidad());
    }

    @Test
    public void testArmaduraVelocidadPositiva() {
        // Algunas armaduras ligeras, servoarmaduras avanzadas o equipo especial
        // podrían aumentar la velocidad en vez de reducirla.
        Armaduras armadura = new Armaduras("Exoesqueleto Ágil", 25, 15);

        assertEquals("Exoesqueleto Ágil", armadura.getnombre());
        assertEquals(25, armadura.getBlindaje());
        assertEquals(15, armadura.getVelocidad());
    }

    @Test
    public void testArmaduraValoresExtremos() {
        // Probamos los límites de memoria de Java para asegurarnos de que no haya
        // desbordamiento
        // al asignar los valores máximos a la clase.
        Armaduras armadura = new Armaduras("Escudo del Emperador", Integer.MAX_VALUE, Integer.MIN_VALUE);

        assertEquals(Integer.MAX_VALUE, armadura.getBlindaje());
        assertEquals(Integer.MIN_VALUE, armadura.getVelocidad());
    }
}
