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
        String mascota;
        if(this.getMascota()){

            mascota = "si";

        } else{

            mascota = "no";
        }

        return "Nom: " + super.getNom() + ", ID allotjament: " + super.getId() + ", mida: " + super.getMida() + ", nombre d'habitacions: " + super.getHabitacions() + ", places: " + super.getPlacesPersones()
                + " Espai per a mascotes: " + mascota + " Material del glamping: "+material;
    }
}
