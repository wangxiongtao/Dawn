package http2;

/**
 * Created by Administrator on 2017/11/23.
 */
class  MyRequest extends HttpRequest{

    public MyRequest(int tag) {
        super(tag);
    }
}

public class HttpTest {
    public static void main(String[] a){
       MyRequest request=new MyRequest(2);
       request.doRequest();
    }
}
