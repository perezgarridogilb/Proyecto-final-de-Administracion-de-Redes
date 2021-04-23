package controlador;

import modelo.FirmaDigital;
import modelo.CifradoRSA;

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

        //hacemos la relacion del controlador con las demas clases y viceversa
    }
}
