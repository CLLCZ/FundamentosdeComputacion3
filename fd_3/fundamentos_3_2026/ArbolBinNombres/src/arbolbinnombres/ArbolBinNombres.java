/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolbinnombres;

/**
 *
 * @author camil
 */

class Nodo {
    int valor;
    Nodo izquierda; 
    Nodo derecha;
    public Nodo (int valor){
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }
}

class ArbolBinario{
    Nodo raiz;
    public ArbolBinario(){
        this.raiz = null;
    }
    public void insertar(int valor){
        raiz = insertarRecursivo(raiz, valor);
    }
    private Nodo insertarRecursivo(Nodo nodo, int valor){
        if(nodo == null){
            return new Nodo(valor);
        }
        if(valor < nodo.valor){
            nodo.izquierda = insertarRecursivo(nodo.izquierda, valor);
        }else if (valor > nodo.valor){
            nodo.derecha = insertarRecursivo(nodo.derecha, valor);
        }
        
        return nodo;
    }
    public void preOrden(){
        preOrdenRecursivo(raiz);
    } 
    private void preOrdenRecursivo(Nodo nodo){
        if(nodo != null){
            System.out.println(nodo.valor + " ");
            preOrdenRecursivo(nodo.izquierda);
            preOrdenRecursivo(nodo.derecha);
        }
    }   
    public void inOrden(){
        inOrdenRecursivo(raiz);
        
    }
    public void inOrdenRecursivo(Nodo nodo){
        if (nodo != null){
            inOrdenRecursivo(nodo.izquierda);
            System.out.println(nodo.valor + " ");
            inOrdenRecursivo(nodo.derecha);
        }
    }
}
public class ArbolBinNombres {

    public static void main(String[] args) { 
        String[] array = {A,B,C,D,E,E,F,G,H,I,J,K,L,M,N,O,P,Q}
                ////nombre
    }
    
}
