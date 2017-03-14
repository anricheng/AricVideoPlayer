package chou.aric.com.aricvideoplayer.dependencies.components;

import android.content.Context;

import javax.inject.Singleton;

import chou.aric.com.aricvideoplayer.dependencies.modules.AppModule;
import dagger.Component;

/**
 * Created by aric on 2017/3/4.
 */
@Singleton
@Component(modules={AppModule.class})
public interface AppComponent {

    Context context();




}
