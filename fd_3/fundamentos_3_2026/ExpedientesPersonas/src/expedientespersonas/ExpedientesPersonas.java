/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package expedientespersonas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author camil
 */
class Personas {
    private String nombre;
    private String expediente;
    private int edad;
    
    public Personas(String nombre, String expediente, int edad){
        this.nombre = nombre;
        this.expediente = expediente;
        this.edad = edad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getExpediente() {
        return expediente;
    }

    public int getEdad() {
        return edad;
    }
    
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Expediente: " + expediente);
        System.out.println("Edad: " + edad);
    }
}
public class ExpedientesPersonas {

    public static ArrayList<Personas> cargaArchivoPersonas(String nombreArchivo) {
        ArrayList<Personas> personas = new ArrayList<>(); 
            try(BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))){
                String linea;
                boolean primeraLinea = true;
                while((linea = br.readLine()) != null){
                    
                    if(primeraLinea){
                        primeraLinea = false;
                        continue;
                    }
                    
                    String[] partes = linea.split(",");
                    if(partes.length == 3){
                        String nombre = partes[0].trim();
                        String expediente = partes[1].trim();
                        int edad = Integer.parseInt(partes[2].trim());
                        personas.add(new Personas(nombre, expediente, edad));
                    }
                }
            }  catch (IOException e) {
               System.out.println("Error al leer el archivo: " + e.getMessage());
            }
            return personas; 
        } 
    public static void main(String[] args){
        String nombreArchivo = "/Users/camil/Documents/FundamentosdeComputacion3/FundamentosdeComputacion3/fd_3/fundamentos_3_2026/ExpedientesPersonas/src/expedientespersonas/listado_personas_expediente.csv";
        
        ArrayList<Personas> personas = cargaArchivoPersonas(nombreArchivo);
        if(personas.size() > 10){
            Personas personaEncontrada = personas.get(10);
            System.out.println("Nombre: "+ personaEncontrada.getNombre());
            System.out.println("Expediente: "+ personaEncontrada.getExpediente());
            System.out.println("Edad: "+ personaEncontrada.getEdad());
            
        }else {
            System.out.println("No hay suficientes registros en el archivo.");
        }
        buscarVariasPersonasEnLista(personas, new String[]{"Alan Aldama Andre","Isabel Domínguez Ochoa","Ernesto Ozuna Ramirez","Ada Pino López","Bruno Diaz Hernández","Luis Caro Durazo"});
    }
    public static Personas buscarPersonaEnLista(ArrayList<Personas> personas, String nombre) {
        for (Personas persona : personas) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return persona;
            }
        }
        return null; // Retorna null si no se encuentra la persona
    }

    public static void buscarVariasPersonasEnLista(ArrayList<Personas> personas, String[] nombres) {
    // Inicia un timer para medir el tiempo de búsqueda
        long startTime = System.nanoTime();
        for (String nombre : nombres) {
            Personas personaEncontrada = buscarPersonaEnLista(personas, nombre);
            if (personaEncontrada != null) {
                personaEncontrada.mostrarDatos();
            } else {
                System.out.println("No se encontró a la persona con nombre: " + nombre);
            }
        }
        // Finaliza el timer y muestra el tiempo de búsqueda
        long endTime = System.nanoTime();
        System.out.println("Tiempo de búsqueda: " + (endTime - startTime) / 1000000.0 + " ms");
    }
  
}
