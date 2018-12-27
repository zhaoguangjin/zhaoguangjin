package bw.com.ak;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bw.com.ak.adapter.ViewPageAdapter;

public class MainActivity extends AppCompatActivity {
    private String[] titles;
    private List<TextView> list;
    private HorizontalScrollView hs;
    private LinearLayout linearlayout;
    private ViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hs = (HorizontalScrollView)findViewById(R.id.hs);
        linearlayout = (LinearLayout)findViewById(R.id.linearlayout);
        viewpager = (ViewPager)findViewById(R.id.viewpager);

        //创建数组,存放标题
        titles = new String[] { "头条", "娱乐", "科技" };
        viewpager.setAdapter(new ViewPageAdapter(getSupportFragmentManager(),titles));
        //创建集合,存放textview
        list = new ArrayList<TextView>();
        for (int i = 0; i < titles.length; i++) {
            //创建textview
            TextView textView = new TextView(MainActivity.this);
            textView.setText(titles[i]);
            textView.setTextSize(20);
            textView.setTextColor(Color.rgb(250,250,250));
            textView.setId(i + 20);
            //点击事件
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = view.getId();
                    viewpager.setCurrentItem(id-20);
                }
            });
            //刚进程序第一个默认红色,其他为黑色
            if(i ==0){
                textView.setTextColor(Color.RED);
            }else {
                textView.setTextColor(Color.BLACK);
            }

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(20,40,20,40);
            //添加到布局中
            linearlayout.setBackground(getDrawable(R.color.app_color));
            linearlayout.addView(textView,layoutParams);
            //添加到集合
            list.add(textView);
        }

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //滑动
            @Override
            public void onPageScrolled(int position, float v, int i1) {
                //list中存的是 textview
                for (int i = 0; i < list.size(); i++) {
                    if(position==i){
                        list.get(i).setTextColor(getResources().getColor(R.color.app_r));
                    }else{
                        list.get(i).setTextColor(getResources().getColor(R.color.app_w));
                    }
                }
                //获取当前的textview
                TextView textView = list.get(position);
                //width是每次滑动的距离
                int width = textView.getWidth()+10;
                //让scrollView滑动   滑动距离是textview之间的间距
                hs.scrollTo(width*position,0);

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


    }
}
