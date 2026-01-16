import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String archivo = "codigos_postales_hmo.csv";
        String separador = ",";

        ArrayList<String> codigosPostales = new ArrayList<>();
        ArrayList<Integer> conteos = new ArrayList<>();

        String linea;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            // Saltamos el encabezado
            br.readLine();

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(separador);
                String codigoPostal = datos[0];

                // Analizamos si existe un codigo y lo verificamos
                int indice = codigosPostales.indexOf(codigoPostal);

                if (indice != -1) {
                    // Si existe el mismo numero este tiende a aumentar conteo
                    conteos.set(indice, conteos.get(indice) + 1);
                } else {
                    // Si no existe, lo agregamos como nuevo
                    codigosPostales.add(codigoPostal);
                    conteos.add(1);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Mostrar resultados
        System.out.println("Resultados del análisis:\n");
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < codigosPostales.size(); i++) {
            System.out.println("Código postal: " + codigosPostales.get(i) + " - Número de asentamientos: " + conteos.get(i)
            );
        }
    }
}