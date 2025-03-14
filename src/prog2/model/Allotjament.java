package prog2.model;

public abstract class Allotjament implements InAllotjament {

    private String id;
    private String nom;
    private long estadaMinimaTempBaixa;
    private long estadaMinimaTempAlta;
    private boolean estat;
    // només pot ser 0: 0% ,1: 50%, o 2: 100%
    private int iluminacio;



    public Allotjament(String _id,String _nom, int estadaMinimaTempAlta_, int estadaMinimaTempBaixa_ ){

        this.setId(_id);
        this.setNom(_nom);
        this.obrirAllotjament();
        setEstadaMinima(estadaMinimaTempAlta_,estadaMinimaTempBaixa_);
    }



    //getters:
    public String getNom(){
        return nom;
    }
    public String getId(){
        return id;
    }

    public long getEstadaMinima(Temp temp){

        return switch (temp) {
            case BAIXA -> estadaMinimaTempBaixa;
            case ALTA -> estadaMinimaTempAlta;
            default -> 0;
        };

    }

    //setters:

    public void setIluminacio(int _iluminacio) {this.iluminacio = _iluminacio;}

    public void obrirAllotjament() {
        this.estat= true;
        this.setIluminacio(2);
    }
    public void setId(String id_){
        this.id = id_;
    }
    public void setNom(String nom_){
        this.nom = nom_;
    }
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){

        this.estadaMinimaTempAlta = estadaMinimaALTA_ ;
        this.estadaMinimaTempBaixa = estadaMinimaBAIXA_;
    }

    //altres:
    public String toString() {
        return "ID: " + getId() + ", Nom: " + getNom() + ", Estada minima Temp Baixa: " + getEstadaMinima(Temp.BAIXA) + ", Estada minima Temp Alta: " + getEstadaMinima(Temp.ALTA);
    }
}
