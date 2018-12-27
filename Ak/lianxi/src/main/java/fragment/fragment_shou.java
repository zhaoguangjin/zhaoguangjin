package fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lianxi.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import adapter.MyAdapterviewpager;

public class fragment_shou extends Fragment {

    private ViewPager view_pager;
    private HorizontalScrollView hs;
    private String[] titles = new String[]{"知乎日报", "热点新闻", "微信热点"};
    private List<TextView> list;
    private LinearLayout linearLayout;


    @SuppressLint("ResourceAsColor")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shou, container, false);
        //初始化数据
        view_pager = view.findViewById(R.id.view_pager);
        hs = view.findViewById(R.id.hs);
        linearLayout = view.findViewById(R.id.linearLayout);
        //viewpager适配器
        view_pager.setAdapter(new MyAdapterviewpager(getActivity().getSupportFragmentManager(),titles));
        //创建一个集合，存放textview
        list = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            TextView textView = new TextView(getActivity());
            textView.setText(titles[i]);
            textView.setTextColor(R.color.app_w);
            textView.setTextSize(20);
            textView.setId(i);
            //点击事件和viewpager联动
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId();
                    view_pager.setCurrentItem(id);
                }
            });
            //刚进程序第一个字为红色
            if (i==0) {
                textView.setTextColor(Color.RED);
            }
            //设置布局样式
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.gravity = Gravity.CENTER;
            layoutParams.setMargins(65, 35, 65, 20);
            linearLayout.setBackground(getActivity().getDrawable(R.color.app_color));
            linearLayout.addView(textView,layoutParams);
            list.add(textView);

        }
           view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
              //滑动
                @Override
               public void onPageScrolled(int i, float v, int i1) {
                    //list中存的是 textview
                    for (int x = 0; x < list.size(); x++) {
                        if (i == x) {
                           list.get(x).setTextColor(getResources().getColor(R.color.app_r));
                      } else {
                           list.get(x).setTextColor(getResources().getColor(R.color.app_w));
                       }
                        //获取当前的textview
                       TextView textView = list.get(i);
                       //width是每次滑动的距离
                        int width = textView.getWidth() + 65;
                       ////让scrollView滑动   滑动距离是textview之间的间距
                        hs.scrollTo(width * i, 0);
                   }
               }

               //选中
               @Override
             public void onPageSelected(int i) {

               }

               //改变
               @Override
              public void onPageScrollStateChanged(int i) {

               }
            });
     return view;
   }

    }

