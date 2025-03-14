package prog2.model;

public class CarreteraAsfaltada extends CamiAsfaltat{
    private float pesMaxim;

    // Constructor
    public CarreteraAsfaltada(boolean accessibilitat, boolean estat, Allotjament desti, float asfalt, float pesMaxim) {
        super(true, estat, desti, asfalt);

        this.setPesMaxim(pesMaxim);
    }

    // Getters
    public float getPesMaxim() {
        return pesMaxim;
    }
    // Setters
    public void setPesMaxim(float pesMaxim) {
        this.pesMaxim = pesMaxim;
    }
}
