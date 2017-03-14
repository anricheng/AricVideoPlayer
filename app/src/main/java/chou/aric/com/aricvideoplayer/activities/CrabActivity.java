package chou.aric.com.aricvideoplayer.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;

import com.baidu.crabsdk.CrabSDK;

import chou.aric.com.aricvideoplayer.R;

/**
 * Created by aric on 2017/3/13.
 */

public class CrabActivity extends BaseActivity {
    private Button crashbtn;
    private Button blockbtn;
    private Button anrbtn;
    private Button exbtn;

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_crab);
        crashbtn = (Button) findViewById(R.id.crashbtn1);
        crashbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // outofbound
                int arr[] = new int[10];
                int last = arr[10];
            }
        });
        blockbtn = (Button) findViewById(R.id.btn_block);
        blockbtn.setOnClickListener(view->{
                // 制造卡顿，UI线程睡眠2秒
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }

        });

        anrbtn = (Button) findViewById(R.id.anrbtn);
        anrbtn.setOnClickListener(view -> {
                // anr
                Log.e("*****", "anr!!!");

                int i = 0;
                while (true) {
                    i++;
                    // BLog.d("ANRing...");
                }

        });

        exbtn = (Button) findViewById(R.id.exbtn);
        exbtn.setOnClickListener(view ->  {
                // exception
                Log.e("*****", "exception!!!");

                try {
                    String s = null;
                    s.length();
                } catch (Exception e) {
                    Log.e("catched_upload", "CrabSDK.uploadException(e);");
                    CrabSDK.uploadException(e);
                }

        });

    }
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }
}
