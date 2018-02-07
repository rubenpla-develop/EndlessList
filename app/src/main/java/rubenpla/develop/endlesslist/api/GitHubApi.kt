package rubenpla.develop.endlesslist.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import rubenpla.develop.endlesslist.entity.ResultRepos

interface GitHubApi {

    @GET("users/xing/repos")
    fun loadRepos(@Query("page") page : Int,
                  @Query("per_page") perPage : Int ): Observable<ResultRepos>

    companion object Factory {
        fun create(): GithubApi {

            val retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addCallAdapterFactory(retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create())
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                    .build()

            return retrofit.create(rubenpla.develop.endlesslist.api.GithubApi::class.java)
        }
    }
}