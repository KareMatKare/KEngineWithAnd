package lube.kare.kengine.parser;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import lube.kare.kengine.model.Model;
import lube.kare.kengine.util.parser.BaseParser;

/**
 * Created by imac on 15. 11. 26..
 */
public class ContentParser implements BaseParser {
    @Override
    public Model doParse(JSONObject result) {
        Log.e("파서","파싱 시작");
        try {
            Model model = new Model();
            String content = result.getString("test");
            model.putData("content",content);

            Log.e("파서","파싱 완료 content="+content);
            return model;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
