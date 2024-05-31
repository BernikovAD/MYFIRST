package com.abernikov.myfirstapplication

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.abernikov.myfirstapplication.adapter.MyListAdapter
import com.abernikov.myfirstapplication.adapter.OnClickListener
import com.abernikov.myfirstapplication.databinding.FragmentMyBinding


class MyFragment : BaseFragment<FragmentMyBinding>(FragmentMyBinding::inflate) {

    val list = mutableListOf(
        "Новость 1",
        "Новость 2",
        "Новость 3",
        "Новость 4",
        "Новость 5",
        "Новость 6",
        "Новость 7",
        "Новость 8",
        "Новость 9",
        "Новость 10",
        /*       "Новость 11",
               "Новость 12",
               "Новость 13",
               "Новость 14",
               "Новость 15",
               "Новость 16",
               "Новость 17",
               "Новость 18",
               "Новость 19",
               "Новость 20",
               "Новость 10",
               "Новость 11",
               "Новость 12",
               "Новость 13",
               "Новость 14",
               "Новость 15",
               "Новость 16",
               "Новость 17",
               "Новость 18",
               "Новость 19",
               "Новость 20",
               "Новость 10",
               "Новость 11",
               "Новость 12",
               "Новость 13",
               "Новость 14",
               "Новость 15",
               "Новость 16",
               "Новость 17",
               "Новость 18",
               "Новость 19",
               "Новость 20",
               "Новость 10",
               "Новость 11",
               "Новость 12",
               "Новость 13",
               "Новость 14",
               "Новость 15",
               "Новость 16",
               "Новость 17",
               "Новость 18",
               "Новость 19",
               "Новость 20",
               "Новость 10",
               "Новость 11",
               "Новость 12",
               "Новость 13",
               "Новость 14",
               "Новость 15",
               "Новость 16",
               "Новость 17",
               "Новость 18",
               "Новость 19",
               "Новость 20",
               "Новость 10",
               "Новость 11",
               "Новость 12",
               "Новость 13",
               "Новость 14",
               "Новость 15",
               "Новость 16",
               "Новость 17",
               "Новость 18",
               "Новость 19",
               "Новость 20"*/
    )

    //private val adapter: MyAdapter by lazy { MyAdapter(list) }
    private val listAdapter: MyListAdapter by lazy {
        MyListAdapter(object : OnClickListener {
            override fun onClick(position: Int) {
                val currentList = listAdapter.currentList.toMutableList()
                currentList.removeAt(position)
                listAdapter.submitList(currentList)
            }

        })
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.recyclerView.adapter = listAdapter
        //binding.recyclerView.addItemDecoration(ShakeAndScaleItemDecorator())
        //val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallbackMyListAdapter(listAdapter))
        //itemTouchHelper.attachToRecyclerView(binding.recyclerView)
        listAdapter.submitList(list)
    }
}