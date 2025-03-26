package prog2.model;

import prog2.vista.ExcepcioCamping;
import prog2.vista.ExempleMenu;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaIncidencies implements InLlistaIncidencies {
    private ArrayList<Incidencia> llistaIncidencies;

    // Constructor
    public LlistaIncidencies() {
        this.llistaIncidencies = new ArrayList<Incidencia>();
    }
    public boolean incidenciaRepetidaAllotjament(Allotjament allotjament){

        Allotjament allotjamentActual;
        Iterator<Incidencia> itr = llistaIncidencies.iterator();
        boolean repetit = false;

        while (itr.hasNext()&&!repetit){

            allotjamentActual = itr.next().getAllotjament();

            if (allotjamentActual.getId()==allotjament.getId()){
                repetit = true;
            }
        }

        return repetit;
    }
    public boolean incidenciaRepetida(int num){

        boolean repetit = false;
        Iterator<Incidencia> itr = llistaIncidencies.iterator();
        Incidencia incidenciaActual;

        while (itr.hasNext()&&!repetit){

            incidenciaActual = itr.next();

            if(incidenciaActual.getNum()==num){
                repetit = true;
            }
        }
        return  repetit;
    }

    public Incidencia.TipusIncidencia retornaTipus(String tipus) throws  ExcepcioCamping{

        switch (tipus){
            case "Reparacio":
                return Incidencia.TipusIncidencia.Reparacio;
            case "Neteja":
                return  Incidencia.TipusIncidencia.Neteja;
            case  "Tancament":
                return  Incidencia.TipusIncidencia.Tancament;
            default:
                throw new ExcepcioCamping("El tipus "+ tipus +" no coincideix amb el de cap incidencia");
        }
    }


    // Altres mètodes
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {

        if(!incidenciaRepetidaAllotjament(allotjament) && !incidenciaRepetida(num)){

            Incidencia novaIncidencia = new Incidencia(data,num,allotjament,retornaTipus(tipus));

        }else if (!incidenciaRepetidaAllotjament(allotjament) && incidenciaRepetida(num)) {

            throw new ExcepcioCamping("L'excepció amb el identificador: "+num+" ja existeix.");

        } else if(incidenciaRepetidaAllotjament(allotjament) && !incidenciaRepetida(num)) {

            throw new ExcepcioCamping("L'allotjament amb id" + allotjament.getId() +" ja existeix");

        } else {

            throw new ExcepcioCamping("Aquesta excepció ja existeix.");
        }

    }

    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping {

        Incidencia incidenciaActual;
        Iterator<Incidencia> it = llistaIncidencies.iterator();

        if(incidenciaRepetida(in.getNum())) {

            while (it.hasNext()) {
                incidenciaActual = it.next();
                if (incidenciaActual.getNum() == in.getNum()) {
                    it.remove();
                }
            }
        }else{
            throw new ExcepcioCamping("La incidencia sol·licitada no coincideix amb cap incidencia.");
        }
    }

    public String llistarIncidencies() throws ExcepcioCamping {

        if (llistaIncidencies.size() != 0) {
            Incidencia incidenciaActual;
            Iterator<Incidencia> it = llistaIncidencies.iterator();
            StringBuffer sb = new StringBuffer();

            while (it.hasNext()) {
                incidenciaActual = it.next();
                sb.append(incidenciaActual.toString());
                sb.append("\n");
                sb.append("=============================================================");
            }
            return sb.toString();
        } else {
            throw new ExcepcioCamping("No hi ha cap element a la llista.");
        }
    }

    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        Incidencia incidenciaActual;
        Iterator<Incidencia> it = llistaIncidencies.iterator();
        if(incidenciaRepetida(num)) {

            while (it.hasNext()) {
                incidenciaActual = it.next();
                if (num == incidenciaActual.getNum()) {
                    return incidenciaActual;
                }
            }
            return null;

        } else {
            throw new ExcepcioCamping("No existeix cap incidencia amb aquest número.");
        }
    }

}