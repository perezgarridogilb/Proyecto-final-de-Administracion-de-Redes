package vista;
/* Firma Digital */
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.StringTokenizer;

import javax.imageio.*;
import controlador.Controlador;

public class App extends JFrame implements ActionListener {
    private Controlador miControlador;
    private JPanel mainPanel, subPanel1, subPanel2;
    JLabel FirmaDigital, usuario, alumno, sistemaEscolar, base, matricula, llavePublica, llavePrivada,
            calificacionEncriptada, calificacion, resultado;
    JTextField textFieldNombreAlumno, textFieldLLavePublicaAlumno, textFieldLLavePrivadaAlumno, textFieldCalificacionEncriptada,textFieldCalificacion,textFieldLLavePublicaServidor, textFieldLLavePrivadaServidor, textFieldSolicitudServidor, textFieldCalificacionAEnviarServidor;
    JButton crearLlaves, solicitarCalificacion, generarFuncionHash, encriptarFuncionHash, encriptarMensaje,
            desencriptarCalificacion;
    Border blackline, etched, raisedbevel, loweredbevel, empty;
    TitledBorder title1;
    String pth = "/Users/MacBook/Desktop/Proyecto final de AdministracioÌ�n de Redes/circled-user-icon-user-pro-icon-11553397069rpnu1bqqup.png";

    public App() {

        super("Firma Digital");
        empty = BorderFactory.createEmptyBorder();
        setSize(770, 770);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Construyendo JPanel principal con GridLayout de 1 fila y 2 columnas */
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#fefea2"));
        title1 = BorderFactory.createTitledBorder(blackline, "Administraci\u00f3n de Redes");
        title1.setTitleJustification(TitledBorder.CENTER);
        mainPanel.setBorder(title1);
        mainPanel.setLayout(new GridLayout(1, 2));

        /* Armando JPanel 1 y 2 con GridLayout de 1 fila y 1 columna */
        alumno();
        sistemaEscolar();
        mainPanel.add(subPanel1);
        mainPanel.add(subPanel2);

        /* Preparar el contenedor para que se agreguen los componentes */
        Container pane = getContentPane();
        setContentPane(pane);
        pane.add(mainPanel);
    }

