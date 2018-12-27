package fragment;

import android.annotation.SuppressLint;
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
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import adapter.MyAdaptergn;
import adapter.MyAdaptershehui;
import adapter.MyAdapterxlist;
import bean.Bean;
import ulits.conn;
import view.XListView;

public class MainFragment extends Fragment {

    private View mview;
    private XListView xlist_view;
    private String mnr;

    public static Fragment getinstance(String s) {
        //创建fragment
        MainFragment fragment = new MainFragment();
        //创建bundle
        Bundle bundle = new Bundle();
        //添加值
        bundle.putString("tiele", s);
        //吧值添加到arguments
        fragment.setArguments(bundle);

        return fragment;
    }

    ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获取Arguments
        Bundle bundle = getArguments();
        //获取值
        String tiele = bundle.getString("tiele");
        Log.i("WA",tiele);
        //创建textview
        // TextView textView = new TextView(getActivity());
        //设置值
        //textView.setText(tiele);
        //获取view绑定数据
        if (mview == null) {
            mview = inflater.inflate(R.layout.mainfragment, container, false);
            xlist_view = mview.findViewById(R.id.xlist_view);
            //获取数据 "知乎日报", "热点新闻", "微信热点"
            switch (tiele) {
                case "知乎日报":
                    mnr = "tt";
                    getdata();
                    break;
              case "热点新闻":
                    mnr = "shehui";
                    getdata();
                    break;
                case "微信热点":
                    mnr = "gn";
                    getdata();
                    break;
            }

        }
        return mview;
    }

    //获取数据
    private void getdata()   {

        if (conn.iscon(getActivity())) {
            new Ma().execute();
            Toast.makeText(getActivity(), "网络已连接", Toast.LENGTH_SHORT).show();
        }
 /*       ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo.isConnected()) {

        }*/
    }

    //获取数据
    class Ma extends AsyncTask<Integer, Integer, String> {
//http://result.eolinker.com/k2BaduF2a6caa275f395919a66ab1dfe4b584cc60685573?uri=" + mnr + "
        @Override
        protected String doInBackground(Integer... integers) {
            String path = "http://result.eolinker.com/k2BaduF2a6caa275f395919a66ab1dfe4b584cc60685573?uri=" + mnr + "";
            try {
                URL url = new URL(path);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(5 * 1000);
                connection.setConnectTimeout(5 * 1000);
                if (connection.getResponseCode() == 200) {
                    InputStream inputStream = connection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    byte[] bytes = new byte[1024 * 512];
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    int len = 0;
                    while ((len = inputStream.read(bytes)) > -1) {
                        stream.write(bytes, 0, len);
                    }
                    String str = "";
                    str = stream.toString();
                    //Log.i("WA", "内容" + str);
                    inputStream.close();
                    connection.disconnect();
                    return str;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null) {
                Gson gson = new Gson();
                Bean bean = gson.fromJson(s, Bean.class);
                List<Bean.ResultBean.DataBean> dataBeans;
                dataBeans = bean.getResult().getData();
                switch (mnr) {
                    case "tt":
                    MyAdapterxlist adapterxlist = new MyAdapterxlist(dataBeans, getActivity());
                    xlist_view.setAdapter(adapterxlist);
                    break;
                case "shehui":
                    MyAdapterxlist adapterxlistist = new MyAdapterxlist(dataBeans, getActivity());
                    xlist_view.setAdapter(adapterxlistist);
/*                    MyAdaptershehui adaptershehui = new MyAdaptershehui(dataBeans, getActivity());
                    xlist_view.setAdapter(adaptershehui);*/
                    break;
                case "gn":
                    MyAdaptergn adaptergn = new MyAdaptergn(getActivity(), dataBeans);
                    xlist_view.setAdapter(adaptergn);
                    break;
            }


            }

        }
    }
}
