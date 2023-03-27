package com.example.template.ui.showairlines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.template.databinding.FragmentShowAirlinesBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShowAirlinesFragment : Fragment() {

    private var _binding: FragmentShowAirlinesBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<ShowAirlinesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowAirlinesBinding.inflate(inflater, container, false)
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

            setOnClickListener {
                val direction = ShowAirlinesFragmentDirections
                    .actionShowAirlinesFragmentToAirlineDetailsFragment(it.title)
                findNavController().navigate(direction)
            }
        }
    }
}
