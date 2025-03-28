package prog2.model;

import java.io.Serializable;

public class Incidencia implements Serializable {

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
        this.data = data;
        this.num = num;
        this.allotjament = allotjament;
        this.tipusIncidencia = tipusIncidencia;
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

    public TipusIncidencia getTipusIncidencia() {
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

        StringBuffer nouString = new StringBuffer();
        nouString.append("El número d'incidència és: ");
        nouString.append(this.getNum());
        nouString.append(" a l'allotjament: ");
        nouString.append(this.getAllotjament().toString());
        nouString.append("\n");
        nouString.append("Amb data: ");
        nouString.append(this.getData());
        nouString.append(" i és una incidencia de tipus: ");
        nouString.append(this.getTipusIncidencia());

        return nouString.toString();
    }

    public String getIluminacioAllotjament() {
        switch (tipusIncidencia) {
            case Reparacio:
                return "100%";
            case Neteja:
                return "50%";
            case Tancament:
                return "0%";
            default:
                return "100%";
        }
    }
}
