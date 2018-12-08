import java.util.Scanner;
import java.util.Arrays; //Buscado en Internet (para comprobaciones)
public class Proyecto{
  //ENGAME!

  public static int[] digits(int random){
    int[] digits=new int[6];



    digits[5] = random%10;
    digits[4] = ((random/10))%10 ;
    digits[3] = ((random/100))%10 ;
    digits[2] = ((random/1000))%10 ;
    digits[1] = ((random/10000))%10 ;
    digits[0]=((random/100000))%10 ;


    return digits;


  }
  public static void engame(int numb){
    int[] code=digits(numb);
    int[] numpad={-1,-1,-1,-1,-1,-1};
    String[] progress={"_","_","_","_","_","_"};
    int count=0;
    Scanner sc=new Scanner(System.in);
    System.out.println(printAr2(progress));
    while(true){
      System.out.println("Inserte Numbero");
      int x=sc.nextInt();
      for(int i=0;i<code.length;i++){
        if(x==code[i]){
          numpad[i]=x;
          progress[i]=Integer.toString(x);
        }
      }

      if(count==6){
        System.out.println("Has sido cazado por la pasma");
        muerte();
      }

      count++;
      System.out.println("Tienes "+(7-count)+" Intentos restantes");
      System.out.println(printAr2(progress));


      if(SumAr(numpad)==SumAr(code)){
        System.out.println("GG WP");
        exit();
      }

    }




  }
  public static String printAr2(String[] arr){
    String res="";
    for(int i=0;i<arr.length;i++){
      if(i==0)
      res=""+arr[i];
      else
      res=res+","+arr[i];
    }
    return(res);
  }











