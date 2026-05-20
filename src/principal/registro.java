

    package principal;
import Persistencia.ArchivoUsuarios;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class registro extends javax.swing.JFrame {

    private javax.swing.JPanel panelRegistro;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JTextField txtUsuarioRegistro;
    private javax.swing.JPasswordField txtPasswordRegistro;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel lblLogin;

    public registro() {
        initComponents();
        setTitle("LifeFit - Registro");
        setSize(536, 415);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(235, 240, 245));
    }

    private void initComponents() {
        panelRegistro = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsuarioRegistro = new javax.swing.JTextField();
        txtPasswordRegistro = new javax.swing.JPasswordField();
        btnRegistrar = new javax.swing.JButton();
        lblLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        panelRegistro.setLayout(null);
        panelRegistro.setBounds(75, 35, 380, 300);
        panelRegistro.setBackground(Color.WHITE);
        panelRegistro.setBorder(BorderFactory.createLineBorder(new Color(0, 120, 210), 2, true));
        add(panelRegistro);

        lblTitulo.setText("Crear cuenta");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setBounds(110, 20, 200, 35);
        panelRegistro.add(lblTitulo);

        lblUsuario.setText("Ingrese un usuario");
        lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblUsuario.setBounds(45, 70, 220, 25);
        panelRegistro.add(lblUsuario);

        txtUsuarioRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtUsuarioRegistro.setBounds(45, 95, 290, 38);
        panelRegistro.add(txtUsuarioRegistro);

        lblPassword.setText("Ingrese una contraseña");
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblPassword.setBounds(45, 145, 220, 25);
        panelRegistro.add(lblPassword);

        txtPasswordRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtPasswordRegistro.setBounds(45, 170, 290, 38);
        panelRegistro.add(txtPasswordRegistro);

        btnRegistrar.setText("Registrarse");
        btnRegistrar.setBounds(45, 225, 290, 42);
        btnRegistrar.setBackground(new Color(0, 120, 210));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnRegistrar.setFocusPainted(false);
        panelRegistro.add(btnRegistrar);

        lblLogin.setText("¿Ya tienes cuenta? Inicia sesión");
        lblLogin.setBounds(80, 270, 250, 25);
        lblLogin.setForeground(new Color(0, 100, 180));
        lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelRegistro.add(lblLogin);

        btnRegistrar.addActionListener(evt -> registrarUsuario());

        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frmLogin login = new frmLogin();
                login.setVisible(true);
                dispose();
            }
        });
    }

    private void registrarUsuario() {
        String usuario = txtUsuarioRegistro.getText();
        String password = new String(txtPasswordRegistro.getPassword());

        if (usuario.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos");
            return;
        }

        try {
            ArchivoUsuarios.guardarUsuario(usuario, password);

            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente");

            frmLogin login = new frmLogin();
            login.setVisible(true);
            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar usuario");
        }
    }
}