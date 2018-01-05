package derector;

/**
 * Created by Administrator on 2017/12/4.
 */

public class ITestB extends ITestDerector {

    public ITestB(ITest iTest) {
        super(iTest);
    }

    @Override
    public int getValue() {
        return super.getValue()+80;
    }
}
