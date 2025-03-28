package prog2.model;

public abstract class AccesAsfalt extends Acces{
    private float asfalt;

    public AccesAsfalt(String nom_,boolean accessibilitat_, boolean estat_, float asfalt){
        super(nom_,accessibilitat_,estat_);
        this.asfalt = asfalt;
    }

    //Getters:
    public float getAsfalt() {
        return asfalt;
    }

    // Setters:
    public void setAsfalt(float asfalt_) {
        this.asfalt = asfalt_;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append("Àrea asfaltada: " + this.getAsfalt());

        return sb.toString();
    }
}
