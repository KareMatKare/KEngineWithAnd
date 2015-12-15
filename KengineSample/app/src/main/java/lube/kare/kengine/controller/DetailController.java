package lube.kare.kengine.controller;


import lube.kare.kengine.mapper.DetailMapper;
import lube.kare.kengine.mapper.MainMapper;
import lube.kare.kengine.model.Model;
import lube.kare.kenginesample.DetailActivity;
import lube.kare.kenginesample.MainActivity;

/**
 * Created by Curry on 2015-12-13.
 */
public class DetailController extends BaseController {

    private DetailMapper detailMapper;


    public void init(DetailActivity activity) {
        initMapper(activity);
        initData(activity);
    }

    private void initData(DetailActivity activity) {
        String contentStr=activity.getIntent().getStringExtra("contentModel");
        Model contentModel=Model.toModel(contentStr);
        detailMapper.mappingContentView(contentModel);
    }

    private void initMapper(DetailActivity activity) {
        detailMapper=new DetailMapper();
        detailMapper.init(activity);
    }
    @Override
    protected void init() {

    }
}
