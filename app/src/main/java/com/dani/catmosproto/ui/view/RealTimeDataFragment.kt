package com.dani.catmosproto.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dani.catmosproto.databinding.FragmentRealTimeDataBinding

class RealTimeDataFragment : Fragment() {
    private val binding by lazy { FragmentRealTimeDataBinding.inflate(layoutInflater) }
//    lateinit var viewModel: SearchViewModel
//    private val adapter = ImageListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = requireArguments().getString("title")
        val key = requireArguments().getString("key")

//        initView(title.toString())
//        binding.searchView.ivSearch.setOnClickListener {
//            val searchKeyword = binding.searchView.etSearch.text.toString()
//
//            viewModel = ViewModelProvider(this, SearchViewModelFactory(SearchRepository())).get(
//                SearchViewModel::class.java
//            )
//            subscribeUi(adapter)
//            viewModel.getSearchResult(key.toString(), searchKeyword)
//            KeyboardUtil(requireContext()).hideKeyboard(binding.searchView.etSearch)
//        }
    }

//    private fun subscribeUi(adapter: ImageListAdapter) {
//        viewModel.resultList.observe(viewLifecycleOwner) { resultList ->ㅈ
//            adapter.submitList(resultList)
//        }
//    }
//
//    private fun initView(title: String) {
//        binding.searchView.etSearch.hint = "$title Search"
//        binding.rvImageList.adapter = adapter
//    }

    companion object {
        fun newInstance(title: String, key: String) = RealTimeDataFragment().apply {
            arguments = Bundle().apply {
                putString("title", title)
                putString("key", key)
            }
        }
    }
}