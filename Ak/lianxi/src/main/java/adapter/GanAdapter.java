package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragment.Ganfragment;

public class GanAdapter extends FragmentPagerAdapter  {
    String[] titles;

    public GanAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int i) {
        return Ganfragment.getinstance(titles[i]);
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}
