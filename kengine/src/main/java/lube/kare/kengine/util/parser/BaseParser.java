package lube.kare.kengine.util.parser;

import org.json.JSONObject;

import lube.kare.kengine.model.Model;


/**
 * Created by imac on 15. 11. 24..
 */
public interface BaseParser {
    public Model doParse(JSONObject result);

}
