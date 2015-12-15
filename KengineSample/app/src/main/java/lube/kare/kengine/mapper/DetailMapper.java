package lube.kare.kengine.mapper;

import android.content.Intent;
import android.view.View;

import lube.kare.kengine.model.Model;
import lube.kare.kengine.util.activityutil.DefaulActivityUtil;
import lube.kare.kenginesample.DetailActivity;
import lube.kare.kenginesample.R;

/**
 * Created by Curry on 2015-12-13.
 */
public class DetailMapper extends BaseMapper {

    private DetailActivity detailActivity;

    public void init(DetailActivity activity) {
        this.detailActivity =activity;
    }
    @Override
    protected void init() {

    }

    public void mappingContentView(Model contentModel){
        String content= contentModel.getData("content");
        DefaulActivityUtil.getInstance().setTextToTextView(detailActivity, R.id.detail_textview_content, content);

    }
}
