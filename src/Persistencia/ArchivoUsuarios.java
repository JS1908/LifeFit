
    package Persistencia;

import java.io.*;

public class ArchivoUsuarios {

    private static final String ARCHIVO = "usuarios.txt";

    public static void guardarUsuario(String usuario, String password) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true));
        bw.write(usuario + "," + password);
        bw.newLine();
        bw.close();
    }

    public static boolean validarUsuario(String usuario, String password) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ARCHIVO));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");

            if (datos.length == 2) {
                if (datos[0].equals(usuario) && datos[1].equals(password)) {
                    br.close();
                    return true;
                }
            }
        }

        br.close();
        return false;
    }
}