  //TIC TAC TOE
  //___________________________________________________________________MARCADORES_________________________________________________________________________________________________
  public static int [] marcadores (int[][]tablero){
    int[] marcadores=new int[9];
    marcadores[0] = tablero[0][1]*tablero[0][2]*tablero[0][0];//[0]=Fila Cero
    marcadores[1] = tablero[1][1]*tablero[1][2]*tablero[1][0];//[1]=Fila Uno
    marcadores[2] = tablero[2][1]*tablero[2][2]*tablero[2][0];//[2]=Fila Dos
    marcadores[3] = tablero[0][0]*tablero[1][0]*tablero[2][0];//[3]=Columna Cero
    marcadores[4] = tablero[0][1]*tablero[1][1]*tablero[2][1];//[4]=Columna Uno
    marcadores[5] = tablero[0][2]*tablero[1][2]*tablero[2][2];//[5]=Columna dos
    marcadores[6] = tablero[0][0]*tablero[1][1]*tablero[2][2];//[6]=Diagonal Cero
    marcadores[7] = tablero[0][2]*tablero[1][1]*tablero[2][0];//[7]=Diagonal Uno
    marcadores[8] = marcadores[0]*marcadores[1]*marcadores[2];//[8]=Tablas
    return marcadores;
  }
  //_________________________________________________________________________ORIENTACIoN GANAR____________________________________________________________________________________
  public static int orientacionGanar (int [][] tablero){

    // res=1 -------- FILAS
    // res=2 -------- COLUMNAS
    // res=3 -------- DIAGONAL PRINCIPAL
    // res=4 -------- DIAGONAL SECUNDARIA

    int n = 0;
    int res = -1;

    //Comprobamos FILAS
    while(n<3){
      if ((tablero[n][0]*tablero[n][1]==4 && tablero[n][2]==0) || (tablero[n][0]*tablero[n][2]==4 && tablero[n][1]==0) || (tablero[n][2]*tablero[n][1]==4 && tablero[n][0]==0)){
        res = 1;
        n = 3;
      }
      n++;
    }

    if(n==4)
      n = 0;

    //Comprobamos COLUMNAS
    if(n>2){
      n = 0;
      while (n<3){
        if ((tablero[0][n]*tablero[2][n]==4 && tablero[1][n]==0) || (tablero[1][n]*tablero[2][n]==4 && tablero[0][n]==0) || (tablero[0][n]*tablero[1][n]==4 && tablero[2][n]==0)){
          res = 2;
          n = 3;
        }
        n++;
      }
    }

    if(n==4)
      n = 0;

    //Comprobamos DIAGONALES

    if(n>2){
      if((tablero[2][2]*tablero[1][1]==4 && tablero[0][0]==0) || (tablero[2][2]*tablero[0][0]==4 && tablero[1][1]==0) || (tablero[0][0]*tablero[1][1]==4 && tablero[2][2]==0))
        res = 3;
      else if((tablero[1][1]*tablero[2][0]==4 && tablero[0][2]==0) || (tablero[0][2]*tablero[2][0]==4 && tablero[1][1]==0) || (tablero[1][1]*tablero[0][2]==4 && tablero[2][0]==0))
        res = 4;
    }
    return res;
  }
  //__________________________________________________________________________FILA GANAR__________________________________________________________________________________________
  public static int ganarFila(int [][] tablero){
    int n = 0;
    int fila = -1;

    //Estudiamos el tablero por FILAS
    while (n<3){
      if((tablero[n][0]*tablero[n][1]==4 && tablero[n][2]==0) || (tablero[n][0]*tablero[n][2]==4 && tablero[n][1]==0) || (tablero[n][2]*tablero[n][1]==4 && tablero[n][0]==0)){
        fila = n;
        n=3;
      }
      n++;
    }

    if(n==4)
      n = 0;

    //Estudiamos el tablero por COLUMNAS
    if(n>2){
      n = 0;
      while(n<3){
        if(tablero[0][n]*tablero[2][n]==4 && tablero[1][n]==0){
          fila = 1;
          n=3;
        }else if(tablero[1][n]*tablero[2][n]==4 && tablero[0][n]==0){
          fila = 0;
          n=3;
        }else if(tablero[0][n]*tablero[1][n]==4 && tablero[2][n]==0){
          fila = 2;
          n=3;
        }
        n++;
      }
    }

    if(n==4)
      n=0;

    //Estudiamos el tablero por DIAGONALES
    if(n>2){
      if(tablero[2][2]*tablero[1][1]==4 && tablero[0][0]==0 || tablero[1][1]*tablero[2][0]==4 && tablero[0][2]==0)
        fila = 0;
      else if (tablero[2][2]*tablero[0][0]==4 && tablero[1][1]==0 || tablero[0][2]*tablero[2][0]==4 && tablero[1][1]==0)
        fila = 1;
      else if (tablero[0][0]*tablero[1][1]==4 && tablero[2][2]==0 || tablero[1][1]*tablero[0][2]==4 && tablero[2][0]==0)
        fila = 2;
    }
    return fila;
  }
  //__________________________________________________________________________COLUMNA GANAR_______________________________________________________________________________________
  public static int ganarColumna (int[][]tablero){

    int fila = ganarFila (tablero);
    int b = orientacionGanar(tablero);
    int columna = -1;

    //Estudiar columna en orientacion 1 (FILAS)
    if (b==1){
      if (tablero[fila][0]==0)
        columna = 0;
      else if (tablero[fila][1]==0)
        columna = 1;
      else if (tablero[fila][2]==0)
        columna = 2;
    }

    //Estudiar columna en orientacion 2 (COLUMNA)
    if (b==2){
      if (fila == 0){
        if (tablero[2][0]*tablero[1][0]==4 && tablero[0][0]==0)
          columna = 0;
        else if (tablero[2][1]*tablero[1][1]==4 && tablero[0][1]==0)
          columna = 1;
        else if (tablero[2][2]*tablero[1][2]==4 && tablero[0][2]==0)
          columna = 2;
      }else if (fila == 1){
        if (tablero[2][0]*tablero[0][0]==4 && tablero[1][0]==0)
          columna = 0;
        else if (tablero[2][1]*tablero[0][1]==4 && tablero[1][1]==0)
          columna = 1;
        else if (tablero[2][2]*tablero[0][2]==4 && tablero[1][2]==0)
          columna = 2;
      }else if (fila == 2){
        if (tablero[0][0]*tablero[1][0]==4 && tablero[2][0]==0)
          columna = 0;
        else if (tablero[0][1]*tablero[1][1]==4 && tablero[2][1]==0)
          columna = 1;
        else if (tablero[0][2]*tablero[1][2]==4 && tablero[2][2]==0)
          columna = 2;
      }
    }
    //Estudiar columna en orientacion 3 (DIAGONAL PRINCIPAL)
    if(b==3)
      columna = fila;

    //Estudiar columna en orientacion 4 (DIAGONAL SECUNDARIA)
    if(b==4){
      if(fila == 0)
        columna = 2;
      else if(fila == 1)
        columna = 1;
      else if(fila == 2)
        columna = 0;
    }
    return columna;
  }
  //__________________________________________________________________________ORIENTACIoN PERDER__________________________________________________________________________________
  public static int orientacionPerder (int [][] tablero){

    // res=1 -------- FILAS
    // res=2 -------- COLUMNAS
    // res=3 -------- DIAGONAL PRINCIPAL
    // res=4 -------- DIAGONAL SECUNDARIA

    int n=0;
    int res=-1;

    //Comprobamos FILAS
    while(n<3){
      if((tablero[n][0]*tablero[n][1]==1 && tablero[n][2]==0) || (tablero[n][0]*tablero[n][2]==1 && tablero[n][1]==0) || (tablero[n][2]*tablero[n][1]==1 && tablero[n][0]==0)){
        res = 1;
        n = 3;
      }
      n++;
    }

    if(n==4)
      n=0;

    //Comprobamos COLUMNAS
    if(n>2){
      n=0;
      while (n<3){
        if ((tablero[0][n]*tablero[1][n]==1 && tablero[2][n]==0) || (tablero[1][n]*tablero[2][n]==1 && tablero[0][n]==0) || (tablero[0][n]*tablero[2][n]==1 && tablero[1][n]==0)){
          res = 2;
          n=3;
        }
        n++;
      }
    }

    if(n==4)
      n=0;

    //Comprobamos DIAGONALES

    if(n>2){
      if((tablero[2][2]*tablero[1][1]==1 && tablero[0][0]==0) || (tablero[2][2]*tablero[0][0]==1 && tablero[1][1]==0) || (tablero[0][0]*tablero[1][1]==1 && tablero[2][2]==0))
        res= 3;
      else if((tablero[1][1]*tablero[2][0]==1 && tablero[0][2]==0) || (tablero[0][2]*tablero[2][0]==1 && tablero[1][1]==0) || (tablero[1][1]*tablero[0][2]==1 && tablero[2][0]==0))
        res = 4;
    }
    return res;
  }
  //______________________________________________________________________FILA EVITAR ERROR_______________________________________________________________________________________
  public static int errorFila (int [][] tablero){
    int n = 0;
    int fila = -1;

    //Estudiamos el tablero por FILAS
    while(n<3){
      if((tablero[n][0]*tablero[n][1]==1 && tablero[n][2]==0) || (tablero[n][0]*tablero[n][2]==1 && tablero[n][1]==0) || (tablero[n][2]*tablero[n][1]==1 && tablero[n][0]==0) ){
        fila = n;
        n=3;
      }
      n++;
    }

    if(n==4)
      n=0;

    //Estudiamos el tablero por COLUMNAS
    if(n>2){
      n = 0;
      while(n<3){
        if(tablero[0][n]*tablero[2][n]==1 && tablero[1][n]==0){
          fila = 1;
          n=3;
        }else if(tablero[1][n]*tablero[2][n]==1 && tablero[0][n]==0){
          fila = 0;
          n=3;
        }else if(tablero[0][n]*tablero[1][n]==1 && tablero[2][n]==0){
          fila = 2;
          n=3;
        }
        n++;
      }
    }

    if(n==4)
      n=0;

    //Estudiamos el tablero por DIAGONALES
    if(n>2){
      if(tablero[2][2]*tablero[1][1]==1 && tablero[0][0]==0 || tablero[1][1]*tablero[2][0]==1 && tablero[0][2]==0)
        fila = 0;
      else if(tablero[2][2]*tablero[0][0]==1 && tablero[1][1]==0 || tablero[0][2]*tablero[2][0]==1 && tablero[1][1]==0)
        fila = 1;
      else if(tablero[0][0]*tablero[1][1]==1 && tablero[2][2]==0 || tablero[1][1]*tablero[0][2]==1 && tablero[2][0]==0)
        fila = 2;
    }
    return fila;
  }
  //__________________________________________________________________________COLUMNA EVITAR ERROR________________________________________________________________________________
  public static int errorColumna (int[][]tablero){

    int fila = errorFila (tablero);
    int a = orientacionPerder(tablero);
    int columna = -1;

    //Estudiar columna en orientacion 1 (FILAS)
    if(a==1){
      if(tablero[fila][0]==0)
        columna = 0;
      else if(tablero[fila][1]==0)
        columna = 1;
      else if(tablero[fila][2]==0)
        columna = 2;
    }

    //Estudiar columna en orientacion 2 (COLUMNA)
    if(a==2){
      if(fila == 0){
        if(tablero[2][0]*tablero[1][0]==1 && tablero[0][0]==0)
          columna = 0;
        else if(tablero[2][1]*tablero[1][1]==1 && tablero[0][1]==0)
          columna = 1;
        else if(tablero[2][2]*tablero[1][2]==1 && tablero[0][2]==0)
          columna = 2;
      }else if(fila == 1){
        if(tablero[2][0]*tablero[0][0]==1 && tablero[1][0]==0)
          columna = 0;
        else if(tablero[2][1]*tablero[0][1]==1 && tablero[1][1]==0)
          columna = 1;
        else if(tablero[2][2]*tablero[0][2]==1 && tablero[1][2]==0)
          columna = 2;
      }else if(fila == 2){
        if(tablero[0][0]*tablero[1][0]==1 && tablero[2][0]==0)
          columna = 0;
        else if(tablero[0][1]*tablero[1][1]==1 && tablero[2][1]==0)
          columna = 1;
        else if(tablero[0][2]*tablero[1][2]==1 && tablero[2][2]==0)
          columna = 2;
      }
    }
    //Estudiar columna en orientacion 3 (DIAGONAL PRINCIPAL)
    if(a==3)
      columna = fila;

    //Estudiar columna en orientacion 4 (DIAGONAL SECUNDARIA)
    if(a==4){
      if(fila == 0)
        columna = 2;
      if (fila == 1)
        columna = 1;
      if (fila == 2)
        columna = 0;
    }
    return columna;
  }
  //______________________________________________________________________________________________________________________________________________________________________________
  public static int ticTacToe(){

    //     RESULTADO (res)
    //continuando ---------- -1
    //winnerH --------------- 1
    //winnerM --------------- 2
    //tablas ---------------- 3

    //    MARCA
    //Maquina --------------- 2
    //Usuario --------------- 1

    Scanner sc = new Scanner (System.in);
    int res = -1;
    int numeroMovimientos = 0;
    int[][] tablero = {{0,0,0},{0,0,0},{0,0,0}};
    int filaMovimiento, columnaMovimiento;
    System.out.println("Te recomiendo que saques una toalla y una botella de agua, porque vas a recibir una paliza al tres en raya.");
    System.out.print("     C0      C1      C2   \n         |       |\nF0       |       |\n  _______|_______|_______\n         |       |\nF1       |       |\n  _______|_______|_______\n         |       |\nF2       |       |\n         |       |\n");
    System.out.print("Este es el tablero, tu escribiras con 1 y yo con 2 \n \n ");

    do{
      //Mueve el jugador
      System.out.println("Introduce el numero de la fila.");
      filaMovimiento = sc.nextInt();
      System.out.println("Introduce el numero de la columna.");
      columnaMovimiento = sc.nextInt();

      if(filaMovimiento>2 || columnaMovimiento>2 || filaMovimiento<0 || columnaMovimiento<0 ){
        System.out.println("\n Te estas quedando conmigo??");
        while(filaMovimiento>2 || columnaMovimiento>2 || filaMovimiento<0 || columnaMovimiento<0){
          while(filaMovimiento>2 || filaMovimiento<0){
            System.out.println("Introduce otro numero de la fila.");
            filaMovimiento = sc.nextInt();
          }
          System.out.print ("\n");                                                                                                                  //POR QUe?? -Aida
          while(columnaMovimiento>2 || columnaMovimiento<0){
            System.out.println("Introduce otro numero de la columna.");
            columnaMovimiento = sc.nextInt();
          }
        }
        System.out.println("Aleluya!! Verdad que no era tan dificil????? \n ");
      }

      if(tablero[filaMovimiento][columnaMovimiento]!=0){
        System.out.println("Esa casilla ya esta ocupada.");
        while(tablero[filaMovimiento][columnaMovimiento]!=0){
          System.out.println("Introduce otra fila.");
          filaMovimiento = sc.nextInt();
          System.out.println("Introduce otra columna.");
          columnaMovimiento = sc.nextInt();
        }
      }

      tablero[filaMovimiento][columnaMovimiento] = 1;
      numeroMovimientos++;

      //Comprobaciones
      boolean gana = marcadores(tablero)[0]==1||marcadores(tablero)[1]==1||marcadores(tablero)[2]==1||marcadores(tablero)[3]==1||marcadores(tablero)[4]==1||marcadores(tablero)[5]==1||marcadores(tablero)[6]==1||marcadores(tablero)[7]==1;
      boolean pierde = marcadores(tablero)[0]==8||marcadores(tablero)[1]==8||marcadores(tablero)[2]==8||marcadores(tablero)[3]==8||marcadores(tablero)[4]==8||marcadores(tablero)[5]==8||marcadores(tablero)[6]==8||marcadores(tablero)[7]==8;
      boolean noExisteGanador = !gana && !pierde;
      boolean tablas = marcadores(tablero)[8]!=0;

      //Mueve la maquina
      int a = orientacionGanar(tablero);
      int b = orientacionPerder(tablero);

      if(tablas==false && gana==false){
        while(tablero[filaMovimiento][columnaMovimiento]!=0){
          if(a>0 || b>0){
            if(a>0){
              filaMovimiento = ganarFila(tablero);
              columnaMovimiento = ganarColumna(tablero);
              b=-1;
            }else if(b>0){
              filaMovimiento = errorFila(tablero);
              columnaMovimiento = errorColumna(tablero);
            }
          }else{
            filaMovimiento = (int)(Math.random()*(2+1));
            columnaMovimiento = (int)(Math.random()*(2+1));
          }
        }
        tablero[filaMovimiento][columnaMovimiento] = 2;
      }
      System.out.println("He movido a fila "+filaMovimiento+" y columna "+ columnaMovimiento+"\n ");

      //Comprobacion ganador
      pierde = marcadores(tablero)[0]==8||marcadores(tablero)[1]==8||marcadores(tablero)[2]==8||marcadores(tablero)[3]==8||marcadores(tablero)[4]==8||marcadores(tablero)[5]==8||marcadores(tablero)[6]==8||marcadores(tablero)[7]==8;
      noExisteGanador = gana!=true && pierde!=true;
      tablas = marcadores(tablero)[8]!=0;

      if(gana)
        res = 1;
      else if(pierde)
        res = 2;
      else if(noExisteGanador && tablas)
        res = 3;

      //Imprimir tablero
      System.out.print("     C0      C1      C2   \n         |       |\nF0   "+tablero[0][0]+"   |   "+tablero[0][1]+"   |   "+tablero[0][2]+"\n  _______|_______|_______\n         |       |\nF1   "+tablero[1][0]+"   |   "+tablero[1][1]+"   |   "+tablero[1][2]+"   \n  _______|_______|_______\n         |       |\nF2   "+tablero[2][0]+"   |   "+tablero[2][1]+"   |   "+tablero[2][2]+"   \n         |       |\n");

    } while (res==-1);

    return res;
  }

