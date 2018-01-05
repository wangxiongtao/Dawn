package rx;

/**
 * Created by Administrator on 2017/12/15.
 */

public class MyRx {
    public interface MyCallBack{
        void success(String str);
    }
    public interface AsynJob{
        void start(MyCallBack str);
    }



    public void getDataByNet(String string, final MyCallBack callBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                callBack.success("get data  success");

            }
        }).start();
    }

    public AsynJob getDataByNet(String str){
       return new AsynJob() {
           @Override
           public void start(final MyCallBack str) {
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       try {
                           Thread.sleep(5000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       str.success("get data  success");

                   }
               }).start();
           }
       };
    }


}
