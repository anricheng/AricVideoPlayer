package chou.aric.com.aricvideoplayer.utils.listviewAdapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by aric on 2017/3/11.
 */

public class ViewHolder {

    protected SparseArray<View> mViewContainer;
    protected View mConvertView;
    protected int mPosition;

    private ViewHolder(Context context, int position, ViewGroup parent, int layout) {
        mConvertView = LayoutInflater.from(context).inflate(layout, parent, false);
        mConvertView.setTag(this);
        mViewContainer = new SparseArray<View>();
        this.mPosition = position;
    }

    public static ViewHolder getInstance(Context context, int position, View convertView, ViewGroup parent, int layout) {

        if (null == convertView) {
            return new ViewHolder(context, position, parent, layout);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition=position;
            return holder;
        }
    }

    public <T extends View> T getView(int viewId) {

        View view = mViewContainer.get(viewId);

        if (null == view) {
            view= mConvertView.findViewById(viewId);
            mViewContainer.put(viewId,view);
        }

        return (T) view;
    }

    public ViewHolder setTextView(int rsid,String content){
        ((TextView)getView(rsid)).setText(content);
        return this;
    }

    public ViewHolder setTextView(int viewid,int resid){
        ((TextView)getView(viewid)).setText(resid);
        return this;
    }

    public ViewHolder setClickListener(int viewId, View.OnClickListener listener){

        getView(viewId).setOnClickListener(listener);

        return this;

    }

    public ViewHolder setCheckBoxState(int checkBoxID, boolean isChecked){

        ((CheckBox)getView(checkBoxID)).setChecked(isChecked);

        return this;
    }

    public View getConvertView() {
        return mConvertView;
    }
}
