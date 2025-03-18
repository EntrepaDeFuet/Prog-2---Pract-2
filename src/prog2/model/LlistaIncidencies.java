package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaIncidencies implements InLlistaIncidencies {
    private ArrayList<Incidencia> llistaIncidencies = new ArrayList<Incidencia>();

    // Constructor
    public LlistaIncidencies(Incidencia incidencia_) {

    }

    // Altres mètodes
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {

    }

    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping {

    }

    public String llistarIncidencies() throws ExcepcioCamping {
        Incidencia incidenciaActual;
        Iterator<Incidencia> it = llistaIncidencies.iterator();
        StringBuilder sb = new StringBuilder();
        int comptador = 1;

        while (it.hasNext()) {
            incidenciaActual = it.next();
            System.out.println("Incidència número: " + comptador);
            sb.append(incidenciaActual.getData());
            sb.append(incidenciaActual.getNum());
            sb.append(incidenciaActual.getAllotjament());
            sb.append(incidenciaActual.getTipusIncidencia());
            sb.append(incidenciaActual.getIluminacioAllotjament());
            sb.append("\n");
            comptador++;
        }

        return sb.toString();
    }

    public Incidencia getIncidencia(int num) throws ExcepcioCamping {

    }
}
