package com.sslabs.smashbrosultimate.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sslabs.smashbrosultimate.R
import com.sslabs.smashbrosultimate.base.navigation.IScreensNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashView : Fragment() {

    @Inject lateinit var navigator: IScreensNavigator
    val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash_view, container, false)
    }

    override fun onResume() {
        super.onResume()
        requireView().postDelayed({
            observeData()
        }, SPLASH_DELAY)
    }

    private fun observeData() {
        viewModel.walkthroughDisplayed.observe(viewLifecycleOwner, {
            navigator.fromSplash(!it)
        })
    }

    companion object {
        const val SPLASH_DELAY: Long = 1000L
    }
}