package prog2.model;

public class CamiTerra extends Acces {
    private float longitud;

    // Constructor
    public CamiTerra(boolean accessibilitat, boolean estat, Allotjament desti, float longitud) {
        super(accessibilitat, estat, desti);

        this.setLongitud(float longitud);
    }

    // Getters
    public float getLongitud(){
        return longitud;
    }

    // Setters
    public float setLongitud(float longitud) {
        this.longitud = longitud;
    }
}
