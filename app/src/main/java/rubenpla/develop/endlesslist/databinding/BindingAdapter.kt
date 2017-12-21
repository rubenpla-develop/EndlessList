package rubenpla.develop.endlesslist.databinding

import android.databinding.BindingAdapter
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import rubenpla.develop.endlesslist.listener.RecyclerViewScrollCallback

/**
 * Created by alten on 20/12/17.
 */
class BindingAdapter {

    @BindingAdapter(value = *arrayOf("visibleThreshold", "resetLoading", "onScrollToBottom"), requireAll = false)
    fun setRecyclerViewScrollCallback(recyclerView: RecyclerView, visibleThreshold: Int,
                                      resetLoading : Boolean, onScrolledListener: RecyclerViewScrollCallback.OnScrolledListener) {
        val callback = RecyclerViewScrollCallback.Builder(recyclerView.layoutManager)
                .resetLoadingState(resetLoading)
                .visibleThreshold(visibleThreshold)
                .onScrolledListener(onScrolledListener)
                .build()

        recyclerView.clearOnScrollListeners()
        recyclerView.addOnScrollListener(callback)
    }

    @BindingAdapter(value = ["onPullSwipeRefresh"])
    fun setOnPullSwipeRefresh(swipeRefreshLayout: SwipeRefreshLayout,
                              onPulledSwipeRefreshAction : Runnable) {
        swipeRefreshLayout.setOnRefreshListener { onPulledSwipeRefreshAction.run() }
    }
}