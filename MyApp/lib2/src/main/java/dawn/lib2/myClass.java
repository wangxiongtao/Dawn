package dawn.lib2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class B{
    public List<C>list=new ArrayList<>();
    public void add(C c){
        list.add(c);
    }
    public void update(int i){
        list.get(0).onUpdate(i);
    }













}
class C {
    public void  onUpdate(int i){
        System.out.println("=i===============>"+i);
    };


}




public class myClass {
    static int a=0;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) {
        java.util.Random r=new java.util.Random();
        System.out.println("============>"+r.nextLong());
        System.out.println("============>"+System.currentTimeMillis());
            fun(10);











//        String a=null;
//        switch (a){
//            case "asdasdas":
//                System.out.println("========1====>");
//                break;
//            case "2":
//                System.out.println("========2====>");
//                break;
//            case "3q eq  ":
//                System.out.println("========3====>");
//                break;
//            case "4sss":
//                System.out.println("========4====>");
//                break;
//        }

        final CountDownLatch latch=new CountDownLatch(1);
        latch.countDown();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("========wo s thrid zi thread====>");
//        final CountDownLatch latch1=new CountDownLatch(1);
//        new MyThread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("========wo s zi thread====>");
//                latch.countDown();
//            }
//        }).start();
//
//        new MyThread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    latch.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    System.out.println("====eeeee========>"+e.getMessage());
//                }
//                System.out.println("========wo s second zi thread====>");
//                latch1.countDown();
//            }
//        }).start();
//        new MyThread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    latch1.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    System.out.println("====eeeee========>"+e.getMessage());
//                }
//                System.out.println("========wo s thrid zi thread====>");
//            }
//        }).start();



//        for (int i=0;i<2;i++) {
//            MyThread thread=new MyThread(""+i);
//            thread.start();
////            try {
////                MyThread.sleep(2000);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////            System.out.println("===sleep  2 second-------------------------------------------------------------------------------------------====>"+a);
////            new MyThread(new Runnable() {
////                @Override
////                public void run() {
////
////                }
////            }).start();
//        }
//
//        try {
//            MyThread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
    static class MyThread extends Thread{
        public MyThread(String  name){
            super(name);
        }
        @Override
        public void run() {
            super.run();
            for (int i=0;i<1000;i++) {
                        a++;
//                        atomicInteger.getAndIncrement();
//                        System.out.println("===A====>"+a);
                        System.out.println(Thread.currentThread().getName()+"===atomicInteger====>"+a);
                    }
        }
    }


    public static void fun(int i){
        //1,1,2,3,5,8,13,21,34,55,89....
        int a=1;
        int b=1;
        int c=0;

        for (int v=0;v<=i;v++){
            if(v==0||v==1){
                c=1;

            }else {
                b = a + b;
                a = b;
            }
        }
        System.out.println("========>"+b);



    }

}
