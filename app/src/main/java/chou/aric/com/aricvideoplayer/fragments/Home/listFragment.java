package chou.aric.com.aricvideoplayer.fragments.Home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.tencent.bugly.crashreport.CrashReport;

import java.util.ArrayList;
import java.util.List;

import chou.aric.com.aricvideoplayer.R;
import chou.aric.com.aricvideoplayer.activities.MainActivity;
import chou.aric.com.aricvideoplayer.fragments.BaseFragment;
import chou.aric.com.aricvideoplayer.model.Bean;
import chou.aric.com.aricvideoplayer.utils.listviewAdapter.CommonAdapter;
import chou.aric.com.aricvideoplayer.utils.listviewAdapter.ViewHolder;

/**
 * Created by aric on 2017/3/11.
 */

public class ListFragment extends BaseFragment {
    private ListView mlistView;
    private MainActivity mMainActivity;
    private Button button;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainActivity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View contentView = inflater.inflate(R.layout.fragment_home_list, container, false);
        LinearLayout lvContainer = (LinearLayout) contentView.findViewById(R.id.lv_container);

        button = (Button) contentView.findViewById(R.id.bt_click);

        button.setOnClickListener((view)->{
            CrashReport.testJavaCrash();

        });

        List<Bean> beanList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Bean bean = new Bean("这是标题" + i, "这是今天的报纸的内容，请您继续欣赏，祝您有愉快的一天" + i, "2017-6-5", "" + i);
            beanList.add(bean);
        }

        mlistView = ((ListView) contentView.findViewById(R.id.lv_news));
        mlistView.setAdapter(new CommonAdapter<Bean>(mMainActivity, R.layout.item_test, beanList) {
            @Override
            public void bindData(ViewHolder instance, Bean bean, int position) {
                boolean checked = bean.isChecked();
                instance.setTextView(R.id.tv_item_title, bean.getTitle())
                        .setTextView(R.id.tv_item_content, bean.getContent())
                        .setTextView(R.id.tv_item_time, bean.getDate())
                        .setCheckBoxState(R.id.cb_item_checkable, checked)
                        .setClickListener(R.id.tv_item_content, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Snackbar.make(lvContainer,"你点击了contentView",Snackbar.LENGTH_SHORT).setAction("这是Action", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                    }
                                }).show();
                            }


                        })
                        .setClickListener(R.id.cb_item_checkable, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                bean.setChecked(!checked);
                            }
                        });
            }
        });
        return contentView;
    }
}
