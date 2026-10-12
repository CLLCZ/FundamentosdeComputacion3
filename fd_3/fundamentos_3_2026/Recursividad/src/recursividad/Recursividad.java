/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursividad;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author camil
 */
public class Recursividad {

    static Map<Integer, Long> memo = new HashMap<>();
    
     
    public static void main(String[] args) {
        //System.out.println("Factorial de 31 (Maximo antes de que sobrepase): " + factorial(31));
        int[] arr = {7,15,30,45,50};
        long startTime = System.nanoTime();
        for (int i =0; i<arr.length; i++){
            long sTime = System.nanoTime();
            System.out.println("Fibonacci de " + arr[i] + ": "+ fibonacci(arr[i]));
            long endTime = System.nanoTime();
            System.out.println("Tiempo de ejecucion: " +(endTime - sTime) / 1000000.0+ " ms");
        }
        for (int i =0; i<arr.length; i++){
            long sTime = System.nanoTime();
            System.out.println("Fibonacci de " + arr[i] + ": "+ fib(arr[i]));
            long endTime = System.nanoTime();
            System.out.println("Tiempo de ejecucion: " +(endTime - sTime) / 1000000.0+ " ms");
        }
    }
    public static long fib(int n) {
        if (n <= 1) return n;
        Long guardado = memo.get(n);
        if(guardado != null) return guardado;
        long resultado = fib(n-1) + fib(n-2);
        memo.put(n, resultado);
        return resultado;
    };
    
    public static int factorial(int n){
        if(n == 0){
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }
    public static int fibonacci(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            return n*( fibonacci(n-1) + fibonacci(n-2));
        }
    }
   
}
