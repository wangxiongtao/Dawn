package dawn.lib2.b;

/**
 * Created by Administrator on 2017/11/22.
 */

public interface IMyLoop<T> {
    String intercept(ILoop chain);
    public interface ILoop{
        String proceed();
    }
    T fun(T t);



}
