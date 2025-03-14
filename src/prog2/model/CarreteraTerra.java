package prog2.model;

public class CarreteraTerra  extends  CamiTerra {
    private  float amplada;

    // Constructor

    public CarreteraTerra(boolean accessibilitat, boolean estat, Allotjament desti, float longitud, float amplada) {
        super(true, estat, desti, longitud);

        this.setAmplada(float amplada);
    }

    // Getters
    public float getAmplada() {
        getAmplada();
    }

    // Setters
    public void setAmplada(float amplada) {
        this.amplada = amplada;
    }

}
