package controlador;

import modelo.FirmaDigital;
import modelo.CifradoRSA;
import modelo.Alumno;
import modelo.Sistema;
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
        Alumno miAlumno = new Alumno(miCifradoAlumno);
        Sistema miSistema = new Sistema(miCifradoSistema);
        App miApp = new App();

        //hacemos la relacion del controlador con las demas clases y viceversa
        miControlador.setFirmaDigital(miFirmaDigital);
        miControlador.setAppVista(miApp);
        miControlador.setAlumno(miAlumno);
        miControlador.setSistema(miSistema);

        miApp.setControlador(miControlador);
        miFirmaDigital.setControlador(miControlador);
        miAlumno.setControlador(miControlador);
        miSistema.setControlador(miControlador);
        //hacemos visible nuestra aplicacion es decir la vista
        miApp.setVisible(true);
    }
}
