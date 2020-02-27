package com.treeengineering.repolist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.treeengineering.repolist.R
import com.treeengineering.repolist.databinding.FragmentRepoListBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_repo_list.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepoListFragment : Fragment() {
    private val repoListStore: RepoListStore by viewModel()
    private val repoListActionCreator: RepoListActionCreator by inject()
    private lateinit var binding: FragmentRepoListBinding
    private lateinit var adapter: GroupAdapter<GroupieViewHolder>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_repo_list,
            container,
            false
        )
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observe()
        repoListActionCreator.getRepoList()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
    }

    private fun observe() {
        repoListStore.repoList.observe(this, Observer {
            val repoListItem = it.map { repo -> RepoListItem(repo) }
            adapter.update(repoListItem)
        })

        repoListStore.progress.observe(this, Observer {
            progress.visibility = it
        })
    }

    private fun setupRecyclerView() {
        adapter = GroupAdapter()
        binding.repoList.adapter = adapter
    }
}
