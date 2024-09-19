import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class BibliotecaApp extends JFrame {

    // Estructuras para almacenar libros y usuarios
    private HashMap<String, Boolean> libros = new HashMap<>();
    private HashMap<String, String> usuarios = new HashMap<>();

    // Componentes de la GUI
    private JTextField txtTituloLibro;
    private JTextField txtNombreUsuario;
    private JLabel lblResultado;
    private JComboBox<String> comboLibros;

    public BibliotecaApp() {
        setTitle("Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        // Campos para agregar libros
        panel.add(new JLabel("Título del Libro:"));
        txtTituloLibro = new JTextField();
        panel.add(txtTituloLibro);

        // Botón para agregar libro
        JButton btnAgregarLibro = new JButton("Agregar Libro");
        btnAgregarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });
        panel.add(btnAgregarLibro);

        // Campos para registrar usuarios
        panel.add(new JLabel("Nombre del Usuario:"));
        txtNombreUsuario = new JTextField();
        panel.add(txtNombreUsuario);

        // Botón para agregar usuario
        JButton btnAgregarUsuario = new JButton("Agregar Usuario");
        btnAgregarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarUsuario();
            }
        });
        panel.add(btnAgregarUsuario);

        // Desplegable para seleccionar un libro
        panel.add(new JLabel("Verificar disponibilidad del Libro:"));
        comboLibros = new JComboBox<>();
        panel.add(comboLibros);

        // Botón para verificar disponibilidad
        JButton btnVerificarDisponibilidad = new JButton("Verificar Disponibilidad");
        btnVerificarDisponibilidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarDisponibilidad();
            }
        });
        panel.add(btnVerificarDisponibilidad);

        // Label para mostrar resultados
        lblResultado = new JLabel("");
        panel.add(lblResultado);

        // Añadir el panel a la ventana
        add(panel);
        setVisible(true);
    }

    // Método para agregar libros a la colección
    private void agregarLibro() {
        String titulo = txtTituloLibro.getText();
        if (!titulo.isEmpty()) {
            libros.put(titulo, true); // El libro está disponible por defecto
            comboLibros.addItem(titulo);
            lblResultado.setText("Libro agregado: " + titulo);
            txtTituloLibro.setText("");
        } else {
            lblResultado.setText("Por favor, ingresa un título.");
        }
    }

    // Método para agregar usuarios
    private void agregarUsuario() {
        String nombreUsuario = txtNombreUsuario.getText();
        if (!nombreUsuario.isEmpty()){// agregar cosas, porque esta en espacio en blanco 
            usuarios.put(nombreUsuario, nombreUsuario);
            lblResultado.setText("Usuario registrado: " + nombreUsuario);
            txtNombreUsuario.setText("");
        } else {
            lblResultado.setText("Por favor, ingresa un nombre de usuario.");
        }
    }

    // Método para verificar si el libro está disponible
    private void verificarDisponibilidad() {
        String libroSeleccionado = (String) comboLibros.getSelectedItem();
        if (libroSeleccionado != null) {
            boolean disponible = libros.get(libroSeleccionado);
            if (disponible) {
                lblResultado.setText("El libro '" + libroSeleccionado + "' está disponible.");
            } else {
                lblResultado.setText("El libro '" + libroSeleccionado + "' no está disponible.");
            }
        } else {
            lblResultado.setText("Por favor, selecciona un libro.");
        }
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BibliotecaApp();
            }
        });
    }
}