/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NombresArrayList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author camil
 */ 
class nameCount {

    String name;
    int count;

    public nameCount(String name) {
        this.name = name;
        this.count = 1;
    }

    public void incrementCount() {
        this.count++;
    }

    public String getName() {
        return this.name + " (" + this.name + ") ";
    }
}
public class NombreArrayList {
    public static void main(String[] args){ 
        Path filePath = Paths.get("/Users/camil/Documents/FundamentosdeComputacion3/FundamentosdeComputacion3/fd_3/fundamentos_3_2026/NombresArrayList2/listado.txt");
        ArrayList<String> namesList = readNamesFromFile(filePath.toString());
        int FIRSTNAME=0;
        int FIRST_LASTNAME=1;
        int LAST_LASTNAME=2;
        printNames(namesList);
        ArrayList<String> countedNames = countNames(namesList,FIRSTNAME);
        printNames(countedNames);
        ArrayList<String> countedFirstLastNames = countNames(namesList, FIRST_LASTNAME);
        printNames(countedFirstLastNames);
        System.out.println("Last Last Names count:");
        ArrayList<String> countedLastLastNames = countNames(namesList, LAST_LASTNAME);
    }
    
    public static ArrayList<String>readNamesFromFile(String filePath) {
        ArrayList<String> names = new ArrayList<>();
        try{
            Stream<String> lines = Files.lines(Paths.get(filePath));
            for (String line : (Iterable<String>) lines::iterator){
                names.add(line);
            }
            lines.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return names;
    }

    public static void printNames(ArrayList<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
     
    public static ArrayList<String> countNames(ArrayList<String> names, int pos){
        ArrayList<nameCount> countedNames = new ArrayList<>();
        //int pos = 0;
        for (String name : names){
            String[] splitName = name.split(" ");
            boolean found = false;
            for (nameCount nc : countedNames){
                if (nc.name.equals(splitName[pos])){
                   nc.incrementCount();
                   found = true;
                   break;
                }
            } 
            if(!found){
                countedNames.add(new nameCount(splitName[pos]));
            } 
        }
        ArrayList<String> result = new ArrayList<>();
        for (nameCount nc : countedNames) {
            result.add(nc.getName());
        }
        return result;
    }
}
    

