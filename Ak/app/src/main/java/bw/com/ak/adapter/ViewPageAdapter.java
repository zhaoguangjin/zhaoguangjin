package bw.com.ak.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import bw.com.ak.view.MainFragment;

public class ViewPageAdapter extends FragmentPagerAdapter {
    String[] titles;
    public ViewPageAdapter(FragmentManager fm,String[] titles) {
        super(fm);
        this.titles=titles;
    }
    //当前fragment
    @Override
    public Fragment getItem(int i) {
        return MainFragment.getinstance(titles[i]);
    }
  //fragment 数量
    @Override
    public int getCount() {
        return titles.length;
    }
}
