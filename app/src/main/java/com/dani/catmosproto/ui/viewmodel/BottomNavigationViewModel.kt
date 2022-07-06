package com.dani.catmosproto.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dani.catmosproto.R
import com.dani.catmosproto.enums.PageType

class BottomNavigationViewModel : ViewModel() {
    private val _currentPageType = MutableLiveData(PageType.RealTimeData)
    val currentPageType: LiveData<PageType> = _currentPageType

    fun setCurrentPage(menuItemId: Int): Boolean {
        val pageType = getPageType(menuItemId)
        changeCurrentPage(pageType)
        return true
    }

    private fun getPageType(menuItemId: Int): PageType {
        return when (menuItemId) {
            R.id.action_realtime_data -> PageType.RealTimeData
            R.id.action_cat_behaviors -> PageType.CatBehaviors
            else -> throw IllegalArgumentException("not found menu item id")
        }
    }

    private fun changeCurrentPage(pageType: PageType) {
        if (currentPageType.value == pageType) return
        _currentPageType.value = pageType
    }
}


