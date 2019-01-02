package com.example.zh.zhaoguangjin20190102;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import fragment.fragment_shou;
import fragment.fragment_tui;

public class MainActivity extends FragmentActivity {

    private RadioGroup radio_group;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radio_group = findViewById(R.id.radio_group);
        manager = getSupportFragmentManager();
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId) {
                    case R.id.re1:
                        transaction.replace(R.id.fragment,new fragment_shou());
                        break;
                        case R.id.re2:
                            transaction.replace(R.id.fragment,new fragment_tui());
                            break;
                }
                transaction.commit();
            }
        });
    }
}
