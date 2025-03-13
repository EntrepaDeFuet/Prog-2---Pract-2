package prog2.model;

import java.util.ArrayList;

public abstract class Acces  implements  InAcces {
    private boolean accessibilitat;
    private boolean estat;
    private ArrayList<Allotjament> destins = new ArrayList<Allotjament>();

    public Acces(boolean accessibilitat_, boolean estat_, Allotjament desti_) {

    }

    // Getters
    public boolean isEstat() {
        return estat;
    }

    public ArrayList<Allotjament> getDestins() {
        return this.destins;
    }

    // Setters
    public void setAccessibilitat(boolean accessibilitat_) { this.accessibilitat = accessibilitat_; }

    public void setEstat(boolean estat_) {
        this.estat = estat_;
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

    public boolean isAccessibilitat() {
        return accessibilitat;
    }
}

