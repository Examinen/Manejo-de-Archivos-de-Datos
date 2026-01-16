import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String archivo = "codigos_postales_hmo.csv";
        String separador = ",";

        // ArrayLists
        ArrayList<String> codigosPostales = new ArrayList<>();
        ArrayList<Integer> conteos = new ArrayList<>();

        String linea;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            // Saltar encabezados
            br.readLine();

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(separador);
                String codigoPostal = datos[0];

                // Verificar si el código ya existe
                int indice = codigosPostales.indexOf(codigoPostal);

                if (indice != -1) {
                    // Ya existe → aumentar conteo
                    conteos.set(indice, conteos.get(indice) + 1);
                } else {
                    // No existe → agregar
                    codigosPostales.add(codigoPostal);
                    conteos.add(1);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Mostrar resultados
        System.out.println("Resultados del análisis:\n");

        for (int i = 0; i < codigosPostales.size(); i++) {
            System.out.println(
                    "Código postal: " + codigosPostales.get(i) +
                            " - Número de asentamientos: " + conteos.get(i)
            );
        }
    }
}