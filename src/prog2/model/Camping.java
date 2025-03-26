package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDate;



public class Camping implements InCamping {
    //Atributs
    private String nom;
    private LlistaAllotjaments llistaAllotjaments;
    private LlistaAccessos llistaAccessos;
    private  LlistaIncidencies llistaIncidencies;

    // Constructor:
    public Camping(String nom) {
        this.nom = nom;
        this.llistaAccessos = new llistaAccessos();
        this.llistaIncidencies = new LlistaIncidencies();
    }

    //Getters:


    public String getNomCamping() {

        return nom;
    }

    public LlistaAllotjaments getLlistaAllotjaments() {

        return llistaAllotjaments;
    }





    //Afegir allotjaments:

    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) throws ExcepcioCamping {

        Parcela parcelaNova = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(parcelaNova);

    }

    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred) throws ExcepcioCamping {

        Bungalow bungalowNou = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.afegirAllotjament(bungalowNou);


    }

    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                                      int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                                      boolean serveisExtra, String codiWifi) throws ExcepcioCamping {

        BungalowPremium bungalowPremiumNou = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.afegirAllotjament(bungalowPremiumNou);
    }

    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               String material, boolean casaMascota) throws ExcepcioCamping {

        Glamping glampingNou = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.afegirAllotjament(glampingNou);

    }

    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                                boolean terrassaBarbacoa) throws ExcepcioCamping {

        MobilHome mobilHomeNou = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.afegirAllotjament(mobilHomeNou);
    }




    public static InAllotjament.Temp getTemporada(LocalDate data){

        LocalDate tempAltaInici = LocalDate.of(2025, 3, 21);
        LocalDate tempAltaFinal = LocalDate.of(2025, 9, 20);

        //Aquestes variables les hem fet per llegibilitat de codi.
        boolean condicio1, condicio2;

        condicio1 = data.equals(tempAltaInici)|| data.isAfter(tempAltaInici);
        condicio2 = data.equals(tempAltaFinal) || data.isBefore(tempAltaFinal);

        if(condicio1 && condicio2){

            return InAllotjament.Temp.ALTA;

        } else{

            return InAllotjament.Temp.BAIXA;
        }

    }

    //Gestió incidències.
    public Incidencia buscaIncidencia(int num) throws ExcepcioCamping{
        return this.llistaIncidencies.getIncidencia(num);
    }


    public void afegirIncidencia(int num, String tipus, String idAllotjament, String data) throws ExcepcioCamping {

        Allotjament allotjamentActual = llistaAllotjaments.getAllotjament(idAllotjament);
        this.llistaIncidencies.afegirIncidencia(num, tipus, allotjamentActual, data);
        this.llistaAccessos.actualitzarEstatAccesos();


    }
    public void eliminarIncidencia(int num) throws ExcepcioCamping {

        Incidencia incidenciaAcutal = buscaIncidencia(num);
        this.llistaIncidencies.eliminarIncidencia(incidenciaAcutal);

    }
    //Gestió dels Acessos:
    public int calculaAccessosAccessibles(){
        return llistaAccessos.calculaAccessosAccessibles();
    }
    public float calculaMetresQuadratsAsfalt(){
        return llistaAccessos.calculaMetresQuadratsAsfalt();
    }
    // toString de les llistes:
    public String llistarAllotjaments(String infoEstat) throws ExcepcioCamping{
        return llistaAllotjaments.llistarAllotjament(infoEstat);
    }
    public String llistarIncidencies() throws ExcepcioCamping{
        return llistaIncidencies.llistarIncidencies();
    }
    public String llistarAccessos(String infoEstat){
        return llistaAccessos.llistarAccessos(infoEstat);
    }

}


