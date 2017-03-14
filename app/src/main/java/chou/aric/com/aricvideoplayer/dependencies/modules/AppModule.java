package chou.aric.com.aricvideoplayer.dependencies.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by aric on 2017/3/4.
 */
@Module
public class AppModule {

    private final Context applicationContext;

    public AppModule(Context applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Provides
    @Singleton
    Context provideApplicationContext() {
        return applicationContext;
    }
}
