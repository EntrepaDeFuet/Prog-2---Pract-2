package prog2.vista;

import prog2.model.Camping;

import java.util.Scanner;

public class VistaCamping {

    static private enum OpcionsMenuPrincipal {MENU_PRINCIPAL_OPCIO1,MENU_PRINCIPAL_OPCIO2,
        MENU_PRINCIPAL_OPCIO3,MENU_PRINCIPAL_OPCIO4,MENU_PRINCIPAL_OPCIO5, MENU_PRINCIPAL_OPCIO6,
        MENU_PRINCIPAL_OPCIO7,MENU_PRINCIPAL_OPCIO8, MENU_PRINCIPAL_OPCIO9, MENU_PRINCIPAL_OPCIO10,
        MENU_PRINCIPAL_OPCIO11, MENU_PRINCIPAL_OPCIO12, MENU_PRINCIPAL_SORTIR};

    static private String[] descMenuPrincipal={"Llistar la informació de tots els allotjaments",
            "Llistar la informació dels allotjaments operatius","Llistar la informació dels allotjaments no operatius",
            "Llistar la informació dels accessos oberts","Llistar la informació dels accessos tancats",
            "Llistar la informació de les incidències actuals","Afegir una incidència", "Eliminar una incidència",
            "Calcular i mostrar el número total d’accessos que proporcionen accessibilitat amb cotxe",
            "Calcular i mostrar el número total de metres quadrats d’asfalt dels accessos asfaltats.",
            "Guardar càmping","Recuperar càmping", "Sortir de l'aplicació"};

    private Camping camping;

    //Constructor:
    public VistaCamping(String nom_){

        this.camping = new Camping(nom_);
        this.camping.inicialitzaDadesCamping();

    }

    public void gestioCamping(){


        Menu<VistaCamping.OpcionsMenuPrincipal> menu=new Menu<VistaCamping.OpcionsMenuPrincipal>("Menu Principal", VistaCamping.OpcionsMenuPrincipal.values());
        Scanner sc = new Scanner(System.in);
        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuPrincipal);

        // Obtenim una opció des del menú i fem les accions pertinents
        VistaCamping.OpcionsMenuPrincipal opcio = null;
        int _num;
        String _idAllotjament,_data,_tipus;
        do {

            menu.mostrarMenu();
            opcio=menu.getOpcio(sc);


            switch(opcio) {
                case MENU_PRINCIPAL_OPCIO1:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[0]);
                    System.out.println("A continuació es mostraràn els allotjaments del càmping");
                    try {
                        System.out.println(this.camping.llistarAllotjaments("Operatiu"));
                        System.out.println(this.camping.llistarAllotjaments("No Operatiu"));
                    } catch (ExcepcioCamping e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case MENU_PRINCIPAL_OPCIO2:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[1]+"\n");
                    System.out.println("A continuació es mostraràn els allotjaments operatius del càmping:\n");
                    try {
                        System.out.println(this.camping.llistarAllotjaments("Operatiu"));
                    } catch (ExcepcioCamping e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case MENU_PRINCIPAL_OPCIO3:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[2]+"\n");
                    System.out.println("A continuació es mostraràn els allotjaments no operatius del càmping:\n");
                    try {
                        System.out.println(this.camping.llistarAllotjaments("No Operatiu"));
                    } catch (ExcepcioCamping e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case MENU_PRINCIPAL_OPCIO4:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[3]);
                    System.out.println("A continuació es mostraràn els accessos oberts del càmping:\n");
                    try {
                        System.out.println(this.camping.llistarAccessos("Obert"));
                    } catch (ExcepcioCamping e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case MENU_PRINCIPAL_OPCIO5:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[4]+"\n");
                    System.out.println("A continuació es mostraràn els accessos tancats del càmping:\n");
                    try {
                        System.out.println(this.camping.llistarAccessos("Tancat"));
                    } catch (ExcepcioCamping e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case MENU_PRINCIPAL_OPCIO6:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[5]+"\n");
                    System.out.println("A continuació es llistaràn les incidències actuals: \n");
                    try {
                        System.out.println(camping.llistarIncidencies());
                    } catch (ExcepcioCamping e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case MENU_PRINCIPAL_OPCIO7:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[6]+"\n");
                    System.out.println("Digues la Id de la incidència: ");
                    _num = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introdueix la Id del allotjament: ");
                    _idAllotjament = sc.nextLine();

                    System.out.println("Ara digues, és una incidència de 'Reparacio','Neteja' o 'Tancament'");
                    _tipus = sc.nextLine();
                    System.out.println("De quin dia és aquesta incidència? (dd/mm/aaaa)");
                    _data = sc.nextLine();
                    try {
                        camping.afegirIncidencia(_num, _tipus, _idAllotjament, _data);
                    } catch (ExcepcioCamping e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case MENU_PRINCIPAL_OPCIO8:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[7]+"\n");
                    System.out.println("A continuació es llistaràn les incidències actuals: \n");
                    try {
                        System.out.println(camping.llistarIncidencies());
                    } catch (ExcepcioCamping e){
                        System.err.println(e.getMessage());
                    }
                    System.out.println("Introdueix el número de la Incidència a eliminar.");
                    _num = sc.nextInt();
                    try{
                        camping.eliminarIncidencia(_num);
                    } catch (ExcepcioCamping e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case MENU_PRINCIPAL_OPCIO9:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[8]+"\n");
                    System.out.println("Número d'accessos disponibles per a vehicles: ");
                    System.out.println(camping.calculaAccessosAccessibles());
                    break;

                case MENU_PRINCIPAL_OPCIO10:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[9]+"\n");
                    System.out.println("Metres quadrats d'asfalt: ");
                    System.out.println(camping.calculaMetresQuadratsAsfalt());
                    break;

                case MENU_PRINCIPAL_OPCIO11:
                    System.out.println("Has triat la opció: "+descMenuPrincipal[10]+"\n");
                    try {
                        camping.save("Camping.dat");
                        System.out.println("S'ha guardat amb éxit el fitxer.");
                    } catch (ExcepcioCamping e){
                        System.err.println(e.getMessage());
                    }

                    break;
                case MENU_PRINCIPAL_OPCIO12:
                    System.out.println("Has triat la opció: "+descMenuPrincipal[11]+"\n");
                    try{
                        this.camping = Camping.load("Camping.dat");
                    } catch (ExcepcioCamping e){
                        System.err.println(e.getMessage());
                    }

                    break;

                case MENU_PRINCIPAL_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio!= VistaCamping.OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);
    }
}

