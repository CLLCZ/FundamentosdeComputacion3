/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

import java.util.ArrayList;

/**
 *
 * @author camil
 */
public class Nodos {
    String nombre;
    ArrayList<Nodos> adyacentes;
    int peso;
    
    public Nodos(String nombre){
        this.nombre = nombre;
        this.peso = 0;
        this.adyacentes = new ArrayList<>();
    }
    public void agregarAdyacente(Nodos nodo, int peso){
        adyacentes.add(nodo); 
        nodo.peso = peso;
    }
    public void display(){
        System.out.println(nombre);
        System.out.print("| Adyacentes: ");
        for(Nodos nodo : adyacentes){
            System.out.print(nodo.nombre + ": " + nodo.peso + " ");
        }
        System.out.println();
    }
    
    
}