  /*public static void main(String[] args){
   switch (ticTacToe()){
   case 1: System.out.println ("Has ganado");break;
   case 2: System.out.println ("Has perdido");break;
   case 3: System.out.println ("Empate");break;
   }
   }*/

  //EVALUAR HANGMAN
  public static int evaluarHangman(String palabra, char intento, int aPartirDe){
    int pos = -1;
    for (int i = 0;i<palabra.length() && pos<0; i++){
      if(palabra.indexOf(intento,aPartirDe)==i)
        pos = i;
    }
    return pos;
  }

  //HANGMAN
  public static boolean hangman(){
    System.out.println("Jugemos al ahorcado, pues. ¿Quien morira?... Yo creo que tu.");
    Scanner sc = new Scanner(System.in);

    //Elegir palabra
    int random = (int)(Math.random() * 13);
    String[] listaPalabras = {"alcachofa","destornillador","explosivo","reclusa","aislamiento", "pena", "permiso", "perpetua", "reinsercion", "condena", "carcel", "sobornar", "juicio"};
    String palabra = listaPalabras[random];
    int longitud = palabra.length();
    System.out.println("Tu palabra tiene "+longitud+" letras.\nRecuerda, solo te puedes permitir tres fallos.");

    //Letras que se han acertado
    String letrasAdivinadas = "";
    for (int i=0;i<longitud;i++)
      letrasAdivinadas+="-";
    System.out.println(""+letrasAdivinadas);

    //Comprobacion de acierto y actualizacion de las letras acertadas
    int pos, fallosRestantes = 3;
    char intento;
    boolean winner = false;
    while (!winner && fallosRestantes>0){
      System.out.print("Introduce una letra.");
      intento = sc.next().toLowerCase().charAt(0);
      pos = evaluarHangman(palabra, intento, 0);
      if (pos<0){
        fallosRestantes--;
        System.out.println("Pringada! esa letra no esta. Tienes un intento menos JA JA JA ");
      }else{
        while(pos>=0){
          letrasAdivinadas = letrasAdivinadas.substring(0,pos)+intento+letrasAdivinadas.substring(pos+1,longitud);
          pos = evaluarHangman(palabra, intento, pos+1);
        }
        System.out.println("No esta mal... de momento llevas esto: "+letrasAdivinadas);
      }

      //Condicion de ganador
      if(palabra.equals(letrasAdivinadas))
        winner=true;
    }
    return winner;
  }

