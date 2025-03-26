package prog2.model;

public class CamiTerra extends AccesTerra {


    // Constructor
    public CamiTerra(String nom_,boolean estat, Allotjament desti, float longitud) {
        super(nom_,this.isAccessibilitat(), estat, desti);

        this.setLongitud(float longitud);
    }

    // Getters
    public float getLongitud(){
        return longitud;
    }

    public boolean isAccessibilitat(){
        return false;
    }

    // Setters
    public float setLongitud(float longitud) {
        this.longitud = longitud;
    }

    //Altres:
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());

        return sb.toString();
    }
}
