package modelo;
import java.security.KeyPair;

import controlador.Controlador;
/**
 * Esta classe desempeña el rol de cliente solo debe de poder enviar su mensaje
 */
public class Alumno {
    //atributos
    private CifradoRSA miCifradoRSA;
    private Controlador miControlador;
    
    //constructor
    public Alumno(CifradoRSA miCifrado){
        this.miCifradoRSA = miCifrado;
    }
    
    //metodos
    public KeyPair generarLlaves(){
        return miCifradoRSA.generarLlaves();
    }

    //metodos getter and setter
    public void setControlador(Controlador miControlador){
        this.miControlador = miControlador;
    }
}