  //COMPROBACIONES ROCK, PAPER, SCISSORS
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

  //ROCK, PAPER, SCISSORS
  public static void ppt1(int dif) {
    Scanner sc=new Scanner(System.in);
    int scoreh=0;
    int scorem=0;
    int round=0;
    while(scoreh!=3 && scorem!=3){
      int y=(int)(Math.random() * ((3 - 1) + 1)) + 1;
      System.out.println("\nElige una opcion(Numero)\n=================\n1.-Papel\n2.-Tijeras\n3.-Piedra ");
      int x=sc.nextInt();
      if(x!=y){
        boolean who=Checkers2(x,y);
        if(who){
          scoreh ++;
          System.out.println("================================\n¡Has GANADO!");
          System.out.println("Puntuaciones: \nContrincante:"+scorem+"\nTu"+scoreh+"\n================================");
          if(dif==1 && round<2){
            round++;
            scoreh=0;
            scorem=0;
            System.out.println("Relaja las tetas.\n Esto solo acaba de empezar");
            System.out.println("Que empiece otra ronda!");
          }

        }else{
          scorem++;
          System.out.println("================================\n¡Has PERDIDO!");
          System.out.println("Puntuaciones: \nContrincante:"+scorem+"\nTu"+scoreh+"\n================================");
        }
      }else
        System.out.println("================================\n¡Otra vez!\n================================");
    }
    if(scoreh==3){
      System.out.println("Lo prometido es deuda");
    }
  }



