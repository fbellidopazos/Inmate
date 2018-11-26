import java.util.Scanner;
import java.util.Arrays; //Buscado en Internet
public class Proyecto{


































  //============================================================================================================================================================================================================================
  //Funciones varias
  public static int[] Code(int random,int Difficulty){

    if(Difficulty==0){
      int[] digits = new int[4];
      digits[3] = random%10;
      digits[2] = ((random/10))%10 ;
      digits[1] = ((random/100))%10 ;
      digits[0] = ((random/1000))%10 ;
      System.out.println(Arrays.toString(digits));
      return digits;
    }else{
      int[] digits = new int[5];
      digits[4] =random%10;
      digits[3] = ((random/10))%10 ;
      digits[2] = ((random/100))%10 ;
      digits[1] = ((random/1000))%10 ;
      digits[0] = ((random/10000))%10 ;
      System.out.println(Arrays.toString(digits));
      return digits;
    }


    // Buscado en Internet   https://stackoverflow.com/questions/8557716/how-to-return-multiple-values   https://stackoverflow.com/questions/409784/whats-the-simplest-way-to-print-a-java-array
  }
  //El codigo del nivel de dificultad genera codigo
  public static int Difficult(int dif){
    if(dif==0){
      return((int)(Math.random() * ((9999 - 1000) + 1)) + 1000);
    }
    else{
      return((int)(Math.random() * ((99999 - 10000) + 1)) + 10000);
    }
  }



  //================================================================================================================================================================================================================================================
  //COMANDOS FUNDAMENTALES.
  //EXIT
  public static void Exit(){
    System.exit(0);
  }
  //HOW-TO
  public static String howto(int lugar){
    String Instructions="";
    switch (lugar) {
      case 0:Instructions="";break;
      case 1:Instructions="";break;
      case 2:Instructions="";break;
      case 3:Instructions="";break;
      case 4:Instructions="";break;
    }


    return (Instructions);
  }
  public static String Description(int sala){
    String des="";
    switch(sala){
      case 1:des="";;break;
      case 2:des="";;break;
      case 3:des="";;break;
      case 4:des="";;break;
      default:;break;
    }
    return(des);

  }

  //================================================================================================================================================================================================================================================
  //SETTINGS
  public static String Settings(int[] ingame){
    Scanner sc = new Scanner(System.in);


    while(true){
      System.out.println("\n-------------------------------------------------------------------------\nMenu \n============================== \n 1.-Difficulty : Easy/Difficult \n 2.- Graphics : High/Low \n 3.- Return \n\n NOTE: Write the change i.e. Want to change graphics write Easy\n-------------------------------------------------------------------------\n");
      String SettingsInput= sc.nextLine();
      SettingsInput=SettingsInput.toLowerCase();
      switch(SettingsInput){
        case "easy":ingame[1]=0;break;
        case "difficult":ingame[1]=1;break;
        case "high":case "low":System.out.println("\n-------------------------------------------------------------------------\n REALLY???!!!!: \n (╯°□°）╯︵ ┻──┻ \n\n ┬──┬◡ﾉ(° -°ﾉ)) \n NOTE: There is no Text Adventure with Graphics\n-------------------------------------------------------------------------\n");break;
        case "return":return("\n-------------------------------------------------------------------------\n Returned\n-------------------------------------------------------------------------\n");
        default:System.out.println("\n-------------------------------------------------------------------------\nOption Does NOT Exist\n-------------------------------------------------------------------------\n");break;
      }

    }
  }


  //================================================================================================================================================================================================================================================
  //================================================================================================================================================================================================================================================

  //START MENU
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("-------------------------------------------------------------------------\nWelcome to INMATE.");

    int[] Inventory={0,0,0,0};//Array Inventario
    int[] ingame={/*Inmate Number*/0,/*Dificultad*/0,0,0};//Array Dificultad,codigo ,final y final


