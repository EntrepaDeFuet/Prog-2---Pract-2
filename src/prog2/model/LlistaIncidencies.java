package prog2.model;

import prog2.vista.ExcepcioCamping;
import prog2.vista.ExempleMenu;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaIncidencies implements InLlistaIncidencies {
    private ArrayList<Incidencia> llistaIncidencies = new ArrayList<Incidencia>();

    // Constructor
    public LlistaIncidencies(Incidencia incidencia_) {
    }

    // Altres mètodes
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {
        Incidencia incidenciaActual;
        Incidencia novaIncidencia;
        Iterator<Incidencia> it = llistaIncidencies.iterator();
        while (it.hasNext()) {
            incidenciaActual = it.next();
            if(incidenciaActual.getNum()!=num){
                novaIncidencia.setNum(num);
                String tipus = novaIncidencia.getTipusInicdencia().name();
                novaIncidencia.setTipusIncidencia(tipus);
                novaIncidencia.setAllotjament(allotjament);
                novaIncidencia.setData(data);
            } else {
                throw new ExcepcioCamping("Ja hi ha una seqüència amb aquesta id");
            }
        }
    }

    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping {
        Incidencia incidenciaActual;
        Iterator<Incidencia> it = llistaIncidencies.iterator();

        while (it.hasNext()) {
            incidenciaActual = it.next();
            if(incidenciaActual.getNum()==in.getNum()){
                it.remove();
            } else {
                throw new ExcepcioCamping("No s'ha trobat cap allotjament igual.");
            }
        }
    }

    public String llistaIncidencies() throws ExcepcioCamping {
        if (llistaIncidencies.size() != 0) {
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
                String tipus = incidenciaActual.getTipusInicdencia().name();
                sb.append(tipus);
                sb.append(incidenciaActual.getIluminacioAllotjament());
                sb.append("\n");
                comptador++;
            }

            return sb.toString();
        } else {
            throw new ExcepcioCamping("Llista buida");
        }
    }

    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        Incidencia incidenciaActual;
        Iterator<Incidencia> it = llistaIncidencies.iterator();

        while (it.hasNext()) {
            incidenciaActual = it.next();

            if (num == incidenciaActual.getNum()) {
                return incidenciaActual;
            } else {
                throw new ExcepcioCamping("No hi ha cap incidencia amb aquesta id");
            }
        }
    }
}