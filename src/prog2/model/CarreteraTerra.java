package prog2.model;

public class CarreteraTerra  extends  AccesTerra {
    private  float amplada;

    // Constructor

    public CarreteraTerra(String nom_, boolean estat, Allotjament desti, float longitud, float amplada) {
        super(nom_,this.isAccessibilitat(), estat, desti, longitud);

        this.setAmplada(float amplada);
    }

    // Getters
    public float getAmplada() {
        getAmplada();
    }

    public boolean isAccessibilitat(){
        return true;
    }

    // Setters
    public void setAmplada(float amplada) {
        this.amplada = amplada;
    }

    //Altres:
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append("Amplada: "+this.getAmplada());

        return sb.toString();
    }
}
