package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class LlistaAccessosTest {
    private Allotjament allotjamentActual = new Bungalow("Prova","prova",true,"100%",22f,2,4,4,true,true,true);
    private LlistaAccessos llistaAccessosTest;
    private Acces accesTest;
    private AccesAsfalt accesAsfaltTest;

    @BeforeEach
    void setUp() {
        llistaAccessosTest = new LlistaAccessos();
        accesTest = new Acces("AccesTest", true, true) {};
        accesAsfaltTest = new AccesAsfalt("testAsfalt", true, true, 10){};
        accesTest.afegirAllotjament(allotjamentActual);

    }

    @Test
    void afegirAcces() throws ExcepcioCamping {
        llistaAccessosTest.afegirAcces(accesTest);
        assertEquals(1, llistaAccessosTest.midaLlista());
    }

    @Test
    void buidar() {
        llistaAccessosTest.buidar();
        assertEquals(0, llistaAccessosTest.midaLlista());
    }

    @Test
    void llistarAccessos() throws ExcepcioCamping {
        llistaAccessosTest.afegirAcces(accesTest);

        String llistaTest = llistaAccessosTest.llistarAccessos(true);
        assertTrue(llistaTest.contains(accesTest.toString()));
    }

    @Test
    void actualitzaEstatAccessos() throws ExcepcioCamping {
        llistaAccessosTest.afegirAcces(accesTest);

        llistaAccessosTest.actualitzaEstatAccessos();
        assertTrue(accesTest.isEstat());
    }

    @Test
    void calculaAccessosAccessibles() throws ExcepcioCamping {
        llistaAccessosTest.afegirAcces(accesTest);

        int comptadorTest = llistaAccessosTest.calculaAccessosAccessibles();
        assertTrue(comptadorTest == 1);
    }

    @Test
    void calculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        llistaAccessosTest.afegirAcces(accesAsfaltTest);

        float areaTest = llistaAccessosTest.calculaMetresQuadratsAsfalt();
        assertEquals(10.0, areaTest);
    }
}