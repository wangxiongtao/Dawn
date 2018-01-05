package derector;

/**
 * Created by Administrator on 2017/12/4.
 */

public abstract class ITestDerector implements ITest {
    private ITest iTest;
    public ITestDerector(ITest iTest){
        this.iTest=iTest;
    }
    @Override
    public int getValue() {
        return iTest.getValue();
    }
}
