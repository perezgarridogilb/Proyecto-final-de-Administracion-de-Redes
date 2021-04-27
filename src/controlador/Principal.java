package controlador;
/**
 * Esta clase sirve para poder correr el programa
 */
public class Principal {
    public static void main(String[] args){
        /* Crear y mostrar el diálogo */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        Aplicacion miAplicacion = new Aplicacion();
        miAplicacion.iniciarSistema();
            }
        });
    }
}