package derector;

/**
 * Created by Administrator on 2017/12/4.
 */

public class ITestA extends ITestDerector {

    public ITestA(ITest iTest) {
        super(iTest);
    }

    @Override
    public int getValue() {
        return super.getValue()+20;
    }
}
