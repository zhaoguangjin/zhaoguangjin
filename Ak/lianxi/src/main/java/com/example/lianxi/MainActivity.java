package com.example.lianxi;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.RadioGroup;

import fragment.fragment_ganhuo;
import fragment.fragment_geren;
import fragment.fragment_shou;
import fragment.fragment_shuji;
import fragment.fragment_yingshi;

public class MainActivity extends FragmentActivity {


    private RadioGroup radio_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radio_group = findViewById(R.id.radio_group);
        final FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,new fragment_shou());
        fragmentTransaction.commit();
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = manager.beginTransaction();
        switch (checkedId) {
            case    R.id.re_1:
                transaction.replace(R.id.fragment,new fragment_shou());
                break;
            case    R.id.re_2:
                transaction.replace(R.id.fragment,new fragment_ganhuo());
                break;
            case    R.id.re_3:
                transaction.replace(R.id.fragment,new fragment_yingshi());
                break;
            case    R.id.re_4:
                transaction.replace(R.id.fragment,new fragment_shuji());
                break;
            case    R.id.re_5:
                transaction.replace(R.id.fragment,new fragment_geren());
                break;

        }
        transaction.commit();
    }
});
    }

}