  //El codigo del NIVEL de DIFICULTAD genera el codigo final
  public static int difficult(int dif){
      return((int)(Math.random() * ((999999 - 100000) + 1)) + 100000);
      }

  //COMANDOS FUNDAMENTALES.
  //EXIT
  public static void exit(){
    System.exit(0);
  }

  //DEATH
  public static void muerte(){
    System.out.println("          __________\n         | ___  ___ |\n         ||   ||   ||\n         ||   ||   ||\n         ||___||___||\n         |_        _|\n           |      |\n           |_|_|_||\n\nHas muerto.");
    System.exit(0);
  }

  //HOW-TO
  public static String howto(int lugar){
    String instructions = "";
    switch (lugar) {
      case 0:instructions = "======================================================\nPara jugar a INMATE unicamente necesitas saber español y leer. Las tildes SI importan, asi que recuerda ponerlas siempre. Cada sala tiene un comando 'Help' al que puedes recurrir\nsi te quedas sin ideas de que hacer. Recuerda que siempre podras escribir la palabra 'Exit' para salir del juego.";break;
      case 1:instructions = "======================================================\nLos comandos disponibles en esta sala son:\n-Pasillo\n-Hablar\n-Investigar\n-Help\n-Exit\n======================================================\n";break;//Habitacion
      case 2:instructions = "======================================================\nLos comandos disponibles en esta sala son:\n-Norte\n-Sur\n-Este\n-Oeste\n-Help\n-Exit\n======================================================\n";break;//Pasillo
      case 3:instructions = "======================================================\nLos comandos disponibles en esta sala son:\n-Norte\n-Este\n-Bancos\n-Duchas\n-Help\n-Exit\n======================================================\n";break;//S2-Baño
      case 4:instructions = "======================================================\nLos comandos disponibles en esta sala son:\n-Norte\n-Oeste\n-ppt(Piedra  Papel  Tijera)\n-Help\n-Exit\n======================================================\n";break;//S3-Enfermeria
      case 5:instructions = "======================================================\nLos comandos disponibles en esta sala son:\n-Norte\n-Sur\n-ttt(Tres  en  Raya)\n-Help\n-Exit\n======================================================\n";break;//S4-Comedor
      case 6:instructions = "======================================================\nLos comandos disponibles en esta sala son:\n-Codigo Final\n-Help\n-Exit\n======================================================\n";break;//S5
    }
    return (instructions);
  }

