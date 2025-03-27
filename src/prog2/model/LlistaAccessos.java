package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAccessos implements InLlistaAccessos{
    // Atributs
    private ArrayList<Acces> llista;

    // Constructor
    public LlistaAccessos() { this.llista = new ArrayList<Acces>() }

    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        if (!this.llista.contains(acc)) {
            llista.add(acc)
        } else {
            throw new ExcepcioCamping("Aquest accés ja existeix");
        }
    }

    public void buidar() throws ExcepcioCamping{
        llista.clear();
    }

    public String llistarAccessos(boolean estat) throws ExcepcioCamping{
        Acces accesActual = null;
        Iterator<Acces> it = llista.iterator();
        StringBuffer sb = new StringBuffer();

        while (it.hasNext()) {
            accesActual = it.next();

            if (accesActual.isEstat().equals(estat)) {
                sb.append(accesActual.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}