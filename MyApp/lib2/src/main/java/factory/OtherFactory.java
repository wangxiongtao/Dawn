package factory;

/**
 * Created by Administrator on 2018/3/26 0026.
 */

public class OtherFactory implements IUserFactory {
    @Override
    public IUser getUser() {
        return new OtherUser();
    }
}