  //DESCRIPTIONS
  public static String description(int sala){
    String des = "";
    switch(sala){
      case 1:des = "Esta es tu habitacion, en la que convives con tu compañera.\nTiene una puerta por la que puedes salir al pasillo, una ventana, tus cosas y las de tu compañera. Puedes investigar las cosas de tu compañera, ¿por que no lo intentas?";break;
      case 2:des = "Este es el sucio baño que usas todos los dias. Las duchas estan en la pared que hay a tu derecha,\ny los retretes en la que tienes en frente. A tu izquierda hay unos bancos anclados al suelo, donde se visten las reclusas despues de las duchas.\nHace tiempo decidiste pasar al baño unicamente cuando hubiese poca gente. Ironicamente aqui es donde se suele 'jugar' al ahorcado.";break;
      case 3:des = "Te encuentras en la enfermeria.\nEn esta sala,hay una enfermera(Cuyas apariencias resultan muy sinuiosas para formar parte del cuerpo de trabajadores de la carcel) ,ademas se observan <Aqui el Objeto> ";break;
      case 4:des = "";;break;
      case 5:des = "";break;
      case 6:des = "Estas en medio del pasillo muevete en alguna direccion.";break;
      default:des = "";break;
    }
    return(des);
  }

  //SETTINGS
  public static String settings(int[] ingame){
    Scanner sc = new Scanner(System.in);
    while(true){
      System.out.println("\n-------------------------------------------------------------------------\nMenu \n============================== \n   - Dificultad: Facil/Dificil \n   - Graficos: HD/Ahorro \n   - Return \n\n Escribe a lo que quieres cambiar, por ejemplo, si quieres cambiar los graficos escribe HD\n-------------------------------------------------------------------------\n");
      String settingsInput= sc.nextLine();
      settingsInput=settingsInput.toLowerCase();
      switch(settingsInput){
        case "facil":ingame[1]=0;System.out.println("-------------------------------------------------------------------------\nModo dificil: Desactivado\n----------------------------------------------------------------------");break;
        case "dificil":ingame[1]=1;System.out.println("-------------------------------------------------------------------------\nModo dificil: Activado\n-------------------------------------------------------------------------");break;
        case "hd":
        case "ahorro":System.out.println("-------------------------------------------------------------------------\n Los 'Text Adventure' no tienen graficos ;)\n-------------------------------------------------------------------------");break;
        case "return": return("");
        default:System.out.println("-------------------------------------------------------------------------\nOption Does NOT Exist\n-------------------------------------------------------------------------");break;
      }
    }
  }

  //START MENU
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("-------------------------------------------------------------------------\nBienvenid@ a INMATE.");
    int[] inventory = {0,0,0,0,0,0,0,0};
    int[] ingame={/*Inmate Number*/0,/*Dificultad*/0,0,0};//Array Dificultad,codigo ,final y final

