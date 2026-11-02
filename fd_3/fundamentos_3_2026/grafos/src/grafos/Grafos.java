/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grafos;

/**
 *
 * @author camil
 */
class GrafoArrays {
    private String [] vertices;
    private int numVertices;
    private int[][] matrizAdyacencia;
    
    public GrafoArrays(String origen){
        creaTablaVertices(origen);
        matrizAdyacencia = new int[numVertices][numVertices];
    }
    
    private void creaTablaVertices(String origen){
        String[] lineas = origen.split("\\R");
        vertices = new String[lineas.length* 2];
        numVertices = 0;
        
        for(String linea : lineas){
        String arista = linea.trim();
        if(arista.startsWith("{")){
            arista = arista.substring(1).trim();
        }
        int etiqueta = arista.indexOf('[');
        if(etiqueta >= 0){
            arista = arista.substring(0, etiqueta); 
        }
        String[] extremos = arista.split("--", 2);
        if(extremos.length == 2){
            agregarVertice(extremos[0].trim());
            agregarVertice(extremos[1].trim());
            }
        } 
    }


    private void agregarVertice(String vertice){
        for(int i =0; i< numVertices; i++){
            if(vertices[i].equals(vertice)){
              return;  
            } 
        }
        vertices[numVertices] = vertice;
        numVertices++;
    }

    public void display(){
        System.out.println("Vértices del grafo: ");
        displayVertices();
    }

    private void displayVertices(){
        for(int i=0; i < numVertices; i++){
            System.out.println(vertices[i]);
        }
    }

    private int obtenerIndiceVertice(String vertice){
        for(int i=0; i< numVertices; i++){
            if(vertices[i].equals(vertice)){
                return i;
            }
        }
        return -1; //funciona como bool para lso nimbres 
    }

    private void agregarArista(String vertice1, String vertice2, int peso){
        int indice1 = obtenerIndiceVertice(vertice1);
        int indice2 = obtenerIndiceVertice(vertice2);
        if(indice1 >= 0 && indice2>= 0){
            matrizAdyacencia[indice1][indice2] = peso;
            matrizAdyacencia[indice2][indice1] = peso;//grafos no dirigidos
        }
    }
}

public class Grafos {
 
    public static void main(String[] args) { 
        String texto = cargaArchivo("C:\\Users\\camil\\Documents\\FundamentosdeComputacion3\\FundamentosdeComputacion3\\fd_3\\fundamentos_3_2026\\grafos\\src\\grafo_salon.txt");
        System.out.println("Contenido del archivo:\n" + texto);
        GrafoArrays grafo = new GrafoArrays(texto);
        grafo.display();
    }
      public static String cargaArchivo(String ruta) {
        String contenido = "";
        try {
            java.io.File archivo = new java.io.File(ruta);
            java.util.Scanner scanner = new java.util.Scanner(archivo);
            while(scanner.hasNextLine()) {
                contenido += scanner.nextLine() + "\n";
            }
            scanner.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + ruta);
        }
        return contenido;
    }
}  
      
      

