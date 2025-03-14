package prog2.model;

public class AccesTerra extends Acces{
    private float longitud;

    public AccesTerra(boolean accessibilitat_, boolean estat_, Allotjament desti_,float longitud){

        super(accessibilitat_,estat_,desti_);
        this.longitud = longitud;

    }
}
