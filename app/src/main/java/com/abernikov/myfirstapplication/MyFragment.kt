package com.abernikov.myfirstapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class MyFragment : Fragment() {
    private lateinit var viewRoot: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewRoot = inflater.inflate(R.layout.fragment_my, container, false)
        return viewRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewRoot.findViewById<TextView>(R.id.text).setOnClickListener {
            findNavController().navigate(MyFragmentDirections.actionSettingsFragmentToBlankFragment())
            /*      requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container, BlankFragment(), "MyFragment")
                      .commit()*/
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyFragment()
    }
}