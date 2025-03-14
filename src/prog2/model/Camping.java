package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDate;



public class Camping implements InCamping {
    //Atributs
    private String nom;
    private ArrayList<Allotjament> allotjaments = new ArrayList<Allotjament>();
    private LlistaAccessos llistaAccessos;
    private  LlistaIncidencies llistaIncidencies;

    // Constructor:
    public Camping(String nom) {
        this.nom = nom;
    }

    //Getters:

    public float calculMidaTotalParceles() {
        float midaTotal = 0;

        Iterator itrAllotjaments = allotjaments.iterator();

        while (itrAllotjaments.hasNext()) {

            Allotjament allotjamentActual = (Allotjament) itrAllotjaments.next();

            if (allotjamentActual instanceof Parcela) {

                Parcela parcelaActual = (Parcela) allotjamentActual;
                midaTotal += parcelaActual.getMida();
            }
        }

        return midaTotal;
    }

    public String getNom() {

        return nom;
    }

    public ArrayList<Allotjament> getLlistaAllotjaments() {

        return allotjaments;
    }


    public int getNumAllotjaments() {

        return allotjaments.size();
    }

    //Com diu el nom revisa a allotjaments que el allotjament nou no estigui ja registrat. En el cas d'estar allotjaments buit
    //no funcionaria pero s'ha implementat a cadascun dels afegir "allotjament" una solució per a evitar-ho.
    public boolean allotjamentRepetit(String id_){

        boolean repetit = false;
        Iterator <Allotjament> itrAllotjaments = allotjaments.iterator();

        while(itrAllotjaments.hasNext() && !repetit){
            repetit = itrAllotjaments.next().getId().equals(id_);
        }


        return repetit;
    }

    //Afegir allotjaments:
    //Aquests mètodes revisen primerament si la llista d'allotjaments està buida per evitar que la funció allotjament repetit falli.
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {

        if(allotjaments.isEmpty()){

            Parcela parcelaNova = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
            allotjaments.add(parcelaNova);

        }
        else if (!allotjamentRepetit(idAllotjament_)) {

            Parcela parcelaNova = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
            allotjaments.add(parcelaNova);

        } else {
            System.out.println("Ja existeix un allotjament amb aquesta Id.");
        }
    }

    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {

        if(allotjaments.isEmpty()){

            Bungalow bungalowNou = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
            allotjaments.add(bungalowNou);

        }
        else if (!allotjamentRepetit(idAllotjament_)) {

            Bungalow bungalowNou = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
            allotjaments.add(bungalowNou);

        } else {
            System.out.println("Ja existeix un allotjament amb aquesta Id.");
        }
    }

    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                                      int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                                      boolean serveisExtra, String codiWifi) {

        if(allotjaments.isEmpty()){

            BungalowPremium bungalowPremiumNou = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
            allotjaments.add(bungalowPremiumNou);

        }
        else if (!allotjamentRepetit(idAllotjament_)) {

            BungalowPremium bungalowPremiumNou = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
            allotjaments.add(bungalowPremiumNou);

        } else {
            System.out.println("Ja existeix un allotjament amb aquesta Id.");
        }
    }

    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               String material, boolean casaMascota) {

        if(allotjaments.isEmpty()){

            Glamping glampingNou = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
            allotjaments.add(glampingNou);

        }
        else if (!allotjamentRepetit(idAllotjament_)) {

            Glamping glampingNou = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
            allotjaments.add(glampingNou);

        } else {
            System.out.println("Ja existeix un allotjament amb aquesta Id.");
        }

    }

    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                                boolean terrassaBarbacoa) {

        if(allotjaments.isEmpty()){

            MobilHome mobilHomeNou = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
            allotjaments.add(mobilHomeNou);

        }
        else if (!allotjamentRepetit(idAllotjament_)) {

            MobilHome mobilHomeNou = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
            allotjaments.add(mobilHomeNou);

        } else {
            System.out.println("Ja existeix un allotjament amb aquesta Id.");
        }
    }

    //El mètode recorre tots els allotjaments registrats i en cas d'obtindre un true a correctefuncionament suma 1 a comptador.
    public int calculAllotjamentsOperatius() {
        int comptador = 0;
        Allotjament allotjamentActual;

        Iterator<Allotjament> itrAllotjament = allotjaments.iterator();

        while(itrAllotjament.hasNext()){

            allotjamentActual = itrAllotjament.next();

            if(allotjamentActual.correcteFuncionament()){
                comptador +=1;
            }
        }

        return comptador;
    }
    public Allotjament getAllotjamentEstadaMesCurta(){

        Allotjament allotjamentActual, allotjamentMinim;
        Iterator <Allotjament> itrAllotjament = allotjaments.iterator();

        allotjamentMinim = itrAllotjament.next();

        while(itrAllotjament.hasNext()){

            allotjamentActual = itrAllotjament.next();

            if (allotjamentActual.getEstadaMinima(InAllotjament.Temp.BAIXA) < allotjamentMinim.getEstadaMinima(InAllotjament.Temp.BAIXA)){
                allotjamentMinim = allotjamentActual;
            }

        }
        return allotjamentMinim;
    }
    //busca dins els allotjaments un allotjament amb la mateixa id.
    public Allotjament buscaAllotjament(String id_) throws ExcepcioCamping{

        Allotjament allotjamentActual = null;
        boolean condicio=false;

        if (allotjamentRepetit(id_)){
            Iterator<Allotjament> itrAllotjaments = allotjaments.iterator();

            while (itrAllotjaments.hasNext() && !condicio){

                allotjamentActual= itrAllotjaments.next();
                condicio = allotjamentActual.getId().equals(id_);
            }
        } else {
            throw new ExcepcioCamping("No existeix cap camping amb aquesta id.");
        }

        return allotjamentActual;
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
    public Incidencia buscaIncidencia(int num){
        return this.llistaIncidencies.buscaIncidencia;
    }


    public void afegirIncidencia(int num, String tipus, String idAllotjament, String data) throws ExcepcioCamping {

        Allotjament allotjamentActual = buscaAllotjament(idAllotjament);
        this.llistaIncidencies.afegirIncidencia(num, tipus, allotjamentActual, data);
        this.llistaAccessos.actualitzarEstatAccesos();


    }


    public void eliminarIncidencia(int num) throws ExcepcioCamping {

    }
}


