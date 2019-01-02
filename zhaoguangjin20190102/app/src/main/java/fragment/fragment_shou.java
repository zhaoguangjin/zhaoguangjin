package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.example.zh.zhaoguangjin20190102.MainActivity;
import com.example.zh.zhaoguangjin20190102.R;
import com.google.gson.Gson;

import java.util.List;

import adapter.MyAdapter;
import bean.Bean;
import presenter.Presenter;
import view.Viewinten;

public class fragment_shou extends Fragment implements Viewinten {


    private Presenter presenter1;

    private MyAdapter myAdapter;
    private ListView list_view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shou, container, false);
        list_view = view.findViewById(R.id.list_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter1 = new Presenter(fragment_shou.this);
        presenter1.getpreshent();
      list_view.setAdapter(myAdapter);
    }

    @Override
    public void getview(String data) {
        Log.i("QQQQ","内容"+data);
        Gson gson = new Gson();
        Bean bean = gson.fromJson(data, Bean.class);
        List<Bean.DataBean.MiaoshaBean.ListBean> beans;
        beans=bean.getData().getMiaosha().getList();
        myAdapter = new MyAdapter(getActivity(),beans);


    }
}
