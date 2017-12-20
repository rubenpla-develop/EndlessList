package rubenpla.develop.endlesslist.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rubenpla.develop.endlesslist.R
import rubenpla.develop.endlesslist.databinding.ItemListBinding
import rubenpla.develop.endlesslist.databinding.ItemProgressBinding
import rubenpla.develop.endlesslist.model.RepoBindModel

/**
 * Created by alten on 20/12/17.
 */
class RepoAdapter(val context : Context, private val list: List<RepoBindModel?>,
                  private val listener: (RepoBindModel?) -> Unit)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

    }


    override fun getItemCount() = list.size



}