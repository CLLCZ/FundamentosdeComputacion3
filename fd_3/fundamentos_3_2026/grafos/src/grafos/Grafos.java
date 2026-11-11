/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grafos;

import java.util.ArrayList;

/**
 *
 * @author camil
 */
/*
class GrafoArrays {
    private String [] vertices;
    private int numVertices;
    private int[][] matrizAdyacencia;
    private ArrayList<String> arcosDFS;
    private ArrayList<String> arcosBFS;
    
    public GrafoArrays(String origen){
        creaTablaVertices(origen);
        matrizAdyacencia = new int[numVertices][numVertices];
        pupulateMatrizAdyacencia(origen);
        arcosDFS = new ArrayList<>();
        arcosBFS = new ArrayList<>();
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
        displayMatrizAdyacencia();
    }

    private void displayVertices(){
        for(int i=0; i < numVertices; i++){
            System.out.println(vertices[i]);
        }
    }
     private void displayMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        // Imprimir encabezado de columnas
        System.out.print("     ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("   " +vertices[i].substring(0,4) );
        }
        System.out.println();
        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertices[i].substring(0, 4) + "     ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + "      ");
            }
            System.out.println();
        }
    } 
    
    private int obtenerIndiceVertice(String vertice){
        for(int i=0; i< numVertices; i++){
            if(vertices[i].equals(vertice)){
                return i;
            }
        }
        return -1; //funciona como bool para los nombres 
    }

    private void agregarArista(String vertice1, String vertice2, int peso){
        int indice1 = obtenerIndiceVertice(vertice1);
        int indice2 = obtenerIndiceVertice(vertice2);
        if(indice1 >= 0 && indice2>= 0){
            matrizAdyacencia[indice1][indice2] = peso;
            matrizAdyacencia[indice2][indice1] = peso;//grafos no dirigidos
        }
    }
    private void pupulateMatrizAdyacencia(String origen){
        String[] lineas = origen.split("\\R");
        for (String linea : lineas){
            String arista = linea.trim();
            if(arista.startsWith("{")){
                arista = arista.substring(1).trim(); 
            }
            int etiqueta = arista.indexOf('[');
            int peso =1;
            if(etiqueta>=0){
                String etiquetaStr = arista.substring(etiqueta + 1, arista.indexOf(']', etiqueta));
                String pesoStr = etiquetaStr.replaceAll("[^0-9]", "");
                
                //String pesoStr = arista.substring(etiqueta + 1, arista.indexOf(']',etiqueta));
                //Resultaba en peso invalido debido a las " " 
                // bhbhbhbhhbhbhbhbhb 
                try { 
                    peso = Integer.parseInt(pesoStr.trim());
                } catch (NumberFormatException e ){
                    System.out.println("Peso inválido en la línea: "+linea);
                    
                }
                arista = arista.substring(0,etiqueta);
            }
            String[] extremos = arista.split("--", 2);
            if(extremos.length == 2){
                agregarArista(extremos[0].trim(), extremos[1].trim(), peso);
            }
        }
    }
    
    public void DFS(String verticeInicial, String verticeFinal){
        if (arcosDFS == null) arcosDFS = new ArrayList<>();
        arcosDFS.clear();
        boolean[] visitado= new boolean[numVertices];
        int indiceInicial= obtenerIndiceVertice(verticeInicial);
        int indiceFinal= obtenerIndiceVertice(verticeFinal);
        if(indiceInicial == -1 || indiceFinal==-1){
            System.out.println("Uno o ambos vértices no existen en el grafo.");
            return;
        }
        System.out.println("Recorrido DFS desde "+ verticeInicial + " hasta " +verticeFinal+" :");
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(indiceInicial);
        while(!stack.isEmpty()){
            int indiceActual = stack.pop();  
            if(!visitado[indiceActual]){
                visitado[indiceActual] = true;
                System.out.print(vertices[indiceActual]+ " ");
                if(indiceActual == indiceFinal){
                    System.out.println("\nSe ha alcanzado el vértice final");
                    return;
                }
            }
            for(int i=0; i<numVertices;i++){
                if(matrizAdyacencia[indiceActual][i] != 0 && !visitado[i]){
                    arcosDFS.add(vertices[indiceActual] + " -- " + vertices[i]);
                    stack.push(i);
                }
            }
        }
    }
    public void BFS(String verticeInicial, String verticeFinal){
        if (arcosBFS == null) arcosBFS = new ArrayList<>();
        arcosBFS.clear();
        boolean[] visitado= new boolean[numVertices];
        int indiceInicial= obtenerIndiceVertice(verticeInicial);
        int indiceFinal= obtenerIndiceVertice(verticeFinal);
        if(indiceInicial == -1 || indiceFinal==-1){
            System.out.println("Uno o ambos vértices no existen en el grafo.");
            return;
        }
        System.out.println("Recorrido BFS desde "+ verticeInicial + " hasta " +verticeFinal+" :");
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        queue.add(indiceInicial);
        while(!queue.isEmpty()){
            int indiceActual = queue.poll();  
            if(!visitado[indiceActual]){
                visitado[indiceActual] = true;
                System.out.print(vertices[indiceActual]+ " ");
                if(indiceActual == indiceFinal){
                    System.out.println("\nSe ha alcanzado el vértice final");
                    return;
                }
            }
            for(int i=0; i<numVertices;i++){
                if(matrizAdyacencia[indiceActual][i] != 0 && !visitado[i]){
                    arcosBFS.add(vertices[indiceActual] + " -- " + vertices[i]);
                    queue.add(i);
                }
            }
        }
    }
        public String caminoMasCortoBFS(String verticeInicial, String verticeFinal){
            int inicio = obtenerIndiceVertice(verticeInicial);
            int destino = obtenerIndiceVertice(verticeFinal);
            if(inicio == -1 || destino == -1){
                return "Uno o ambos vértices no existen en el grafo";
            }
            int[] distancia = new int[numVertices];
            int[] anterior = new int[numVertices];
            boolean[] visitado = new boolean[numVertices];
            java.util.Arrays.fill(distancia, Integer.MAX_VALUE);
            java.util.Arrays.fill(anterior, -1);
            distancia[inicio]=0; 
            for(int peso =0; peso < numVertices; peso++){
                int actual = -1;
                for(int i =0; i <numVertices;i++){
                    if(!visitado[i] && distancia[i] != Integer.MAX_VALUE){  /////////////////
                        
                        actual=i;
                    }
                }
                if(actual==-1){
                break;
                }
                if(actual==destino){
                    break;
                }
                visitado[actual]= true;
            
                for(int vecino =0;vecino<numVertices; vecino++){
                    int peso = matrizAdyacencia[actual][vecino];
                    if(peso !=0 && !visitado[vecino]&& distancia[actual] <= Integer.MAX_VALUE - peso){
                        int nuevaDistancia = distancia[actual];
                        if(nuevaDistancia < distancia[vecino]){
                            distancia[vecino] = nuevaDistancia;
                            anterior[vecino] = actual;
                    }
                    
                }
                
            }
            
            
            
        }

    } 
    public void despliegaArcos(){
        System.out.println("\n--- RESULTADOS Y DESPLIEGUE DE ARCOS ---");
 
        System.out.println("Arcos DFS: " + (arcosDFS != null ? arcosDFS : "null"));
        System.out.println("Arcos BFS: " + (arcosBFS != null ? arcosBFS : "null"));
 
        int totalArcosMatriz = 0;
        for (int i = 0; i < numVertices; i++) {
            for (int j = i; j < numVertices; j++) {  
                if (matrizAdyacencia[i][j] != 0) {
                    totalArcosMatriz++;
                }
            }
        }
        int tamDFS = 0;
        if (arcosDFS != null) {
            tamDFS = arcosDFS.size();
        }

        int tamBFS = 0;
        if (arcosBFS != null) {
            tamBFS = arcosBFS.size();
        }
        int totalArcosOcupados = tamDFS + tamBFS;

        System.out.println("Número total de vértices: " + numVertices);
        System.out.println("Número total de arcos en el grafo: " + totalArcosMatriz);
        System.out.println("Número total de arcos ocupados (DFS + BFS): " + totalArcosOcupados);
 
        if (arcosDFS != null && arcosBFS != null) {
            System.out.println("\nComparación de Arcos Registrados:");
            System.out.println("Saltos DFS: " + tamDFS);
            System.out.println("Saltos BFS: " + tamBFS);

            if (tamDFS < tamBFS) {
                System.out.println("El recorrido DFS registró menos arcos/saltos (" + tamDFS + ").");
            } else if (tamBFS < tamDFS) {
                System.out.println("El recorrido BFS registró menos arcos/saltos (" + tamBFS + ").");
            } else {
                System.out.println("Ambos recorridos registraron la misma cantidad de arcos (" + tamDFS + ").");
            }
        } else {
            System.out.println("No es posible comparar: uno o ambos atributos son nulos.");
        }
    }

//Agregar 2 obj, que nodos se han visitado en dfs y bfs, que al final diga hizo x cantidad de saltos, cual es el mas corto
 // Crear método para agregar aristas después de crear la tabla de vértices populateMatrizAdyacencia(origen);
             // Dividir el archivo de texto en lineas y procesar cada línea para agregar aristas 
             // Cada linea se separa en dos vértices y un peso, luego se llama al método agregarArista para agregarlas a la matriz de adyacencia
             // Crear un método para desplegar la Matriz de adyacencia
  
*/
public class Grafos {
 
    public static void main(String[] args) { 
        String texto = cargaArchivo("C:\\Users\\camil\\Documents\\FundamentosdeComputacion3\\FundamentosdeComputacion3\\fd_3\\fundamentos_3_2026\\grafos\\src\\grafo_salon.txt");
        System.out.println("Contenido del archivo:\n" + texto);
        grafosArrays grafo = new grafosArrays(texto);
        grafo.display();
        System.out.println("\n--- Ejecución de DFS y BFS ---"); 
        if (grafo != null) { 
            grafo.DFS("Angel", "Andres");
            grafo.BFS("Angel", "Andres");
            String caminoDijkstra = grafo.caminoMasCorto("Arcangel", "Sergio");
        System.out.println(caminoDijkstra);
        }
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

      
      

