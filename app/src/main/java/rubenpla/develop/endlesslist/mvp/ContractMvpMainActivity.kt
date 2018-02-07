package rubenpla.develop.endlesslist.mvp

import io.reactivex.Flowable
import rubenpla.develop.endlesslist.entity.Repo
import rubenpla.develop.endlesslist.entity.RepoApi

/**
 * Created by alten on 20/12/17.
 */
interface ContractMvpMainActivity {
    fun getRepos(page: Int): Flowable<List<Repo>>

    fun getReposFromApi(page : Int): Flowable<List<RepoApi>>

    interface Presenter {
        fun initialize()

        fun onLoadMore(page: Int)

        fun terminate()
    }

    interface View {
        fun showProgress(): Boolean

        fun hideProgress(): Boolean

        fun showItems(items: List<Repo>)

        fun showItemsFromApi(items: List<RepoApi>)

        fun showError(message: String)
    }

    companion object {
        const val PAGE_SIZE: Int = 10
    }
}