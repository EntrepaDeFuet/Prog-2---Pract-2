package prog2.model;

public class CamiTerra extends AccesTerra {


    // Constructor
    public CamiTerra(String nom_,boolean estat, Allotjament desti, float longitud) {
        super(nom_,this.isAccessibilitat(), estat, desti);

        this.setLongitud(float longitud);
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
