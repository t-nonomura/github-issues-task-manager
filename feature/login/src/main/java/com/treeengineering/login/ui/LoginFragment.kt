package com.treeengineering.login.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.treeengineering.login.R
import com.treeengineering.login.databinding.FragmentLoginBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {
    private val args: LoginFragmentArgs by navArgs()
    private val loginStore: LoginStore by viewModel()
    private val loginActionCreator: LoginActionCreator by inject()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observe()
        loginActionCreator.login(args.authUri)
    }

    private fun observe() {

        loginStore.codeRequest.observe(this, Observer {
            requestCode(it)
        })

        loginStore.accessTokenSaved.observe(this, Observer {
            if (it) loginActionCreator.fetchUser()
        })

        loginStore.progress.observe(this, Observer { visibility ->
            binding.loginProgress.visibility = visibility
        })

        loginStore.userSaved.observe(this, Observer {
            if (it) startRepoListFragment()
        })
    }

    private fun requestCode(uri: Uri) {
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun startRepoListFragment() {
        findNavController().navigate(R.id.repo_list)
    }
}
