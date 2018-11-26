import java.util.Scanner;
public class TickTacToe{
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
  public static void main(String[] args) {
    System.out.println(TicTacToe());
  }
}
