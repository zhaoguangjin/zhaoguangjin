package home.presenter;

import android.util.Log;

import com.example.mvplianxi.MainActivity;

import home.model.Model;

public class Presenter implements Presenterinten,Model.Modelint {
    //初始化视图
    MainActivity mview;
    private final Model model;
//与Model和view进行关联
    public Presenter(MainActivity mainActivity){
        this.mview=mainActivity;
        model = new Model(this);
    }
    //实现接口的类
    @Override
    public void getpreent() {
        //调用model里的接口实现类
        model.getModelinten();
    }
//model里内部接口定义的类
    @Override
    public void getyou(String zhi) {
mview.getview(zhi);
        Log.i("WA","aa"+zhi);
    }
    //model里内部接口定义的类
    @Override
    public void wu() {
        mview.getview("没有加载成功");
    }
}
