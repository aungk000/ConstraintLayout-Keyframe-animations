package me.ako.constraintlayoutkeyframe.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import me.ako.constraintlayoutkeyframe.R
import me.ako.constraintlayoutkeyframe.databinding.ListItemBinding
import me.ako.constraintlayoutkeyframe.model.Item

class ItemAdapter(private val onItemClicked: (Item) -> Unit) :
    ListAdapter<Item, ItemAdapter.ItemViewHolder>(diffCallback) {
    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return (oldItem.id == newItem.id)
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }
        }
    }

    class ItemViewHolder(private val binding: ListItemBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Item) {
            binding.txtItem.text = item.title
            binding.imgItem.load(item.imgUrl) {
                listener(
                    onError = { _, _ ->
                        binding.imgItem.load(R.drawable.bryan_goff_andromeda)
                    }
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = ListItemBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(item)
        }
        holder.onBind(item)
    }
}