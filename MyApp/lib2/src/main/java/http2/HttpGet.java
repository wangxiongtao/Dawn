package http2;

/**
 * Created by Administrator on 2017/11/23.
 */

public class HttpGet implements IHttp {

    @Override
    public void doRequest(HttpRequest httpRequest) {
        System.out.println("===I AM GET REQUEST===========>");
    }
}
