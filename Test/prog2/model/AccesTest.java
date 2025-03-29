package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccesTest {

    private Acces accesTest;
    private Allotjament allotjamentTest;


    @BeforeEach
    void setUp() {
        accesTest = new Acces("AccesTest", true, true) {};
        allotjamentTest = new Allotjament("A01", "AllotjamentTest", true, "100%", 5, 2) {};
    }

    @Test
    void afegirAllotjament() {
        accesTest.afegirAllotjament(allotjamentTest);

        assertEquals(allotjamentTest, accesTest.getDestins().get(0));
    }

    @Test
    void obrirAcces() {
        accesTest.obrirAcces();

        assertTrue(allotjamentTest.getEstat().equals("Operatiu"));
    }

    @Test
    void tancarAcces() {
        accesTest.tancarAcces();

        assertFalse(allotjamentTest.getEstat().equals("No Operatiu"));
    }

    @Test
    void isAccessibilitat() {
        assertTrue(accesTest.isAccessibilitat());
    }
}