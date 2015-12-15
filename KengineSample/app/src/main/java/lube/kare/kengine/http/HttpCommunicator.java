package lube.kare.kengine.http;

import com.loopj.android.http.AsyncHttpClient;


import lube.kare.kengine.parser.ContentParser;
import lube.kare.kengine.util.httputil.HttpRespon;
import lube.kare.kengine.util.httputil.listener.HttpModelListener;

/**
 * Created by imac on 15. 10. 27..
 */
public class HttpCommunicator {
    private static HttpCommunicator instance;

    public static HttpCommunicator getInstance() {
        if (instance == null) {
            instance = new HttpCommunicator();
        }
        return instance;
    }

    public void doContent(){
        HttpURLManager hum=HttpURLManager.getInstance();
        String testUrl=hum.TESTURL;
        HttpModelListener httpModelListener=new HttpModelListener(new ContentParser(),"mainContent");
        AsyncHttpClient httpClient=new AsyncHttpClient();
        httpClient.get(testUrl,new HttpRespon(httpModelListener));
    }




}
