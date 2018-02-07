package rubenpla.develop.endlesslist.api

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import retrofit2.http.GET
import retrofit2.http.Query
import rubenpla.develop.endlesslist.entity.RepoApi

interface GitHubApi {

    @GET("users/xing/repos")
    fun loadReposFromApi(@Query("page") page : Int,
                         @Query("per_page") perPage : Int ): Flowable<List<RepoApi>>

    companion object Factory {
        fun create(): GitHubApi {

            val retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addCallAdapterFactory(retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
                            .createWithScheduler(Schedulers.io()))
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                    .build()

            return retrofit.create(rubenpla.develop.endlesslist.api.GitHubApi::class.java)
        }
    }
}