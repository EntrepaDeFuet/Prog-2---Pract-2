package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAllotjaments {
    //Atributs
    private ArrayList<Allotjament> llista;


    //Constructor
    public LlistaAllotjaments(){
        this.llista = new ArrayList<Allotjament>();
    }

    /**
     * A partir d'un nom busca si hi ha algun allotjament que ja existeixi amb aquest nom.
     * @param nom_
     * @return
     */
    public boolean allotjamentRepetit(String nom_){

        boolean repetit = false;
        Iterator<Allotjament> itrAllotjaments = llista.iterator();

        while(itrAllotjaments.hasNext() && !repetit){
            repetit = itrAllotjaments.next().getNom().equals(nom_);
        }


        return repetit;
    }


    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {

        if(!this.contains(allotjament)){
            llista.add(allotjament);
        } else {
            throw new ExcepcioCamping ("Ja existeix un Allotjament amb aquest nom.");
        }
    }

    public boolean contains(Allotjament allotjament){
        return allotjamentRepetit(allotjament.getNom());
    }

    public void buidar(){

        Iterator <Allotjament> itrLlista = llista.iterator();

        while (itrLlista.hasNext()){
            itrLlista.remove();
        }
    }

    public boolean containsOperatiu(){

        Iterator <Allotjament> itrLlista = llista.iterator();
        boolean operatiu = false;
        Allotjament allotjamentActual;

        while (itrLlista.hasNext() && !operatiu){
            allotjamentActual = itrLlista.next();
            operatiu = allotjamentActual.isEstat();
        }
        return operatiu;
    }

    public boolean isEmpty(){

        return llista.isEmpty();

    }

}
