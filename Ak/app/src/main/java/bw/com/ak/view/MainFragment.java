package bw.com.ak.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {

    public static Fragment getinstance(String title){
        //创建Fragment1
        MainFragment fragment1 = new MainFragment();
        //创建bundle
        Bundle bundle = new Bundle();
        //添加值
        bundle.putString("title",title);
        //把值添加到Arguments中
        fragment1.setArguments(bundle);
        return fragment1;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获取Arguments
        Bundle arguments = getArguments();
        //获取值
        String title = arguments.getString("title");
        //创建textview
        TextView textView = new TextView(getActivity());
        //设置值
        textView.setText("1608c"+title);
        return textView;


    }
}