    while(true){
      System.out.println("\n-------------------------------------------------------------------------\n Menu \n============================== \n 1.- Play \n 2.- How-To \n 3.- Settings \n 4.- Exit \n\n NOTE 1: Write the option i.e. Want to Play -> write Play\n NOTE 2: Default mode=Easy\n-------------------------------------------------------------------------\n");
      String menuintput= sc.nextLine();
      menuintput=menuintput.toLowerCase();

      switch (menuintput) {
        case "play":
        System.out.println("\n-------------------------------------------------------------------------\nWelcome to Inmate");
        System.out.println("Si no sabes/recuerdas com jugar escribe how-to\n-------------------------------------------------------------------------\n");
        ingame[0]=Difficult(ingame[1]);//Codigo Inmate.

        Sala1(Inventory,ingame);
        break;

        case "how-to":
        System.out.println(howto(0));break;

        case "settings":
        System.out.println(Settings(ingame));break;

        case "debug":
        System.out.println(TicTacToe());break;

        case "exit":
        Exit();break;

        default:
        System.out.println("\n-------------------------------------------------------------------------\nOption Does NOT Exist\n-------------------------------------------------------------------------\n");break;
      }
    }

  }
  //================================================================================================================================================================================================================================================
  //================================================================================================================================================================================================================================================
  //Sala 1-Principal
  public static void Sala1(int[] Inventory,int[] ingame){
    System.out.println("\n-------------------------------------------------------------------------\nDescripcion Sala1\n-------------------------------------------------------------------------\n");
    Scanner sc = new Scanner(System.in);
    while(true){
      String Sala1Input= sc.nextLine();
      Sala1Input=Sala1Input.toLowerCase();
      switch(Sala1Input){

        case "help":System.out.println(howto(1));break;
        case "exit":Exit();break;
      }

    }
  }


  //================================================================================================================================================================================================================================================
  //MINIJUEGOS!
  //TicTacToe
  public static int[] Checkers(int[][] tablero){
    int[] resultado=new int[9];

    resultado[0] = tablero[0][1]*tablero[0][2]*tablero[0][0];//[0]=Fila Cero
    resultado[1] = tablero[1][1]*tablero[1][2]*tablero[1][0];//[1]=Fila Uno
    resultado[2] = tablero[2][1]*tablero[2][2]*tablero[2][0];//[2]=Fila Dos
    resultado[3] = tablero[0][0]*tablero[1][0]*tablero[2][0];//[3]=Columna Cero
    resultado[4] = tablero[0][1]*tablero[1][1]*tablero[2][1];//[4]=Columna Uno
    resultado[5] = tablero[0][2]*tablero[1][2]*tablero[2][2];//[5]=Columna dos
    resultado[6] = tablero[0][0]*tablero[1][1]*tablero[2][2];//[6]=Diagonal Cero
    resultado[7] = tablero[0][2]*tablero[1][1]*tablero[2][0];//[7]=Diagonal Uno
    resultado[8] = resultado[0]*resultado[1]*resultado[2];//[8]=Tablas

    return(resultado);

  }

  public static String TicTacToe(){
    Scanner sc = new Scanner(System.in);
    boolean winnerH = false;
    boolean winnerIA = false;
    int[] resultado=new int[9];
    // 1.Usuario 2.Maquina
    //System.out.println("Te recomiendo que saques un papel y una botella de agua, porque vas a recibir una paliza al tres en raya.");
    System.out.print("     C0      C1      C2   \n         |       |\nF0       |       |\n  _______|_______|_______\n         |       |\nF1       |       |\n  _______|_______|_______\n         |       |\nF2       |       |\n         |       |\n");
    int[][] tablero = {{0, 0, 0},{0, 0, 0},{0, 0, 0}};
    int filaMovimiento, columnaMovimiento;
    boolean condicion;
    do{
      //Mueve el jugador
      System.out.println("Introduce la fila.");
      filaMovimiento = sc.nextInt();
      System.out.println("Introduce la columna.");
      columnaMovimiento = sc.nextInt();
      if(tablero[filaMovimiento][columnaMovimiento]!=0)
      System.out.println("Esa casilla ya está ocupada.");
      else
      tablero[filaMovimiento][columnaMovimiento] = 1;


      //Comprobacion estado Humano
      resultado=Checkers(tablero);
      if(resultado[0]==1||resultado[1]==1||resultado[2]==1||resultado[3]==1||resultado[4]==1||resultado[5]==1||resultado[6]==1||resultado[7]==1){
        winnerH = true;

      }
      condicion = !winnerH && resultado[8]==0;



      //Mueve la máquina
      do{
        filaMovimiento = (int)(Math.random()*(2+1));
        columnaMovimiento = (int)(Math.random()*(2+1));
      }while(tablero[filaMovimiento][columnaMovimiento]!=0);
      tablero[filaMovimiento][columnaMovimiento] = 2;
      System.out.println("He movido a fila "+filaMovimiento+" y columna "+ columnaMovimiento);

      //Comprobacion estado Maquina
      resultado=Checkers(tablero);
      if(resultado[0]==8||resultado[1]==8||resultado[2]==8||resultado[3]==8||resultado[4]==8||resultado[5]==8||resultado[6]==8||resultado[7]==8){
        winnerIA = true;

      }
      condicion = !winnerIA && resultado[7]==0;
      System.out.print("     C0      C1      C2   \n         |       |\nF0   "+tablero[0][0]+"   |   "+tablero[0][1]+"   |   "+tablero[0][2]+"\n  _______|_______|_______\n         |       |\nF1   "+tablero[1][0]+"   |   "+tablero[1][1]+"   |   "+tablero[1][2]+"   \n  _______|_______|_______\n         |       |\nF2   "+tablero[2][0]+"   |   "+tablero[2][1]+"   |   "+tablero[2][2]+"   \n         |       |\n");


    } while (condicion);



    //RESULTADO FINAL
    String res="Has perdido";
    if(winnerH)
    res= ("Has Ganado!");
    return res;
  }


}
