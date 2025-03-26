package prog2.model;
public class Incidencia {

    public static enum TipusIncidencia {
        Reparacio,
        Neteja,
        Tancament
    };

    private String data;
    private int num;
    private Allotjament allotjament;
    private TipusIncidencia tipusIncidencia;

    // Constructor
    public Incidencia(String data, int num, Allotjament allotjament, TipusIncidencia tipusIncidencia) {

    }

    // Getters
    public String getData() {
        return data;
    }

    public int getNum() {
        return  num;
    }

    public Allotjament getAllotjament() {
        return allotjament;
    }

    public TipusIncidencia getTipusInicdencia() {
        return tipusIncidencia;
    }

    // Setters
    public void setData(String data) {
        this.data = data;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

    public void setTipusIncidencia(TipusIncidencia tipusIncidencia) {
        this.tipusIncidencia = tipusIncidencia;
    }

    // Altres metodes
    public String toString() {
        return "La data es: " + getData() + ", el numero de la incidencia es: " + getNum() + ", el allotjament és: " +
                getAllotjament() + ", el tipus d'incidencia es: " + getTipusIncidencia();
    }

    public String getIluminacioAllotjament() {
        switch (tipusIncidencia) {
            case Reparacio:
                return "100%";
            case Neteja:
                return "50%";
            case Tancament:
                return "0%";
        }
    }
}
