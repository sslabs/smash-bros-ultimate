package com.sslabs.smashbrosultimate.ui.fighter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sslabs.smashbrosultimate.databinding.FragmentSelectFighterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectFighterView : Fragment() {

    private lateinit var binding: FragmentSelectFighterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectFighterBinding.inflate(inflater, container, false)
        return binding.root
    }
}