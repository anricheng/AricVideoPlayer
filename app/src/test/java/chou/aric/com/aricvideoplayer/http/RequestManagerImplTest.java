package chou.aric.com.aricvideoplayer.http;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import chou.aric.com.aricvideoplayer.presenter.HomeActivityPresenter;
import chou.aric.com.aricvideoplayer.viewComponents.CustomedView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by aric on 2017/3/14.
 */
@RunWith(MockitoJUnitRunner.class)
public class RequestManagerImplTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    RequestManager requestManager;
    @Mock
    CustomedView customedView;

    HomeActivityPresenter presenter;

    @Before
    public void setUp(){presenter =new HomeActivityPresenter(requestManager,customedView);}

    @Test
    public void shoudPass() {

        RequestManager mock = mock(RequestManager.class);
        Assert.assertEquals(1, 1);
    }

    /**
     * Normal test method process:
     * 1.give test object
     * 2.simulate conditions when action
     * 3.then test the result
     */

    @Test
    public void shoudDoNothing() {
        //give

        //when
        when(requestManager.getContribute("zhou","haifeng")).thenReturn(null);
        presenter.loadData();

        //then
        verify(customedView).showError();

    }


    @Test
    public void shoudDoSomething() {
        //given
        HomeActivityPresenter presenter =new HomeActivityPresenter(requestManager,customedView);

        //when
        when( requestManager.getContribute("zhou", "123456")).thenReturn(new GithubBean("zhou"));
        presenter.loadData();

        //then
        verify(customedView).showSuccess();

    }


/**
 * We don't need this two implementations now Since we could use Mockito to mock this object;
 */
//    private class MockView implements CustomedView {
//
//        public boolean flag;
//
//        @Override
//        public void say() {
//
//
//        }
//
//        @Override
//        public void showError() {
//            flag =false;
//        }
//
//        @Override
//        public void showSuccess() {
//            flag = true;
//
//        }
//    }
//
//    private class MockRequestManager implements RequestManager {
//
//        @Override
//        public GithubBean getContribute(String userName, String password) {
//
//            return new GithubBean("bima");
//
//        }
//    }


}