    while(true){
      System.out.println("\n-------------------------------------------------------------------------\nMenu:\n   - Play \n   - How-To \n   - Settings \n   - Exit \nModo: Facil\n-------------------------------------------------------------------------\n");
      String menuintput = sc.nextLine().toLowerCase();
      switch(menuintput){
        case "play":
          ingame[0] = difficult(ingame[1]);//Codigo Inmate.
          System.out.println("\n-------------------------------------------------------------------------\nBienvenid@ a Inmate:"+ingame[0]);
          System.out.println("Si necesitas ayuda en cualquier momento, escribe help\n-------------------------------------------------------------------------\n");
          boolean boolRespuesta = false;
          String respuesta = "";
          for(int dias=230;!boolRespuesta; dias+=50){
            System.out.println("Buenos dias reclusa. Llevas "+dias+" dias encerrada en esta prision de maxima seguridad. ¿Quieres escapar?");
            respuesta = sc.next().toLowerCase().substring(0,1);
            if(respuesta.equals("s"))
              boolRespuesta = true;
          }
          sala1(inventory,ingame);
          break;
        case "how-to": System.out.println(howto(0));break;
        case "settings": System.out.println(settings(ingame));break;
        case "exit": exit();break;
        case "debug":ingame[0] = difficult(ingame[1]);sala5(inventory,ingame);break;
        default: System.out.println("\n-------------------------------------------------------------------------\n"+"text"+"\n-------------------------------------------------------------------------\n");break;
      }
    }
  }

  //Utilities
  public static int SumAr(int[] arr){
    int res = 0;
    for(int i=0;i<arr.length;i++)
      res+=arr[i];
    return(res);
  }

  //Cambia Objetos dado el inventario y la posicion de un objeto
  public static void CambObjt(int[] inventory,int posobj){
    Scanner sc=new Scanner(System.in);
    int[] poss=listObj(inventory);
    int x=sc.nextInt();
    boolean condition=true;

    for(int i=0;i<poss.length && inventory[posobj]!=1 && condition ;i++){
      if(x==posobj || (x!=poss[i] && x>=0 && x<=7)){
        System.out.println("Error");
        x=sc.nextInt();
        i=0;
      }
      else if(x==poss[i] && poss[i]!=-1 ){
        inventory[x]=0;
        inventory[posobj]=1;
      }
      else {
        condition=false;
      }
    }
  }







