package chou.aric.com.aricvideoplayer.network;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by aric on 2017/3/8.
 */

public interface GithubNetwork {

    @GET("users/{user}/repos")
    Observable<>
}
