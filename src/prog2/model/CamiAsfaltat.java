package prog2.model;

public class CamiAsfaltat extends Acces {
    private float asfalt;

    // Constructor
    public CamiAsfaltat(boolean accessibilitat, boolean estat, Allotjament desti, float asfalt) {
        super(accessibilitat, estat, desti);

        this.setAsfalt(asfalt);
    }

    // Getters
    public float getAsfalt() {
        return asfalt;
    }

    // Setters
    public void setAsfalt(float asfalt_) {
        this.asfalt = asfalt_;
    }
}