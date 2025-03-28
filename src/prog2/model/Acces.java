package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Acces  implements  InAcces, Serializable {
    private String nom;
    private boolean accessibilitat;
    private boolean estat;
    private ArrayList<Allotjament> destins; // He pensat que podria ser curios fer servir una LlistaAllotjaments
    //Tot i així  no és possible perquè em demanaría modificar el InLlistaAllotjaments per afegir un throws a un metode.

    public Acces(String nom_, boolean accessibilitat_, boolean estat_) {
        this.setNom(nom_);
        this.setEstat(estat_);
        this.setAccessibilitat(accessibilitat_);
        this.destins = new ArrayList<Allotjament>();

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

    public boolean teAllotjamentsOberts() throws ExcepcioCamping {
        boolean enTe = false;
        Iterator<Allotjament> itr = destins.iterator();
        Allotjament allotjamentActual = null;
        String estat;
        if(destins.isEmpty()){
            throw new ExcepcioCamping("El Acces: "+this.getNom()+" no té cap allotjament associat.");
        } else {
            while (itr.hasNext() && !enTe) {
                allotjamentActual = itr.next();
                estat = allotjamentActual.getEstat();
                switch (estat){
                    case "Operatiu":
                        enTe = true;
                        break;
                    case "No Operatiu":
                        break;
                    default:
                        throw new ExcepcioCamping("L'allotjament "+allotjamentActual.getNom()+" té un estat invàlid.");
                }
            }
        }
        return enTe;
    }

    public void obrirAcces() {
        this.setEstat(true);
    }

    public void tancarAcces() {
        this.setEstat(false);
    }

    public boolean isAccessibilitat() {
        return this.accessibilitat;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nom: " + this.nom + "\n");
        sb.append("Accessibilitat: " + this.isAccessibilitat() + "\n");
        sb.append("Estat: " + this.isEstat() + "\n");
        sb.append("Destins: ");
        Iterator<Allotjament> itrdestins = this.destins.iterator();

        while(itrdestins.hasNext()){
            sb.append(itrdestins.next().getId());
            sb.append(", ");
        }

        return sb.toString();
    }
}