package chou.aric.com.aricvideoplayer.fragments.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import chou.aric.com.aricvideoplayer.R;
import chou.aric.com.aricvideoplayer.fragments.BaseFragment;

/**
 * Created by aric on 2017/3/14.
 */

public class TestFindViewByIdFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    /**
     * it's a test!
     */
    private TextView mFlTitle;
    private ImageView mFlIv;
    /**
     * click
     */
    private Button mBtClick;
    private ListView mLvNews;
    private LinearLayout mLvContainer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = View.inflate(getActivity(), R.layout.fragment_test_findviewbyid, null);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // TODO:OnCreateView Method has been created, run FindViewById again to generate code
        initView(view);
        return view;
    }

    public void initView(View view) {
        mFlTitle = (TextView) view.findViewById(R.id.fl_title);
        mFlIv = (ImageView) view.findViewById(R.id.fl_iv);
        mBtClick = (Button) view.findViewById(R.id.bt_click);
        mBtClick.setOnClickListener(this);
        mLvNews = (ListView) view.findViewById(R.id.lv_news);
        mLvContainer = (LinearLayout) view.findViewById(R.id.lv_container);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_click:
                break;
        }
    }
}
