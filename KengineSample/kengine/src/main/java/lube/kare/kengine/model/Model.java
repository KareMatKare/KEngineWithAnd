package lube.kare.kengine.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by imac on 15. 11. 24..
 */
public class Model {
    private HashMap<String,Object> map=new HashMap<>();

    public void putData(String key,Object value) {
        map.put(key,value);
    }

    public <T> T getData(String key){
        return (T) map.get(key);
    }
    public <T> T getData(String key,T t){
        T val=(T) map.get(key);
        if(val==null){
            val=t;
        }
        return val;
    }

    @Override
    public String toString() {
        return toJson();
    }
    private String toJson(){
        JSONObject jsonObject= new JSONObject();
        Set<String> keys = map.keySet();
        for(String key : keys){
            Object value=map.get(key);
            try {
                jsonObject.put(key,value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jsonObject.toString();
    }

    public static Model toModel(String string){
        Model model=new Model();
        try {
//            JSONObject jsonObject=new JSONObject(string);
//            Iterator<String> keys = jsonObject.keys();
//            while (keys.hasNext()){
//                String key=jsonObject.keys().next();
//                Object value=jsonObject.get(key);
//                model.putData(key,value);
//            }
            JSONObject jsonObject=new JSONObject(string);
            JSONArray keys = jsonObject.names();
            for(int i =0;i<keys.length();i++){
                String key=keys.getString(i);
                Object value=jsonObject.get(key);
                model.putData(key,value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return model;
    }
}
