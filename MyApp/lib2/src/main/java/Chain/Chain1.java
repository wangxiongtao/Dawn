package Chain;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public class Chain1 extends MyChain {
    @Override
    public void doRequest(int i) {
        if(i<5){
            System.out.println("====>little");
        }else {
            nextChain.doRequest(i);
        }
    }
}
