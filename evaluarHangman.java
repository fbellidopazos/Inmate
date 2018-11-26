public class EvaluarHangman{
public static int[] evaluarHangman(char[] palabra, int intento){
     boolean res = false;
     int n = 0;
     int[] posicionesTrue = {-1,-1,-1};
     for (int i = 0;i<palabra.length; i++){
      if(palabra[i]==intento){
       posicionesTrue[n] = i;
       n++;
      }
     }
     return posicionesTrue;
	}

	public static void main (String[] args){
	char[] palabra = {'a',l,c,a,c,h,o,f,a};
	char intento = 'a';
	System.out.println(evaluarHangman(palabra, intento));
	}
}
