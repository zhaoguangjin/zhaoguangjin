package add;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
;

public class Http {
    public static String getdata(String path,String get){
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(get);
            connection.setReadTimeout(5*1000);
            connection.setConnectTimeout(5*1000);
            if (connection.getResponseCode()==HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String str="";
                String str1="";
                if ((str=reader.readLine())!=null) {
                    str1+=str;
                }

                return str1;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    };

};
