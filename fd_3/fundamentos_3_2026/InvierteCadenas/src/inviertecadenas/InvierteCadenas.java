/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inviertecadenas;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 *
 * @author camil
 */
public class InvierteCadenas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cadena = args.length > 0 ? args[0] : "Hola mundo";
        String cadenaInvertida = invertirCadena(cadena);
        System.out.println("Cadena original: " + cadena);
        System.out.println("Cadena invertida: " + cadenaInvertida);
    }
    public static String invertirCadena(String cadena){
        Deque<String> pila = new ArrayDeque<>();
        String[] palabras = cadena.split(" ");
        for (String palabra : palabras){
            pila.push(palabra);
        }
        StringBuilder cadenaInvertida = new StringBuilder();
        while(!pila.isEmpty()){
            cadenaInvertida.append(pila.pop()).append(" ");
        }
        return cadenaInvertida.toString().trim();
        //return cadena;
    }
}
