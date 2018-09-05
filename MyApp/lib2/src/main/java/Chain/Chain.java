package Chain;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public class Chain {
    public static void main(String[] args) {
        MyChain chain1=new Chain1();
        MyChain chain2=new Chain2();
        chain1.setNextChain(chain2);
        int array[]={3,4,8,9,1,7,0,10,11};


        for (int i=0;i<array.length;i++){
            chain1.doRequest(array[i]);
        }
    }
}
