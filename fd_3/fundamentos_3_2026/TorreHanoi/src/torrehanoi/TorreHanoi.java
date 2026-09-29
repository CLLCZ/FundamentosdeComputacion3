/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package torrehanoi;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author camil
 */
public class TorreHanoi {
    static Scanner sc = new Scanner(System.in);
    static int numDiscos = 3;
    static Stack<Integer>[] torres = new Stack[3];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        menuPrincipal();
    }
    static int leerEntero(){
        while (!sc.hasNextInt()){
            System.out.println("Ingrese un número entero :");
            sc.nextInt();
        }
        return sc.nextInt();
    }
    
    public static void menuPrincipal(){
        int opcion;
        do {
            System.out.println("====== Torres de Hanoi ======");
            System.out.println("    Número de discos elegidos: " +numDiscos);
            System.out.println("  1.- Elegir número de discos (3-8)");
            System.out.println("  2.- Jugar manualmente");
            System.out.println("  3.- Mostrar solución automática");
            System.out.println("  4.- Salir");
            System.out.println("  ~~~~Eliga una opción~~~~");
            opcion = leerEntero();
            switch (opcion){
                case 1:
                    elegirNumeroDiscos();
                    break;
                case 2:
                    jugarManual();
                    break;
                case 3:
                    mostrarSolucion();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }while (opcion != 4);
    }

    private static void elegirNumeroDiscos() { 
        System.out.println("1.- Elegir número de discos (3-8)");
        int n;
        do{
            System.out.print("Ingrese el número de discos: ");
            n = leerEntero();
            if(n<3 || n>8){
                System.out.println("Número inválido. \nRango de discos es de 3 - 8.");
            }
            numDiscos = n;
        }while (n<3 || n>8) ;
    }
    
    static void inicializaTorres() {
        for (int i =0; i<3; i++){
            torres[i] = new Stack<>();
        }
        for(int i = numDiscos; i>= 1; i--){
            torres[0].push(i);
        }
    } 
    
    static void despliegaTorre(int torre) {
        System.out.println("Torre " +(char)('A'+torre)+ ": ");
        //for (int disco : torres[torre]){
        for (int disco: torres[torre]){
            System.out.print(disco + " ");
        }
        System.out.println();
    }
    
    static void despliegaTorres() {
        for(int i = 0; i<3; i++ ){
            despliegaTorre(i);
        }
    }
    ////////rESOLVER MODO AUTOMATICO
    private static void jugarManual() {
        System.out.println("2.- Jugar manualmente");
        inicializaTorres();
            
        while(numDiscos > torres[2].size()){
            despliegaTorres();  
            String origen = eligeTorre("Elige la torre de origen (A, B o C): ");
            String destino = eligeTorre("Elige la torre de destino (A, B o C): ");
            
            int torreOrigen = origen.charAt(0) - 'A';
            int torreDestino = destino.charAt(0) - 'A';
            if (torres[torreOrigen].isEmpty()){
                System.out.println("La torre de ofrigen está vacía. Intenta de nuevo.");
                continue;
            }
            if (torreOrigen == torreDestino){
                System.out.println("La torre de origen y de destino son las mismas. Intenta de nuevo.");
                continue;
            }
            moverDisco(torreOrigen, torreDestino);
        }
        System.out.println("¡Felicidades! Has completado el juego.");
    }
    
    public static boolean moverDisco(int origen, int destino){
        if (torres[origen].isEmpty()){
            System.out.println("No hay discos en la torre de origen. ");
            return false;
        }
        if (!torres[destino].isEmpty() && torres[destino].peek() < torres[destino].peek()){
            System.out.println("Movimiento inválido. No puedes colocar un disco más grande sobre uno más pequeño.");
            return false;
            
        }
        int disco = torres[origen].pop();
        torres[destino].push(disco);
        System.out.println("Moviste el disco "+ disco + " de la torre "+ (char)('A' + destino) + ".");
        return true;
    }
    
    public static String eligeTorre(String mensaje){
        String torre;
        do{
            System.out.print(mensaje);
            torre = sc.next().toUpperCase();
            if (!torre.equals("A") && !torre.equals("B") && !torre.equals("C")){
                System.out.println("Torre inválida. Debe ser A, B o C");
            }
        }while(!torre.equals("A") && !torre.equals("B") && !torre.equals("C"));
        return torre;
    }
    

    private static void mostrarSolucion() {
            System.out.println("3.- Mostrar solución automática");
    }
}
