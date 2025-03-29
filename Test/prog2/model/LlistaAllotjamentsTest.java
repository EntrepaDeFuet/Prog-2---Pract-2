package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

class LlistaAllotjamentsTest {

    private LlistaAllotjaments llistaAllotjamentsTest;
    private Allotjament allotjamentTest;

    @BeforeEach
    void setUp() {
        llistaAllotjamentsTest = new LlistaAllotjaments() {};
        allotjamentTest = new Allotjament("A01", "AllotjamentTest", true, "100%", 5, 2) {};
    }

    @Test
    void afegirAllotjament() throws ExcepcioCamping {
        llistaAllotjamentsTest.afegirAllotjament(allotjamentTest);

        assertEquals(1, llistaAllotjamentsTest.midaLlista());
    }

    @Test
    void contains() throws ExcepcioCamping {
        llistaAllotjamentsTest.afegirAllotjament(allotjamentTest);

        assertTrue(llistaAllotjamentsTest.contains(allotjamentTest));
    }

    @Test
    void buidar() throws ExcepcioCamping {
        llistaAllotjamentsTest.afegirAllotjament(allotjamentTest);
        llistaAllotjamentsTest.buidar();

        assertEquals(0, llistaAllotjamentsTest.midaLlista());
    }

    @Test
    void getAllotjament() throws ExcepcioCamping {
        llistaAllotjamentsTest.afegirAllotjament(allotjamentTest);

        assertEquals(allotjamentTest, llistaAllotjamentsTest.getAllotjament("A01"));
    }

    @Test
    void llistarAllotjaments() throws ExcepcioCamping {
        llistaAllotjamentsTest.afegirAllotjament(allotjamentTest);

        String llistaTest = llistaAllotjamentsTest.llistarAllotjaments("Operatiu");
        assertTrue(llistaTest.contains(allotjamentTest.toString()));
    }
}