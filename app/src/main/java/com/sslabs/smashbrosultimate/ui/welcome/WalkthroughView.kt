package com.sslabs.smashbrosultimate.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sslabs.smashbrosultimate.base.navigation.IScreensNavigator
import com.sslabs.smashbrosultimate.databinding.FragmentWalkthroughViewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WalkthroughView : Fragment() {

    @Inject
    lateinit var navigator: IScreensNavigator

    private val viewModel: WalkthroughViewModel by viewModels()
    private lateinit var binding: FragmentWalkthroughViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val safeArgs: WalkthroughViewArgs by navArgs()
        viewModel.setStep(safeArgs.stepNumber)
        binding = FragmentWalkthroughViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initViews()
        observeData()
    }

    private fun initViews() {
        binding.walkthroughNextButton.setOnClickListener {
            viewModel.step.value?.let {
                viewModel.setWalkthroughComplete()
                navigator.fromWalkthrough(it)
            }
        }
    }

    private fun observeData() {
        viewModel.stepConfiguration.observe(viewLifecycleOwner, { stepConfig ->
            binding.walkthroughHeadline.text = getString(stepConfig.headerId)
            binding.walkthroughFighterImage.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    stepConfig.fighterDrawableId
                )
            )
        })
    }
}
