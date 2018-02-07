package rubenpla.develop.endlesslist.api

/**
 * Created by alten on 21/12/17.
 */
object GetReposRepositoryProvider {

    fun provideGetReposRepository() : GetReposRepository {
        return GetReposRepository(GitHubApi.Factory.create())
    }
}