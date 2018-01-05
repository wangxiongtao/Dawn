package derector;

/**
 * Created by Administrator on 2017/12/4.
 */

public class Test {
    public static void main(String args[]){
        ITest iTest=new ITestImpl();
        ITest iTest1=new ITestA(new ITestB(iTest));
        System.out.println(iTest1.getValue());
    }
}
