package prog2.model;

public class CarreteraAsfaltada extends AccesAsfalt{
    private float pesMaxim;

    // Constructor
    public CarreteraAsfaltada(boolean estat, Allotjament desti, float asfalt, float pesMaxim) {
        super(this.isAccessibilitat(), estat, desti, asfalt);

        this.setPesMaxim(pesMaxim);
    }

    // Getters
    public float getPesMaxim() {
        return pesMaxim;
    }

    public boolean isAccessibilitat(){
        return true;
    }
    // Setters
    public void setPesMaxim(float pesMaxim) {
        this.pesMaxim = pesMaxim;
    }
}
