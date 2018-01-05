package rx;

/**
 * Created by Administrator on 2017/12/15.
 */

public class TestRx {
    public static void main(String[] args) {
        MyRx myRx=new MyRx();
//        myRx.getDataByNet("", new MyRx.MyCallBack() {
//            @Override
//            public void success(String str) {
//                System.out.println("str============>"+str);
//            }
//        });
        myRx.getDataByNet("").start(new MyRx.MyCallBack() {
            @Override
            public void success(String str) {
                System.out.println("str============>"+str);
            }
        });

    }
}
