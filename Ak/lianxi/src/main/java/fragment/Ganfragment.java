package fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lianxi.R;

import ulits.Asynck;
import ulits.conn;
import view.XListView;

public class Ganfragment extends Fragment {

    private XListView gxlist_view;
private String mnr;
    public static Fragment getinstance(String title) {
        //创建fragment
        Ganfragment ganfragment = new Ganfragment();
        //创建bundle
        Bundle bundle = new Bundle();
        //添加值
        bundle.putString("title", title);
        //把值添加到argument
        ganfragment.setArguments(bundle);
        return ganfragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ganfragment, container, false);

        //获取argument
        Bundle bundle = getArguments();
        //获取值
        String title = bundle.getString("title");

        //获取绑定数据
        if (view != null) {
            gxlist_view = view.findViewById(R.id.gxlist_view);
            switch (title) {
                case "每日推荐":
                    getdata();
                    mnr="ty";
                    break;
                case "干货定制":
                    mnr="js";
                    getdata();
                    break;
                case "福利":
                    mnr="kj";
                    getdata();
                    break;

            }

        }
        return view;
    }

    private void getdata() {
        if (conn.iscon(getActivity())) {
            new Maa().execute();
            Toast.makeText(getActivity(), "网络连接成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "网络未连接", Toast.LENGTH_SHORT).show();
        }
    }

    class Maa extends AsyncTask<Integer, Integer, String> {
        public   String path="http://result.eolinker.com/k2BaduF2a6caa275f395919a66ab1dfe4b584cc60685573?uri="+mnr+"";
        @Override
        protected String doInBackground(Integer... integers) {
            //Toast.makeText(getActivity(), path, Toast.LENGTH_SHORT).show();
            return Asynck.getcount(getActivity(),path);
        }
    }
}
