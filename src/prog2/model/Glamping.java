package prog2.model;

public class Glamping extends Casa{
    private String material;
    private boolean mascota;

    //Constructor:
    public Glamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                    String material, boolean casaMascota){

        super(idAllotjament_,nom_,mida,habitacions,placesPersones,5,3);
        this.setMascota(casaMascota);
        this.setMaterial(material);


    }
    //getters:
    public  String getMaterial(){
        return this.material;
    }
    public boolean getMascota(){
        return this.mascota;
    }

    //setters:
    public void setMaterial(String material_){
        this.material = material_;
    }
    public void setMascota(boolean mascota_){
        this.mascota = mascota_;
    }

    //Altres:


    public boolean correcteFuncionament() {
        return this.getMascota();
    }

    public String toString() {

        StringBuffer nouString = new StringBuffer();
        nouString.append(super.toString());
        nouString.append(", disposa d'espai per a mascota? ");
        nouString.append(mascota);
        nouString.append(", El glamping està fabricat amb: ");
        nouString.append(material);

        return nouString.toString();

    }

}
