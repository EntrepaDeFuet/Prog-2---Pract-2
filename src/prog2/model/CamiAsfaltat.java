package prog2.model;

public class CamiAsfaltat extends AccesAsfalt {


    // Constructor
    public CamiAsfaltat(boolean estat, Allotjament desti, float asfalt) {
        super(this.isAccessibilitat(), estat, desti);

        this.setAsfalt(asfalt);
    }

    // Getters
    public float getAsfalt() {
        return asfalt
    }

    public boolean isAccessibilitat(){
        return false;
    }

    // Setters
    public void setAsfalt(float asfalt_) {
        this.asfalt = asfalt_;
    }
}