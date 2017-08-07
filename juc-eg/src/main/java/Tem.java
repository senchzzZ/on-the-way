import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaoshengqi on 2017/7/25.
 */
public class Tem {
    public static void main(String[] args) {
        //System.out.println(String.format("%.2f", new BigDecimal(0.04906205).doubleValue()*100));

        /*if(false && isExcute()){
            
        }*/
       /* int i=0;
        int j=0;
        System.out.println(i++ == 0);
        System.out.println(++i == 2);
        System.out.println(++j == 1);
        System.out.println(++j == 2);*/
      /*  int n = 15;
       for (int i = 0;i<100;i++){
           System.out.println((i & n));
           System.out.println((i)%15);

       }*/
      /*String s = null;
      String p = "1";
      //p = s;
        System.out.println((p=s) ==null);*/
      for (;;){
          int i=0;
          int j=100;
          ++i;
          System.out.println("i = "+i);
          for (;;--j){
              System.out.println("j = "+j + " i = "+i);
          }
      }



/* 00000001 << 1 = 00000010 *//*
        1 << 1 == 2

*//* 00000001 << 3 = 00001000 *//*
        1 << 3 == 8

*//* 11111111 11111111 11111111 11110000 >> 4 = 11111111 11111111 11111111 11111111 *//*
        0xFFFFFFF0 >> 4 == 0xFFFFFFFF

*//* 00001111 11111111 11111111 11111111 >> 4 = 00000000 11111111 11111111 11111111 *//*
        0x0FFFFFFF >> 4 == 0x00FFFFFF

*//* 10000000 00000000 00000000 00000000 >>> 1 = 01000000 00000000 00000000 00000000 *//*
        0x80000000 >>> 1 == 0x40000000

*//* 10000000 00000000 00000000 00000000 >> 1 = 11000000 00000000 00000000 00000000 *//*
        0x80000000 >> 1  == 0xC0000000*/

        //System.out.println(~10);

        /*int tab = 5;
        for(int a = tab;;){
            System.out.println(a);
        }*/



    }

    private static boolean isExcute() {
        System.out.println("excute!");
        return false;
    }
}
