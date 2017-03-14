package chou.aric.com.aricvideoplayer.viewComponents;

import android.app.Activity;
import android.widget.FrameLayout;

import chou.aric.com.aricvideoplayer.R;

/**
 * Created by aric on 2017/3/14.
 */

public class HomeView extends FrameLayout {

    public HomeView(Activity activity) {
        super(activity);


        inflate(getContext(), R.layout.activity_main, this);

    }
}
