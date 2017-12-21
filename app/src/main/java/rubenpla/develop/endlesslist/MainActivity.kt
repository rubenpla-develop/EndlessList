package rubenpla.develop.endlesslist

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import rubenpla.develop.endlesslist.adapter.RepoAdapter
import rubenpla.develop.endlesslist.databinding.ActivityMainBinding
import rubenpla.develop.endlesslist.databinding.BindingComponent
import rubenpla.develop.endlesslist.entity.Repo
import rubenpla.develop.endlesslist.model.MainActivityBindModel
import rubenpla.develop.endlesslist.model.RepoBindModel
import rubenpla.develop.endlesslist.mvp.ContractMvpMainActivity
import rubenpla.develop.endlesslist.mvp.MainActivityPresenterImpl
import rubenpla.develop.endlesslist.utils.Mapper

class MainActivity : AppCompatActivity(), ContractMvpMainActivity.View {

    private lateinit var binding : ActivityMainBinding

    private lateinit var mainActivityModel : MainActivityBindModel

    private lateinit var mainActivityPresenter : ContractMvpMainActivity.Presenter

    private lateinit var repoAdapter: RepoAdapter

    private var list = arrayListOf<RepoBindModel?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                binding = DataBindingUtil.setContentView(this, R.layout.activity_main,
                        BindingComponent())

        setBindingData()

        repoAdapter = RepoAdapter(this, list) {}
        binding.endlessRecyclerview.adapter = repoAdapter

        mainActivityPresenter = MainActivityPresenterImpl(this)
        binding.mainPresenter = mainActivityPresenter
    }

    private fun setBindingData() {
        mainActivityModel = MainActivityBindModel()
        mainActivityModel.visibleThreshold = 5
        binding.mainModel = mainActivityModel
    }

    override fun showProgress(): Boolean {
        binding.endlessRecyclerview.post { repoAdapter.add(null) }

        return true
    }

    override fun hideProgress(): Boolean {
        if (list.size > 0 && null == list[list.size - 1]) {
            repoAdapter.remove(list.size -1)
        }

        if (binding.endlessSwipeRefresh.isRefreshing) {
            repoAdapter.clear()
            binding.endlessSwipeRefresh.isRefreshing = false
            mainActivityModel.resetLoading = true
        }

        return false
    }

    override fun showItems(items: List<Repo>) {
        val mappedItems = arrayListOf<RepoBindModel>()
        items.map { mappedItems.add( Mapper.mapToUserModel(it) ) }
        repoAdapter.addAll(mappedItems)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
