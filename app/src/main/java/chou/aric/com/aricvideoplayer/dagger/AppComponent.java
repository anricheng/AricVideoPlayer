package chou.aric.com.aricvideoplayer.dagger;

import android.content.Context;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by aric on 2017/3/4.
 */
@AppScope
@Component(modules={AppModule.class})
public interface AppComponent {

    Context appContext();

    OkHttpClient okHttpClient();

}
