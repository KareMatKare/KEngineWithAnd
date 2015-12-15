package lube.kare.kenginesample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import lube.kare.kengine.controller.DetailController;

public class DetailActivity extends Activity {
    private DetailController detailController=new DetailController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
    }

    private void init() {
        detailController.init(this);
    }

}
