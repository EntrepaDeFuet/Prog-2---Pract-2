package prog2.model;

public class AccesTerra extends Acces{
    private float longitud;

    public AccesTerra(String nom_,boolean accessibilitat_, boolean estat_, Allotjament desti_,float longitud){

        super(nom_,accessibilitat_,estat_,desti_);
        this.longitud = longitud;

    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append("Longitud: ").append(this.longitud);

        return sb.toString();
    }
}
