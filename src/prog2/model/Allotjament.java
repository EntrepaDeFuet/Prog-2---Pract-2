package prog2.model;

public abstract class Allotjament implements InAllotjament {

    private String id;
    private String nom;
    private long estadaMinimaTempBaixa;
    private long estadaMinimaTempAlta;
    // "Operatiu" "No Operatiu"
    private String estat;
    // només pot ser 0: 0% ,1: 50%, o 2: 100%
    private String iluminacio;


    public Allotjament(String _id, String _nom, int estadaMinimaTempAlta_, int estadaMinimaTempBaixa_) {

        this.setId(_id);
        this.setNom(_nom);
        this.obrirAllotjament();
        setEstadaMinima(estadaMinimaTempAlta_, estadaMinimaTempBaixa_);
    }


    //getters:
    public String getNom() {
        return nom;
    }

    public String getId() {
        return id;
    }
    public String getIluminacio() { return  iluminacio; }


    public long getEstadaMinima(Temp temp) {

        return switch (temp) {
            case BAIXA -> estadaMinimaTempBaixa;
            case ALTA -> estadaMinimaTempAlta;
            default -> 0;
        };

    }
    public String getEstat(){
        return estat;
    }

    //setters:


    public void setIluminacio(String _iluminacio) {this.iluminacio = _iluminacio;}


    public void obrirAllotjament() {
        this.estat = "Operatiu";
        this.setIluminacio("100%");
    }

    public void setId(String id_) {
        this.id = id_;
    }

    public void setNom(String nom_) {
        this.nom = nom_;
    }

    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {

        this.estadaMinimaTempAlta = estadaMinimaALTA_;
        this.estadaMinimaTempBaixa = estadaMinimaBAIXA_;
    }

    //altres:
    public String toString() {

        StringBuffer nouString = new StringBuffer();
        nouString.append("ID: ");
        nouString.append(getId());
        nouString.append(", Nom: ");
        nouString.append(getNom());
        nouString.append(", Estada minima Temp Baixa: ");
        nouString.append(getEstadaMinima(Temp.BAIXA));
        nouString.append(", Estada minima Temp Alta: ");
        nouString.append(getEstadaMinima(Temp.ALTA));

        return nouString.toString();
    }
}
