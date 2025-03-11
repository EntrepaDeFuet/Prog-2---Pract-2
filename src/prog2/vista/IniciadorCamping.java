package prog2.vista;

/**
 *
 * @author lauraigual
 */
public class IniciadorCamping {
    
    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        // Definim el nom del càmping
        String nomCamping = "Green";

        // Creem un objecte de la prog2.vista i li passem el nom del càmping
        VistaCamping vistaCamping = new VistaCamping(nomCamping);
     
        // Inicialitzem l'execució de la prog2.vista
        vistaCamping.gestioCamping();
    }
}
