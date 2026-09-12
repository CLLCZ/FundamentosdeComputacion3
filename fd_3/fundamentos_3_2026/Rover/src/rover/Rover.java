/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author camil
 */
public class Rover {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cadena = args.length > 0 ? args[0] : "path1.txt";
        ArrayList<String> lineas = leerArchivo(cadena);
        Queue<String> queue = addToQueue(lineas);
        travelQueue(queue);
        queue = addToQueue(lineas);
        Deque<String> stack = queueToStack(queue);
        queue = stackToQueue(stack);
        travelQueue(queue);
    }
    public static ArrayList<String> leerArchivo(String nombreArchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return lineas;
    }
    
    public static Deque<String> queueToStack(Queue<String> queue){
        Deque<String> deque = new ArrayDeque<>();
        while (!queue.isEmpty()){
            String linea = queue.poll();
            if (linea != null){
                deque.push(linea);
            }
        } return deque;
    }
    public static Queue<String> stackToQueue(Deque<String> stack){
        Queue<String> queue = new LinkedList<String>();
        while (!stack.isEmpty()){
            String linea = stack.pop();
            if (linea != null){
                queue.add(linea);
            }
        } return queue;
    }
    public static void travelQueue(Queue<String> queue){
        while (!queue.isEmpty()){
            String linea = queue.poll();
            if(linea != null){
                if(linea.toUpperCase().equals("A")){
                    System.out.print("^");
                }else if(linea.toUpperCase().equals("D")){
                    System.out.print("v");
                }else if(linea.toUpperCase().equals("S")){
                    System.out.print("-");
                }
            }
        } System.out.println();
    }
    public static Queue<String> addToQueue(ArrayList<String> lineas) {
        Queue<String> queue = new java.util.LinkedList<>();
        for (String linea : lineas) {
            queue.add(linea);
        }
        return queue;
    }
    
}
