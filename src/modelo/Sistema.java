package modelo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.KeyPair;
import java.security.PrivateKey;

import controlador.Controlador;
/**
 * Esta clase es la que se encarga de desempeñar la funcion de servidor
 * Debe de poder leer del archivo que ya este hecho.
 */

public class Sistema {
    //atributos
    private CifradoRSA miCifradoRSA;
    private Controlador miControlador;
    private FirmaDigital miFirma;
    //constructor
    public Sistema(CifradoRSA miCifrado){
        this.miCifradoRSA = miCifrado;
    }
    
    //metodos
    public KeyPair generarLlaves(){
        return miCifradoRSA.generarLlaves();
    }

    public String[] recibirAlumno(byte[] mensaje, PrivateKey llavePrivadaAlumno){
        byte[] mensajeSinRSA = miCifradoRSA.desencriptar(mensaje, llavePrivadaAlumno);
        //aqui debemos de traer todos los datos de alumnos en nuestro archivo para aplicarles la firma digital y
        //comprobar que el alumno este en el sistema
        String[] alumno = recuperarAlumnos(mensajeSinRSA);
        if(alumno != null) {
        	return alumno;
        }else {
        	return null;
        }
    }
    
    public byte[] calificacionEncriptada(String calificacion) {
    	return miCifradoRSA.encriptar(calificacion.getBytes());
    }
    
    //funcion que lee el archivo y compara el alumno que llego con firma digital con los que tenemos en bd
    //en caso de ser un alumno entonces regresa el nombre del alumno y la calificacion correspondiente
    private String[] recuperarAlumnos(byte[] mensaje){
        File archivo = new File("C:/Users/crist/Documents/BUAP/Octavosemestre/AdmonRedes/proyecto/Proyecto-final-de-Administracion-de-Redes/src","calificaciones.txt");
        try{
        
        	FileReader leible = new FileReader(archivo);
        	BufferedReader entrada = new BufferedReader(leible);
        	String linea;
        	//leemos el archivo linea a linea
        	while((linea = entrada.readLine()) != null){
        	
        		String[] nombreCalificacion = linea.split(" ");
        		String soloNombre = "";
        		//lo siguiente espara que podamos tener el nombre de un alumno sin su califiacion y aplicar la firma digital para comparar
        		for(int i=0;i<nombreCalificacion.length-1;i++) {
        			if(i == nombreCalificacion.length-1) {
        				soloNombre = soloNombre + nombreCalificacion[i];
        			}
        			soloNombre = soloNombre + nombreCalificacion[i] + " ";
        		}
        		//aplicamos la firma digital
        		miFirma.setMensaje(soloNombre);
        		miFirma.hash();
        		//comparamos con el mensaje sin rsa que recibimos como parametro
        		if( miFirma.getMensajeCodificado().equals(mensaje) ) {
        			return nombreCalificacion;
        		}
        	}
        	return null;

        }catch(Exception err){
        	System.out.println("Error de: " + err.getMessage());
        	return null;
    	}
    }
    //metodos getter and setter
    public void setControlador(Controlador miControlador){
        this.miControlador = miControlador;
    }
    public PrivateKey getLlavePrivada() {
    	return miCifradoRSA.getLlavePrivada();
    }
}
