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
        Camping camping;
        try {
            File fitxer = new File(camiOrigen);
            FileInputStream fis = new FileInputStream(fitxer);
            ObjectInputStream ois = new ObjectInputStream(fis);
            camping = (Camping) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e){
            throw new ExcepcioCamping(e.getMessage());
        }

        return camping;
    }

    //Aqui ve el drama:
    public void inicialitzaDadesCamping(){

        this.llistaAccessos.buidar();
        float asfalt = 200;
        Acces Acc1 = new CamiAsfaltat("A1", true, asfalt);
        try {
            llistaAccessos.afegirAcces(Acc1);
        }catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }

        asfalt = 800;
        float pesMaxim = 10000;
        Acces Acc2 = new CarreteraAsfaltada("A2", true, asfalt, pesMaxim);
        try {
            llistaAccessos.afegirAcces(Acc2);
        }catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }

        float longitud = 100;
        Acces Acc3 = new CamiTerra("A3", true, longitud);
        try {
            llistaAccessos.afegirAcces(Acc3);
        }catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }

        longitud = 200;
        float amplada = 3;
        Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
        try {
            llistaAccessos.afegirAcces(Acc4);
        }catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }

        asfalt = 350;
        Acces Acc5 = new CamiAsfaltat("A5", true, asfalt);
        try {
            llistaAccessos.afegirAcces(Acc5);
        }catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }

        asfalt = 800;
        pesMaxim = 12000;
        Acces Acc6 = new CarreteraAsfaltada("A6", true, asfalt, pesMaxim);
        try {
            llistaAccessos.afegirAcces(Acc6);
        }catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }

        asfalt = 100;
        Acces Acc7 = new CamiAsfaltat("A7", true, asfalt);
        try {
            llistaAccessos.afegirAcces(Acc7);
        }catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }

        asfalt = 800;
        pesMaxim = 10000;
        Acces Acc8 = new CarreteraAsfaltada("A8", true, asfalt, pesMaxim);
        try {
            llistaAccessos.afegirAcces(Acc8);
        }catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }

        longitud = 50;
        Acces Acc9 = new CamiTerra("A9", true, longitud);
        try {
            llistaAccessos.afegirAcces(Acc9);
        }catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }

        longitud = 400;
        amplada = 4;
        Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
        try {
            llistaAccessos.afegirAcces(Acc10);
        }catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }

        longitud = 80;
        Acces Acc11 = new CamiTerra("A11", true, longitud);
        try {
            llistaAccessos.afegirAcces(Acc11);
        }catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }

        longitud = 800;
        amplada = 5;
        Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
        try {
            llistaAccessos.afegirAcces(Acc12);
        }catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }
        llistaAllotjaments.buidar();

        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "ALL1";
        float mida = 64.0f;
        boolean connexioElectrica = true;

        Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        try {
            llistaAllotjaments.afegirAllotjament(ALL1);
        } catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }

        nom = "Parcel·la Sud";
        idAllotjament = "ALL2";

        Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        try {
            llistaAllotjaments.afegirAllotjament(ALL2);
        } catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }

        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Nord";
        idAllotjament = "ALL3";
        mida = 22f;
        int habitacions =2;
        int placesPersones = 4;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;

        Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        try {
            llistaAllotjaments.afegirAllotjament(ALL3);
        } catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Sud";
        idAllotjament = "ALL4";
        mida = 27f;
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= true;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        try {
            llistaAllotjaments.afegirAllotjament(ALL4);
        } catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }

        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "ALL5";
        mida = 20f;
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        Glamping ALL5 = new Glamping(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
        try {
            llistaAllotjaments.afegirAllotjament(ALL5);
        } catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Sud";
        idAllotjament = "ALL6";
        mida = 20f;
        habitacions =  2;
        placesPersones = 4;
        boolean terrassaBarbacoa = true;

        MobilHome ALL6 = new MobilHome(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
        try {
            llistaAllotjaments.afegirAllotjament(ALL6);
        } catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }
        Acc1.afegirAllotjament(ALL1);
        Acc1.afegirAllotjament(ALL2);
        Acc2.afegirAllotjament(ALL1);
        Acc2.afegirAllotjament(ALL2);
        Acc3.afegirAllotjament(ALL3);
        Acc4.afegirAllotjament(ALL3);
        Acc5.afegirAllotjament(ALL4);
        Acc6.afegirAllotjament(ALL4);
        Acc7.afegirAllotjament(ALL5);
        Acc7.afegirAllotjament(ALL6);
        Acc8.afegirAllotjament(ALL5);
        Acc8.afegirAllotjament(ALL6);
        Acc9.afegirAllotjament(ALL2);
        Acc10.afegirAllotjament(ALL2);
        Acc11.afegirAllotjament(ALL6);
        Acc12.afegirAllotjament(ALL6);
    }

}


