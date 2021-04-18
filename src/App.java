
/* Firma Digital */
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class App extends JFrame implements ActionListener {

    private JPanel mainPanel, subPanel1, subPanel2;
    JLabel FirmaDigital, usuario, alumno, base, matricula, llavePublica, llavePrivada, calificacionEncriptada, calificacion,
            resultado;
    JTextField a, b, c, d, eField;
    JButton crearLlaves, solicitarCalificacion, desencriptarCalificacion;
    Border blackline, etched, raisedbevel, loweredbevel, empty;
    TitledBorder title1;

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

        // Setting up the container ready for the components to be added.
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
        
        //usuario.setIcon(new ImageIcon("/Users/MacBook/Desktop/Proyecto final de Administración de Redes/usuario.png"));

        matricula = new JLabel("Matrícula:");
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

        calificacionEncriptada = new JLabel("Calificación encriptada:");
        calificacionEncriptada.setBounds(20, 450, 200, 20);
        subPanel1.add(calificacionEncriptada);

        crearLlaves = new JButton("Crear llaves");
        crearLlaves.setBounds(20, 140, 100, 20);
        crearLlaves.setBackground(Color.green);
        subPanel1.add(crearLlaves);

        solicitarCalificacion = new JButton("Solicitar calificación");
        solicitarCalificacion.setBounds(20, 270, 150, 20);
        solicitarCalificacion.setBackground(Color.green);
        subPanel1.add(solicitarCalificacion);
        solicitarCalificacion.addActionListener(this);

        desencriptarCalificacion = new JButton("Desencriptar calificación");
        desencriptarCalificacion.setBounds(20, 490, 170, 20);
        desencriptarCalificacion.setBackground(Color.green);
        subPanel1.add(desencriptarCalificacion);

        calificacion = new JLabel("Calificación:");
        calificacion.setBounds(20, 530, 200, 20);
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
        d.setBounds(180, 450, 170, 20);
        subPanel1.add(d);

        eField = new JTextField();
        eField.setBounds(180, 530, 40, 20);
        subPanel1.add(eField);

    }

    public void sistemaEscolar() {

        subPanel2 = new JPanel();
        subPanel2.setBorder(BorderFactory.createTitledBorder("Sistema"));
        subPanel2.setLayout(null);

        alumno = new JLabel("1.- Identifica el alumno");
        alumno.setBounds(20, 20, 200, 20);
        subPanel2.add(alumno);

        llavePublica = new JLabel("Llave pública:");
        llavePublica.setBounds(20, 170, 200, 20);
        subPanel2.add(llavePublica);

        llavePrivada = new JLabel("Llave privada:");
        llavePrivada.setBounds(20, 210, 200, 20);
        subPanel2.add(llavePrivada);

        alumno = new JLabel("2.- Generar llaves");
        alumno.setBounds(20, 110, 200, 20);
        subPanel2.add(alumno);

        llavePrivada = new JLabel("Solicitud:");
        llavePrivada.setBounds(20, 250, 200, 20);
        subPanel2.add(llavePrivada);

        llavePrivada = new JLabel("Calificación a enviar:");
        llavePrivada.setBounds(20, 290, 200, 20);
        subPanel2.add(llavePrivada);

        a = new JTextField();
        a.setBounds(130, 170, 170, 20);
        subPanel2.add(a);

        c = new JTextField();
        c.setBounds(130, 210, 170, 20);
        subPanel2.add(c);

        d = new JTextField();
        d.setBounds(130, 250, 170, 20);
        subPanel2.add(d);

        eField = new JTextField();
        eField.setBounds(160, 290, 40, 20);
        subPanel2.add(eField);

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