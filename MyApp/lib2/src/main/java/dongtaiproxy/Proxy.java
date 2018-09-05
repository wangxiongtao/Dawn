package dongtaiproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/3/19 0019.
 */

public class Proxy {
    public ApiService get(){

        return (ApiService) java.lang.reflect.Proxy.newProxyInstance(ApiService.class.getClassLoader(), new Class[]{ApiService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                return method.invoke(ApiService.class.newInstance(),objects);
            }
        });


    }

    public static void main(String[] args) {
        Proxy proxy=new Proxy();
        System.out.println("===========>"+proxy.get().getValue(11212));
    }


}
