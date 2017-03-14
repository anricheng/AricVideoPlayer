package chou.aric.com.aricvideoplayer.dependencies.modules;

import android.content.Context;

import com.google.gson.Gson;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.readystatesoftware.chuck.ChuckInterceptor;
import com.squareup.picasso.Picasso;

import java.io.File;

import javax.inject.Named;

import chou.aric.com.aricvideoplayer.R;
import chou.aric.com.aricvideoplayer.dependencies.scopes.AppScope;
import chou.aric.com.aricvideoplayer.http.GithubApi;
import chou.aric.com.aricvideoplayer.utils.Constants;
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

    @Named("URL1")
    @AppScope
    @Provides
    public Retrofit provideURL1Retrofit(OkHttpClient okHttpClient, Gson gson,Context context){
        return  new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(context.getResources().getString(R.string.base_url1))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }


    @Named("URL2")
    @AppScope
    @Provides
    public Retrofit provideURL2Retrofit(OkHttpClient okHttpClient, Gson gson,Context context){
        return  new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(context.getResources().getString(R.string.base_url2))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }


    @AppScope
    @Provides
    public GithubApi provideGithubApi(OkHttpClient okHttpClient, Gson gson,Context context){
        return  new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(context.getResources().getString(R.string.base_url2))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(GithubApi.class);
    }

    @AppScope
    @Provides
    public GithubApi provideGithubNewWork(Retrofit retrofit){
        return  retrofit.create(GithubApi.class);
    }


    @AppScope
    @Provides
    public Picasso providePicasso(Context context,OkHttpClient okHttpClient){
        return new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
    }


}
