/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package espalindromo;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;
/**
 *
 * @author camil
 */
public class EsPalindromo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        //public static void EsPalindromo(String[] args){
            String cadena = args.length > 0 ? args[0] : "ama";
            boolean esPalindromo = esPalindromo(cadena);
            System.out.println("Cadena: " +cadena );
            System.out.println("Es palindromo?" + esPalindromo);
            
        }
        public static boolean esPalindromo(String cadena){
            Deque<Character> pila = new ArrayDeque<>();
            for (char c : cadena.toCharArray()){
                pila.push(c);
                
            }
            char[] cadenaInvertida = new char[cadena.length()];
            while(!pila.isEmpty()){
                //cadenaInvertidaChar[cadena.length() - pila.size()];
                pila.pop();
            }
            
            String cadenaInvertidaStr = new String(cadenaInvertida);
            System.out.println("Cadena INVERTIDA: "+ cadenaInvertidaStr);
            return cadena.equals(cadenaInvertidaStr);
        }
    }
    

