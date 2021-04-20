/* Firma Digital */
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class App extends JFrame implements ActionListener {

    private JPanel mainPanel, subPanel1, subPanel2;
    JLabel FirmaDigital, usuario, alumno, sistemaEscolar, base, matricula, llavePublica, llavePrivada, calificacionEncriptada, calificacion,
            resultado;
    JTextField a, b, c, d, eField;
    JButton crearLlaves, solicitarCalificacion, generarFuncionHash, encriptarFuncionHash, encriptarMensaje,  desencriptarCalificacion;
    Border blackline, etched, raisedbevel, loweredbevel, empty;
    TitledBorder title1;
    String pth = "/Users/MacBook/Desktop/Proyecto final de Administración de Redes/circled-user-icon-user-pro-icon-11553397069rpnu1bqqup.png";

    public App() {

        super("Firma Digital");
        empty = BorderFactory.createEmptyBorder();
        setSize(770, 770);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Construyendo JPanel principal con GridLayout de 1 fila y 2 columnas */
        mainPanel = new JPanel();
        title1 = BorderFactory.createTitledBorder(blackline, "Administración de Redes");
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
        setVisible(true);
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

        llavePublica = new JLabel("Llave pública:");
        llavePublica.setBounds(20, 170, 200, 20);
        subPanel1.add(llavePublica);

        llavePrivada = new JLabel("Llave privada:");
        llavePrivada.setBounds(20, 210, 200, 20);
        subPanel1.add(llavePrivada);

        alumno = new JLabel("3.- Solicitar calificación");
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

        calificacionEncriptada = new JLabel("Calificación encriptada:");
        calificacionEncriptada.setBounds(20, 480, 200, 20);
        subPanel1.add(calificacionEncriptada);

        crearLlaves = new JButton("Crear llaves");
        crearLlaves.setBounds(20, 140, 100, 20);
        crearLlaves.setBackground(Color.green);
        subPanel1.add(crearLlaves);

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

        calificacion = new JLabel("Calificación:");
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

        llavePublica = new JLabel("Llave pública:");
        llavePublica.setBounds(20, 140, 200, 20);
        subPanel2.add(llavePublica);

        llavePrivada = new JLabel("Llave privada:");
        llavePrivada.setBounds(20, 180, 200, 20);
        subPanel2.add(llavePrivada);

        llavePrivada = new JLabel("Solicitud:");
        llavePrivada.setBounds(20, 220, 200, 20);
        subPanel2.add(llavePrivada);

        llavePrivada = new JLabel("Calificación a enviar:");
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

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
    
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
    
        return resizedImg;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == solicitarCalificacion) {

            String res1 = "a";
            eField.setText(res1); 

        }
    }

    public static void main(String[] args) {
        /* Crear y mostrar el diálogo */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new App();
            }
        });
    }
}