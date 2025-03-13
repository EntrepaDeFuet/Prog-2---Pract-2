package prog2.model;

import prog2.vista.vista.ExcepcioReserva;

import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDate;



public class Camping implements InCamping {
    //Atributs
    private String nom;
    private ArrayList<Allotjament> allotjaments = new ArrayList<Allotjament>();
    private ArrayList<Client> clients = new ArrayList<Client>();
    private LlistaReserves reserves = new LlistaReserves();

    // Constructor:
    public Camping(String nom) {
        this.nom = nom;
    }

    //Getters:
    public LlistaReserves getLlistaReserves() {

        return reserves;
    }

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

    public ArrayList<Client> getLlistaClients() {

        return clients;
    }

    public int getNumAllotjaments() {

        return allotjaments.size();
    }

    public int getNumReserves() {

        return reserves.getNumReserves();
    }

    public int getNumClients() {

        return clients.size();
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
    public boolean clientRepetit(String dni_){

        boolean repetit = false;
        Iterator <Client> itrClients = clients.iterator();

        while(itrClients.hasNext() && !repetit){
            repetit = itrClients.next().getDni().equals(dni_);
        }
        return repetit;
    }

    public void afegirClient(String nom_, String dni_) throws ExcepcioReserva {

        if(!clientRepetit(dni_)) {

            Client clientNou = new Client(nom_, dni_);
            clients.addLast(clientNou);

        } else {

            throw new ExcepcioReserva ("Aquest client ja existeix.");
        }

    }
    //Afegir allotjaments:
    //Aquests mètodes revisen primerament si la llista d'allotjaments està buida per evitar que la funció allotjament repetit falli.
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {

        if(allotjaments.isEmpty()){

            Parcela parcelaNova = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
            allotjaments.addLast(parcelaNova);

        }
        else if (!allotjamentRepetit(idAllotjament_)) {

            Parcela parcelaNova = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
            allotjaments.addLast(parcelaNova);

        } else {
            System.out.println("Ja existeix un allotjament amb aquesta Id.");
        }
    }

    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {

        if(allotjaments.isEmpty()){

            Bungalow bungalowNou = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
            allotjaments.addLast(bungalowNou);

        }
        else if (!allotjamentRepetit(idAllotjament_)) {

            Bungalow bungalowNou = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
            allotjaments.addLast(bungalowNou);

        } else {
            System.out.println("Ja existeix un allotjament amb aquesta Id.");
        }
    }

    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                                      int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                                      boolean serveisExtra, String codiWifi) {

        if(allotjaments.isEmpty()){

            BungalowPremium bungalowPremiumNou = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
            allotjaments.addLast(bungalowPremiumNou);

        }
        else if (!allotjamentRepetit(idAllotjament_)) {

            BungalowPremium bungalowPremiumNou = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
            allotjaments.addLast(bungalowPremiumNou);

        } else {
            System.out.println("Ja existeix un allotjament amb aquesta Id.");
        }
    }

    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               String material, boolean casaMascota) {

        if(allotjaments.isEmpty()){

            Glamping glampingNou = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
            allotjaments.addLast(glampingNou);

        }
        else if (!allotjamentRepetit(idAllotjament_)) {

            Glamping glampingNou = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
            allotjaments.addLast(glampingNou);

        } else {
            System.out.println("Ja existeix un allotjament amb aquesta Id.");
        }

    }

    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                                boolean terrassaBarbacoa) {

        if(allotjaments.isEmpty()){

            MobilHome mobilHomeNou = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
            allotjaments.addLast(mobilHomeNou);

        }
        else if (!allotjamentRepetit(idAllotjament_)) {

            MobilHome mobilHomeNou = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
            allotjaments.addLast(mobilHomeNou);

        } else {
            System.out.println("Ja existeix un allotjament amb aquesta Id.");
        }
    }

    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {

        boolean condicio = false;
        Allotjament allotjamentActual;
        Client clientActual;

        clientActual = buscaClient(dni_);
        allotjamentActual = buscaAllotjament(id_);

        if(allotjamentActual.correcteFuncionament()) {

            reserves.afegirReserva(allotjamentActual, clientActual, dataEntrada, dataSortida);
        } else {
            throw new ExcepcioReserva("La reserva de l'allotjament amb id "+id_+ " per el client "+clientActual.getNom()+ " amb DNI: "+clientActual.getDni()+ "" +
                    " No s'ha pogut efectuar degut al incorrecte funcionament de l'allotjament.");
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
    public Allotjament buscaAllotjament(String id_) throws ExcepcioReserva{

        Allotjament allotjamentActual = null;
        boolean condicio=false;

        if (allotjamentRepetit(id_)){
            Iterator<Allotjament> itrAllotjaments = allotjaments.iterator();

            while (itrAllotjaments.hasNext() && !condicio){

                allotjamentActual= itrAllotjaments.next();
                condicio = allotjamentActual.getId().equals(id_);
            }
        } else {
            throw new ExcepcioReserva("No existeix cap allotjament amb aquesta Id.");
        }

        return allotjamentActual;
    }
    //Busca dins els clients un client amb el mateix dni
    public Client buscaClient(String dni_) throws ExcepcioReserva{

        boolean condicio = false;
        Client clientActual = null;

        if (clientRepetit(dni_)) {

            Iterator<Client> itrClient = clients.iterator();

            while (itrClient.hasNext() && !condicio) {

                clientActual = itrClient.next();

                if (clientActual.getDni().equals(dni_)) {

                    condicio = true;

                }
            }
            return clientActual;
        } else {
            throw new ExcepcioReserva("El Dni"+ dni_+ "no coincideix amb el de cap client.");
        }
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




}


