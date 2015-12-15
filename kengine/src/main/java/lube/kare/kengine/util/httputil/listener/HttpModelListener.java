package lube.kare.kengine.util.httputil.listener;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import lube.kare.kengine.model.Model;
import lube.kare.kengine.noti.Noti;
import lube.kare.kengine.noti.NotiCenter;
import lube.kare.kengine.util.parser.BaseParser;


/**
 * Created by imac on 15. 11. 24..
 */
public class HttpModelListener extends HttpListener {
    private BaseParser parser;
    private String notiName;

    public HttpModelListener(BaseParser parser,String notiName){
        this.parser=parser;
        this.notiName=notiName;
    }

    @Override
    public void responData(String result) {
        Log.e("Http리스너","통신성공");
        try {
            Log.e("Http리스너",result);
            Model model = parser.doParse(new JSONObject(result));
            Noti noti = new Noti();
            noti.putData("model", model);
            NotiCenter.getInstance().doNoti(notiName, noti);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setParser(BaseParser parser) {
        this.parser = parser;
    }

    public void setNotiName(String notiName) {
        this.notiName = notiName;
    }
}
