package Chain;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public class Chain2 extends MyChain {
    @Override
    public void doRequest(int i) {
        if(i<10){
            System.out.println("====>middle");
        }
    }
}
