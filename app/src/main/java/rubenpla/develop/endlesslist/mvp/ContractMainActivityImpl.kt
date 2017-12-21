package rubenpla.develop.endlesslist.mvp

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import rubenpla.develop.endlesslist.entity.Repo
import java.util.concurrent.TimeUnit

/**
 * Created by alten on 20/12/17.
 */
class ContractMainActivityImpl : ContractMvpMainActivity {
    override fun getRepos(page: Int): Flowable<List<Repo>> {
        return Flowable.just(page)
                .observeOn(AndroidSchedulers.mainThread())
                .delay( 1000, TimeUnit.MILLISECONDS)
                .map { p -> getItems(p) }
    }

    private fun getItems(page : Int) : List<Repo> {
        return (getStartIndex(page) until page * ContractMvpMainActivity.PAGE_SIZE)
                .map { Repo(it, "repoName", "OwnerName",
                        "Description") }
    }

    private fun getStartIndex(page: Int) = (page - 1) * ContractMvpMainActivity.PAGE_SIZE
}