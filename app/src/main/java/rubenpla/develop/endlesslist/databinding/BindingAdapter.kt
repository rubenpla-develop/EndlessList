package rubenpla.develop.endlesslist.databinding

import android.databinding.BindingAdapter
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView

/**
 * Created by alten on 20/12/17.
 */
class BindingAdapter {

    @BindingAdapter(value = *arrayOf("visibleThreshold", "resetLoading"), requireAll = true)
    fun setRecyclerViewScrollCallback(recyclerView: RecyclerView, visibleThreshold: Int,
                                      resetLoading : Boolean) {

    }

    @BindingAdapter(value = ["onPullSwipeRefresh"])
    fun setOnPullSwipeRefresh(swipeRefreshLayout: SwipeRefreshLayout,
                              onPulledSwipeRefreshAction : Runnable) {
        swipeRefreshLayout.setOnRefreshListener { onPulledSwipeRefreshAction.run() }
    }
}