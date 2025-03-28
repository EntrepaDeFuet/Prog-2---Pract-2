package prog2.model;

public abstract class  AccesTerra extends Acces{
    private float longitud;

    public AccesTerra(String nom_,boolean accessibilitat_, boolean estat_, float longitud){

        super(nom_,accessibilitat_,estat_);
        this.longitud = longitud;

    }
    //getters:
    public float getLongitud(){
        return longitud;
    }
    // Setters:
    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append("Longitud: ").append(this.getLongitud());

        return sb.toString();
    }
}
