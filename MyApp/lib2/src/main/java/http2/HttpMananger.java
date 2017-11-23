package http2;

/**
 * Created by Administrator on 2017/11/23.
 */

public class HttpMananger {
    private static HttpMananger sHttpMananger;

    public static HttpMananger getInstance() {
        if (sHttpMananger == null) {
            sHttpMananger = new HttpMananger();
        }
        return sHttpMananger;
    }

    public void doRequest(IHttp http, HttpRequest request) {
        http.doRequest(request);
    }


}
