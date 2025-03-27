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
        do {

            menu.mostrarMenu();
            opcio=menu.getOpcio(sc);


            switch(opcio) {
                case MENU_PRINCIPAL_OPCIO1:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[0]);
                    System.out.println("A continuació es mostraràn els allotjaments del càmping");
                    System.out.println(this.camping.llistarAllotjaments("Operatiu"));
                    System.out.println(this.camping.llistarAllotjaments("No Operatiu"));
                    break;

                case MENU_PRINCIPAL_OPCIO2:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[1]);
                    System.out.println("A continuació es mostraràn els allotjaments operatius del càmping");
                    System.out.println(this.camping.llistarAllotjaments("Operatiu"));
                    break;

                case MENU_PRINCIPAL_OPCIO3:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[2]);
                    System.out.println("A continuació es mostraràn els allotjaments no operatius del càmping");
                    System.out.println(this.camping.llistarAllotjaments("No Operatiu"));
                    break;
                case MENU_PRINCIPAL_OPCIO4:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[3]);
                    break;
                case MENU_PRINCIPAL_OPCIO5:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[4]);
                    break;
                case MENU_PRINCIPAL_OPCIO6:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[5]);
                    break;
                case MENU_PRINCIPAL_OPCIO7:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[6]);
                    break;
                case MENU_PRINCIPAL_OPCIO8:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[7]);
                    break;
                case MENU_PRINCIPAL_OPCIO9:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[8]);
                    break;
                case MENU_PRINCIPAL_OPCIO10:

                    System.out.println("Has triat la opció: "+descMenuPrincipal[9]);
                    break;
                case MENU_PRINCIPAL_OPCIO11:
                    System.out.println("Has triat la opció: "+descMenuPrincipal[10]);

                    break;
                case MENU_PRINCIPAL_OPCIO12:
                    System.out.println("Has triat la opció: "+descMenuPrincipal[11]);

                    break;

                case MENU_PRINCIPAL_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio!= ExempleMenu.OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);
    }
}

