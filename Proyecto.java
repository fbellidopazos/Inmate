import java.util.Scanner;
public class Proyecto{

  public static final String NORTE = "norte";
  public static final String OESTE = "oeste";
  public static final String ESTE = "este";
  public static final String HELP = "help";
  public static final String EXIT = "exit";
  public static final String NOTAS = "notas";
  public static final String INVENTARIO = "inventario";

//JUEGOS
  //TIC TAC TOE
  //___________________________________________________________________MARCADORES_________________________________________________________________________________________________
  public static int [] marcadores (int[][]tablero){
    int[] marcadores = new int[9];
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
  public static boolean hangman(int dificultad){
    System.out.println("Jugemos al ahorcado, pues. ¿Quien morira?... Yo creo que tu.");
    Scanner sc = new Scanner(System.in);

    //Elegir palabra
    int random = (int)(Math.random() * 13);
    String[] listaPalabras = {"alcachofa","destornillador","explosivo","aislamiento","pena","permiso","perpetua","reclusa","condena","sobornar","juicio","presa","crimen"};
    String palabra = listaPalabras[random];
    int longitud = palabra.length();
    System.out.println("Tu palabra tiene "+longitud+" letras.");
    if(dificultad!=1)
      System.out.println("Recuerda, solo te puedes permitir tres fallos.");

    //Letras que se han acertado
    String letrasAdivinadas = "";
    for (int i=0;i<longitud;i++)
      letrasAdivinadas+="-";
    System.out.println(""+letrasAdivinadas);

    //Comprobacion de acierto y actualizacion de las letras acertadas
    int pos, fallosRestantes = 3;
    char intento;
    boolean winner = false;
    if(dificultad==1)
      fallosRestantes = 1;
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

  //Movimientos ROCK PAPER SCISSORS a palabra
  public static String mov(int a){
    String res;
    switch (a){
      case 1: res = "Papel"; break;
      case 2: res = "Tijeras"; break;
      case 3: res = "Piedra"; break;
      default: res = "ERROR"; break;
    }
    return res;
  }

  //Comprobacion de ganador ROCK PAPER SCISSORS (False gana Humano, True gana la Maquina)
  public static boolean checkers(int x,int y){
    boolean who=false;
    if((x==1)&&(y==2))
      who=true;
    else if((x==2)&&(y==3))
      who=true;
    else if((x==3)&&(y==1))
      who=true;
    return who;
  }

  //ROCK PAPER SCISSORS
  public static boolean ppt1(int dificultad) {
    //Declarar variables
    Scanner sc = new Scanner(System.in);
    int scoreh = 0, scorem = 0, round = 0, textoG = 0, textoP = 0, y, x, trol = 0, numRound = 3;
    do{
      y = (int)(Math.random() * ((3 - 1) + 1)) + 1;
      System.out.println("\nElige el numero: \n=================\n1.- Papel\n2.- Tijeras\n3.- Piedra ");
      x = sc.nextInt();
      //Version dificil
      if (dificultad==1){
        System.out.println("¿A cuantos puntos quieres jugar?");
        numRound = sc.nextInt();
      }
      //Fuera de opciones (trol)
      while(x>3 || x<1){
        if(trol==0){
          System.out.println("Te crees muy lista, no?\nTe doy una ultima oportinudad.\n\nElige el numero:\n1.- Papel\n2.- Tijeras\n3.- Piedra ");
          x = sc.nextInt();
        }else if(trol==1){
          scorem++;
          System.out.println("Mi paciencia tiene un limite, y tu lo has cruzado.\nComo eres taaaan lista no te importara que me sume un punto, no?\n¡¡Listo!! Espero que te haya quedado clarito, venga, te toca y a partir de ahora se acabaron las tonterias.\n\nElige el numero:\n1.- Papel\n2.- Tijeras\n3.- Piedra ");
          x = sc.nextInt();
        }else{
          System.out.println("¡¡OTRA VEZ!!\nMira cielo, has vacilado a la persona equivocada...");
          muerte();
        }
        trol++;
      }
      //Comprobacion
      while(x==y){
        System.out.println("Hemos sacado las dos: "+mov(x)+"\nVenga, otra vez\n\nElige el numero: \n=================\n1.- Papel\n2.- Tijeras\n3.- Piedra ");
        y = (int)(Math.random()*((3 - 1) + 1)) + 1;
        x = sc.nextInt();
      }
      System.out.println("He sacado: "+mov(y)+"\nHas sacado: "+mov(x));
      round++;
      boolean who = checkers(x,y);
      if(who==false){
        scoreh++;
        System.out.println("Un punto para ti\nPuntuaciones: \n- Contrincante:"+scorem+"\n- Tu:"+scoreh+"\n================================");
        if(textoG>0 && textoG<4 && scoreh<3){
          switch(textoG){
            case 1:
              if(scoreh>scorem)
              System.out.println("Vas ganado... De momento");
              else
                System.out.println("Bueno, sigues perdiendo...");
              break;
            case 2:
              if(scoreh>scorem)
              System.out.println("La suerte del principiante...");
              else
                System.out.println("No te emociones que no tienes nada que hacer...");
              break;
            case 3:
              System.out.println("No eres tan inutil como pensaba...");
              break;
          }
          textoG++;
        }
      }else{
        scorem++;
        System.out.println("¡Un punto para mi!\nPuntuaciones: \n- Contrincante:"+scorem+"\n- Tu:"+scoreh+"\n================================");
        if (textoP>0 && textoP<4 && scorem<3){
          switch(textoP){
            case 1:
              if(scoreh>scorem)
              System.out.println("Vas ganado... De momento");
              else
                System.out.println("Y yo que pensaba que ibas a durar mas, una pena...");
              break;
            case 2:
              if(scoreh>scorem)
              System.out.println("Creo que se te ha acabado la suerte guapa.");
              else
                System.out.println("No tienes nada que hacer...");
              break;
            case 3:
              if(scoreh>scorem)
              System.out.println("Despidete del codigo cielo.");
              else
                System.out.println("Fiajte, eres tan inutil como pensaba...");
              break;
          }
          textoP++;
        }
      }
      if(round==1){
        System.out.println("Relajate muchacha.\nEsto solo acaba de empezar...\n¡Que empiece otra ronda!");
        textoG++;
        textoP++;
      }
      if(scorem==2&&scoreh==0)
        System.out.println("¡JA! ¡JA! ¡JA! Menuda paliza te estoy dando.");
      if(scoreh==2&&scorem==2)
        System.out.println("¡¡El desempate!! Hagan sus apuestas...");
      //Comprobacion fin de juego
      if(scorem==numRound)
        System.out.println("Ha sido un placer ganarte tan rapido, cuando quieras pudes volver a que te de otra paliza. ");
      if(scoreh==numRound)
        System.out.println("Lo que decia, la suerte del principiante.");
    }while(scoreh!=numRound && scorem!=numRound);
    return scoreh==numRound;
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
      case 0:instructions = "======================================================\nPara jugar a INMATE unicamente necesitas saber leer. Recuerda no poner tildes. Cada sala tiene un comando 'Help' al que puedes recurrir\nsi te quedas sin ideas de que hacer. Recuerda que siempre podras escribir la palabra 'Exit' para salir del juego.";break;
      case 1:instructions = "======================================================\nLos comandos disponibles en esta sala son:\n-Pasillo\n-Hablar\n-Investigar\n-Notas\n-Inventario\n-Help\n-Exit\n======================================================";break;//Habitacion
      case 2:instructions = "======================================================\nLos comandos disponibles en esta sala son:\n-Norte\n-Sur\n-Este\n-Oeste\n-Notas\n-Inventario\n-Help\n-Exit\n======================================================";break;//Pasillo
      case 3:instructions = "======================================================\nLos comandos disponibles en esta sala son:\n-Norte\n-Este\n-Bancos\n-Duchas\n-Retretes\n-Notas\n-Inventario\n-Help\n-Exit\n======================================================";break;//S2-Baño
      case 4:instructions = "======================================================\nLos comandos disponibles en esta sala son:\n-Norte\n-Oeste\n-Pastillas\n-Enfermero\n-Notas\n-Inventario\n-Help\n-Exit\n======================================================";break;//S3-Enfermeria
      case 5:instructions = "======================================================\nLos comandos disponibles en esta sala son:\n-Norte\n-Sur\n-Armario\n-Mesa\n-Luces\n-Notas\n-Inventario\n-Help\n-Exit\n======================================================";break;//S4-Comedor
      case 6:instructions = "======================================================\nLos comandos disponibles en esta sala son:\n-Codigo\n-Notas\n-Inventario\n-Help\n-Exit\n======================================================";break;//S5
      case 7:instructions = "======================================================\nLos comandos disponibles en esta sala son:\n-Tornillo\n-Rotulador\n-Botella\n-Foto\n-Investigar\n-Habitacion\n-Notas\n-Inventario\n-Help\n-Exit\n======================================================";break;//Mochila
      default:instructions = "";break;
    }
    return (instructions);
  }

  //DESCRIPTIONS
  public static String description(int sala){
    String des = "";
    switch(sala){
      case 1:des = "Esta es tu habitacion, en la que convives con tu compañera.\nTiene una puerta por la que puedes salir al pasillo, una ventana, tus cosas y las de tu compañera. Puedes investigar las cosas de tu compañera, ¿por que no lo intentas?";break;
      case 2:des = "Este es el sucio baño que usas todos los dias. Las duchas estan en la pared que hay a tu derecha,\ny los retretes en la que tienes en frente. A tu izquierda hay unos bancos anclados al suelo, donde se visten las reclusas despues de las duchas.\nHace tiempo decidiste pasar al baño unicamente cuando hubiese poca gente. Ironicamente aqui es donde se suele 'jugar' al ahorcado.";break;
      case 3:des = "Te encuentras en la enfermeria. En esta sala, suele estar el enfermero,\nun amable señor que ha dedicado toda su vida a esta carcel. Es posible que sea la persona mas graciosa de este lugar.\nLa enfermeria, la mayor pesadilla de la mayoria de las reclusas, sin embargo para ti, \nes de uno de los sitios mas agradables posiblemente porque es del los pocos sitios en donde nadie atenta contra tu vida.";break;
      case 4:des = "Este es el comedor. Aqui comes todos los dias esa basura a la que llaman comida,\npero aunque esta mala, es tu sala favorita. ¡Te encantan las natillas!\nA la derecha esta tu mesa de todos los dias, en la esquina izquierda esta el viejo armario en el que se guardan las bandejas y colgando por encima de la sala estan las luces fosforescentes.";;break;
      case 5:des = "Por fin has llegado a la sala de control. Ya no hay vuelta atras. Debes introducir el codigo final para poder salir.";break;
      case 6:des = "Estas en medio del pasillo, tu habitacion esta al sur. Muevete en alguna direccion.";break;
      default:des = "";break;
    }
    return(des);
  }

  //SETTINGS
  public static String settings(int[] ingame){
    Scanner sc = new Scanner(System.in);
    while(true){
      System.out.println("\n-------------------------------------------------------------------------\nMenu \n============================== \n   - Dificultad: Facil/Dificil \n   - Graficos: HD/Ahorro \n   - Return \n\n Escribe a lo que quieres cambiar, por ejemplo, si quieres cambiar los graficos escribe HD\n-------------------------------------------------------------------------");
      String settingsInput = sc.nextLine().toLowerCase();
      switch(settingsInput){
        case "facil":ingame[1] = 0;System.out.println("-------------------------------------------------------------------------\nModo dificil: Desactivado\n----------------------------------------------------------------------");break;
        case "dificil":ingame[1] = 1;System.out.println("-------------------------------------------------------------------------\nModo dificil: Activado\n-------------------------------------------------------------------------");break;
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
    System.out.println("-------------------------------------------------------------------------\n       Bienvenid@ a INMATE.");
    int[] inventory = {0,0,0,0,0,0,0,0};
    int[] ingame = {/*Inmate Number*/0,/*Dificultad*/0,0,0,0,0};//Array Dificultad,codigo ,final y final
    String mode = "";
    while(true){
      mode = "Facil";
      if(ingame[1]==1)
        mode = "Dificil";
      System.out.println("-------------------------------------------------------------------------\nMenu:\n   - Play \n   - How-To \n   - Settings \n   - Exit \n   - About-Us \n\nModo: "+mode+"\n-------------------------------------------------------------------------\n");
      String menuintput = sc.nextLine().toLowerCase();
      switch(menuintput){
        case "play":
          ingame[0] = difficult(ingame[1]);//Codigo Inmate.
          System.out.println("-------------------------------------------------------------------------\nBienvenid@ a Inmate:"+ingame[0]+"\nSi necesitas ayuda en cualquier momento, escribe help\n-------------------------------------------------------------------------\n");
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
        case "about-us": System.out.println("'INMATE' es un juego desarrollado por Sara Alonso, Fernando Bellido y Aida Muñoz.");break;
        case EXIT: exit();break;
        default: System.out.println("Ese comando no existe. Escribe 'help' si necesitas recibir ayuda.");break;
      }
    }
  }

  //Utilities
  public static int sumAr(int[] arr){
    int res = 0;
    for(int i=0;i<arr.length;i++)
      res+=arr[i];
    return(res);
  }

  //Objetos del inventario
  public static String objetoInventario (int a){
    String res = "";
    int b = a+1;
    switch (b){
      case 1: res = "el movil"; break;
      case 2: res = "las pastillas"; break;
      case 3: res = "el ladrillo"; break;
      case 4: res = "la foto"; break;
      case 5: res = "el jabon"; break;
      case 6: res = "el tornillo"; break;
      case 7: res = "el rotulador"; break;
      case 8: res = "el hierro oxidado"; break;
    }
    return res;
  }

  //Cambiar objetos
  public static void cambObjt(int[] inventory,int posobjt){                      //posobjt = y = posicion en el array del objeto que quiere coger
    Scanner sc = new Scanner(System.in);
    elegObjt(inventory);
    int x = sc.nextInt();                                                          //x = posicion del objeto que quiere dejar
    int y = posobjt;

    if(x>=0 && x<=7){
      while ((x>=0 && x<=7)&&(inventory[x]==0)){
        System.out.println("Esa opcion no es valida\nIntroduce otra posicion:");
        x = sc.nextInt();
      }
      inventory[x]= 0;
      inventory[y]= 1;
    }

    String objDejado = objetoInventario(x);
    String objCogido = objetoInventario(y);
    if (x>=0 && x<=7)
      System.out.println ("Has cambiado " + objDejado + " por " + objCogido );
    if (x<0 || x>7)
      System.out.println("Dejas " + objCogido + " en el suelo.");
  }

  //Mostrar Objetos a elegir (con numeros)
  public static void elegObjt(int[] inventory){
    String res="Vacio";
    System.out.println("\nEn el inventario tienes:");
    for(int i=0;i<inventory.length;i++)
      if(inventory[i]==1){
      switch (i+1){
        case 1: res = "0.- Movil"; break;
        case 2: res = "1.- Pastillas"; break;
        case 3: res = "2.- Ladrillo"; break;
        case 4: res = "3.- Foto"; break;
        case 5: res = "4.- Jabon"; break;
        case 6: res = "5.- Tornillo"; break;
        case 7: res = "6.- Rotulador"; break;
        case 8: res = "7.- Hierro oxidado"; break;
      }
      System.out.println(res);
    }
    System.out.println("\n¿Que objeto quieres dejar?\nEscribe cualquier numero distinto de 0-7 para salir.");
  }

  //Mostrar Inventario
  public static void mostrarInv(int[] inventory){
    int a=0;
    System.out.println("INVENTARIO:");
    for(int i=0;i<inventory.length;i++){
      String res=" ";
      if(inventory[i]==1){
        switch (i+1){
          case 1: res = "- Movil"; break;
          case 2: res = "- Pastillas"; break;
          case 3: res = "- Ladrillo"; break;
          case 4: res = "- Foto"; break;
          case 5: res = "- Jabon"; break;
          case 6: res = "- Tornillo"; break;
          case 7: res = "- Rotulador"; break;
          case 8: res = "- Hierro oxidado"; break;
        }
        a++;
        System.out.println(res);
      }
    }
    while(a<4){
      System.out.println("- Vacio");
      a++;
    }
  }

  //Imprimir array de int
  public static String printAr(int[] arr){
    String res = "";
    for(int i=0;i<arr.length;i++){
      if(i!=0)
        res+=", "+arr[i];
      else
        res = ""+arr[i];
    }
    return(res);
  }

  //Imprimir array de strings
  public static String printAr2(String[] arr){
    String res = "";
    for(int i=0;i<arr.length;i++){
      if(i!=0)
        res+=", "+arr[i];
      else
        res = ""+arr[i];;
    }
    return(res);
  }

  //ENDGAME
  public static void endgame(int[] ingame){
    int[] code = digits(ingame[0]);
    int[] numpad = {-1,-1,-1,-1,-1,-1};
    String[] progress = {"_","_","_","_","_","_"};
    System.out.println("Tus Apuntes:"+ingame[2]+""+ingame[3]+""+ingame[4]);
    int count = 0, x;
    Scanner sc = new Scanner(System.in);
    System.out.println(printAr2(progress));
    while(true){
      System.out.println("Inserte Numero");
      x = sc.nextInt();
      for(int i=0;i<code.length;i++){
        if(x==code[i]){
          numpad[i] = x;
          progress[i] = Integer.toString(x);
        }
      }
      if(count==6){
        System.out.println("Has sido cazado por la pasma.");
        muerte();
      }
      count++;
      System.out.println("Tienes "+(7-count)+" Intentos restantes.");
      System.out.println(printAr2(progress));
      if(sumAr(numpad)==sumAr(code)){
        System.out.println("Nada mas introducir los digitos oyes la gruesa puerta crujir a tu espalda. Se ilumina una luz verde encima del teclado numerico.\n Se abre la puerta al exterior y corres como si te fuese la vida en ello.\n\n\n\n\n\nHan pasado tres años desde que te escapaste de la carcel, y la policia ya ha dejado de buscarte.\n Enhorabuena, lo has conseguido.\n\n\n\n");
        System.out.println("   =========================================================\n   =========================================================\n\n    WW           WW  II  NN   NN  NN   NN  EEEEE  RRRRR\n     WW         WW   II  NNN  NN  NNN  NN  EE     RR  RR\n      WW   W   WW    II  NN N NN  NN N NN  EEEE   RRRRR\n       WW WWW WW     II  NN  NNN  NN  NNN  EE     RR RR\n        WWW WWW      II  NN   NN  NN   NN  EEEEE  RR  RR\n\n   =========================================================\n   =========================================================");
        exit();
      }
    }
  }

  //El codigo del NIVEL de DIFICULTAD genera el codigo final
  public static int difficult(int dif){
    return((int)(Math.random() * ((999999 - 100000) + 1)) + 100000);
  }

  //Numero aleatorio de 6 digitos
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

  //Guarda las pistas que llevas del codigo final.
  public static String answers(int juego,int[] ingame){
    int[] digits = digits(ingame[0]);
    String res = "";
    switch(juego){
      case 0://Ahorcado
        res=digits[0]+""+digits[1];
        ingame[2]=digits[0]*10+digits[1];
        break;
      case 1://ppt
        res=digits[2]+""+digits[3];
        ingame[3]=digits[2]*10+digits[3];
        break;
      case 2://ttt
        res=digits[4]+""+digits[5];
        ingame[4]=digits[4]*10+digits[5];
        break;
    }
    return res;
  }


  //SALAS
  //Sala 1-Habitacion
  public static void sala1(int[] inventory,int[] ingame){
    System.out.println(description(1));
    Scanner sc = new Scanner(System.in);
    boolean companera = true;
    String respuesta = "";
    while(true){
      String sala1Input = sc.nextLine().toLowerCase();
      switch(sala1Input){
        case "pasillo": pasillo(inventory,ingame);break;
        case "hablar":
          if (companera){
          System.out.println("¡Que miras payasa!\nApartate si no quieres arrepentirte...\nLlevo 3 años en este agujero de ratas y no estoy para aguantar a niñatas.\nTu compañera se levanta irritada y abandona la celda.");
          companera = false;
        }else
          System.out.println("Tu compañera no esta en la habitacion en este momento.");
        break;
        case "investigar":
          if (companera){
          System.out.println("¡Eh! ¡Eh! ¡Eh! ¿QUE HACES FISGANDO EN MIS COSAS? ¿¿Sabes que hacen por aqui con las ladronas como tu?? ");
          muerte();
        }else{
          System.out.println("Dentro de la mochila de tu compañera hay una antigua foto en la que aparece ella con su hija, una botella de leche, un tornillo y un rotulador. Investigando mas a fondo descubres un falso fondo. ¿Que quieres hacer?");
          boolean mochila = true;
          while(mochila){
            String mochilaInput = sc.nextLine().toLowerCase();
            switch (mochilaInput){
              case "tornillo":
                if (inventory[5]==0){
                System.out.println("Se trata de un pequeño tornillo oxidado, decides guardarlo por si te sirve de ayuda mas adelante...");
                if(sumAr(inventory)<4){
                  System.out.println("¡Guardado!");
                  inventory[5] = 1;
                }else{
                  System.out.println("Pero descubres que no tienes espacio en la mochila para guardarlo, quieres cambiarlo por otro objeto?");
                  respuesta = sc.next().toLowerCase().substring(0,1);
                  if (respuesta.equals("s")){
                    cambObjt(inventory,5);
                    System.out.println("¡Listo!");
                  }else
                    System.out.println("Dejas el tornillo en la mochila.");
                }
              }else
                System.out.println("Ya te has guardado el tornillo que tenia tu compañera.");
              break;
              case "botella": System.out.println("Observas detenidamente la botella, nunca entenderas porque tu compañera siempre tiene objetos tan raros?...\nVuelves a dejar la botella en su sitio."); break;
              case "foto":
                System.out.println("\nEn la foto se muestra a tu compañera abrazada a dos niños, que supones sus hijos, en algun sitio semejante a un parque.\nUno de los niños sujeta un goblo amarillo mientras el otro regala una sonrisa de oreja a oreja a la camara, tu compañera parece realmente feliz.\nParece una foto muy antigua... Te preguntas cuanto tiempo pude haber pasado desde que tu compañera vio a sus hijos por ultima vez, y que edad deben tener ahora...\n¿Quieres guardar la foto?");
                respuesta = ((sc.nextLine()).toLowerCase()).substring(0,1);
                if(respuesta.equals("s")){
                  System.out.println("Te dispones a guardala cuando de repente entra tu compañera enfurecida en la habitacion, te agarra del cuello y te pregunta gritando:\n¿Que te crees que estas haciendo? ¿Como se te ocurre intentar robarme la unica cosa que me importa, el utlimo recuerdo de mis niños?\nLo vas a pagar muy caro...");
                  muerte();
                }else
                  System.out.println("Vuelves a dejar la foto en la mochila.");
                break;
              case "rotulador":
                System.out.println("Un rotulador normal y corriente.");
                if (inventory[6]==0){
                  System.out.println("¿Lo quieres guardar?");
                  respuesta = ((sc.nextLine()).toLowerCase()).substring(0,1);
                  if(respuesta.equals("s")){
                    if(sumAr(inventory)<4){
                      inventory[6]=1;
                      System.out.println("¡Guardado!");
                    }else{
                      System.out.println("No tienes espacio en la mochila para guardar ese objeto, ¿Quieres cambiarlo por otro objeto?");
                      respuesta = sc.next().toLowerCase().substring(0,1);
                      if (respuesta.equals("s")){
                        cambObjt(inventory,6);
                        System.out.println("Listo");
                      }
                    }
                  }else
                    System.out.println("Dejas de nuevo el rotulador en la mochila.");
                }
                break;
              case "investigar":
                if (inventory[0]==0){
                System.out.println("Levantas el falso fondo de la mochila y descubres que tu compañera tenia un movil.\n¿Quieres guardarlo?");
                respuesta = ((sc.nextLine()).toLowerCase()).substring(0,1);
                if(respuesta.equals("s")){
                  if(sumAr(inventory)<4){
                    inventory[0]=1;
                    System.out.println("¡Guardado!");
                  }else{
                    System.out.println("No tienes espacio en la mochila para guardar ese objeto, ¿Quieres cambiarlo por otro objeto?");
                    respuesta = sc.next().toLowerCase().substring(0,1);
                    if (respuesta.equals("s")){
                      cambObjt(inventory,0);
                      System.out.println("Listo");
                    }
                  }
                }else
                  System.out.println("Dejas de nuevo el movil en el falso fondo y vuelves a taparlo.");
              }else
                System.out.println("No hay nada nuevo que investigar.");
              break;
              case HELP:System.out.println(howto(7));break;
              case INVENTARIO: mostrarInv(inventory);break;
              case EXIT:exit(); break;
              case "habitacion":mochila = false;break;
              default: System.out.println("Ese comando no existe. Escribe 'help' si necesitas recibir ayuda.");break;
            }
          }
        }
        break;
        case HELP:System.out.println(howto(1));break;
        case INVENTARIO: mostrarInv(inventory);break;
        case EXIT:exit(); break;
        default: System.out.println("Ese comando no existe. Escribe 'help' si necesitas recibir ayuda.");break;
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
        case NORTE: sala4(inventory,ingame);break;
        case "sur": sala1(inventory,ingame);break;
        case ESTE: sala3(inventory,ingame);break;
        case OESTE: sala2(inventory,ingame);break;
        case HELP: System.out.println(howto(2));break;
        case EXIT:exit();break;
        case NOTAS:System.out.println(ingame[2]+""+ingame[3]+""+ingame[4]);break;
        case INVENTARIO: mostrarInv(inventory);break;
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
        case NORTE:System.out.println("¡Atencion! Entras en un punto de no retorno.");sala5(inventory,ingame);break;
        case ESTE:pasillo(inventory,ingame);break;
        case "bancos":
          if (inventory[2]==1){
          System.out.println("No parece nada especial, simplemente un banco.");
        }else{
          System.out.println("Al acercarte a los bancos, ves que hay un ladrillo caido cerca de una de las paredes de la habitacion. ¿Quieres guardarlo?");
          respuesta = sc.nextLine().toLowerCase().substring(0,1);
          if(respuesta.equals("s")){
            if(sumAr(inventory)<4){
              inventory[2] = 1;
              System.out.println("¡Guardado!");
            }else{
              System.out.println("No tienes espacio en la mochila para guardar este ladrillo, Quieres cambiarlo por otro objeto?");
              respuesta = sc.next().toLowerCase().substring(0,1);
              if(respuesta.equals("s")){
                cambObjt(inventory, 2);
                System.out.println("¡Listo!");
              }else
                System.out.println("Dejas el ladrillo en el suelo.");
            }
          }else
            System.out.println("Dejas el ladrillo en el suelo.");
        }
        break;
        case "retretes":
        System.out.println("Parece que alguien ha pintado el tablero de un ahorcado en la pared. ¿Quieres acercarte?");
          respuesta = sc.nextLine().toLowerCase().substring(0,1);
          if(respuesta.equals("s")){
            System.out.println("Al acercarte a investigar, aparece una reclusa de la zona de los retretes. Que haces en mi vater pingaja,¿acaso quieres jugar?");
            respuesta = sc.nextLine().toLowerCase().substring(0,1);
            if(inventory[6]==1 && respuesta.equals("s")){
              System.out.println("Si traes hasta tu propio rotulador, ¡trae pa'aca!.");
              if(hangman(ingame[1]))
                System.out.println("Enhorabuena, no eres tan tonta como pensaba.\nBuena suerte, dice la reclusa. Te da un papel y se va hacia las duchas.\nCuando desaparece de tu vista, lo abres y ves el numero "+answers(0,ingame)+" escrito en el. 'Que extraño', piensas.");
            }else if(respuesta.equals("s")&& inventory[6]==0)
              System.out.println("Pero si no tienes nada con lo que escribir, te dice con asco la reclusa. ¡Largo de aqui!.");
            else
              System.out.println("¡Pues entonces largo de aqui!.");
          }
        break;
        case "duchas":
          if(inventory[4] == 0){
          System.out.println("En el suelo de las duchas hay una pastilla de jabon que parece que alguien ha olvidado, ¿Quieres cogerla?");
          respuesta = sc.nextLine ().toLowerCase ().substring (0,1);
          if(respuesta.equals("s")){
            if(sumAr(inventory)<4){
              System.out.println("¡Listo!, ¿Te esperabas algo mas?");
              inventory[4] = 1;
            }else{
              System.out.println("No tienes espacio en la mochila para guardarlo, quieres cambiarlo por otro objeto?");
              respuesta = sc.next().toLowerCase().substring(0,1);
              if (respuesta.equals("s")){
                cambObjt(inventory, 4);
                System.out.println("¡Listo!.");
              }else
                System.out.print("Dejas el jabon en el suelo.");
            }
          }else
            System.out.println("'Una pena...' se oye a lo lejos.\nDejas el jabon en el suelo.");
        }
          break;
        case HELP:System.out.println(howto(3));break;
        case NOTAS:System.out.println(ingame[2]+""+ingame[3]+""+ingame[4]);break;
        case INVENTARIO: mostrarInv(inventory); break;
        case EXIT:exit();break;
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
        case NORTE:System.out.println("¡Atencion! Entras en un punto de no retorno.");sala5(inventory,ingame);break;
        case OESTE:pasillo(inventory, ingame);break;
        case "pastillas":
          System.out.println("Le pides al amable enfermero unos antidepresivos que puedan calmar tu dolor interior.\nSin dudarlo un solo segundo llama unos funcionarios de la prision los cuales te encierran en aislamiento, donde pasaras los proximos 23 años de tu vida,\nhasta que un dia, presa de la locura decides comerte tu propio uniforme, provocandote una indigestion con el almidon de la ropa y muriendo a causa de la consecuente ulcera en el estomago.");
          muerte();break;
        case "enfermero":
          if(inventory[2]==1){
          System.out.println("Sabia eleccion...\nNo obstante,para obtener lo que yo he de guardar,deberas jugar a un sencillo juego de niños... \n Sencillo verdad?");
          if(ppt1(ingame[1]))
            System.out.println("Bueno, bueno, esto no se te da nada mal. Aqui esta tu pista: "+ answers(1,ingame));
        }else
          System.out.println("Te crees que porque sea el enfermero te voy a ayudar.\nTan solo necesito arreglar esta pared y... con estas tijeras y papel que me das no hago nada\nSi me das lo que necesito te ayudo.");
        break;
        case HELP:System.out.println(howto(4));break;
        case NOTAS:System.out.println(ingame[2]+""+ingame[3]+""+ingame[4]);break;
        case INVENTARIO: mostrarInv(inventory);break;
        case EXIT:exit();break;
        default: System.out.println("Ese comando no existe. Escribe 'help' si necesitas recibir ayuda.");break;
      }
    }
  }

  //Sala 4-Comedor (tres en raya)
  public static void sala4(int[] inventory,int[] ingame){
    System.out.println(description(4));
    Scanner sc = new Scanner(System.in);
    String respuesta = "";
    while(true){
      String sala4Input = sc.nextLine().toLowerCase();
      switch(sala4Input){
        case NORTE:System.out.println("¡Atencion! Entras en un punto de no retorno.");sala5(inventory,ingame);break;
        case "sur":pasillo(inventory,ingame);break;
        case "mesa":
          System.out.println("Cuando te sientas a recuperar el aliento tras el dia que llevas, se te acerca una reclusa.\nPor lo visto vas a jugar conmigo al tres en raya... que buena suerte tengo, otra valiente con la que pelear.");
          if(inventory[5]==1){
            System.out.println("¡Tienes mi tornillo favorito y todo! Jugemos pues.\nDecides confiar en la peliculiar reclusa, que tiene por objeto favorito un tornillo, con la experanza de que la suerte juege a tu favor.");
            int tresEnRaya = ticTacToe();
            if(tresEnRaya==1)
              System.out.println("No te creas que por ganarme una vez lo has conseguido, pero si que te puedo entregar esto: "+answers(2,ingame)+"\nLa reclusa se levanta y abandona la sala.");
            else if (tresEnRaya==3)
              System.out.println("Bueno, al menos lo has intentado. Para recordarme te llevas esto: "+answers(2,ingame)+" y una bonita puñalada.\n Cuando te empiezas a levantar notas como alguien viene por detras y te apuñala por la espalda. 'Por lo menos no es en una zona vital' piensas.");
            else
              System.out.println("Ves, si es que no vales para esto.");
          }else
            System.out.println("Para poder jugar a mi juego debes regalarme mi objeto favorito.");
          break;
        case "armario":
          System.out.println("Al acercarte al armario, ves que por detras tiene algo escondido, ¿quieres mirar que es?");
          respuesta = sc.nextLine().toLowerCase().substring(0,1);
          if(respuesta.equals("s")){
            System.out.println("De detras del armario sale un guardia asustado, y al verte te dispara a la frente.\nTe desangras lentamente en tu sala favorita de la carcel, de la cual nunca llegaste a escapar.");
            muerte();
          } break;
        case "luces":
          if (inventory[7]==0){
          System.out.println("Al mirar hacia arriba ves como sobresale un hierro de la lampara mas cercana. ¿Quieres cogerlo?");
          respuesta = sc.nextLine().toLowerCase().substring(0,1);
          boolean a = false;
          if(respuesta.equals("s")){
            a = true;
            if(sumAr(inventory)<4){
              inventory[7] = 1;
              System.out.println("¡Guardado!");
            }else{
              System.out.println("No tienes espacio en la mochila para guardar ese hierro, Quieres cambiarlo por otro objeto?");
              respuesta = sc.next().toLowerCase().substring(0,1);
              if (respuesta.equals("s")){
                cambObjt(inventory, 7);
                System.out.println("¡Listo!");
              }
            }
          }else
            a = false;
        }else
          System.out.println("Miras hacia arriba y observas los fluorescentes amarillos tipicos de esta sala.\n Quedas cegada por un momento.");
        break;
        case HELP:System.out.println(howto(5));break;
        case NOTAS:System.out.println(ingame[2]+""+ingame[3]+""+ingame[4]);break;
        case INVENTARIO: mostrarInv(inventory); break;
        case EXIT:exit();break;
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
        case "codigo":endgame(ingame);break;
        case NOTAS:System.out.println(ingame[2]+""+ingame[3]+""+ingame[4]);break;
        case HELP:System.out.println(howto(6));break;
        case INVENTARIO: mostrarInv(inventory);break;
        case EXIT:exit();break;
        default: System.out.println("Ese comando no existe. Escribe 'help' si necesitas recibir ayuda.");break;
      }
    }
  }
}
