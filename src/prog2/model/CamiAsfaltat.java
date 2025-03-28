package prog2.model;

public class CamiAsfaltat extends AccesAsfalt {


    // Constructor
    public CamiAsfaltat(String nom_,boolean estat,  float asfalt) {
        super(nom_,false, estat, asfalt);

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