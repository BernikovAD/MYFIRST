package com.abernikov.myfirstapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class BlankFragment : Fragment() {
    private lateinit var viewRoot: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewRoot = inflater.inflate(R.layout.fragment_blank, container, false)
        return viewRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findNavController().navigateUp()
        /*       viewRoot.findViewById<TextView>(R.id.text).setOnClickListener {
           requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container, MyFragment()).commit()
       }*/
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}