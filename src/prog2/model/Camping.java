package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDate;



public class Camping implements InCamping, Serializable {
    //Atributs
    private String nom;
    private LlistaAllotjaments llistaAllotjaments;
    private LlistaAccessos llistaAccessos;
    private  LlistaIncidencies llistaIncidencies;

    // Constructor:
    public Camping(String nom) {
        this.nom = nom;
        this.llistaAllotjaments = new LlistaAllotjaments();
        this.llistaAccessos = new LlistaAccessos();
        this.llistaIncidencies = new LlistaIncidencies();
    }

    //Getters:


    public String getNomCamping() {

        return nom;
    }


    public LlistaAllotjaments getLlistaAllotjaments() {

        return llistaAllotjaments;
    }

    public LlistaAccessos getLlistaAccessos() {
        return llistaAccessos;
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
        this.llistaAccessos.actualitzaEstatAccessos();


    }
    public void eliminarIncidencia(int num) throws ExcepcioCamping {

        Incidencia incidenciaActual = buscaIncidencia(num);
        Allotjament allotjamentActual = incidenciaActual.getAllotjament();
        allotjamentActual.obrirAllotjament();
        this.llistaIncidencies.eliminarIncidencia(incidenciaActual);
        //Falta obrir els allotjaments.
        this.llistaAccessos.actualitzaEstatAccessos();

    }
    //Gestió dels Acessos:
    public int calculaAccessosAccessibles(){
        // Ja sé que és molt cutre fer el try-catch aqui, però les normes diuen que no puc modificar InCamping
        try {
            return llistaAccessos.calculaAccessosAccessibles();
        }catch (ExcepcioCamping e){
            return 0;
        }
    }
    public float calculaMetresQuadratsAsfalt(){
        // Ja sé que és molt cutre fer el try-catch aqui, però les normes diuen que no puc modificar InCamping
        try {
            return llistaAccessos.calculaMetresQuadratsAsfalt();
        } catch (ExcepcioCamping e){
            return 0;
        }
    }
    // toString de les llistes:
    public String llistarAllotjaments(String infoEstat) throws ExcepcioCamping{
        return llistaAllotjaments.llistarAllotjaments(infoEstat);
    }
    public String llistarIncidencies() throws ExcepcioCamping{
        return llistaIncidencies.llistarIncidencies();
    }
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping{
        if (infoEstat.equals("Obert")) {
            return llistaAccessos.llistarAccessos(true);
        } else if (infoEstat.equals("Tancat")){
            return llistaAccessos.llistarAccessos(false);
        } else {
            throw new ExcepcioCamping("L'estat indicat no existeix.");
        }
    }
    //Retenció de memòria (No garanteixo que funcioni):
    public void save(String camiDesti) throws ExcepcioCamping{
        try {
            File fitxer = new File(camiDesti);
            FileOutputStream fout = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            oos.close();
            fout.close();
        } catch (Exception e){
            throw new ExcepcioCamping(e.getMessage());
        }
    }
    public  static Camping load(String camiOrigen) throws ExcepcioCamping {

        try {
            File fitxer = new File(camiOrigen);
            FileInputStream fis = new FileInputStream(fitxer);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Camping camping = (Camping) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e){
            throw new ExcepcioCamping(e.getMessage());
        }

        return null;
    }

    //Aqui ve el drama:
    public void inicialitzaDadesCamping(){
        this.llistaAccessos.buidar();
        float asfalt = 200;
        Acces Acc1 = new CamiAsfaltat("A1", true, asfalt);
        llistaAccessos.afegirAcces(Acc1);

        asfalt = 800;
        float pesMaxim = 10000;
        Acces Acc2 = new CarreteraAsfaltada("A2", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc2);

        float longitud = 100;
        Acces Acc3 = new CamiTerra("A3", true, longitud);
        llistaAccessos.afegirAcces(Acc3);

        longitud = 200;
        float amplada = 3;
        Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc4);

        asfalt = 350;
        Acces Acc5 = new CamiAsfaltat("A5", true, asfalt);
        llistaAccessos.afegirAcces(Acc5);

        asfalt = 800;
        pesMaxim = 12000;
        Acces Acc6 = new CarreteraAsfaltada("A6", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc6);

        asfalt = 100;
        Acces Acc7 = new CamiAsfaltat("A7", true, asfalt);
        llistaAccessos.afegirAcces(Acc7);

        asfalt = 800;
        pesMaxim = 10000;
        Acces Acc8 = new CarreteraAsfaltada("A8", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc8);

        longitud = 50;
        Acces Acc9 = new CamiTerra("A9", true, longitud);
        llistaAccessos.afegirAcces(Acc9);

        longitud = 400;
        amplada = 4;
        Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc10);

        longitud = 80;
        Acces Acc11 = new CamiTerra("A11", true, longitud);
        llistaAccessos.afegirAcces(Acc11);

        longitud = 800;
        amplada = 5;
        Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc12);
    }

}


