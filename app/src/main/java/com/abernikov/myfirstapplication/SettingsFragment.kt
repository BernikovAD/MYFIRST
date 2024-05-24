package com.abernikov.myfirstapplication

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.abernikov.myfirstapplication.databinding.FragmentSettingsBinding


class SettingsFragment : BaseFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (Settings.loadTheme(requireContext())) {
            2 -> {
                requireContext().setTheme(R.style.AppThemeDark)
                binding.radioButtonLightStyle.isChecked = false
                binding.radioButtonNightStyle.isChecked = true
            }

            else -> {
                requireContext().setTheme(R.style.MyFirstApplication)
                binding.radioButtonNightStyle.isChecked = false
                binding.radioButtonLightStyle.isChecked = true
            }
        }
        binding.radioButtons.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioButtonNightStyle -> Settings.saveTheme(requireContext(), 2)
                R.id.radioButtonLightStyle -> Settings.saveTheme(requireContext(), 1)
                else -> Settings.saveTheme(requireContext(), 1)
            }
            requireActivity().recreate()
        }

        binding.ivBack.setOnClickListener {
            requireActivity().finish()
        }
        binding.button.setOnClickListener {
            val action = SettingsFragmentDirections.actionSettingsFragmentToMyFragment()
            findNavController().navigate(action)
        }
    }

}
