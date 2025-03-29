package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

class LlistaIncidenciesTest {

    private Allotjament allotjamentTest;
    private LlistaIncidencies llistaIncidenciesTest;
    private Incidencia incidenciaTest;

    @BeforeEach
    void setUp() {
        allotjamentTest = new Allotjament("A01", "AllotjamentTest", true, "100%", 5, 2) {};
        llistaIncidenciesTest = new LlistaIncidencies() {};
        incidenciaTest = new Incidencia("dataTest", 1, allotjamentTest, Incidencia.TipusIncidencia.Reparacio) {};
    }

    @Test
    void afegirIncidencia() throws ExcepcioCamping {
        llistaIncidenciesTest.afegirIncidencia(1, "Reparacio", allotjamentTest, "dataTest");

        assertEquals(1, llistaIncidenciesTest.midaLlista());
    }

    @Test
    void eliminarIncidencia() throws ExcepcioCamping {
        llistaIncidenciesTest.afegirIncidencia(1, "Reparacio", allotjamentTest, "dataTest");

        assertEquals(0, llistaIncidenciesTest.midaLlista());
    }

    @Test
    void llistarIncidencies() throws ExcepcioCamping {
        llistaIncidenciesTest.afegirIncidencia(1, "Reparacio", allotjamentTest, "dataTest");
        String llistaTest = llistaIncidenciesTest.llistarIncidencies();

        assertTrue(llistaTest.contains("Reparacio"));
    }

    @Test
    void getIncidencia() throws ExcepcioCamping {
        llistaIncidenciesTest.afegirIncidencia(1, "Reparacio", allotjamentTest, "dataTest");

        assertEquals(incidenciaTest.getNum(), llistaIncidenciesTest.getIncidencia(1).getNum());
    }
}