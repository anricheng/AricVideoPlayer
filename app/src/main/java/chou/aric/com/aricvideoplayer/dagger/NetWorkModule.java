package chou.aric.com.aricvideoplayer.dagger;

import android.content.Context;

import com.google.gson.Gson;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.readystatesoftware.chuck.ChuckInterceptor;
import com.squareup.picasso.Picasso;

import java.io.File;

import chou.aric.com.aricvideoplayer.Utils.Constants;
import chou.aric.com.aricvideoplayer.network.GithubNetwork;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aric on 2017/3/4.
 */

@Module
public class NetWorkModule {

    @AppScope
    @Provides
    public Cache provideCache(Context context){
        return  new Cache(new File(context.getCacheDir(),Constants.HTTP_CACHE_DIR),Constants.HTTP_CACHE_SIZE);
    }

    @AppScope
    @Provides
    public OkHttpClient provideOKHttpClient(Context context,Cache cache){
        return  new OkHttpClient
                .Builder()
                .addInterceptor(new ChuckInterceptor(context))
                .cache(cache)
                .build();
    }

    @AppScope
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson){
        return  new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @AppScope
    @Provides
    public GithubNetwork provideGithubNewWork(Retrofit retrofit){
        return  retrofit.create(GithubNetwork.class);
    }


    @AppScope
    @Provides
    public Picasso providePicasso(Context context,OkHttpClient okHttpClient){
        return new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
    }





}
