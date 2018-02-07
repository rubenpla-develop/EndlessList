package rubenpla.develop.endlesslist.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import rubenpla.develop.endlesslist.BR

/**
 * Created by alten on 20/12/17.
 */
class RepoBindModel : BaseObservable() {

    @get:Bindable
    var repoName: String = ""
        set(repoName) {
            field = repoName
            notifyPropertyChanged(BR.repoName)
        }

    @get:Bindable
    var owner: String = ""
        set(ownerName) {
            field = ownerName
            notifyPropertyChanged(BR.owner)
        }

    @get:Bindable
    var description: String? = ""
        set(descriptionContent) {
            field = descriptionContent
            notifyPropertyChanged(BR.description)
        }
}