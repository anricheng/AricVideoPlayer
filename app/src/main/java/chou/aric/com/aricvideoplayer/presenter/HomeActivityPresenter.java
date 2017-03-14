package chou.aric.com.aricvideoplayer.presenter;

import chou.aric.com.aricvideoplayer.http.GithubBean;
import chou.aric.com.aricvideoplayer.http.RequestManager;
import chou.aric.com.aricvideoplayer.viewComponents.CustomedView;

/**
 * Created by aric on 2017/3/14.
 */

public class HomeActivityPresenter {

    RequestManager mRequestManager;
    CustomedView mCustomedView;

    public HomeActivityPresenter(RequestManager mRequestManager, CustomedView mCustomedView) {
        this.mRequestManager = mRequestManager;
        this.mCustomedView = mCustomedView;
    }

    public void loadData() {

        GithubBean zhou = mRequestManager.getContribute("zhou", "123456");

        if (zhou == null) {
            mCustomedView.showError();
        }else{
            mCustomedView.showSuccess();
        }

    }
}
