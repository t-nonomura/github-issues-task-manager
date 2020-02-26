package com.treeengineering.repolist.ui

import com.treeengineering.core.action.Action
import com.treeengineering.model.response.Repo

sealed class RepoListAction : Action() {
    data class ProgressAction(val visible: Int) : RepoListAction()
    data class RepoListGetAction(val repoList: List<Repo>) : RepoListAction()
}
