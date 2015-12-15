package lube.kare.kengine.util.httputil;

import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import lube.kare.kengine.util.httputil.listener.HttpListener;


/**
 * Created by imac on 15. 11. 26..
 */
public class HttpRespon extends AsyncHttpResponseHandler {
    private HttpListener httpListener;

    public HttpRespon(HttpListener httpListener) {
        this.httpListener = httpListener;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        String result = new String(responseBody);
        httpListener.responData(result);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

    }
}
