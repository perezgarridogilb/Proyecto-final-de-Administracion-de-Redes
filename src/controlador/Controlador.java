package controlador;
import modelo.*;
import vista.App;

public class Controlador {
    //atributos
    private FirmaDigital miFirmaDigital;
    private CifradoRSA miCifradoRSAAlumno;
    private CifradoRSA miCifradoRSASistema;
    private App miApp;
    //constructor
    //metodos
    
    
    //metodos setter
    public void setFirmaDigital(FirmaDigital firmaDigital){
        this.miFirmaDigital = firmaDigital;
    }
    public void setCifradoRSAAlumno(CifradoRSA cifrado1){
        this.miCifradoRSAAlumno = cifrado1;
    }
    public void setCifradoRSASistema(CifradoRSA cifrado2){
        this.miCifradoRSASistema = cifrado2;
    }
    public void setAppVista(App miApp){
        this.miApp = miApp;
    }
}
