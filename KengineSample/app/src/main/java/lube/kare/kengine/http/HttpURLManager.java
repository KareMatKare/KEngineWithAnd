package lube.kare.kengine.http;

/**
 * Created by imac on 15. 10. 31..
 */
public class HttpURLManager {

    private static HttpURLManager instance;

    public static HttpURLManager getInstance() {
        if (instance == null) instance = new HttpURLManager();
        return instance;
    }

    public final String TESTURL = "http://rrtt96.cafe24.com/sample.php";
}
