package lube.kare.kengine.noti;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by imac on 15. 10. 28..
 */
public class Noti {
    private String key;
    private Map<String,Object> datas=new HashMap<>();

    public void putData(String key,Object value){
        datas.put(key,value);
    }

    public void putData(String key,int value){
        datas.put(key,value);
    }
    public void putData(String key,double value){
        datas.put(key,value);
    }
    public void putData(String key,float value){
        datas.put(key,value);
    }
    public void putData(String key,boolean value){
        datas.put(key,value);
    }
    public <T>T getData(String key){
        return (T) datas.get(key);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
