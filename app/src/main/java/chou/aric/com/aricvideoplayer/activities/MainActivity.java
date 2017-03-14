package chou.aric.com.aricvideoplayer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;

import com.squareup.otto.Subscribe;

import java.util.List;

import chou.aric.com.aricvideoplayer.R;
import chou.aric.com.aricvideoplayer.fragments.Home.ListFragment;
import chou.aric.com.aricvideoplayer.http.GithubBean;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fl_container,new ListFragment());
        fragmentTransaction.commit();



    }


    public void crab(View view){
       startActivity(new Intent(MainActivity.this,CrabActivity.class));
    }



    @Subscribe
    public  void LoadDataEvent(List<GithubBean> githubBeanList){

    }
}
