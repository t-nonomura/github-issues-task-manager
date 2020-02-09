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
import com.treeengineering.core.ext.ManifestUtil
import com.treeengineering.login.R
import com.treeengineering.login.databinding.FragmentLoginBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {
    private val loginStore: LoginStore by viewModel()
    private val loginActionCreator: LoginActionCreator by inject()
    private val manifestUtil: ManifestUtil by inject()
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
        loginActionCreator.login()
    }

    private fun observe() {
        loginStore.oAuthBrowserRequest.observe(this, Observer {
            if (it) requestOAuthBrowser()
        })

        loginStore.progress.observe(this, Observer { visibility ->
            binding.loginProgress.visibility = visibility
        })
    }

    private fun requestOAuthBrowser() {
        val clientId = manifestUtil.getClientId()
        val clientSecret = manifestUtil.getClientSecret()
        if (clientId.isNullOrEmpty() || clientSecret.isNullOrEmpty()) return

        val uri = Uri.parse("https://github.com/login/oauth/authorize")
            .buildUpon()
            .appendQueryParameter("client_id", clientId)
            .appendQueryParameter("client_secret", clientSecret)
            .appendQueryParameter("scope", "repo")
            .build()
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}
