package rubenpla.develop.endlesslist.mvp

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import rubenpla.develop.endlesslist.api.GetReposRepositoryProvider
import rubenpla.develop.endlesslist.entity.Repo
import rubenpla.develop.endlesslist.entity.RepoApi
import java.util.concurrent.TimeUnit

/**
 * Created by alten on 20/12/17.
 */
class ContractMainActivityImpl : ContractMvpMainActivity {
    /*
     * THIS METHOD IS ONLY FOR MOCKING PURPOSES
     */
    override fun getRepos(page: Int): Flowable<List<Repo>> {
        return Flowable.just(page)
                .observeOn(AndroidSchedulers.mainThread())
                .delay( 1000, TimeUnit.MILLISECONDS)
                .map { p -> getItems(p) }
    }

    override fun getReposFromApi(page:Int) : Flowable<List<RepoApi>> {

        val loadReposRepository = GetReposRepositoryProvider.provideGetReposRepository()

        return Flowable.just(page)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { _ -> loadReposRepository.getReposFromApi(page, ContractMvpMainActivity.PAGE_SIZE) }
    }

    private fun getItems(page : Int) : List<Repo> {
        return (getStartIndex(page) until page * ContractMvpMainActivity.PAGE_SIZE)
                .map { Repo(it, "repoName", "OwnerName",
                        "Description") }
    }

    private fun getStartIndex(page: Int) = (page - 1) * ContractMvpMainActivity.PAGE_SIZE
}