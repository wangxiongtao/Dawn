package factory;

/**
 * Created by Administrator on 2018/3/26 0026.
 */

public class MyUser implements IUser {
    @Override
    public void getUrl() {
        System.out.println("========>MyUser");
    }
}
