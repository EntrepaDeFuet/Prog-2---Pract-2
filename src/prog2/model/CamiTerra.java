package prog2.model;

public class CamiTerra extends AccesTerra {


    // Constructor
    public CamiTerra(String nom_,boolean estat, Allotjament desti, float longitud) {
        super(nom_,false, estat, desti,longitud);

    }
    //Getters:
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
