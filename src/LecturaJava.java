// importación de las clases que necesitaremos para realizar el ejercicio que se nos plantea.
import java.io.BufferedReader; // lectura de texto de una entrada linea por linea.
import java.io.FileNotFoundException; // excepción lanzada en el caso de que el archivo no se encuentre.
import java.io.FileReader; // lectura de archivos.
import java.io.IOException; // excepción general.

// definicion de la clase, con el main y el método leerFichero.
public class LecturaJava {
    
    // en el main llamo al método leerFichero y le paso la ruta del archivo, con el throws IOException controlo las excepciones que el programa pueda lanzar.
    public static void main(String[] args) throws IOException {
        leerFichero(".\\src\\prueba.txt"); 
    }

    // metodo para leer el fichero, como su nombre indica.
    public static void leerFichero(String nombre) throws IOException {

        // variables
        String salida; // almacenamos cada línea que se lea en el archivo.
        BufferedReader lector = null; // objeto que usaremos para leer el archivo.
        int contador = 0; // con esta variable contaremos el numero de líneas.

        // bloque try/catch/finally
        try {

            lector = new BufferedReader(new FileReader(nombre)); // creamos el BufferedReader para leer el archivo.
            salida = lector.readLine(); // leemos la primera línea del archivo, la almacenamos en salida, si está vacío será null.

            // bucle while, lee líneas hasta que salida sea null.
            while (salida != null) {
                contador++; // incrementamos el contador de líneas.
                System.out.println(salida + "--> " + salida.length()); // sacamos por pantalla la línea y el número de carácteres de dicha línea.
                salida = lector.readLine(); // leemos la siguiente línea.
            }

            // al salir del bucle, mostramos en pantalla el total de líneas que contiene el archivo.
            System.out.println("el numero de lineas es: " + contador);

        } catch (FileNotFoundException e) { // capturamos la excepción si el archivo no se encuentra.
            System.out.println(e.getMessage()); // si el archivo no está disponible, se imprime un mensaje de error.
        } finally { // cerramos lector, verificando antes si este fue inicializado.
            if (lector != null) {
                lector.close();
            }
        }
    }
}
