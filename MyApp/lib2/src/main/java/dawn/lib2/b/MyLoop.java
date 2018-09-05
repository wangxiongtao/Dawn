package dawn.lib2.b;

/**
 * Created by Administrator on 2017/11/22.
 */

public class MyLoop implements IMyLoop.ILoop {


    @Override
    public String proceed() {
        IMyLoop iMyLoop=new IMyLoop() {
            @Override
            public String intercept(ILoop chain) {
                return this.intercept(new ILoop() {
                    @Override
                    public String proceed() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return "qwdqwqweqweqwe";
                    }
                });
            }

            @Override
            public Object fun(Object o) {
                return null;
            }
        };

        return iMyLoop.intercept(this);
    }
}
