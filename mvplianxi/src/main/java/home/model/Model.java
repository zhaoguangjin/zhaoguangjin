package home.model;

import android.os.AsyncTask;
import android.util.Log;

import add.Http;
import api.Api;

public class Model implements Modelinten {
    //把接口提成成员变量
    Modelint modelint;
    //实现接口
    public Model(Modelint modelint){
        this.modelint=modelint;
    }
    //接口实现的类
    @Override
    public void getModelinten() {
new Mas().execute();
    }
    class Mas extends AsyncTask<Integer,Integer,String>{

        @Override
        protected String doInBackground(Integer... integers) {
            String paths="http://api.tianapi.com/meinv/?key=11500f2566e70105ee1c28a12f5f750a&num=10";

            String ss= Http.getdata(paths,"POST");
            Log.i("WA","aa"+ss);
            if (ss != null) {
                modelint.getyou(ss);
            } else {
                modelint.wu();
            }
            return ss;
        }
    }
    //定义接口
    public interface Modelint{
        void  getyou(String zhi);
        void  wu();
    }
}
