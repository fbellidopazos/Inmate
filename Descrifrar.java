import java.util.Scanner;
import java.util.Arrays; //Buscado en Internet
public class Descrifrar{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int[] code={1,2,3,4};
    String[] progress={"_","_","_","_"};
    int count=0;
    for (int i = 0; i < code.length; i++) {

      // accessing each element of array
      int x = code[i];
      if (x==sc.nextInt()){
      progress[i]=Integer.toString(x);
      count++;
    }
      else
      progress[i]="_";

      System.out.println(Arrays.toString(progress));
    }

    if(count==4){
      System.out.println("GG WP ");
    }
    
  }
}
