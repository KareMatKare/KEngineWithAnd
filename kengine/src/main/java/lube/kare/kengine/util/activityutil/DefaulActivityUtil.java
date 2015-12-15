package lube.kare.kengine.util.activityutil;

/**
 * Created by imac on 15. 11. 26..
 */
public class DefaulActivityUtil extends BaseActivityUtil {
    private static DefaulActivityUtil instance;

    public static DefaulActivityUtil getInstance(){
        if(instance==null)instance=new DefaulActivityUtil();
        instance=new DefaulActivityUtil();
        return instance;
    }
}
