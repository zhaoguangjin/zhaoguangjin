package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lianxi.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bean.Bean;

public class MyAdaptershehui extends BaseAdapter {
    List<Bean.ResultBean.DataBean> beans;
    Context context;

    public MyAdaptershehui(List<Bean.ResultBean.DataBean> beans, Context context) {
        this.beans = beans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public Object getItem(int position) {
        return beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.redianxinwen, null);
            holder = new ListHolder();
            holder.author_name = convertView.findViewById(R.id.author_name);
            holder.title = convertView.findViewById(R.id.title);
            holder.thumbnail_pic_s = convertView.findViewById(R.id.thumbnail_pic_s);
            convertView.setTag(holder);
        } else {
            holder= (ListHolder) convertView.getTag();
        }
        holder.title.setText(beans.get(position).getTitle());
        holder.author_name.setText(beans.get(position).getAuthor_name());
        ImageLoader.getInstance().displayImage(beans.get(position).getThumbnail_pic_s(),holder.thumbnail_pic_s);
        return convertView;
    }
    class ListHolder{
        TextView author_name,title;
        ImageView thumbnail_pic_s;
    }
}
