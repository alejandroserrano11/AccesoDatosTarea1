import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaJava {
    public static void main(String[] args) throws IOException {
        leerFichero(".\\src\\prueba.txt"); // path relativo
    }

    public static void leerFichero(String nombre) throws IOException {
        
        String salida;
        BufferedReader lector = null;
        int contador=0;
        try {
            lector = new BufferedReader(new FileReader(nombre));

            salida = lector.readLine();
            while (salida!=null) {
                contador++;
                System.out.println(salida + "-->" + salida.length());
                salida = lector.readLine();
            }
            System.out.println("el numero de lineas es: " + contador);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (lector!=null) {
                lector.close();
            }
        }
    }
}
