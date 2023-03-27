package com.example.template.ui.createentity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.template.databinding.FragmentCreateEntityBinding
import com.example.template.domain.entity.Airline
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateEntityFragment : Fragment() {

    private var _binding: FragmentCreateEntityBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<CreateEntityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateEntityBinding.inflate(inflater, container, false)
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
        createBtn.setOnClickListener {

            // TODO: Check fields

            val airline = Airline(
                title = titleEdt.text.toString(),
                time = timeEdt.text.toString(),
                terminal = terminalEdt.text.toString(),
            )

            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.createAirline(airline)
                findNavController().popBackStack()
            }
        }
    }
}
