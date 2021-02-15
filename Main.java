import java.util.Scanner;
import java.util.Arrays; 
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;


class Main {
static Map<Character,Integer> map1 = new HashMap<Character,Integer>(); //array asociativo para key y value   

 static ArrayList<Integer> list = new ArrayList<>(); // lista para guardar scores y poder ordenar top10

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

} //cuentaLetras

public static void topScores(){
   for (Map.Entry<Character, Integer> entry : map1.entrySet())
    {
         list.add(entry.getValue()); // guarda los scores en una lista para ordenarlos
    } // termina for 

     // Ordenamiento de los puestos mayor a menor
	   Collections.sort(list, Collections.reverseOrder());
} //top topScores

public static void despliegaHistograma() {
  ArrayList<Character> mostrados = new ArrayList<>();
     for(int k=0; k < 10; k++) {
       for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
      if (entry.getValue() == list.get(k) && mostrados.contains(entry.getKey())== false){
        mostrados.add(entry.getKey());
        System.out.println("Char " + entry.getKey() + ":" + entry.getValue() + " "+ "\u001B[36m"+convertToStars(entry.getValue())+"\u001B[0m");
        
        } //si el valor es el mismo
      
    } // termina for del map1

    } // fin for2

} // despliegaHistograma


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
        topScores(); // ordenados todos los scores
        System.out.println("\n"+"\u001B[36m"+"----Histograma caracteres más utilizados-----"+"\u001B[0m");
        System.out.println("\n");
        despliegaHistograma();  
     
  } //fin metodo main

  } //fin main class
