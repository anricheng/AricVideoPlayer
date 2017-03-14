package chou.aric.com.aricvideoplayer.http;

import com.squareup.otto.Bus;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aric on 2017/3/13.
 */

public class RequestManagerImpl implements RequestManager {

    Bus bus = new Bus();


    @Inject
    GithubApi  githubApi;

    private int sh;


    @Override
    public GithubBean getContribute(String userName, String password) {
        Call<List<GithubBean>> responseBodyCall = githubApi.contributorsBySimpleGetCall(userName, password);
        responseBodyCall.enqueue(new Callback<List<GithubBean>>() {
            @Override
            public void onResponse(Call<List<GithubBean>> call, Response<List<GithubBean>> response) {
                List<GithubBean> body = response.body();
                bus.post(body);
            }

            @Override
            public void onFailure(Call<List<GithubBean>> call, Throwable t) {

            }
        });
        return  null;


    }

}
