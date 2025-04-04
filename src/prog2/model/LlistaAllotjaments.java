package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAllotjaments implements InLlistaAllotjaments, Serializable {
    //Atributs
    private ArrayList<Allotjament> llista;


    //Constructor
    public LlistaAllotjaments(){
        this.llista = new ArrayList<Allotjament>();
    }

    /**
     * A partir d'un nom busca si hi ha algun allotjament que ja existeixi amb aquest nom.
     * @param id
     * @return
     */
    public boolean allotjamentRepetit(String id){

        boolean repetit = false;
        Iterator<Allotjament> itrAllotjaments = llista.iterator();

        while(itrAllotjaments.hasNext() && !repetit){
            repetit = itrAllotjaments.next().getId().equals(id);
        }


        return repetit;
    }


    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {

        if(!this.contains(allotjament)){
            llista.add(allotjament);
        } else {
            throw new ExcepcioCamping("Ja existeix un Allotjament amb aquesta id.");
        }
    }

    public boolean contains(Allotjament allotjament){
        return allotjamentRepetit(allotjament.getId());
    }

    public void buidar(){

        this.llista.clear();

    }

    public boolean containsAllotjamentOperatiu(){

        Iterator <Allotjament> itrLlista = llista.iterator();
        boolean operatiu = false;
        Allotjament allotjamentActual;

        while (itrLlista.hasNext() && !operatiu){
            allotjamentActual = itrLlista.next();
            operatiu = allotjamentActual.getEstat().equals("Operatiu");
        }
        return operatiu;
    }

    public boolean isEmpty(){

        return llista.isEmpty();

    }

    public Allotjament getAllotjament(String id) throws ExcepcioCamping{

        if(this.allotjamentRepetit(id)){

            Iterator <Allotjament> itrAllotjaments = this.llista.iterator();
            Allotjament allotjamentActual = null;
            boolean condicio = false;

            while(itrAllotjaments.hasNext() && !condicio){

                allotjamentActual = itrAllotjaments.next();
                condicio = allotjamentActual.getId().equals(id);

            }
            return allotjamentActual;
        }
        else {

            throw new ExcepcioCamping("No existeix cap allotjament amb aquesta Id.");

        }
    }

    public String llistarAllotjaments(String estat) throws ExcepcioCamping{
        if(!estat.equals("Operatiu")&&!estat.equals("No Operatiu")){
            throw new ExcepcioCamping("El estat introduit no és vàlid.");
        }
        else if(!llista.isEmpty()){
            Allotjament allotjamentActual = null;
            Iterator<Allotjament> itrAllotjaments = llista.iterator();
            StringBuffer llistat = new StringBuffer();

            while (itrAllotjaments.hasNext()) {

                allotjamentActual = itrAllotjaments.next();

                if (allotjamentActual.getEstat().equals(estat)) {

                    llistat.append(allotjamentActual.toString());
                    llistat.append("\n");
                }
            }
            return llistat.toString();
        } else {
            throw new ExcepcioCamping("La llista d'allotjaments és buida.");
        }

    }

    public int midaLlista() {
        return this.llista.size();
    }
}
