package adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragment.MainFragment;


public class MyAdapterviewpager extends FragmentPagerAdapter {
String[] title;

    public MyAdapterviewpager(FragmentManager fm, String[] title) {
        super(fm);
        this.title = title;
    }
//传值
    @Override
    public Fragment getItem(int i) {
        return MainFragment.getinstance(title[i]);
    }

    @Override
    public int getCount() {
        return title.length;
    }
}
