package rubenpla.develop.endlesslist

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import rubenpla.develop.endlesslist.databinding.ActivityMainBinding
import rubenpla.develop.endlesslist.databinding.BindingComponent
import rubenpla.develop.endlesslist.entity.Repo
import rubenpla.develop.endlesslist.mvp.ContractMvpMainActivity

class MainActivity : AppCompatActivity(), ContractMvpMainActivity.View {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                binding = DataBindingUtil.setContentView(this, R.layout.activity_main,
                        BindingComponent())
    }

    override fun showProgress(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showItems(items: List<Repo>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
