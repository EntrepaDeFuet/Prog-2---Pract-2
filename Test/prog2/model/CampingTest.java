package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

class CampingTest {
    Allotjament allotjamentTest;
    Incidencia incidenciaTest;
    Camping campingTest;
    Acces accesTest;

    @BeforeEach
    void setUp() {
        allotjamentTest = new Allotjament("A01", "AllotjamentTest", true, "100%", 5, 2) {};
        campingTest = new Camping("campingTest");
        accesTest = new Acces("Acc0",true,true) {};
        accesTest.afegirAllotjament(allotjamentTest);
        try {
            campingTest.getLlistaAllotjaments().afegirAllotjament(allotjamentTest);
            campingTest.getLlistaAccessos().afegirAcces(accesTest);
        } catch (ExcepcioCamping e){
            System.err.println("Error Controlat.");
        }
        incidenciaTest = new Incidencia("dataTest", 1, allotjamentTest, Incidencia.TipusIncidencia.Reparacio) {};
    }

    @Test
    void getNomCamping() {
        assertEquals("campingTest", campingTest.getNomCamping());
    }

    // REVISAR
    @Test
    void afegirIncidencia() throws ExcepcioCamping {
        campingTest.afegirIncidencia(1, "Reparacio", "A01", "dataTest");
        incidenciaTest = campingTest.buscaIncidencia(1);

        assertNotNull(incidenciaTest);
        assertEquals(1, incidenciaTest.getNum());
    }

    @Test
    void eliminarIncidencia() {
    }

    // REVISAR
    @Test
    void calculaAccessosAccessibles() {
        int accessosTest = campingTest.calculaAccessosAccessibles();
        assertTrue(accessosTest >= 0);
    }

    // REVISAR
    @Test
    void calculaMetresQuadratsAsfalt() {
        float metresTest = campingTest.calculaMetresQuadratsAsfalt();
        assertTrue(metresTest >= 0);
    }

    // REVISAR
    @Test
    void llistarAllotjaments() throws ExcepcioCamping {
        campingTest.inicialitzaDadesCamping();
        String lstAllTest = campingTest.llistarAllotjaments("Operatiu");
        assertNotNull(lstAllTest);
    }

    // REVISAR
    @Test
    void llistarIncidencies() throws ExcepcioCamping {
        campingTest.afegirIncidencia(1, "Reparacio", "A01", "dataTest");
        String lstIncTest = campingTest.llistarIncidencies();
        assertTrue(lstIncTest.contains("Reparacio"));
    }

    @Test
    void llistarAccessos() throws ExcepcioCamping {
        campingTest.inicialitzaDadesCamping();
        String obertTest = campingTest.llistarAccessos("Obert");
        assertTrue(obertTest.contains("A1"));
    }

    @Test
    void inicialitzaDadesCamping() {
        campingTest.inicialitzaDadesCamping();
        assertNotNull(campingTest.getLlistaAccessos());
        assertNotNull(campingTest.getLlistaAllotjaments());
    }
}