package Chain;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public abstract class MyChain {
    protected MyChain nextChain;

    public void setNextChain(MyChain nextChain) {
        this.nextChain = nextChain;
    }
    public abstract void doRequest(int i);

}
