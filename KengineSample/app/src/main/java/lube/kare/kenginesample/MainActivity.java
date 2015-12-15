package lube.kare.kenginesample;

import android.app.Activity;
import android.os.Bundle;

import lube.kare.kengine.controller.MainController;


public class MainActivity extends Activity {
    private MainController mainController=new MainController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mainController.init(this);

    }
}
