package rubenpla.develop.endlesslist.utils

import rubenpla.develop.endlesslist.entity.Repo
import rubenpla.develop.endlesslist.entity.RepoApi
import rubenpla.develop.endlesslist.model.RepoBindModel

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 24/09/17
 */

object Mapper {

    /**
     * map user with id
     */
    fun mapToUserModel(repo : Repo): RepoBindModel {
        val repoModel = RepoBindModel()
        repoModel.repoName = repo.repoName
        repoModel.owner = repo.repoOwner
        repoModel.description = repo.description
        return repoModel
    }

    fun mapToUserModelFromApi(repo : RepoApi): RepoBindModel {
        val repoModel = RepoBindModel()
        repoModel.repoName = repo.name
        repoModel.owner = repo.owner.login
        repoModel.description = repo.description
        return repoModel
    }
}