package me.ako.constraintlayoutkeyframe.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import me.ako.constraintlayoutkeyframe.R
import me.ako.constraintlayoutkeyframe.databinding.FragmentItemListBinding
import me.ako.constraintlayoutkeyframe.model.Item
import me.ako.constraintlayoutkeyframe.model.ItemViewModel

class FragmentItemList : Fragment() {
    private val viewModel: ItemViewModel by activityViewModels()
    private lateinit var _binding: FragmentItemListBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ItemAdapter {
            viewModel.updateCurrentItem(it)
            val action = FragmentItemListDirections.actionFragmentItemListToFragmentItemDetail(
                it.title
            )
            findNavController().navigate(action)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        adapter.submitList(viewModel.itemList)
    }
}