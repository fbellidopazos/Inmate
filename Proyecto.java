import java.util.Scanner;
import java.util.Arrays; //Buscado en Internet (para comprobaciones)
public class Proyecto{
  //TIC TAC TOE
  //___________________________________________________________________MARCADORES________________________________________________________________________________________________________
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
  //_________________________________________________________________________ORIENTACIÓN GANAR_____________________________________________________________________________________
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
  
  //__________________________________________________________________________FILA GANAR_______________________________________________________________________________________________
  
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
  
  
  //__________________________________________________________________________COLUMNA GANAR____________________________________________________________________________________________
  
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
  
  //__________________________________________________________________________ORIENTACIÓN PERDER________________________________________________________________________________________
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
  
  //______________________________________________________________________FILA EVITAR ERROR______________________________________________________________________________________________________
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
  
//__________________________________________________________________________COLUMNA EVITAR ERROR________________________________________________________________________________________
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
  
//____________________________________________________________________________________________________________________________________________________________________________________________-
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
    System.out.print("Este es el tablero, tú escribirás con 1 y yo con 2 \n \n ");
    
    do{
      //Mueve el jugador
      System.out.println("Introduce el número de la fila.");
      filaMovimiento = sc.nextInt();
      System.out.println("Introduce el número de la columna.");
      columnaMovimiento = sc.nextInt();
      
      if(filaMovimiento>2 || columnaMovimiento>2 || filaMovimiento<0 || columnaMovimiento<0 ){
        System.out.println("\n Te estas quedando conmigo??");
        while(filaMovimiento>2 || columnaMovimiento>2 || filaMovimiento<0 || columnaMovimiento<0){
          while(filaMovimiento>2 || filaMovimiento<0){
            System.out.println("Introduce otro número de la fila.");
            filaMovimiento = sc.nextInt();
          }
          System.out.print ("\n");                                                                                                                  //POR QUÉ?? -Aída
          while(columnaMovimiento>2 || columnaMovimiento<0){
            System.out.println("Introduce otro número de la columna.");
            columnaMovimiento = sc.nextInt();
          }
        }
        System.out.println("Aleluya!! Verdad que no era tan dificil????? \n ");
      }
      
      if(tablero[filaMovimiento][columnaMovimiento]!=0){
        System.out.println("Esa casilla ya está ocupada.");
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
      
      //Mueve la máquina
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
  
  
  //public static void main(String[] args){
  //switch (ticTacToe()){
  //  case 1: System.out.println ("Has ganado");break;
  //  case 2: System.out.println ("Has perdido");break;
  //  case 3: System.out.println ("Empate");break; 
  // }
  
  //}
  
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
    System.out.println("Jugemos al ahorcado. ¿Quién morirá?... Yo creo que tú.");
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
    
    //Comprobación de acierto y actualización de las letras acertadas
    int pos, fallosRestantes = 3;
    char intento;
    boolean winner = false;
    while (!winner && fallosRestantes>0){
      System.out.print("Introduce una letra.");
      intento = sc.next().toLowerCase().charAt(0);
      pos = evaluarHangman(palabra, intento, 0);
      if (pos<0){
        fallosRestantes--;
        System.out.println("Pringao! esa letra no está. Tienes un intento menos JA JA JA ");
      }else{
        while(pos>=0){
          letrasAdivinadas = letrasAdivinadas.substring(0,pos)+intento+letrasAdivinadas.substring(pos+1,longitud);
          pos = evaluarHangman(palabra, intento, pos+1);
        }
        System.out.println("No está mal... de momento llevas esto: "+letrasAdivinadas);
      }
      
      //Condición de ganador
      if(palabra.equals(letrasAdivinadas))
        winner=true; 
    }
    return winner;
  }
  
  //(int)(Math.random() * ((max - min) + 1)) + min;
  
  //INMATE NUMBER
  public static int[] code(int random,int difficulty){
    
    if(difficulty==0){
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
    //=====================================================================================================================================================================================================================================
    //====================================================================================================================================================================================================================================
    //=====================================================================================================================================================================================================================================
    
    // Buscado en Internet   https://stackoverflow.com/questions/8557716/how-to-return-multiple-values   https://stackoverflow.com/questions/409784/whats-the-simplest-way-to-print-a-java-array
  }
  
  //El codigo del NIVEL de DIFICULTAD genera codigo
  public static int difficult(int dif){
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
  public static void exit(){
    System.exit(0);
  }
  
  //DEATH
  public static void muerte(){
    System.out.println("Has muerto.");
    System.exit(0);
  }
  
  //HOW-TO
  public static String howto(int lugar){
    String Instructions="";
    switch (lugar) {
      case 0:Instructions="como jugar";break;
      case 1:Instructions="sala1";break;
      case 2:Instructions="";break;
      case 3:Instructions="";break;
      case 4:Instructions="";break;
    }
    return (Instructions);
  }
  
  //DESCRIPTION (TEXTO A RELLENAR)
  public static String description(int sala){
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
  
  //SETTINGS
  public static String settings(int[] ingame){
    Scanner sc = new Scanner(System.in);
    
    
    while(true){
      System.out.println("\n-------------------------------------------------------------------------\nMenu \n============================== \n 1.-difficulty : Easy/Difficult \n 2.- Graphics : High/Low \n 3.- Return \n\n NOTE: Write the change i.e. Want to change graphics write Easy\n-------------------------------------------------------------------------\n");
      String settingsInput= sc.nextLine();
      settingsInput=settingsInput.toLowerCase();
      switch(settingsInput){
        case "easy":ingame[1]=0;break;
        case "difficult":ingame[1]=1;break;
        case "high":
        case "low":System.out.println("\n-------------------------------------------------------------------------\n REALLY???!!!!: \n (╯°□°）╯︵ ┻──┻ \n\n ┬──┬◡ﾉ(° -°ﾉ)) \n NOTE: There is no Text Adventure with Graphics\n-------------------------------------------------------------------------\n");break;
        /**/        case "return": return("\n-------------------------------------------------------------------------\n Returned\n-------------------------------------------------------------------------\n");
        default:System.out.println("\n-------------------------------------------------------------------------\nOption Does NOT Exist\n-------------------------------------------------------------------------\n");break;
      }
      
    }
  }
  
  //START MENU
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("-------------------------------------------------------------------------\nWelcome to INMATE.");
    
    int[] inventory={0,0,0,0};//Array Inventario
    int[] ingame={/*Inmate Number*/0,/*Dificultad*/0,0,0};//Array Dificultad,codigo ,final y final
    
    
    while(true){
      System.out.println("\n-------------------------------------------------------------------------\n Menu \n============================== \n 1.- Play \n 2.- How-To \n 3.- Settings \n 4.- Exit \n\n NOTE 1: Write the option i.e. Want to Play -> write Play\n NOTE 2: Default mode=Easy\n-------------------------------------------------------------------------\n");
      String menuintput= sc.nextLine();
      menuintput=menuintput.toLowerCase();
      
      switch (menuintput) {
        case "play":
          ingame[0]=difficult(ingame[1]);//Codigo Inmate.
          System.out.println("\n-------------------------------------------------------------------------\nWelcome to Inmate:"+ingame[0]);
          System.out.println("Si no sabes/recuerdas como jugar escribe how-to\n-------------------------------------------------------------------------\n");
          
          sala1(inventory,ingame);
          break;
          
        case "how-to": System.out.println(howto(0));break;
        case "settings": System.out.println(settings(ingame));break;
        case "debug": code(difficult(ingame[1]),ingame[1]);break;
        //para comprobaciones
        case "exit": exit();break;
        default: System.out.println("\n-------------------------------------------------------------------------\n"+"text"+"\n-------------------------------------------------------------------------\n");break;
      }
    }
  }
  
  //Sala 1-Habitación
  public static void sala1(int[] inventory,int[] ingame){
    System.out.println("\n-------------------------------------------------------------------------\n"+"text"+"\n-------------------------------------------------------------------------\n");
    Scanner sc = new Scanner(System.in);
    boolean boolRespuesta = false;
    String respuesta = "";
    for(int dias=230;!boolRespuesta; dias+=50){
      System.out.println("Buenos días reclus@. Llevas "+dias+" días encerrado en esta prisión de máxima seguridad. ¿Quieres escapar?");
      respuesta = sc.next().toLowerCase().substring(0,2);
      if (respuesta.equals("si"))
        boolRespuesta = true;
    }
    
    while(true){
      String sala1Input= sc.nextLine();
      sala1Input=sala1Input.toLowerCase();
      switch(sala1Input){
        case "":
        case "help":System.out.println(howto(1));break;
        case "exit":exit();break;
      }
    }
  }
  
  //Sala 2-Baño (ahorcado)
  public static void sala2(int[] inventory,int[] ingame){
    System.out.println("\n-------------------------------------------------------------------------\n"+"text"+"\n-------------------------------------------------------------------------\n");
    Scanner sc = new Scanner(System.in);
    while(true){
      String sala1Input= sc.nextLine();
      sala1Input=sala1Input.toLowerCase();
      switch(sala1Input){
        case "help":System.out.println(howto(1));break;
        case "exit":exit();break;
      }
    }
  }
  
  //Sala 3-Enfermería (piedra papel o tijera)
  public static void sala3(int[] inventory,int[] ingame){
    System.out.println("\n-------------------------------------------------------------------------\n"+"text"+"\n-------------------------------------------------------------------------\n");
    Scanner sc = new Scanner(System.in);
    while(true){
      String sala1Input= sc.nextLine();
      sala1Input=sala1Input.toLowerCase();
      switch(sala1Input){
        case "help":System.out.println(howto(1));break;
        case "exit":exit();break;
      }
    }
  }
  
  
//Sala 4-Comedor (tres en raya)
  public static void sala4(int[] inventory,int[] ingame){
    System.out.println("\n-------------------------------------------------------------------------\n"+"text"+"\n-------------------------------------------------------------------------\n");
    Scanner sc = new Scanner(System.in);
    while(true){
      String sala1Input= sc.nextLine();
      sala1Input=sala1Input.toLowerCase();
      switch(sala1Input){
        case "help":System.out.println(howto(1));break;
        case "exit":exit();break;
      }
    }
  }
  
//Sala 5-Sala de control
  public static void sala5(int[] inventory,int[] ingame){
    System.out.println("\n-------------------------------------------------------------------------\n"+"text"+"\n-------------------------------------------------------------------------\n");
    Scanner sc = new Scanner(System.in);
    while(true){
      String sala1Input= sc.nextLine();
      sala1Input=sala1Input.toLowerCase();
      switch(sala1Input){
        case "help":System.out.println(howto(1));break;
        case "exit":exit();break;
      }
    }
  }
}
