package prog2.model;

import prog2.vista.vista.ExcepcioReserva;

public class Client {
    private String nom;
    private String dni;

    public Client(String nom_ ,String dni) throws ExcepcioReserva{
        if (dniCorrecte(dni)) {
            this.setNom(nom_);
            this.setDni(dni);
        } else {

            throw new ExcepcioReserva ("El DNI ha de tenir 9 caràcters.");

        }
    }
    //Getters:
    public String getNom(){
        return this.nom;
    }
    public String getDni(){
        return this.dni;
    }

    //Setters:
    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Altres:
    public boolean dniCorrecte(String dni) {
        return dni.length() == 9;
    }

    public String toString() {
        return "Nom: " + getNom() + ", DNI: " + getDni();
    }
}