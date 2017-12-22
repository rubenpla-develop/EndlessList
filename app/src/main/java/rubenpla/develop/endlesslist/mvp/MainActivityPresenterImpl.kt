package rubenpla.develop.endlesslist.mvp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.PublishProcessor

/**
 * Created by alten on 20/12/17.
 */
class MainActivityPresenterImpl(private val view: ContractMvpMainActivity.View) :
        ContractMvpMainActivity.Presenter {

    private val mainContract : ContractMvpMainActivity
    private var currentPage: Int = 0
    private val disposables : CompositeDisposable
    private lateinit var paginator: PublishProcessor<Int>
    private var loading : Boolean = false

    init {
        mainContract = ContractMainActivityImpl()
        disposables = CompositeDisposable()
        initialize()
    }

    override fun initialize() {
        currentPage = 1
        paginator = PublishProcessor.create()

        /*val loadReposRepository = GetReposRepositoryProvider.provideGetReposRepository()

        disposables.add(
                loadReposRepository.getRepos(1, 10)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe ({
                            it->
                            Log.d("Result", "There are ${it.items.size} items")
                        }, { error ->
                            error.printStackTrace()
                        })
        )*/

        val disposable = paginator.onBackpressureDrop()
                .filter { !loading }
                .doOnNext { loading = view.showProgress()}
                .concatMap { mainContract.getRepos(it) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    loading = view.hideProgress()
                    view.showItems(it)
                    currentPage++
                }, {
                    loading = view.hideProgress()
                    view.showError(it.localizedMessage)
                } )

        disposables.add(disposable)
        onLoadMore(currentPage)
    }

    override fun onLoadMore(page: Int) {
        paginator.onNext(page)
    }

    override fun terminate() {
        disposables.clear()
    }
}