package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllotjamentTest {
    private Allotjament allotjamentTest;
    private Incidencia incidenciaTest;

    @BeforeEach
    void setUp() {
        // No m'enrecordo de les estades minimes
        allotjamentTest = new Allotjament("A01", "AllotjamentTest", true, "100%", 5, 2) {};
        incidenciaTest = new Incidencia("2025-03-29", 1, allotjamentTest, Incidencia.TipusIncidencia.Reparacio);
    }

    @org.junit.jupiter.api.Test
    void getId() {
        assertEquals("A01", allotjamentTest.getId());
    }

    @org.junit.jupiter.api.Test
    void getEstat() {
        assertTrue(allotjamentTest.getEstat().equals("Operatiu"));
    }

    @Test
    void getNom() {
        assertEquals("AllotjamentTest", allotjamentTest.getNom());
    }

    @Test
    void testGetId() {
        assertEquals("A01", allotjamentTest.getId());
    }

    @Test
    void getEstadaMinima() {
        assertEquals(2, allotjamentTest.getEstadaMinima(InAllotjament.Temp.BAIXA));
    }

    @Test
    void obrirAllotjament() {
        allotjamentTest.obrirAllotjament();

        assertTrue(allotjamentTest.getEstat().equals("Operatiu"));
        assertEquals("100%", allotjamentTest.getIluminacio());
    }

    @Test
    void tancarAllotjament() {
        allotjamentTest.tancarAllotjament(incidenciaTest);

        assertTrue(allotjamentTest.getEstat().equals("No Operatiu"));
        assertEquals("100%", allotjamentTest.getIluminacio());
    }
}