    public void alumno() {

        subPanel1 = new JPanel();
        subPanel1.setBackground(Color.decode("#fefea2"));
        subPanel1.setBorder(BorderFactory.createTitledBorder("Alumno"));
        subPanel1.setLayout(null);

        alumno = new JLabel("1.- Alumno");
        alumno.setBounds(20, 20, 200, 20);
        subPanel1.add(alumno);
        JLabel imageLogo = new JLabel();

        try {
            BufferedImage image = ImageIO.read(new File("./images/usuario.png"));
            image = (BufferedImage) getScaledImage(image, 37, 37);
            /* Setear la imagen al JLabel */
            imageLogo.setIcon(new ImageIcon(image));
        } catch (IOException ioexception) {
            System.err.println(ioexception);
        }

        imageLogo.setBounds(160, 20, 67, 67);
        subPanel1.add(imageLogo);

        imageLogo.setBounds(160, 20, 67, 67);
        subPanel1.add(imageLogo);

        matricula = new JLabel("Nombre:");
        matricula.setBounds(20, 80, 200, 20);
        subPanel1.add(matricula);

        alumno = new JLabel("2.- Generar llaves");
        alumno.setBounds(20, 110, 200, 20);
        subPanel1.add(alumno);

        llavePublica = new JLabel("Llave p\u00fablica:");
        llavePublica.setBounds(20, 180, 200, 20);
        subPanel1.add(llavePublica);

        llavePrivada = new JLabel("Llave privada:");
        llavePrivada.setBounds(20, 220, 200, 20);
        subPanel1.add(llavePrivada);

        alumno = new JLabel("3.- Solicitar calificacion");
        alumno.setBounds(20, 250, 200, 20);
        subPanel1.add(alumno);

        alumno = new JLabel("4.- Generar hash");
        alumno.setBounds(20, 310, 200, 20);
        subPanel1.add(alumno);

        alumno = new JLabel("5.- Encriptar el hash");
        alumno.setBounds(20, 370, 200, 20);
        subPanel1.add(alumno);

        alumno = new JLabel("6.- Enviar solicitud");
        alumno.setBounds(20, 430, 200, 20);
        subPanel1.add(alumno);

        calificacionEncriptada = new JLabel("Calificaci\u00f3n encriptada:");
        calificacionEncriptada.setBounds(20, 490, 200, 20);
        subPanel1.add(calificacionEncriptada);
        
        calificacion = new JLabel("Calificaci\u00f3n:");
        calificacion.setBounds(20, 550, 200, 20);
        subPanel1.add(calificacion);

        crearLlaves = new JButton("Crear llaves");
        crearLlaves.setBounds(20, 135, 100, 30);
        crearLlaves.setBackground(Color.green);
        subPanel1.add(crearLlaves);
        crearLlaves.addActionListener(this);

        generarFuncionHash = new JButton("Generar");
        File archivoImagenHash = new File("./images/baseline_pin_black_48dp.png");
        generarFuncionHash.setIcon(new ImageIcon(archivoImagenHash.getPath()));
        generarFuncionHash.setBounds(20, 335, 105, 30);
        generarFuncionHash.setBackground(Color.green);
        subPanel1.add(generarFuncionHash);
        generarFuncionHash.addActionListener(this);

        encriptarFuncionHash = new JButton("Encriptar");
        File archivoImagenEncripta = new File("./images/key.png");
        encriptarFuncionHash.setIcon(new ImageIcon(archivoImagenEncripta.getPath()));
        encriptarFuncionHash.setBounds(20, 395, 110, 30);
        encriptarFuncionHash.setBackground(Color.green);
        subPanel1.add(encriptarFuncionHash);
        encriptarFuncionHash.addActionListener(this);

        encriptarMensaje = new JButton("Enviar");
        File archivoImagen = new File("./images/send.png");
        encriptarMensaje.setIcon(new ImageIcon(archivoImagen.getPath()));
        encriptarMensaje.setBounds(20, 455, 100, 30);
        encriptarMensaje.setBackground(Color.green);
        subPanel1.add(encriptarMensaje);
        encriptarMensaje.addActionListener(this);

        solicitarCalificacion = new JButton("Solicitar");
        File archivoImagenCalificacion = new File("./images/updateTimeClock.png");
        solicitarCalificacion.setIcon(new ImageIcon(archivoImagenCalificacion.getPath()));
        solicitarCalificacion.setBounds(20, 275, 100, 30);
        solicitarCalificacion.setBackground(Color.green);
        subPanel1.add(solicitarCalificacion);
        solicitarCalificacion.addActionListener(this);

        desencriptarCalificacion = new JButton("Desencriptar");
        File archivoImagenDesencripta = new File("./images/lockOpen.png");
        desencriptarCalificacion.setIcon(new ImageIcon(archivoImagenDesencripta.getPath()));
        desencriptarCalificacion.setBounds(20, 515, 130, 30);
        desencriptarCalificacion.setBackground(Color.green);
        subPanel1.add(desencriptarCalificacion);
        desencriptarCalificacion.addActionListener(this);

        /* Aquí están los JTextField del alumno */
        
        textFieldNombreAlumno = new JTextField();
        textFieldNombreAlumno.setBounds(130, 80, 170, 25);
        subPanel1.add(textFieldNombreAlumno);

        textFieldLLavePublicaAlumno = new JTextField();
        textFieldLLavePublicaAlumno.setBounds(130, 180, 170, 25);
        subPanel1.add(textFieldLLavePublicaAlumno);

        textFieldLLavePrivadaAlumno = new JTextField();
        textFieldLLavePrivadaAlumno.setBounds(130, 220, 170, 25);
        subPanel1.add(textFieldLLavePrivadaAlumno);

        textFieldCalificacionEncriptada = new JTextField();
        textFieldCalificacionEncriptada.setBounds(180, 480, 170, 25);
        subPanel1.add(textFieldCalificacionEncriptada);

        textFieldCalificacion  = new JTextField();
        textFieldCalificacion.setBounds(180, 540, 40, 25);
        subPanel1.add(textFieldCalificacion);

    }

