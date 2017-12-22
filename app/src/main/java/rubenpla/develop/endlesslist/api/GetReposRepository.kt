package rubenpla.develop.endlesslist.api

import io.reactivex.Observable
import rubenpla.develop.endlesslist.entity.ResultRepos

/**
 * Created by alten on 21/12/17.
 */
class GetReposRepository(val apiService : GithubApi) {

    fun getRepos(page : Int, pageSize : Int) : Observable<ResultRepos> {
        return apiService.loadRepos(page, pageSize)
    }
}