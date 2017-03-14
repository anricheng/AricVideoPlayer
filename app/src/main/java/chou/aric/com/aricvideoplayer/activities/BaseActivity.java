package chou.aric.com.aricvideoplayer.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.baidu.crabsdk.CrabSDK;

/**
 * Created by aric on 2017/3/10.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onPause() {
        CrabSDK.onPause(this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        CrabSDK.onResume(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        CrabSDK.behaviorRecordEvent(ev, this);
        return super.dispatchTouchEvent(ev);
    }
}
