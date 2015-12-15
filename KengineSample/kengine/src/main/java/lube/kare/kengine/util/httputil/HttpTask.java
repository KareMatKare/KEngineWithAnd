package lube.kare.kengine.util.httputil;


import lube.kare.kengine.util.httputil.listener.HttpListener;

/**
 * Created by imac on 15. 11. 24..
 */
public class HttpTask {
    private String url;
    private HttpListener httpListener;

    public HttpTask(String url, HttpListener httpListener) {
        this.url = url;
        this.httpListener = httpListener;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HttpListener getHttpListener() {
        return httpListener;
    }

    public void setHttpListener(HttpListener httpListener) {
        this.httpListener = httpListener;
    }
}
