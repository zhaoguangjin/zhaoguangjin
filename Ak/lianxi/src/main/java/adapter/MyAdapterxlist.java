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

public class MyAdapterxlist extends BaseAdapter {
    List<Bean.ResultBean.DataBean> beans;
    Context context;

    public MyAdapterxlist(List<Bean.ResultBean.DataBean> beans, Context context) {
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
        ListHanlser hanlser;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.xlist, null);
            hanlser = new ListHanlser();
            hanlser.author_name = convertView.findViewById(R.id.author_name);
            hanlser.title = convertView.findViewById(R.id.title);
            hanlser.thumbnail_pic_s = convertView.findViewById(R.id.img);
            convertView.setTag(hanlser);
        } else {
            hanlser= (ListHanlser) convertView.getTag();
        }
        hanlser.title.setText(beans.get(position).getTitle());
        hanlser.author_name.setText(beans.get(position).getAuthor_name());
        ImageLoader.getInstance().displayImage(beans.get(position).getThumbnail_pic_s(),hanlser.thumbnail_pic_s);
        return convertView;
    }
    class ListHanlser{
        TextView author_name,title;
        ImageView thumbnail_pic_s;
    }
}
