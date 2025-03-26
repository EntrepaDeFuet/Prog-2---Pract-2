package prog2.model;

public abstract class  AccesTerra extends Acces{
    private float longitud;

    public AccesTerra(String nom_,boolean accessibilitat_, boolean estat_, Allotjament desti_,float longitud){

        super(nom_,accessibilitat_,estat_,desti_);
        this.longitud = longitud;

    }
    public String toString(){
        String resultat;
        resultat = super.toString();
        resultat = resultat + " Longitud del accés: " + longitud;
        return resultat;
    }
}
