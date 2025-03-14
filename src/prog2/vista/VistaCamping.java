package prog2.vista;

import prog2.model.Camping;

public class VistaCamping {

    private Camping camping;

    //Constructor:
    public VistaCamping(String nom_){

        this.camping = new Camping(nom_);
        this.camping.inicialitzaDadesCamping();

    }

    public void gestioCamping(){
        //Encara no puc fer res, no se com funciona Menu.
    }
}

