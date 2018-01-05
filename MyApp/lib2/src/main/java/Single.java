/**
 * Created by Administrator on 2017/12/1.
 */


    public class Single {

    public static class SingleHolder{
        public static Single single=new Single();
    }
    public Single getSingle(){
        return SingleHolder.single;
    }



    private static  Single single1=new Single();
    public   int  a1;
    public static   int  a2=0;
//
    private Single(){
//        a1=4;
//        a2=8;
    }




    public static Single getSingle1() {

//        if(single1==null){
            synchronized (Single.class){
                if(single1==null){
                    single1=new Single();
                }
//            }
        }

        return single1;
    }
    public static Single getSingle2() {

        return single1;
    }


}
