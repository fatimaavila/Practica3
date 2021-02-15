import java.util.Scanner;
import java.util.Arrays; 
import java.util.HashMap;
import java.util.Map;

class Main {
private static String convertToStars(int num) {
    StringBuilder builder = new StringBuilder();
    for (int j = 0; j < num; j++) {
        builder.append('*');
    }
    return builder.toString();
}

  public static void main(String[] args) {
    String parrafo;
     Scanner sc=new Scanner(System.in);
        System.out.print("::Start Entering Paragraph from Here::\n\t"); 
        
        parrafo=sc.nextLine();
        parrafo=parrafo.toUpperCase();
        parrafo= parrafo.replaceAll("\\s+","");
        char[] c=parrafo.toCharArray();
        System.out.println(parrafo);
        //System.out.print("\nTotal Character :=:"+c.length+"\nTotal Spaces :=:"+ (parrafo.length()-parrafo.replace(" ", "").toCharArray().length));

       // System.out.println("\nTotal Strings :=:"+ parrafo.split(" ").length);

         Map<Character,Integer> map1 = new HashMap<Character,Integer>();

    for(int k=0; k < c.length; k++)
    {
      char currentChar = c[k];  
        //System.out.println("current char ->"+ (k+1) +" " + c[k]);  
        //to check that currentChar is not in map, if not will add 1 count for firsttime
       if(map1.get(currentChar) == null){
        map1.put(currentChar, 1); 
      } 
      /*If it is repeating then simply we will increase the count of that key(character) by 1*/
      else {
        map1.put(currentChar, map1.get(currentChar) + 1);
      }

  
      
    } //todo el parrafo

    //Now To find the highest character repeated 
    int max=0;
    char maxCharacter = 'a';//setting to a by default
    for (Map.Entry<Character, Integer> entry : map1.entrySet())
    {
        System.out.println("Key= " + entry.getKey() + " " + convertToStars(entry.getValue()));
        if(max<entry.getValue()){
            max=entry.getValue();
            maxCharacter=entry.getKey();
      }
    }
    System.out.println("Max Character= " + maxCharacter + "Max Count " + max);
  }

  }
