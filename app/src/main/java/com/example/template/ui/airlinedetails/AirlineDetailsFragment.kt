package com.example.template.ui.airlinedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.template.databinding.FragmentAirlineDetailsBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject

class AirlineDetailsFragment : Fragment() {

    private var _binding: FragmentAirlineDetailsBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<AirlineDetailsFragmentArgs>()

    private val vmFactory by inject<AirlineDetailsViewModel.Factory>()
    private val viewModel by viewModels<AirlineDetailsViewModel> {
        AirlineDetailsViewModel.factory(vmFactory, args.title)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAirlineDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() = with(binding) {
        airlinesRv.adapter = AirlinesAdapter().apply {
            viewModel.airlines
                .onEach { submitList(it) }
                .launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }
}
