package prog2.model;

public class MobilHome extends Casa{
    private boolean bbq;


    //constructor:
    public MobilHome(String nom_, String idAllotjament_,boolean estat, String iluminacio ,float mida, int habitacions, int placesPersones,
                     boolean terrassaBarbacoa){

        super(idAllotjament_,nom_,estat,iluminacio,mida,habitacions,placesPersones,5,3);
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

        StringBuffer nouString = new StringBuffer();
        nouString.append(super.toString());
        nouString.append(" La terrassa amb barbacoa està disponible? ");
        nouString.append(bbq);
        return nouString.toString();
    }
}
