package controlador;

import modelo.FirmaDigital;
import modelo.CifradoRSA;
import vista.App;

/**
 * Esta clase sirve para poder hacer la relación entre el modelo, la vista y el controlador
 */
public class Aplicacion {
    //metodo que nos ayuda a inicializar todo
    public void iniciarSistema(){
        //cramos las clases que usaremos
        Controlador miControlador = new Controlador();
        FirmaDigital miFirmaDigital = new FirmaDigital();
        CifradoRSA miCifradoAlumno = new CifradoRSA();
        CifradoRSA miCifradoSistema = new CifradoRSA();
        App miApp = new App();

        //hacemos la relacion del controlador con las demas clases y viceversa
        miControlador.setFirmaDigital(miFirmaDigital);
        miControlador.setCifradoRSAAlumno(miCifradoAlumno);
        miControlador.setCifradoRSASistema(miCifradoSistema);
        miControlador.setAppVista(miApp);

        miApp.setControlador(miControlador);
        miFirmaDigital.setControlador(miControlador);
        miCifradoAlumno.setControlador(miControlador);
        miCifradoSistema.setControlador(miControlador);
        //hacemos visible nuestra aplicacion es decir la vista
        miApp.setVisible(true);
    }
}
