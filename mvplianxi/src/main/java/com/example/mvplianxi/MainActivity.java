package com.example.mvplianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import home.presenter.Presenter;
import home.view.Viewinten;

public class MainActivity extends AppCompatActivity implements Viewinten {

    private Presenter presenter;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textx);
        //强引用
        presenter = new Presenter(this);
        //调用model里的类
        presenter.getpreent();
    }
//接口实现类
    @Override
    public void getview(String strs) {
        Log.i("WA","aa"+strs);
text.setText(strs);
    }

}
