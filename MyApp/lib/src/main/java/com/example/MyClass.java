package com.example;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

class B extends HashMap{
    short aChar=1;
    public int b=10_3;;
    public void fun(){
        System.out.println("==fun b=============>");
    };
}
class C extends B{
    @Override
    public void fun() {
        System.out.println("==fun c============>");
    }
    public void fun1() {
        System.out.println("==fun1 c============>");
    }

}
class Counter implements Runnable {
    private static int count;
//AtomicInteger count = new AtomicInteger(0);
    ThreadLocal<Integer>t=new ThreadLocal<>();


    public void run() {
        if(t.get()==null){
            t.set(0);
        }

//        System.out.println("===============>"+Thread.currentThread().getName()
//                + ":" + count.incrementAndGet());
        int a=t.get();
        a=a+1;
        t.set(a);
        System.out.println("===============>"+Thread.currentThread().getName()
                + ":" + t.get());
    }
}


    public class MyClass {
        public static int a = 0;
        public static AtomicInteger count = new AtomicInteger(0){
            @Override
            public int intValue() {
                return 0;
            }
        };
    public static void main(String[] args) {
//        final Counter counter = new Counter();
//        HashMap<String,Integer>map=new HashMap<>();

        String s="#.##";
        DecimalFormat df = new DecimalFormat(s);
        System.out.println("============="+df.format(5.20d));








         int b=10______________4_____________________________________3;
        System.out.println("===============>"+b);
//        String a="Abc";
//        a="7898";
//        B b=new B();
//        b.b=123;
//        fun(b);
//        System.out.println("===============>"+b.b);

//        Thread t2 = new Thread(counter);
//        Thread t3 = new Thread(counter);
//        Thread t4 = new Thread(counter);
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        for (int i=0;i<100;i++){
//            Thread t1 = new Thread(counter);
//            t1.start();
//        }
//        B b=new C();
//        b.fun();
//        HashMap<String,String>map=new HashMap<>();
//        map.put("a","1");
//        map.put("b","2");
//        map.put("c","3");
//        map.put("d","4");
//        System.out.println("===============>"+map.remove("b"));
//        System.out.println("===============>"+map.remove("d"));
//        System.out.println("======size" +
//                "=========>"+map.size());
//        for (int i = 0; i < 10; i++) {
//            new Thread() {
//                public  void run() {
//                    while (true) {
//                        a++;
//                        try {
//                            Thread.sleep(1);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println("===========>plus:" + Thread.currentThread().getName() + ": " + a);
//                    }
////                    count.incrementAndGet();
//                }
//            }.start();
//            try {
//                Thread.sleep(4000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


//        ITest t=new TestImpl();
//
//       t=new TestA(t);
//        t=new TestB(t);
//
//        System.out.println(t.getValue());









    }
    public static void  fun(B b){
           b.b=34;
           b=new B();
           b.b=100;
        }

}
