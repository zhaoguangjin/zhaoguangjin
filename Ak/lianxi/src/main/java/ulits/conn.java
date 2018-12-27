package ulits;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.security.PublicKey;

public class conn {
    public static  boolean iscon(Context context){
        //获取网络连接对象
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean b = networkInfo.isConnected();
        return b;
    }
}
