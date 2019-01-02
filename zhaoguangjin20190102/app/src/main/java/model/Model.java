package model;

import android.util.Log;

import java.io.IOException;

import app.Okhttp;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Model implements Modelinten {
    getmodeldata getmodeldata;
    public Model(getmodeldata getmodeldata){
        this.getmodeldata=getmodeldata;
    }
    @Override
    public void getmodel() {
        String url="http://www.zhaoapi.cn/home/getHome";
        Okhttp.okhttpget(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {


                       String ss = response.body().string();
                       getmodeldata.getyou(ss);
                Log.i("QQ","内容"+ss);
            }
        });
    }
    public interface getmodeldata{
        void getyou(String s);
        void  getwu();
    }
}
