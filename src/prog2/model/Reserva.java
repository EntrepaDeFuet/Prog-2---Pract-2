package prog2.model;
import prog2.vista.vista.ExcepcioReserva;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class Reserva {
    private LocalDate entrada;
    private LocalDate sortida;
    private Client client;
    private Allotjament allotjament;

    public Reserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
        if(isReserva(allotjament,dataEntrada,dataSortida)) {
            setAllotjament_(allotjament);
            setClient(client);
            setDataEntrada(dataEntrada);
            setDataSortida(dataSortida);
        } else {
            throw new ExcepcioReserva("Les dates sol·licitades pel client "+ client.getNom() +" amb DNI: "+ client.getDni() +"\n no compleixen" +
                    " l'estada mínima per l'allotjament amb identificador " + allotjament.getId() + ".");

        }

    }

    //Getters:
    public LocalDate getDataEntrada(){
        return  entrada;
    }
    public LocalDate getDataSortida(){
        return sortida;
    }
    public Allotjament getAllotjament_(){
        return this.allotjament;
    }
    public Client getClient(){
        return this.client;
    }
    //Setters:
    public void setAllotjament_(Allotjament allotjament) {
        this.allotjament = allotjament;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public void setDataEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }
    public void setDataSortida(LocalDate sortida) {
        this.sortida = sortida;
    }

    //Altres:
    public String toString(){
        return "Allotjament reservat: " +this.allotjament.toString()+ "\n Client que ha fet la reserva: " + this.client.toString() + "\n Data d'entrada: "+ this.getDataEntrada().toString() + " Data de sortida:"+this.getDataSortida();
    }
    public static InAllotjament.Temp getTemporada_(LocalDate data){

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
    //Revisa si la reserva compleix amb l'estada mínima del allotjament i en cas negatiu retorna false.
    public boolean isReserva(Allotjament allotjament,LocalDate dataEntrada,LocalDate dataSortida){

        long estadaMinima_,estada;
        estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);

        return switch (getTemporada_(dataEntrada)) {
            case ALTA -> {
                estadaMinima_ = allotjament.getEstadaMinima(InAllotjament.Temp.ALTA);
                yield estada >= estadaMinima_;
            }
            case BAIXA -> {
                estadaMinima_ = allotjament.getEstadaMinima(InAllotjament.Temp.BAIXA);
                yield estada >= estadaMinima_;
            }
            default -> false;
        };
    }
}
