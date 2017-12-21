package rubenpla.develop.endlesslist.mvp

import io.reactivex.Flowable
import rubenpla.develop.endlesslist.entity.Repo

/**
 * Created by alten on 20/12/17.
 */
interface ContractMvpMainActivity {
    fun getRepos(page: Int): Flowable<List<Repo>>

    interface Presenter {
        fun initialize()

        fun onLoadMore(page: Int)

        fun terminate()
    }

    interface View {
        fun showProgress(): Boolean

        fun hideProgress(): Boolean

        fun showItems(items: List<Repo>)

        fun showError(message: String)
    }

    companion object {
        const val PAGE_SIZE: Int = 10
    }
}