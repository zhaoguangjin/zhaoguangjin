package presenter;

import android.util.Log;

import com.example.zh.zhaoguangjin20190102.MainActivity;

import fragment.fragment_shou;
import model.Model;

public class Presenter implements Presenterinten,Model.getmodeldata {
    fragment_shou fragment_shou;
    private final Model model;
    public Presenter(fragment_shou fragment_shou){
        this.fragment_shou=fragment_shou;
        model = new Model(this);
    }
    @Override
    public void getpreshent() {
model.getmodel();
    }

    @Override
    public void getyou(String s) {
        Log.i("QQQ","内容"+s);
        fragment_shou.getview(s);
    }

    @Override
    public void getwu() {

    }
}
