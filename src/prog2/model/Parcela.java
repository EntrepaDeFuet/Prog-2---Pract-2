package prog2.model;

public class Parcela extends Allotjament {
    private float mida;
    private boolean conexio;

    public Parcela(String nom_, String idAllotjament_,boolean estat, String iluminacio ,float mida, boolean connexioElectrica) {

        super(idAllotjament_,nom_,estat,iluminacio,4,2);
        this.setMida(mida);
        this.setConnexioElectrica(connexioElectrica);


    }
    //getters:
    public float getMida(){
        return this.mida;
    }

    public boolean isConnexioElectrica() {
        return this.conexio;
    }
    //Setters:

    public void setMida(float mida_){
        this.mida = mida_;
    }
    public void setConnexioElectrica(boolean conexio_){
        this.conexio = conexio_;
    }
    //Altres:
    public boolean correcteFuncionament(){

        return this.isConnexioElectrica();
    }

    public String toString(){

        StringBuffer nouString = new StringBuffer();
        nouString.append(super.toString());
        nouString.append(", mida: ");
        nouString.append(mida);
        nouString.append(", té conexió elèctrica? ");
        nouString.append(this.isConnexioElectrica());

        return nouString.toString();
    }
}
