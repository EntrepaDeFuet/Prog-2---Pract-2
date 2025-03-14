package prog2.model;

public class AccesAsfalt extends Acces{
    private float asfalt;

    public AccesAsfalt(boolean accessibilitat_, boolean estat_, Allotjament desti_,float asfalt){
        super(accessibilitat_,estat_,desti_);
        this.asfalt = asfalt;
    }
    public String toString(){

    }
}
