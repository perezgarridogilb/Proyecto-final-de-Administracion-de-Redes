package modelo;
import java.security.KeyPair;
import java.security.PrivateKey;

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
    public byte[] encriptar(byte[] mensaje){
        return miCifradoRSA.encriptar(mensaje);
    }
    public byte[] desencriptarCalificacion(byte[] calificacion, PrivateKey llavePrivada) {
    	return miCifradoRSA.desencriptar(calificacion, llavePrivada);
    }

    //metodos getter and setter
    public void setControlador(Controlador miControlador){
        this.miControlador = miControlador;
    }
    public PrivateKey getLlavePrivada(){
        return this.miCifradoRSA.getLlavePrivada();
    }
}
