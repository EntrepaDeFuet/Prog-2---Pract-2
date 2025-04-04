package prog2.model;

public class Bungalow extends Casa{
    private int placesParking;
    private boolean terrassa, tv, ac;

    // Constructor:
    public Bungalow(String nom_, String idAllotjament_,boolean estat, String iluminacio , float mida, int habitacions, int placesPersones,
                    int placesParquing, boolean terrassa, boolean tv, boolean aireFred){

        super(idAllotjament_,nom_,estat, iluminacio ,mida,habitacions,placesPersones,7,4);

        this.setPlacesParking(placesParquing);
        this.setTerrassa(terrassa);
        this.setTv(tv);
        this.setAc(aireFred);

    }
    //getters:
    public int getPlacesParquing(){
        return this.placesParking;
    }
    public boolean isTerrassa(){
        return this.terrassa;
    }
    public boolean isTv(){
        return this.tv;
    }
    public boolean isAireFred(){
        return this.ac;
    }

    //Setter:
    public void setPlacesParking(int places_){
        this.placesParking=places_;
    }
    public void setTerrassa(boolean terrassa_){
        this.terrassa = terrassa_;
    }
    public void setTv( boolean tv_){
        this.tv = tv_;
    }
    public void setAc(boolean ac_){
        this.ac = ac_;
    }

    //Altres:
    public boolean correcteFuncionament() {
        return this.isAireFred();
    }

    public String toString() {
        StringBuffer nouString = new StringBuffer();
        nouString.append(super.toString());
        nouString.append(", places de parking: ");
        nouString.append(this.placesParking);
        nouString.append(", disposa de terrassa en funcionament? ");
        nouString.append(this.isTerrassa());
        nouString.append(", disposa d'aire acondicionat? ");
        nouString.append(this.isAireFred());
        return nouString.toString();
    }
}
