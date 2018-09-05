package factory;

/**
 * Created by Administrator on 2018/3/26 0026.
 */

public class Client {
    public static void main(String[] args) {
        IUserFactory factory=new OtherFactory();
        IUser iUser=factory.getUser();
        iUser.getUrl();

        int a=1;
        int b=2;
        System.out.println("=a==>"+ (double) (a));
        System.out.println("====>"+ (double) (a) /b);

    }
}
