package prog2.model;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Acces  implements  InAcces {
    private String nom;
    private boolean accessibilitat;
    private boolean estat;
    private ArrayList<Allotjament> destins = new ArrayList<Allotjament>();

    public Acces(String nom_, boolean accessibilitat_, boolean estat_, Allotjament desti_) {
        this.setNom(nom_);
        this.setEstat(estat_);
        this.setAccessibilitat(accessibilitat_);
        this.afegirAllotjament(desti_);

    }

    // Getters
    public boolean isEstat() {
        return estat;
    }

    public ArrayList<Allotjament> getDestins() {
        return this.destins;
    }

    public String getNom(){
        return this.nom;
    }

    // Setters
    public void setAccessibilitat(boolean accessibilitat_) { this.accessibilitat = accessibilitat_; }

    public void setEstat(boolean estat_) {
        this.estat = estat_;
    }

    public void setNom(String nom_){
        this.nom = nom_;
    }

    //Altres metodes
    public void afegirAllotjament(Allotjament allotjament) {
        this.destins.add(allotjament);
    }

    public void obrirAcces() {
        this.setEstat(true);
    }

    public void tancarAcces() {
        this.setEstat(false);
    }

    public String toString(){

        String allotjaments = "";
        String resultat = "Nom: " + this.getNom() + " Accesible per a vehicles : " + this.isAccessibilitat() + " Operatiu: " + this.isEstat();
        Iterator<Allotjament> itrdestins = this.destins.iterator();

        while(itrdestins.hasNext()){
            allotjaments += " " +itrdestins.next().getId();
        }
        resultat+= "Llista d'allotjaments: "+ allotjaments;

        return resultat;
    }


}

