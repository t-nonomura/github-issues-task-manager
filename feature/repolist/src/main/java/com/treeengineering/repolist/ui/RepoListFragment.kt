package com.treeengineering.repolist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.treeengineering.repolist.R
import com.treeengineering.repolist.databinding.FragmentRepoListBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepoListFragment : Fragment() {
    private val repoListStore: RepoListStore by viewModel()
    private val repoListActionCreator: RepoListActionCreator by inject()
    private lateinit var binding: FragmentRepoListBinding
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
}
