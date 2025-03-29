package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncidenciaTest {

    private Allotjament allotjamentTest;
    private Incidencia incidenciaTest;

    @BeforeEach
    void setUp() {
        allotjamentTest = new Allotjament("A01", "AllotjamentTest", true, "100%", 5, 2) {};
        incidenciaTest = new Incidencia("dataTest", 1, allotjamentTest, Incidencia.TipusIncidencia.Reparacio) {};
    }

    @Test
    void getData() {
        assertEquals("dataTest", incidenciaTest.getData());
    }

    @Test
    void getNum() {
        assertEquals(1, incidenciaTest.getNum());
    }

    @Test
    void getAllotjament() {
        assertEquals(allotjamentTest, incidenciaTest.getAllotjament());
    }

    // REVISAR
    @Test
    void getTipusIncidencia() {
        assertEquals(Incidencia.TipusIncidencia.Reparacio, incidenciaTest.getTipusIncidencia());
    }

    // REVISAR
    @Test
    void getIluminacioAllotjament() {
        assertEquals("100%", incidenciaTest.getIluminacioAllotjament());
    }
}