    public void sistemaEscolar() {

        subPanel2 = new JPanel();
        subPanel2.setBackground(Color.decode("#fefea2"));
        subPanel2.setBorder(BorderFactory.createTitledBorder("Sistema Escolar"));
        subPanel2.setLayout(null);

        sistemaEscolar = new JLabel("1.- Identifica el alumno");
        sistemaEscolar.setBounds(20, 20, 200, 20);
        subPanel2.add(sistemaEscolar);

        JLabel imageLogo = new JLabel();

        try {
            BufferedImage image = ImageIO.read(new File("./images/usuario.png"));
            image = (BufferedImage) getScaledImage(image, 37, 37);
            imageLogo.setIcon(new ImageIcon(image));
        } catch (IOException ioexception) {
            System.err.println(ioexception);
        }

        imageLogo.setBounds(160, 20, 67, 67);
        subPanel2.add(imageLogo);

        sistemaEscolar = new JLabel("2.- Generar llaves");
        sistemaEscolar.setBounds(20, 110, 200, 20);
        subPanel2.add(sistemaEscolar);

        llavePublica = new JLabel("Llave p\u00fablica:");
        llavePublica.setBounds(20, 140, 200, 20);
        subPanel2.add(llavePublica);

        llavePrivada = new JLabel("Llave privada:");
        llavePrivada.setBounds(20, 180, 200, 20);
        subPanel2.add(llavePrivada);

        llavePrivada = new JLabel("Solicitud:");
        llavePrivada.setBounds(20, 220, 200, 20);
        subPanel2.add(llavePrivada);

        llavePrivada = new JLabel("Calificaci\u00f3n a enviar:");
        llavePrivada.setBounds(20, 260, 200, 20);
        subPanel2.add(llavePrivada);

        /* Aquí están los JTextField del servicio escolar */
        
        textFieldLLavePublicaServidor = new JTextField();
        textFieldLLavePublicaServidor.setBounds(130, 140, 170, 25);
        subPanel2.add(textFieldLLavePublicaServidor);

        textFieldLLavePrivadaServidor = new JTextField();
        textFieldLLavePrivadaServidor.setBounds(130, 180, 170, 25);
        subPanel2.add(textFieldLLavePrivadaServidor);

        textFieldSolicitudServidor = new JTextField();
        textFieldSolicitudServidor.setBounds(130, 220, 170, 25);
        subPanel2.add(textFieldSolicitudServidor);

        textFieldCalificacionAEnviarServidor = new JTextField();
        textFieldCalificacionAEnviarServidor.setBounds(160, 260, 40, 25);
        subPanel2.add(textFieldCalificacionAEnviarServidor);

    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public void actionPerformed(ActionEvent evento) {
        //cuando se de click al boton de crear llaves
        if (evento.getSource() == crearLlaves) {
            generaLlaves();
        }
        //cuando se de click al boton de generar hash
        if(evento.getSource() == this.generarFuncionHash){
            generarHash();
        }
        //cuando se de click al boton de encriptar
        if(evento.getSource() == this.encriptarFuncionHash){
            encriptarAlumno();
        }
        //cuando se da click al boton de enviar
        if(evento.getSource() == this.encriptarMensaje){
        	enviar();
        }
        //cuando se da click al boton solicitar
        if(evento.getSource() == this.solicitarCalificacion) {
        	solicitar();
        }
        //cuando se da click al boton desencriptar
        if(evento.getSource() == this.desencriptarCalificacion) {
        	desencriptarCalificacion();
        }

    }

    //metodos
    
    //metodo para poder crear las llaves
    private void generaLlaves(){
        //llaves del alumno
        KeyPair llavesAlumno = miControlador.generarLlavesAlumno();
        PublicKey llavePublicaAlumno = llavesAlumno.getPublic();
        PrivateKey llavePrivadaAlumno = llavesAlumno.getPrivate();
        //llaves del sistema
        KeyPair llavesSistema = miControlador.generarLlavesSistema();
        PublicKey llavePublicaSistema = llavesSistema.getPublic();
        PrivateKey llavePrivadaSistema = llavesSistema.getPrivate();
        //validamos que no se haya generado eror
        if(llavesAlumno == null || llavesSistema == null){
            JOptionPane.showMessageDialog(null, "No se generaron las llaves","Error llaves",JOptionPane.ERROR_MESSAGE);
        }else{
            //aqui debemos de poner las llaves en los text field
        	this.textFieldLLavePrivadaAlumno.setText("" +llavePrivadaAlumno.getEncoded().toString());
        	this.textFieldLLavePublicaAlumno.setText("" + llavePublicaAlumno.getEncoded().toString());
        	this.textFieldLLavePublicaServidor.setText("" + llavePublicaSistema.getEncoded().toString());
        	this.textFieldLLavePrivadaServidor.setText("" + llavePrivadaSistema.getEncoded().toString());
            JOptionPane.showMessageDialog(null, "Se generaron correctamente","Llaves listas",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //metodo para generar nuestra firma digital
    private void generarHash(){
        String nombre = textFieldNombreAlumno.getText();
        int verificar = miControlador.generarHash(nombre);
        if(verificar == -1){
            JOptionPane.showMessageDialog(null, "Error al aplicar hash", "Falla firma digital", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Se genero correctamente", "Firma digital", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //metodo para encriptar con RSA la firma digital
    private void encriptarAlumno(){
        int verificar = miControlador.encriptarAlumno();
        if(verificar == 1){
            JOptionPane.showMessageDialog(null, "Se encripto de manera correcta", "RSA", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrio un error al encriptar la firma", "RSA", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //metodo para enviar datos al sistema
    private void enviar(){
        String [] alumno = miControlador.enviar();
        String nombre="";
        if(alumno != null) {
        	//debemos de poner la calificacion en el text field indicado y el nombre del alumno tambien lo debemos de poner en el text field
        	this.textFieldCalificacionAEnviarServidor.setText("" + alumno[alumno.length-1]);
        	for(int i=0;i<alumno.length-1;i++) {
        		nombre = nombre + alumno[i];
        	}
        	this.textFieldSolicitudServidor.setText(nombre);
        	JOptionPane.showMessageDialog(null, "Ya puede solicitar calificacion","Calificacion lista",JOptionPane.INFORMATION_MESSAGE);
        }else {
        	//mostramos un erro
        	JOptionPane.showMessageDialog(null,"Fallo al enviar el mensaje" , "Envio", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //metodo para solicitar la calificacion desde nuestro sistema
    private void solicitar() {
    	//le pasamos la calificacion desde el text field que la vaya a contener
    	byte[] calificacion = miControlador.solicitarCalificacion(this.textFieldCalificacionAEnviarServidor.getText());
    	if(calificacion != null) {
    		//debemos de poner la calificacion encriptada en el text field que corresponda
    		this.textFieldCalificacionEncriptada.setText("" + calificacion.toString());
    		JOptionPane.showMessageDialog(null, "Puede desencriptarla","Calificacion",JOptionPane.INFORMATION_MESSAGE);
    	}else {
    		//mostramos mensaje de algun error
    		JOptionPane.showMessageDialog(null,"No se pudo obtener encriptada","Calificacion",JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    //metodo para desencriptar calificacion
    private void desencriptarCalificacion() {
    	byte[] calDesencriptada = miControlador.desencriptarCalificacion();
    	if(calDesencriptada == null) {
    		JOptionPane.showMessageDialog(null,"No se pudo desencriptar","Calificacion",JOptionPane.ERROR_MESSAGE);
    	}
    	else {
    		//ponemos en text field la calificacion correspondiente
    		String cal = new String(calDesencriptada);
    		this.textFieldCalificacion.setText("" + cal);
    	}
    	
    }

    //metodos setter
    public void setControlador(Controlador miControlador){
        this.miControlador = miControlador;
    }

}
