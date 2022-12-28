package me.ako.constraintlayoutkeyframe.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.ako.constraintlayoutkeyframe.data.ItemData
import me.ako.constraintlayoutkeyframe.model.Item

class ItemViewModel : ViewModel() {
    private var _itemList = ArrayList<Item>()
    val itemList: ArrayList<Item> get() = _itemList

    private val _currentItem = MutableLiveData<Item>()
    val currentItem: LiveData<Item> get() = _currentItem

    init {
        _itemList = ItemData.getItemList()
        _currentItem.value = _itemList[0]
    }

    fun updateCurrentItem(item: Item) {
        _currentItem.value = item
    }
}