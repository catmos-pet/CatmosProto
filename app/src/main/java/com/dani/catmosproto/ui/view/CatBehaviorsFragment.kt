package com.dani.catmosproto.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dani.catmosproto.databinding.FragmentCatBehaviorsBinding

class CatBehaviorsFragment : Fragment() {
    private val binding by lazy { FragmentCatBehaviorsBinding.inflate(layoutInflater) }
//    lateinit var viewModel: SearchViewModel
//    private val adapter = PostListAdapter()

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

//    private fun subscribeUi(adapter: PostListAdapter) {
//        viewModel.resultList.observe(viewLifecycleOwner) { resultList ->
//            adapter.submitList(resultList)
//        }
//    }

//    private fun initView(title: String) {
//        binding.searchView.etSearch.hint = "$title Search"
//        binding.rvPostList.adapter = adapter
//    }

    companion object {
        fun newInstance(title: String, key: String) = CatBehaviorsFragment().apply {
            arguments = Bundle().apply {
                putString("title", title)
                putString("key", key)
            }
        }
    }
}