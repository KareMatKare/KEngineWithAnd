package lube.kare.kengine.noti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by imac on 15. 10. 28..
 */
public class NotiCenter {
    private static NotiCenter instance;

    public static NotiCenter getInstance(){
        if(instance==null) instance=new NotiCenter();
        return instance;
    }



    private Map<String,ArrayList<NotiListener>> notimap=new HashMap<>();

    public void doNoti(String key,Noti noti){
        ArrayList<NotiListener> notis=notimap.get(key);
        noti.setKey(key);
        for(int i=0;i<notis.size();i++){
            NotiListener notiListener=notis.get(i);
            notiListener.receiveNoti(noti);
        }
    }

    public void addNotiListener(String key,NotiListener noti){
        ArrayList<NotiListener> notis=notimap.get(key);
        if(notis==null){
            notis=new ArrayList<>();
            notimap.put(key,notis);
        }
        notis.add(noti);
    }


}
