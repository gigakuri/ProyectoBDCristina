/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package copias;

import application.Consultas;
import entities.Maquinas;
import entities.Productos;
import entities.Ventas;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristina
 */
public class Utilidades {

    public static void crearDirectorio(String ruta) {

        java.nio.file.Path directory = Paths.get(ruta);
        try {
            Files.createDirectories(directory);
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + ruta);
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }

    }

    public static void generarCSV(String ruta, Object[] lista) {
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {

            for (Object linea : lista) {
                flujo.write(linea.toString());
                flujo.newLine();
            }

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero creado correctamente.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static String[] listarDirectorio(String ruta) {
        String[] aux = null;
        int contador = 0;

        File f = new File(ruta);
        if (f.exists()) {
            // Obtiene los ficheros y directorios dentro de f y los 
            // devuelve en un array
            File[] ficheros = f.listFiles();
            aux = new String[ficheros.length];
            for (File file2 : ficheros) {
                aux[contador] = file2.getName();
                contador++;
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }

        return aux;
    }

    public static List<String> leerFicheroTexto(String carpeta, String fichero) {
        List<String> lineas = new ArrayList<>();

        try {
            lineas = Files.readAllLines(Paths.get("./copias" + carpeta + "/" + fichero + ".csv"),
                    StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero");
        }
        for (String linea : lineas) {
            System.out.println(linea);
        }

        return lineas;

    }

    public static List<Maquinas> generarMaquinas(List<String> datos) {
        String[] tokens;
        String linea;
        List<Maquinas> listaMaquinas = new ArrayList<>();

        for (int i = 1; i < datos.size(); i++) {
            linea = datos.get(i);
            tokens = linea.split(",");

            listaMaquinas.add(new Maquinas(Integer.valueOf(tokens[0]), tokens[1], 
                    BigDecimal.valueOf(Double.parseDouble(tokens[2]))));

        }

        return listaMaquinas;
    }
    
    public static List<Productos> generarProductos(List<String> datos) {
        String[] tokens;
        String linea;
        List<Productos> listaProductos = new ArrayList<>();

        for (int i = 1; i < datos.size(); i++) {
            linea = datos.get(i);
            tokens = linea.split(",");

            listaProductos.add(new Productos(Integer.valueOf(tokens[0]), tokens[1], 
                    BigDecimal.valueOf(Double.parseDouble(tokens[2])), Integer.valueOf(tokens[3]), 
                    Consultas.maquinaJPA.findMaquinas(Integer.valueOf(tokens[4]))));

        }

        return listaProductos;
    }
    
    public static List<Ventas> generarVentas(List<String> datos) {
        String[] tokens;
        String linea;
        List<Ventas> listaVentas = new ArrayList<>();

        for (int i = 1; i < datos.size(); i++) {
            linea = datos.get(i);
            tokens = linea.split(",");

            listaVentas.add(new Ventas(Integer.valueOf(tokens[0].split("➔ ")[1].trim()), 
                    Date.valueOf(tokens[1].trim()), 
                    BigDecimal.valueOf(Double.parseDouble(tokens[2].trim())), tokens[3].trim(), 
                    Consultas.productoJPA.findByNombre(tokens[4].trim())));

        }

        return listaVentas;
    }

}
