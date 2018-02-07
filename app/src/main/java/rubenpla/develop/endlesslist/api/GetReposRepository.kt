package rubenpla.develop.endlesslist.api

import io.reactivex.Flowable
import rubenpla.develop.endlesslist.entity.RepoApi

/**
 * Created by alten on 21/12/17.
 */
class GetReposRepository(private val apiService : GitHubApi) {

    fun getReposFromApi(page : Int, pageSize : Int) : Flowable<List<RepoApi>> {
        return apiService.loadReposFromApi(page, pageSize)
    }
}