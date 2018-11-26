import java.util.Scanner;
public class ppt{
  public static boolean Checkers2(int x,int y){
    boolean who=false;
    if((x == 1) && (y==2))
      who=false;
    else if((x == 2) && (y==3))
      who=false;
    else if((x == 3) && (y==1))
      who=false;
    else
      who=true;


    return who;
  }

  public static void ppt1() {
    Scanner sc=new Scanner(System.in);
    int scoreh=0;
    int scorem=0;



    while(scoreh!=3 && scorem!=3){
      int y=(int)(Math.random() * ((3 - 1) + 1)) + 1;

      System.out.println("Insert Choice(Number)\n=================\n1.-Papel\n2.-Tijeras\n3.-Piedra");
      System.out.println(y);
      int x=sc.nextInt();

      if(x!=y){
        boolean who=Checkers2(x,y);
        if(who){
          scoreh ++;
          System.out.println("================================\nHuman WON!");
          System.out.println("Scores: \nMachine:"+scorem+"\nHuman"+scoreh+"\n================================");
        }
        else{
          scorem++;
          System.out.println("================================\nMachine WON!");
          System.out.println("Scores: \nMachine:"+scorem+"\nHuman"+scoreh+"\n================================");
        }
      }
      else{
        System.out.println("================================\nAgain!\n================================");
      }
    }
  }




  public static void main(String[] args) {
    ppt1();
  }
}
