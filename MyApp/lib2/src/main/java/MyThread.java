/**
 * Created by Administrator on 2017/12/1.
 */

public class MyThread {
    public static void main(String[] args) {
//        for (int i=0;i<5;i++){
//            new Thread(new Runnable() {
//                @Override
//                public   void run() {
//                    synchronized ("") {
//                        for (int j = 0; j < 10000; j++) {
//                            System.out.println(Thread.currentThread().getName() + "============>" + j);
//
//                        }
//                    }
//                }
//            }).start();
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

//        }
        System.out.println(Thread.currentThread().getName() + "=====a1=======>" + Single.getSingle2().a1);
        System.out.println(Thread.currentThread().getName() + "=====a2=======>" + Single.getSingle2().a2);

    }



}
