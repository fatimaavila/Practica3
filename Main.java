import java.util.Scanner;
import java.util.Arrays; 
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;


class Main {
static Map<Character,Integer> map1 = new HashMap<Character,Integer>(); //array asociativo para key y value         

private static String convertToStars(int num) {
    StringBuilder builder = new StringBuilder();
    for (int j = 0; j < num; j++) {
        builder.append('*');
    }
    return builder.toString();
} // metodo para string estrellitas (histograma)

public static void cuentaLetras(char[] c)
{
   for(int k=0; k < c.length; k++)
    {
      char currentChar = c[k];  
        //to check that currentChar is not in map, if not will add 1 count for firsttime
       if(map1.get(currentChar) == null){
        map1.put(currentChar, 1); 
      } 
      /*If it is repeating then simply we will increase the count of that key(character) by 1*/
      else {
        map1.put(currentChar, map1.get(currentChar) + 1);
      }
    } //todo el parrafo

}
///======================== main=====================

  public static void main(String[] args) {
    String parrafo;
     Scanner sc=new Scanner(System.in);
        System.out.print("::Ingrese sus párrafos aquí::\n\t"); 
       // sc.skip("\u0085");
        
        parrafo=sc.nextLine();
        parrafo=parrafo.toUpperCase();
        parrafo= parrafo.replaceAll("\\s+",""); // quitar los espacios
        //parrafo= parrafo.replaceAll("\r\n","");
        char[] c=parrafo.toCharArray();
        
        cuentaLetras(c);  //llena array asociativo
   

    //Now To find the highest character repeated 
    //int max=0;
    //char maxCharacter = 'a';//setting to a by default
    System.out.println("\n");
    ArrayList<Integer> list = new ArrayList<>();
    for (Map.Entry<Character, Integer> entry : map1.entrySet())
    {
        //System.out.println("Key= " + entry.getKey() + " " + entry.getValue() + " "+ convertToStars(entry.getValue()));
         list.add(entry.getValue());
      
    } // termina for 

     /* Sorting in decreasing order*/
	   Collections.sort(list, Collections.reverseOrder());
     
     ArrayList<Character> mostrados = new ArrayList<>();

     for(int k=0; k < 10; k++) {
       for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
      if (entry.getValue() == list.get(k) && mostrados.contains(entry.getKey())== false){
        mostrados.add(entry.getKey());
        System.out.println("Key=" + entry.getKey() + " " + entry.getValue() + " "+ "\u001B[36m"+convertToStars(entry.getValue())+"\u001B[0m");
        
        } //si el valor es el mismo
      
    } // termina for del map1

    } // fin for2

  
  } //fin metodo main

  } //fin main class
