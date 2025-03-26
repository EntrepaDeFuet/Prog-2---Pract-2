package prog2.model;

public abstract class AccesAsfalt extends Acces{
    private float asfalt;

    public AccesAsfalt(String nom_,boolean accessibilitat_, boolean estat_, Allotjament desti_,float asfalt){
        super(nom_,accessibilitat_,estat_,desti_);
        this.asfalt = asfalt;
    }
    public String toString(){
        return super.toString() + " Àrea asfaltada: " + asfalt;
    }
}
