package com.sslabs.smashbrosultimate.ui.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sslabs.smashbrosultimate.databinding.FragmentFilterStarsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterStarsView : Fragment() {

    private lateinit var binding: FragmentFilterStarsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilterStarsBinding.inflate(inflater, container, false)
        return binding.root
    }
}