package controlador;
import java.security.KeyPair;

import modelo.*;
import vista.App;

public class Controlador {
    //atributos
    private FirmaDigital miFirmaDigital;
    private App miApp;
    private Alumno miAlumno;
    private Sistema miSistema;
    private byte[] firmaEncriptada;
    private byte[] calificacionEncriptada;
    //constructor
    
    //metodos
    public KeyPair generarLlavesAlumno(){
        return miAlumno.generarLlaves();
    }
    
    public KeyPair generarLlavesSistema(){
        return miSistema.generarLlaves();
    }

    public int generarHash(String nombreAlumno){
        miFirmaDigital.setMensaje(nombreAlumno);
        return miFirmaDigital.hash();
    }

    public int encriptarAlumno(){
        firmaEncriptada = miAlumno.encriptar(miFirmaDigital.getMensajeCodificado());
        if(firmaEncriptada != null){
            return 1;
        }else{
            return -1;
        }
    }

    public String[] enviar(){
        return miSistema.recibirAlumno(firmaEncriptada,miAlumno.getLlavePrivada());
    }
    
    public byte[] solicitarCalificacion(String calificacion) {
    	this.calificacionEncriptada = miSistema.calificacionEncriptada(calificacion);
    	return this.calificacionEncriptada;
    }
    public byte[] desencriptarCalificacion() {
    	return miAlumno.desencriptarCalificacion(this.calificacionEncriptada,miSistema.getLlavePrivada());
    }

    //metodos setter
    public void setFirmaDigital(FirmaDigital firmaDigital){
        this.miFirmaDigital = firmaDigital;
    }
    public void setAppVista(App miApp){
        this.miApp = miApp;
    }
    public void setAlumno(Alumno miAlumno){
        this.miAlumno = miAlumno;
    }
    public void setSistema(Sistema miSistema){
        this.miSistema = miSistema;
    }
    public byte[] getCalificacionEncriptada() {
    	return this.calificacionEncriptada;
    }
}
