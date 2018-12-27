package fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lianxi.R;

import java.util.ArrayList;
import java.util.List;

import adapter.GanAdapter;
import adapter.MyAdapterviewpager;

public class fragment_ganhuo extends Fragment {

    private LinearLayout linearLayout;
    private ViewPager view_pager;
    private List<TextView> list;

    @SuppressLint("ResourceAsColor")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ganhuo, container, false);
        linearLayout = view.findViewById(R.id.linearLayout);
        view_pager = view.findViewById(R.id.gview_pager);
        String[] titles = new String[]{"每日推荐","干货定制","福利"};
        list = new ArrayList<>();
     GanAdapter adapter = new GanAdapter(getActivity().getSupportFragmentManager(),titles);
     view_pager.setAdapter(adapter);
        for (int i=0;i<titles.length;i++){
            //创建textview
            TextView textView = new TextView(getActivity());
            textView.setText(titles[i]);
            textView.setTextSize(20);
            textView.setTextColor(R.color.app_w);
            textView.setId(i);
            //点击事件
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId();
                    view_pager.setCurrentItem(id);
                }
            });
            //设置进程序第一个为红色
            if (i==0) {
                textView.setTextColor(Color.RED);
            }
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.setMargins(75,20,75,20);
            linearLayout.setBackground(getActivity().getDrawable(R.color.app_color));
            linearLayout.addView(textView,layoutParams);
            list.add(textView);
        }
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //滑动
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                for (int x=0;x<list.size();x++){
                    if (i == x) {
                        list.get(x).setTextColor(getResources().getColor(R.color.app_r));
                    } else {
                        list.get(x).setTextColor(getResources().getColor(R.color.app_w));
                    }
                }


            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
            return view;
    }

}
