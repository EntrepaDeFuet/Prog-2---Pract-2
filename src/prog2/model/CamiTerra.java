package prog2.model;

public class CamiTerra extends AccesTerra {


    // Constructor
    public CamiTerra(boolean estat, Allotjament desti, float longitud) {
        super(this.isAccessibilitat(), estat, desti);

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
}
