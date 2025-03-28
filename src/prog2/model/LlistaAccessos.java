package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAccessos implements InLlistaAccessos{
    // Atributs
    private ArrayList<Acces> llista;

    // Constructor
    public LlistaAccessos() { this.llista = new ArrayList<Acces>(); }

    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        if (!this.llista.contains(acc)) {
            llista.add(acc);
        } else {
            throw new ExcepcioCamping("Aquest accés ja existeix");
        }
    }

    public void buidar(){
        llista.clear();
    }

    public String llistarAccessos(boolean estat) throws ExcepcioCamping{
        if (!llista.isEmpty()) {
            Acces accesActual = null;
            Iterator<Acces> it = llista.iterator();
            StringBuffer sb = new StringBuffer();

            while (it.hasNext()) {
                accesActual = it.next();

                if (accesActual.isEstat() == estat) {
                    sb.append(accesActual);
                    sb.append("\n");
                }
            }
            return sb.toString();
        } else {
            throw new ExcepcioCamping("Llista buida.");
        }
    }

    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        if (llista.isEmpty()) {
            Acces accesActual = null;
            Iterator<Acces> it = llista.iterator();

            while (it.hasNext()) {

                accesActual = it.next();

                if (accesActual.teAllotjamentsOberts()) {
                    accesActual.setEstat(true);
                } else {
                    accesActual.setEstat(false);
                }
            }
        } else {
            throw new ExcepcioCamping("Aquesta llista està buida");
        }
    }

    public int calculaAccessosAccessibles() throws ExcepcioCamping {
        if (!llista.isEmpty()) {
            int comptador = 0;
            Acces accesActual = null;
            Iterator<Acces> it = llista.iterator();
            StringBuffer sb = new StringBuffer();

            while (it.hasNext()) {
                accesActual = it.next();

                if (accesActual.isAccessibilitat()) {
                    comptador = comptador + 1;
                }
            }
            return comptador;

        } else {
            throw new ExcepcioCamping("Aquesta llista està buida");
        }
    }

    public float calculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        if (!llista.isEmpty()) {
            Acces accesActual;
            Iterator<Acces> it = llista.iterator();
            float metresQuadrats = 0;
            while (it.hasNext()) {
                accesActual = it.next();
                if (accesActual instanceof AccesAsfalt) {
                    AccesAsfalt asfaltActual = (AccesAsfalt) accesActual;
                    float area = asfaltActual.getAsfalt();
                    metresQuadrats = metresQuadrats + area;
                }
            }

            return metresQuadrats;
        } else {
            throw new ExcepcioCamping("Aquesta llista està buida");
        }
    }
}