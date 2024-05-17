package com.abernikov.myfirstapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.abernikov.myfirstapplication.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(
            requireContext(),
            "${Settings.loadTheme(requireContext())}",
            Toast.LENGTH_LONG
        ).show()
        when (Settings.loadTheme(requireContext())) {
            2 -> {
                requireContext().setTheme(R.style.AppThemeDark)
                binding.radioButtonLightStyle.isChecked = true
                binding.radioButtonNightStyle.isChecked = false
            }

            else -> {
                requireContext().setTheme(R.style.AppThemeLight)
                binding.radioButtonNightStyle.isChecked = true
                binding.radioButtonLightStyle.isChecked = false
            }
        }
        binding.radioButtons.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioButtonNightStyle -> Settings.saveTheme(requireContext(), 2)
                R.id.radioButtonLightStyle -> Settings.saveTheme(requireContext(), 1)
                else -> Settings.saveTheme(requireContext(), 1)
            }
        }
        binding.ivBack.setOnClickListener {
            requireActivity().finish()
        }
        binding.button.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToMyFragment())
            //startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com")))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
