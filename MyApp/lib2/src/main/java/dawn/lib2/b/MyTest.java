package dawn.lib2.b;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/11/22.
 */

public class MyTest {
    public static void main(String[] a){
        BigDecimal decimal=new BigDecimal("1.014567");
        BigDecimal decimal2=new BigDecimal("2.0167890");
        System.out.println("======>"+decimal.add(decimal2));


    }
}
