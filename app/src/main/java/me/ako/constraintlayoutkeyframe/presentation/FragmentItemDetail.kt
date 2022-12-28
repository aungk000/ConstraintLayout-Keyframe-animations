package me.ako.constraintlayoutkeyframe.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnticipateOvershootInterpolator
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import coil.load
import me.ako.constraintlayoutkeyframe.R
import me.ako.constraintlayoutkeyframe.databinding.FragmentItemDetailOneBinding
import me.ako.constraintlayoutkeyframe.model.ItemViewModel

class FragmentItemDetail : Fragment() {
    private val viewModel: ItemViewModel by activityViewModels()
    private lateinit var _binding: FragmentItemDetailOneBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_item_detail_one, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currentItem.observe(viewLifecycleOwner) {
            binding.item = it
            binding.imgView.load(it.imgUrl) {
                listener(
                    onError = { _, _ ->
                        binding.imgView.load(R.drawable.bryan_goff_andromeda)
                        applyTransition(R.layout.fragment_item_detail_two)
                    },
                    onSuccess = { _, _ ->
                        applyTransition(R.layout.fragment_item_detail_two)
                    }
                )
            }
        }
    }

    private fun applyTransition(layoutId: Int) {
        // custom transition
        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1000

        val constraintSet = ConstraintSet()
        constraintSet.clone(requireContext(), layoutId)

        val constraintLayout = binding.constraintLayout

        TransitionManager.beginDelayedTransition(constraintLayout, transition)
        constraintSet.applyTo(constraintLayout)
    }
}