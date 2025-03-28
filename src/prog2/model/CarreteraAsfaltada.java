package prog2.model;

public class CarreteraAsfaltada extends AccesAsfalt{
    private float pesMaxim;

    // Constructor
    public CarreteraAsfaltada(String nom_,boolean estat, Allotjament desti, float asfalt, float pesMaxim) {
        super(nom_,this.isAccessibilitat(), estat, desti, asfalt);

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
    //Altres:
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Pes Maxim: " + this.getPesMaxim());

        return sb.toString();
    }
}
