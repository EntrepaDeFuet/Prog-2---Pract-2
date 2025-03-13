package prog2.model;

public class MobilHome extends Casa{
    private boolean bbq;


    //constructor:
    public MobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                     boolean terrassaBarbacoa){

        super(idAllotjament_,nom_,mida,habitacions,placesPersones,5,3);
        this.setBbq(terrassaBarbacoa);


    }
    //getter:
    public boolean getBbq(){
        return this.bbq;
    }
    //setter:
    public void setBbq(boolean bbq_){
        this.bbq = bbq_;
    }
    //Altres:
    public boolean correcteFuncionament(){
        return this.getBbq();
    }

    public String toString() {
        return "Nom: " + super.getNom() + ", ID allotjament: " + super.getId() + ", mida: " + super.getMida() + ", habiatacions: " + super.getHabitacions() + ", places: " + 
        super.getPlacesPersones() + ", terrassa amb barbacoa: " + getBbq();
    }
}
