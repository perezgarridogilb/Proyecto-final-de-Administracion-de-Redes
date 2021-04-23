package modelo;
import controlador.Controlador;
/**
 * Esta clase es la que se encarga de desempeñar la funcion de servidor
 * Debe de poder leer del archivo que ya este hecho.
 */

public class Sistema {
    //atributos
    private CifradoRSA miCifradoRSA;
    private Controlador miControlador;
    //constructor
    public Sistema(CifradoRSA miCifrado){
        this.miCifradoRSA = miCifrado;
    }
    //metodos
    //metodos getter and setter
    public void setControlador(Controlador miControlador){
        this.miControlador = miControlador;
    }
}
