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
        return if (viewType == -1)
            ProgressBarViewHolder(LayoutInflater.from(context).inflate(R.layout.item_progress,
                    parent, false))
        else
            RepoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_progress,
                    parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is RepoViewHolder) holder.bind(list[position], listener)
        else if (holder is ProgressBarViewHolder) holder.bind(true)
    }


    override fun getItemCount() = list.size

    /**
     * RepoBindModel ViewHolder
     */
    internal class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ItemListBinding = DataBindingUtil.bind(itemView)
        fun bind(user: RepoBindModel?, listener: (RepoBindModel?) -> Unit) {
            binding.repo = user
            itemView.setOnClickListener { listener(user) }
        }
    }

    /**
     * Progress bar ViewHolder
     */
    internal class ProgressBarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ItemProgressBinding = DataBindingUtil.bind(itemView)
        fun bind(isIndeterminate: Boolean) {
            binding.progressbar.isIndeterminate = isIndeterminate
        }
    }
}