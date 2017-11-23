package http2;

/**
 * Created by Administrator on 2017/11/23.
 */

public class HttpPost implements IHttp {

    @Override
    public void doRequest(HttpRequest httpRequest) {
        System.out.println("===I AM POST REQUEST===========>");
    }
}
