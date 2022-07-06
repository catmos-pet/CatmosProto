package com.dani.catmosproto.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.dani.catmosproto.R
import com.dani.catmosproto.databinding.ActivityBottomNavigationBinding
import com.dani.catmosproto.ui.viewmodel.BottomNavigationViewModel
import com.dani.catmosproto.enums.PageType

class BottomNavigationActivity : AppCompatActivity() {

    private val viewModel: BottomNavigationViewModel by viewModels()
    private val binding by lazy { ActivityBottomNavigationBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.vm = viewModel
        viewModel.currentPageType.observe(this) {
            changeFragment(it)
        }
    }

    private fun changeFragment(pageType: PageType) {
        val transaction = supportFragmentManager.beginTransaction()
        var targetFragment = supportFragmentManager.findFragmentByTag(pageType.tag)

        if (targetFragment == null) {
            targetFragment = getFragment(pageType)
            transaction.add(binding.fl.id, targetFragment, pageType.tag)
        }
        transaction.show(targetFragment)

        PageType.values()
            .filterNot { it == pageType }
            .forEach { type ->
                supportFragmentManager.findFragmentByTag(type.tag)?.let {
                    transaction.hide(it)
                }
            }
        transaction.commitAllowingStateLoss()
    }

    private fun getFragment(pageType: PageType): Fragment {
        return when (pageType.title) {
            "RealTimeData" -> {
                RealTimeDataFragment.newInstance(pageType.title, pageType.key)
            }
            else -> {
                CatBehaviorsFragment.newInstance(pageType.title, pageType.key)
            }
        }
    }
}