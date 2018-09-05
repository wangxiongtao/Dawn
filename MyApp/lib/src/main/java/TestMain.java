import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2018/5/8 0008.
 */

public class TestMain {
    public static void main(String[] args) {
//            Object o=null;
        List<String> list = new ArrayList<>();

//            list.add("1");
//            list.addAll(null);
        System.out.println("========>"+TimeUtil.getTimeColor("1527226200000","1527235200000"));
            System.out.println("=f==>"+TimeUtil.getDayFirstTimeStamp(new Date()));
            System.out.println("=d==>"+TimeUtil.getDayEndTimeStamp(new Date()));
            System.out.println("=d==>"+int.class.getName());
            System.out.println("=d==>"+Float.class.getName());
            System.out.println("=d==>"+toTwoDecimalText("123.3598142"));




    }

    /**
     * Created by Administrator on 2018/5/8 0008.
     */

    public static class TimeUtil {
        public static String getDateByTimeStamp(String timeStamp,String format){
            long timeS=Long.parseLong(timeStamp);  //获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)
            SimpleDateFormat sdf=new SimpleDateFormat(format, Locale.CHINESE);//这个是你要转成后的时间的格式
            return  sdf.format(new Date(timeS));   // 时间戳转换成时间
        }

        public static String getDayFirstTimeStamp(Date date){
            String d=getDate(date,"yyyy-MM-dd");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String time=d+" "+"00:00:00";
            try {
                Date resDate = format.parse(time);
                return resDate.getTime()+"";
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return "";
        }
        public static String getDayEndTimeStamp(Date date){
            String d=getDate(date,"yyyy-MM-dd");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String time=d+" "+"23:59:59";
            try {
                Date resDate = format.parse(time);
                return resDate.getTime()+"";
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return "";
        }
        public static String getDate(Date date,String format) {//可根据需要自行截取数据显示
            SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.CHINESE);//这个是你要转成后的时间的格式
            return dateFormat.format(date);
        }
        public static int getTimeColor(String hopeTimeStart, String hopeTimeEnd){
            long oneHourMillSecond=3600*1000L;
            long currentTimeMillis=System.currentTimeMillis();
            long start=Long.parseLong(hopeTimeStart);
            long end=Long.parseLong(hopeTimeEnd);
            if(start-currentTimeMillis>oneHourMillSecond||currentTimeMillis>end){
                return 3;
            }
            return 0;
        }


    }
    public static String toTwoDecimalText(String s){
        int index=s.indexOf(".");
        if(index<0){
            return s;
        }
        String pre=s.substring(0,index);
        String suf=s.substring(index+1,s.length());
        if(suf.length()>2){
            suf=suf.substring(0,2);
            return pre+"."+suf;
        }
        return s;
    }
}
