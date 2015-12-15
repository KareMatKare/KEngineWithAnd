package lube.kare.kengine.mapper;


import android.content.Intent;
import android.view.View;

import lube.kare.kengine.model.Model;
import lube.kare.kengine.util.activityutil.DefaulActivityUtil;
import lube.kare.kenginesample.DetailActivity;
import lube.kare.kenginesample.MainActivity;
import lube.kare.kenginesample.R;

/**
 * Created by imac on 15. 11. 24..
 */
public class MainMapper extends BaseMapper{
    private MainActivity mainActivity;

    public void init(MainActivity activity) {
        this.mainActivity=activity;
    }

    public void mappingContentView(final Model contentModel){
        String content= contentModel.getData("content");
        DefaulActivityUtil.getInstance().setTextToTextView(mainActivity, R.id.main_textview_content,content);
        mainActivity.findViewById(R.id.main_button_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity, DetailActivity.class);
                intent.putExtra("contentModel",contentModel.toString());
                mainActivity.startActivity(intent);
            }
        });
    }

    @Override
    protected void init() {

    }
}
