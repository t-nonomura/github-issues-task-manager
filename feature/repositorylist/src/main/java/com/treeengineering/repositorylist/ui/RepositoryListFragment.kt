package com.treeengineering.repositorylist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.treeengineering.repositorylist.R
import com.treeengineering.repositorylist.databinding.FragmentRepositoryListBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoryListFragment : Fragment() {
    private val repositoryListStore: RepositoryListStore by viewModel()
    private val repositoryListActionCreator: RepositoryListActionCreator by inject()
    private lateinit var binding: FragmentRepositoryListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_repository_list,
            container,
            false
        )
        return binding.root
    }
}
