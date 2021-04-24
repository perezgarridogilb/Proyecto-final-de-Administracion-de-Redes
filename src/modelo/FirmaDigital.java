package modelo;
import java.security.*;
import controlador.Controlador;
/*
    Esta clase nos sirve para poder hacer la firma digital y usar la función hash
    al nombre de la persona que requiera de su calificacion
*/

public class FirmaDigital {
    //atributos
    private String mensaje;
    private byte[] mensajeCodificado;
    private Controlador miControlador;
    //constructor
    //metodos

    public int hash(){
        try{
            //aplicamos funcion hash con SHA
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(this.mensaje.getBytes());
            this.mensajeCodificado = md.digest();
        }catch(Exception err){
            System.out.println("Error de: " + err.getMessage());
            return -1;
        }
        return 1;
    }

    public byte[] getMensajeCodificado(){
        return this.mensajeCodificado;
    }
    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }
    public void setControlador(Controlador miControlador){
        this.miControlador = miControlador;
    }
}
