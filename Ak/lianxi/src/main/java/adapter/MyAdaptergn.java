package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lianxi.R;

import java.util.List;

import bean.Bean;

public class MyAdaptergn extends BaseAdapter {
    Context context;
    List<Bean.ResultBean.DataBean> beans;

    public MyAdaptergn(Context context, List<Bean.ResultBean.DataBean> beans) {
        this.context = context;
        this.beans = beans;
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
        ListHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.weixinjingxuan, null);
            holder = new ListHolder();
            holder.title = convertView.findViewById(R.id.title);
            holder.uthor_name = convertView.findViewById(R.id.uthor_name);
        } else {
            holder= (ListHolder) convertView.getTag();

        }
        holder.uthor_name.setText(beans.get(position).getAuthor_name());
        holder.title.setText(beans.get(position).getTitle());
        return convertView;
    }
    class ListHolder{
        TextView uthor_name,title;
    }
}
