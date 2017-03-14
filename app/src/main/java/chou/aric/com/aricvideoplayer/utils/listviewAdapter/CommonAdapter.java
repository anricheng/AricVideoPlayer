package chou.aric.com.aricvideoplayer.utils.listviewAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by aric on 2017/3/11.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {

    private Context mContext;
    private int mItemLayout;
    private List<T> mDataSource;

    public CommonAdapter(Context mContext, int mItemLayout, List<T> mDataSource) {
        this.mContext = mContext;
        this.mItemLayout = mItemLayout;
        this.mDataSource = mDataSource;
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder instance = ViewHolder.getInstance(mContext, position, convertView, parent, mItemLayout);

        T t = mDataSource.get(position);

        bindData(instance,t,position);

        return instance.getConvertView();
    }

    public abstract void bindData(ViewHolder viewHolder, T t,int position);
}
