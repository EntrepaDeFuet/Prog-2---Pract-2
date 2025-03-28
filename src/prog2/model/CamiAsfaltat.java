package prog2.model;

public class CamiAsfaltat extends AccesAsfalt {


    // Constructor
    public CamiAsfaltat(String nom_,boolean estat, Allotjament desti, float asfalt) {
        super(nom_,this.isAccessibilitat(), estat, desti, asfalt);

    }

    // Getters:
    public boolean isAccessibilitat(){
        return false;
    }


    //Altres:
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());

        return sb.toString();
    }
}