public static int[] listObj(int[] inventory){
  String res="Null";
  int[] pos={-1,-1,-1,-1,-1,-1,-1,-1};

  for(int i=0;i<inventory.length;i++)
  if(inventory[i]==1){
    switch (i+1){
      case 1: res="0.-movil"; break;
      case 2: res="1.-pastillas"; break;
      case 3: res="2.-ladrillo"; break;
      case 4: res="3.-foto"; break;
      case 5: res="4.-ladrillo"; break;
      case 6: res="5.-tornillo"; break;
      case 7: res="6.-rotulador"; break;
      case 8: res="7.-hierro oxidado"; break;
    }
    System.out.println(res);
    pos[i]=i;


  }
  System.out.println("Por favor introduce Numero\n   Escribe cualquier otro numero distinto de 0-7 para salir  ");
  return pos;
}
public static String printAr(int[] arr){
  String res="";
  for(int i=0;i<arr.length;i++){
    if(i==0)
    res=""+arr[i];
    else
    res=res+","+arr[i];
  }
  return(res);
}


  //SALAS
  //Sala 1-Habitacion
  public static void sala1(int[] inventory,int[] ingame){
    System.out.println(description(1));
    Scanner sc = new Scanner(System.in);
    while(true){
      String sala1Input = sc.nextLine().toLowerCase();
      boolean companera = true;
      switch(sala1Input){
        case "pasillo": pasillo(inventory,ingame);break;
        case "hablar":
          if (companera){
          System.out.println("Que miras payasa!\nApartate si no quieres arrepentirte...\nLlevo 3 años en este agujero de ratas y no estoy para aguantar a niñatas.\nTu compañera se levanta irritada y abandona la celda.");
          companera = false;
        }else
          System.out.println("Tu compañera no esta en la habitacion en este momento.");
        break;
        case "investigar":
          if (companera){
		    System.out.println("Tu compañera te mira confundida, pero rapidamente se enfada contigo. '¿Que haces mirando mis cosas?'");
            muerte();
        }else{
          System.out.println("Dentro de la mochila de tu compañera hay una antigua foto en la que aparece ella con su hija, una botella de agua y un tornillo. Investigando mas a fondo descubres un falso fondo. ¿Que quieres hacer?");
          while(true){
            String mochilaInput = sc.nextLine().toLowerCase();
            switch (mochilaInput){
              case "tornillo": break;
              case "botella": break;
              case "foto": break;
              case "investigar":
                System.out.println("Levantas el falso fondo de la mochila y descubres que tu compañera tenia un movil.\n¿Quieres guardarlo?");
                String respuesta = ((sc.nextLine()).toLowerCase()).substring(0,1);
                boolean a = false;
                if(respuesta.equals("s")){
                  a = true;
                  if(SumAr(inventory)<8){
                    inventory[0]=1;
                    //No tocar necesitais explicacion
                  }else{
                    System.out.println("No tienes espacio en la mochila para guardar ese objeto, Quieres cambiarlo por otro objeto?");
                    respuesta = sc.next().toLowerCase().substring(0,1);
                    if (respuesta.equals("s")){
                      CambObjt(inventory,0);
                    }
                  }
                }else{
                  a = false;
                }
                break;
            }
          }
        }
        break;
        case "help":System.out.println(howto(1));break;
        default: System.out.println("Ese comando no existe. Escribe 'help' si necesitas recibir ayuda.");break;
        case "exit":exit();
      }
    }
  }

  //Pasillo
  public static void pasillo(int[] inventory,int[] ingame){
    System.out.println(description(6));
    Scanner sc = new Scanner(System.in);
    while(true){
      String pasilloInput = sc.nextLine().toLowerCase();
      switch(pasilloInput){
        case "norte": sala4(inventory,ingame);break;
        case "este": sala3(inventory,ingame);break;
        case "oeste": sala2(inventory,ingame);break;
        case "help": System.out.println(howto(2));break;
        case "exit":exit();break;
        default: System.out.println("Ese comando no existe. Escribe 'help' si necesitas recibir ayuda.");break;
      }
    }
  }

  //Sala 2-Baño (ahorcado)
  public static void sala2(int[] inventory,int[] ingame){
    System.out.println(description(2));
    Scanner sc = new Scanner(System.in);
    String respuesta = "";
    while(true){
      String sala1Input= sc.nextLine().toLowerCase();
      switch(sala1Input){
        case "bancos":
          System.out.println("Al acercarte a los bancos, ves que hay un rotulador caido cerca de una de las paredes de la habitacion. ¿Quieres guardarlo?");
          respuesta = ((sc.nextLine()).toLowerCase()).substring(0,1);
          boolean a = false;
          if(respuesta.equals("s")){
            a = true;
            if(SumAr(inventory)<8)
              inventory[6]=1;
            else{
              System.out.println("No tienes espacio en la mochila para guardar ese objeto, Quieres cambiarlo por otro objeto?");
              respuesta = sc.next().toLowerCase().substring(0,1);
              if (respuesta.equals("s")){
                CambObjt(inventory, 6);
              }
            }
          }else
            a = false;
          break;
        case "duchas":
          System.out.println("Parece que alguien ha pintado el tablero de un ahorcado en la pared de las duchas. ¿Quieres acercarte?");
          respuesta = ((sc.nextLine()).toLowerCase()).substring(0,1);
          if(respuesta.equals("s")){
			System.out.println("Al acercarte a investigar, aparece una reclusa de la zona de los retretes. Que haces en mi ducha pingaja,¿acaso quieres jugar?");
            respuesta = ((sc.nextLine()).toLowerCase()).substring(0,1);
            if(inventory[6]==1 && respuesta.equals("s"))
              if(hangman())
                System.out.println("Enhorabuena, no eres tan tonta como pensaba.\nBuena suerte, dice la reclusa. Te da un papel y se va hacia los retretes.\nCuando desaparece de tu vista, lo abres y ves el numero ** escrito en el. 'Que extraño'piensas.");
            else if(respuesta.equals("s"))
              System.out.println("Pero si no tienes nada con lo que escribir, te dice con asco la reclusa. ¡Largo de aqui!.");
            else
              System.out.println("¡Pues entonces largo de aqui!.");
		  }
         ;break;
        case "help":System.out.println(howto(3));break;
        case "exit":exit();break;
        default: System.out.println("Ese comando no existe. Escribe 'help' si necesitas recibir ayuda.");break;
      }
    }
  }


  //Sala 3-Enfermeria (piedra papel o tijera)
  public static void sala3(int[] inventory,int[] ingame){
    System.out.println(description(3));
    Scanner sc = new Scanner(System.in);
    while(true){
      String sala3Input= sc.nextLine().toLowerCase();
      switch(sala3Input){

        case "norte":System.out.println("¡Atencion! Entras en un punto de no retorno.");sala5(inventory,ingame);break;
        case "oeste":pasillo(inventory, ingame);break;
        case "ppt":
        if(inventory[2]==1){
          System.out.println("Sabia eleccion...\nNo obstante,para obtener lo que yo he de guardar,deberas jugar a un sencillo juego de niños... \n Sencillo verdad?");
          ppt1(ingame[1]);

        }
        else{
          System.out.println("Te crees que porque sea la enfermera te voy a ayudar.\nTan solo necesito arreglar esta pared y... con estas tijeras y papel que me dan no hago nada\nSi me das lo que necesito te ayudo.");
        };
        break;

        case "help":System.out.println(howto(4));break;
        case "exit":exit();break;
        default: System.out.println("Ese comando no existe. Escribe 'help' si necesitas recibir ayuda.");break;
      }
    }
  }


  //Sala 4-Comedor (tres en raya)
  public static void sala4(int[] inventory,int[] ingame){
    System.out.println(description(4));
    Scanner sc = new Scanner(System.in);
    while(true){
      String sala4Input= sc.nextLine().toLowerCase();
      switch(sala4Input){
        case "norte":System.out.println("¡Atencion! Entras en un punto de no retorno.");sala5(inventory,ingame);break;
        case "oeste":pasillo(inventory,ingame);break;
        case "ppt": ;break;
        case "help":System.out.println(howto(3));break;
        case "exit":exit();break;
        default: System.out.println("Ese comando no existe. Escribe 'help' si necesitas recibir ayuda.");break;
      }
    }
  }


  //Sala 5-Sala de control
  public static void sala5(int[] inventory,int[] ingame){
    System.out.println(description(5));
    Scanner sc = new Scanner(System.in);
    while(true){
      String sala5Input= sc.nextLine().toLowerCase();
      switch(sala5Input){
        case "endgame":engame(ingame[0]);break;
        case "help":System.out.println(howto(4));break;
        case "exit":exit();break;
        default: System.out.println("Ese comando no existe. Escribe 'help' si necesitas recibir ayuda.");break;
      }
    }
  }
}
