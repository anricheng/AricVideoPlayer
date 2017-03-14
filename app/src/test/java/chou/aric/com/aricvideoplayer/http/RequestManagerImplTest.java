package chou.aric.com.aricvideoplayer.http;

import org.junit.Assert;
import org.junit.Test;

import chou.aric.com.aricvideoplayer.presenter.HomeActivityPresenter;
import chou.aric.com.aricvideoplayer.viewComponents.CustomedView;

/**
 * Created by aric on 2017/3/14.
 */
public class RequestManagerImplTest {

    @Test
    public void shoudPass() {
        Assert.assertEquals(1, 1);
    }


    @Test
    public void shoudDoSomething() {
        //given
        CustomedView customedView = new MockView();
        RequestManager requestManager = new MockRequestManager();
        HomeActivityPresenter presenter =new HomeActivityPresenter(requestManager,customedView);

        //when
        presenter.loadData();

        //then
        Assert.assertEquals(true,((MockView)customedView).flag);

    }

    private class MockView implements CustomedView {

        public boolean flag;

        @Override
        public void say() {


        }

        @Override
        public void showError() {
            flag =false;
        }

        @Override
        public void showSuccess() {
            flag = true;

        }
    }

    private class MockRequestManager implements RequestManager {

        @Override
        public GithubBean getContribute(String userName, String password) {

            return new GithubBean("bima");

        }
    }


}