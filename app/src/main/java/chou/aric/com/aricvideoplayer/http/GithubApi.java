package chou.aric.com.aricvideoplayer.http;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by aric on 2017/3/8.
 */

public interface GithubApi {
    @GET("repos/{owner}/{repo}/contributors")
    Call<List<GithubBean>> contributorsBySimpleGetCall(@Path("owner") String owner, @Path("repo") String repo);

}
