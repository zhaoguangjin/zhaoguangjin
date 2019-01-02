package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zh.zhaoguangjin20190102.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bean.Bean;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<Bean.DataBean.MiaoshaBean.ListBean> list;

    public MyAdapter(Context context, List<Bean.DataBean.MiaoshaBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GratHolder holder;

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.gret, null);
            holder = new GratHolder();

            holder.bargainPrice = convertView.findViewById(R.id.jiage);
            holder.subhead = convertView.findViewById(R.id.name);
            holder.images = convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        } else {
            holder= (GratHolder) convertView.getTag();
        }
        holder.subhead.setText(list.get(position).getSubhead());
        holder.bargainPrice.setText( list.get(position).getBargainPrice());
       ImageLoader.getInstance().displayImage(list.get(position).getImages(),holder.images);
        return convertView;
    }
    class GratHolder{
        TextView subhead,bargainPrice;
        ImageView images;
    }
}
