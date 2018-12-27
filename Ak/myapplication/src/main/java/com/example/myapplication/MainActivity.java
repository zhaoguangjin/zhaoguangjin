package com.example.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewById;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String [] strings = new String[]{"我的","他的"};
        tab = findViewById(R.id.tab);
        this.viewById = findViewById(R.id.viewpager);
        for (int i=0;i<strings.length;i++){
            tab.addTab(tab.newTab());
        }
        tab.setupWithViewPager(viewById,false);
        for (int x=0;x<strings.length;x++){
            tab.getTabAt(x).setText(strings[x]);
        }
    }
}
