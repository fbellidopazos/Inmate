import java.util.Arrays;
public class Code{
  public static int[] Code(int random){


    int[] digits = new int[4];
    digits[3] =random%10;
    digits[2] = ((random/10))%10 ;
    digits[1] = ((random/100))%10 ;
    digits[0] = ((random/1000))%10 ;


    return digits;
  }

  public static void main(String[] args) {
    int max=9999;
    int min=1000;
    System.out.println(Arrays.toString(Code( Math.floor(Math.random() * (max - min)) + min)));
  }
}
