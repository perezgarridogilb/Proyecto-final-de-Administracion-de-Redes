package modelo;
import javax.crypto.*;
import java.security.*;
import controlador.Controlador;
/**
 * En esta clase pondremos funciones que nos permiten encriptar
 * cualquier mensaje y desencriptarlo así como de generar llaves publicas y privadas
 */

public class CifradoRSA {
    //atributos
    private static Cipher rsa;
    private PublicKey miLlavePublica;
    private PrivateKey miLlavePrivada;
    private Controlador miControlador;
    //metodos
    //metodo que nos genera las llaves
    public int generarLlaves(){
        try{
            KeyPairGenerator generadorKeys = KeyPairGenerator.getInstance("RSA");
            KeyPair miKey = generadorKeys.generateKeyPair();
            this.miLlavePublica = miKey.getPublic();
            this.miLlavePrivada = miKey.getPrivate();
        }catch(Exception err){
            System.out.println("Error de: " + err.getMessage());
        }
        return 0;
    }
    //metodo que nos ayudará a encriptar un mensaje con RSA
    public byte[] encriptar(byte[] mensaje){
        byte[] encriptadoRSA;
        try{

            rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			rsa.init(Cipher.ENCRYPT_MODE, this.miLlavePublica);
			//encriptadoRSA es lo que se envia finalmente para después ser desencriptado
			encriptadoRSA = rsa.doFinal(mensaje);

        }catch(Exception err){
            System.out.println("Error de: " + err.getMessage());
            return null;
        }

        return encriptadoRSA;
    }

    //metodo que nos ayudara a desencriptar un mensaje encriptado con RSA
    public byte[] desencriptar(byte[] mensajeEncriptado,PrivateKey llavePrivada) {
		byte[] mensajeDesencriptado;
		try {
			
			rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			rsa.init(Cipher.DECRYPT_MODE, llavePrivada);
			mensajeDesencriptado = rsa.doFinal(mensajeEncriptado);
			
		}catch(Exception err) {
			System.out.println("Error de: " + err.getMessage());
			return null;
		}
		
		return mensajeDesencriptado;
	}

    //metodo que nos regresa la llave publica
	public PublicKey getLlavePublica() {
		return this.miLlavePublica;
	}
	
	//metodo que nos regresa la llave privada
	public PrivateKey getLlavePrivada() {
		return this.miLlavePrivada;
	}
    public void setControlador(Controlador miControlador){
        this.miControlador = miControlador;
    }
}
