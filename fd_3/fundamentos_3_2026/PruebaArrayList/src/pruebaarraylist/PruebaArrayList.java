/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaarraylist;
import java.util.ArrayList;

/**
 *
 * @author camil
 * date: 31/08/26
 */
public class PruebaArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> personalities = new ArrayList<String>();
        personalities.add("Ada Lovelace");
        personalities.add("Alan Turing");
        personalities.add("Grace Hopper");
        
        String name = personalities.get(1);
        
        System.out.println(name);
        System.out.println("The size of the ArrayList is = " + personalities.size());
        
        personalities.remove(0);
        personalities.set(1, "Margaret Hamilton");
        System.out.println(personalities);
    }
    
}
