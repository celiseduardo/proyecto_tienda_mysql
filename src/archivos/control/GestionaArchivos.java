package archivos.control;
import producto.dominio.Producto;
import util.Color;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static util.Funciones.*;

public class GestionaArchivos {


    public static void imprimirFactura(List<Producto> productos, String empleado) {

        String archivo = "factura.txt";
        Path path = Paths.get(archivo);

        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                try {
                    FileWriter fileWriter = new FileWriter(archivo);
                    PrintWriter pw = new PrintWriter(fileWriter);
                    var total = 0;
                    pw.println("Factura Simplificada");
                    pw.println("-----------------------------------------------------------------------------");
                    for (int i = 0; i < productos.size(); i++) {
                        pw.printf("%-15s: %s%n", "Código", productos.get(i).getCodigo());
                        pw.printf("%-15s: %s%n", "Nombre", productos.get(i).getNombre());
                        pw.printf("%-15s: %s%n", "Descripción", productos.get(i).getDescripcion());
                        pw.printf("%-15s: %.2f%n", "Precio", productos.get(i).getPrecio());
                        pw.println("");
                        total += productos.get(i).getPrecio();
                    }
                    pw.println("-----------------------------------------------------------------------------");
                    pw.println("El precio TOTAL es: " + total + " Euros");
                    pw.println("Atendido por: " + empleado);
                    pw.println("");
                    pw.close();

                } catch (IOException ex) {
                    muestraMensaje("Error. No se ha podido escribir en el archivo para la factura", Color.ERROR);
                }
            } catch (IOException ex) {
                muestraMensaje("No se puede crear el archivo para la factura", Color.ERROR);
            }
        }

    }
}
