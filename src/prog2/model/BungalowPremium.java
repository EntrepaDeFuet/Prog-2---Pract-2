package prog2.model;

public class BungalowPremium extends Bungalow{
    private boolean serveisExtra;
    private String codiWifi;



    public BungalowPremium(String nom_, String idAllotjament_,boolean estat, String iluminacio , float mida, int habitacions, int placesPersones,
                           int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                           boolean serveisExtra, String codiWifi){

        super ( nom_, idAllotjament_,estat,iluminacio, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.setServeisExtra(serveisExtra);
        this.setCodiWifi(codiWifi);
    }
    //Getters:

    public boolean isServeisExtra(){
        return this.serveisExtra;
    }
    public String getCodiWifi(){
        return this.codiWifi;
    }


    //Setters:

    public void setServeisExtra(boolean serveisExtra_){
        this.serveisExtra = serveisExtra_;
    }
    public void setCodiWifi(String codiWifi_){
        this.codiWifi = codiWifi_;
    }

    @Override
    public boolean correcteFuncionament() {
        //Notar com el .lenght()>=8 sembla una cara sorpresa amb els ulls molt oberts.
        return super.correcteFuncionament() && (this.getCodiWifi().length()>=8) && (this.getCodiWifi().length()<= 16);
    }

    @Override
    public String toString() {

        StringBuffer nouString = new StringBuffer();
        nouString.append(super.toString());
        nouString.append(", disposa de serveis extra? ");
        nouString.append(this.isServeisExtra());
        nouString.append(", codi wifi: ");
        nouString.append(this.getCodiWifi());

        return nouString.toString();
    }
}
