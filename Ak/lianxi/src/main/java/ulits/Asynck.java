package ulits;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.nostra13.universalimageloader.utils.L;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Asynck {
public static String getcount(Context context,String path){
    try {
        URL url = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setReadTimeout(5*1000);
        connection.setConnectTimeout(5*1000);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
}
