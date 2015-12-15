package lube.kare.kengine.controller;


import android.content.Intent;
import android.view.View;

import lube.kare.kengine.http.HttpCommunicator;
import lube.kare.kengine.mapper.MainMapper;
import lube.kare.kengine.model.Model;
import lube.kare.kengine.noti.Noti;
import lube.kare.kengine.noti.NotiCenter;
import lube.kare.kengine.noti.NotiListener;
import lube.kare.kenginesample.MainActivity;
import lube.kare.kenginesample.R;

/**
 * Created by imac on 15. 11. 24..
 */
public class MainController extends BaseController implements NotiListener {
    private MainMapper mainMapper;


    public void init(MainActivity activity) {
        setNoti();
        initMapper(activity);
        setContentWithServer();

    }



    private void initMapper(MainActivity activity) {
        mainMapper=new MainMapper();
        mainMapper.init(activity);
    }

    private void setNoti(){
        NotiCenter.getInstance().addNotiListener("mainContent", this);
    }

    private void setContentWithServer(){

        HttpCommunicator hc=HttpCommunicator.getInstance();
        hc.doContent();
    }

    private void receiveMainContentNoti(Noti noti){
        Model model=noti.getData("model");

        mainMapper.mappingContentView(model);
    }

    @Override
    public void receiveNoti(Noti noti) {
        separateNoti(noti);
    }

    private void separateNoti(Noti noti){
        switch (noti.getKey()){
            case "mainContent":
                receiveMainContentNoti(noti);
                break;
        }
    }

    @Override
    protected void init() {

    }
}
