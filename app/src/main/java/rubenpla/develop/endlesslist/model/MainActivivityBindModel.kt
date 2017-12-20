package rubenpla.develop.endlesslist.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import rubenpla.develop.endlesslist.BR

/**
 * Created by alten on 20/12/17.
 */

class MainActivivityBindModel : BaseObservable() {

    @get:Bindable
    var resetLoading: Boolean = false
        set(resetLoading) {
            field = resetLoading
            notifyPropertyChanged(BR.resetLoading)
        }
    @get:Bindable
    var visibleThreshold: Int = 0
        set(visibleThreshold) {
            field = visibleThreshold
            notifyPropertyChanged(BR.visibleThreshold)
        }
}