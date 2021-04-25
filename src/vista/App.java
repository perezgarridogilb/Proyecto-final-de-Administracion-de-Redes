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
    JTextField a, b, c, d, eField;
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
        title1 = BorderFactory.createTitledBorder(blackline, "AdministraciÃ³n de Redes");
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

        matricula = new JLabel("Nombre:");
        matricula.setBounds(20, 80, 200, 20);
        subPanel1.add(matricula);

        alumno = new JLabel("2.- Generar llaves");
        alumno.setBounds(20, 110, 200, 20);
        subPanel1.add(alumno);

        llavePublica = new JLabel("Llave pÃºblica:");
        llavePublica.setBounds(20, 170, 200, 20);
        subPanel1.add(llavePublica);

        llavePrivada = new JLabel("Llave privada:");
        llavePrivada.setBounds(20, 210, 200, 20);
        subPanel1.add(llavePrivada);

        alumno = new JLabel("3.- Solicitar calificaciÃ³n");
        alumno.setBounds(20, 240, 200, 20);
        subPanel1.add(alumno);

        alumno = new JLabel("4.- Generar hash");
        alumno.setBounds(20, 300, 200, 20);
        subPanel1.add(alumno);

        alumno = new JLabel("5.- Encriptar el hash");
        alumno.setBounds(20, 360, 200, 20);
        subPanel1.add(alumno);

        alumno = new JLabel("6.- Enviar solicitud");
        alumno.setBounds(20, 420, 200, 20);
        subPanel1.add(alumno);

        calificacionEncriptada = new JLabel("CalificaciÃ³n encriptada:");
        calificacionEncriptada.setBounds(20, 480, 200, 20);
        subPanel1.add(calificacionEncriptada);

        crearLlaves = new JButton("Crear llaves");
        crearLlaves.setBounds(20, 140, 100, 20);
        crearLlaves.setBackground(Color.green);
        subPanel1.add(crearLlaves);
        crearLlaves.addActionListener(this);

        generarFuncionHash = new JButton("Generar");
        generarFuncionHash.setBounds(20, 330, 90, 20);
        generarFuncionHash.setBackground(Color.green);
        subPanel1.add(generarFuncionHash);
        generarFuncionHash.addActionListener(this);

        encriptarFuncionHash = new JButton("Encriptar");
        encriptarFuncionHash.setBounds(20, 390, 90, 20);
        encriptarFuncionHash.setBackground(Color.green);
        subPanel1.add(encriptarFuncionHash);
        encriptarFuncionHash.addActionListener(this);

        encriptarMensaje = new JButton("Enviar");
        encriptarMensaje.setBounds(20, 450, 80, 20);
        encriptarMensaje.setBackground(Color.green);
        subPanel1.add(encriptarMensaje);
        encriptarMensaje.addActionListener(this);

        solicitarCalificacion = new JButton("Solicitar");
        solicitarCalificacion.setBounds(20, 270, 90, 20);
        solicitarCalificacion.setBackground(Color.green);
        subPanel1.add(solicitarCalificacion);
        solicitarCalificacion.addActionListener(this);

        desencriptarCalificacion = new JButton("Desencriptar");
        desencriptarCalificacion.setBounds(20, 510, 110, 20);
        desencriptarCalificacion.setBackground(Color.green);
        subPanel1.add(desencriptarCalificacion);

        calificacion = new JLabel("CalificaciÃ³n:");
        calificacion.setBounds(20, 540, 200, 20);
        subPanel1.add(calificacion);

        b = new JTextField();
        b.setBounds(130, 80, 170, 20);
        subPanel1.add(b);

        a = new JTextField();
        a.setBounds(130, 170, 170, 20);
        subPanel1.add(a);

        c = new JTextField();
        c.setBounds(130, 210, 170, 20);
        subPanel1.add(c);

        d = new JTextField();
        d.setBounds(180, 480, 170, 20);
        subPanel1.add(d);

        eField = new JTextField();
        eField.setBounds(180, 540, 40, 20);
        subPanel1.add(eField);

    }

    public void sistemaEscolar() {

        subPanel2 = new JPanel();
        subPanel2.setBorder(BorderFactory.createTitledBorder("Sistema"));
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

        llavePublica = new JLabel("Llave pÃºblica:");
        llavePublica.setBounds(20, 140, 200, 20);
        subPanel2.add(llavePublica);

        llavePrivada = new JLabel("Llave privada:");
        llavePrivada.setBounds(20, 180, 200, 20);
        subPanel2.add(llavePrivada);

        llavePrivada = new JLabel("Solicitud:");
        llavePrivada.setBounds(20, 220, 200, 20);
        subPanel2.add(llavePrivada);

        llavePrivada = new JLabel("CalificaciÃ³n a enviar:");
        llavePrivada.setBounds(20, 260, 200, 20);
        subPanel2.add(llavePrivada);

        a = new JTextField();
        a.setBounds(130, 140, 170, 20);
        subPanel2.add(a);

        c = new JTextField();
        c.setBounds(130, 180, 170, 20);
        subPanel2.add(c);

        d = new JTextField();
        d.setBounds(130, 220, 170, 20);
        subPanel2.add(d);

        eField = new JTextField();
        eField.setBounds(160, 260, 40, 20);
        subPanel2.add(eField);

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
            JOptionPane.showMessageDialog(null, "Se generaron correctamente","Llaves listas",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //metodo para generar nuestra firma digital
    private void generarHash(){
        String nombre = b.getText();
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
        if(alumno != null) {
        	//debemos de poner la calificacion en el text field indicado y el nombre del alumno tambien lo debemos de poner en el text field
        	
        	JOptionPane.showMessageDialog(null, "Ya puede solicitar calificacion","Calificacion lista",JOptionPane.INFORMATION_MESSAGE);
        }else {
        	//mostramos un erro
        	JOptionPane.showMessageDialog(null,"Fallo al enviar el mensaje" , "Envio", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //metodo para solicitar la calificacion desde nuestro sistema
    private void solicitar() {
    	//le pasamos la calificacion desde el text field que la vaya a contener
    	byte[] calificacion = miControlador.solicitarCalificacion(a.getText());
    	if(calificacion != null) {
    		//debemos de poner la calificacion encriptada en el text field que corresponda
    		
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
    		
    	}
    	
    }

    //metodos setter
    public void setControlador(Controlador miControlador){
        this.miControlador = miControlador;
    }

}