package dawn.lib2;

import java.util.ArrayList;
import java.util.List;
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

//        for (int i=0;i<2;i++) {
//            MyThread thread=new MyThread(""+i);
//            thread.start();
////            try {
////                Thread.sleep(2000);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////            System.out.println("===sleep  2 second-------------------------------------------------------------------------------------------====>"+a);
////            new Thread(new Runnable() {
////                @Override
////                public void run() {
////
////                }
////            }).start();
//        }
//
//        try {
//            Thread.sleep(5000);
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

}
