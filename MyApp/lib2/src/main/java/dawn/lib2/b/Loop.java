package dawn.lib2.b;

/**
 * Created by Administrator on 2017/11/22.
 */

public class Loop implements IMyLoop {
    @Override
    public String intercept(ILoop chain) {
        return chain.proceed();
    }
}
