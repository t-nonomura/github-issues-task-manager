package com.treeengineering.repolist.ui

import com.treeengineering.model.response.Repo
import com.treeengineering.repolist.R
import com.treeengineering.repolist.databinding.ItemRepoListBinding
import com.xwray.groupie.databinding.BindableItem

class RepoListItem(private val repo: Repo) : BindableItem<ItemRepoListBinding>() {
    override fun getLayout(): Int = R.layout.item_repo_list

    override fun bind(viewBinding: ItemRepoListBinding, position: Int) {
        viewBinding.setRepoName(repo.name)
        viewBinding.setDescription(repo.description)
        viewBinding.setLanguage(repo.language)
    }
}
