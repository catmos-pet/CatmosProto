package com.dani.catmosproto.ui.view

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.dani.catmosproto.REQUEST_ALL_PERMISSION
import com.dani.catmosproto.databinding.FragmentRealTimeDataBinding
import com.dani.catmosproto.ui.viewmodel.MainViewModel
import com.dani.catmosproto.ui.viewmodel.RealTimeDataViewModel

class RealTimeDataFragment : Fragment() {
    private val binding by lazy { FragmentRealTimeDataBinding.inflate(layoutInflater) }
    lateinit var viewModel: MainViewModel

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
        viewModel = ViewModelProvider(activity as ViewModelStoreOwner)[MainViewModel::class.java]

//        // check if location permission
//        if (!hasPermissions(activity, PERMISSIONS)) {
//            requestPermissions(PERMISSIONS, REQUEST_ALL_PERMISSION)
//        }

//
        initObserver(binding)

//        val title = requireArguments().getString("title")
//        val key = requireArguments().getString("key")
//        initView(title.toString())
//        binding.searchView.ivSearch.setOnClickListener {
//            val searchKeyword = binding.searchView.etSearch.text.toString()
//
//            viewModel = ViewModelProvider(this, SearchViewModelFactory(SearchRepository())).get(
//                SearchViewModel::class.java
//            )
//            subscribeUi(adapter)
//            viewModel.getSearchResult(key.to;String(), searchKeyword)
//            KeyboardUtil(requireContext()).hideKeyboard(binding.searchView.etSearch)
//        }
    }

    private fun initObserver(binding: FragmentRealTimeDataBinding){
        viewModel.statusTxt.observe(viewLifecycleOwner,{
            binding.statusText.text = it

        })

//        viewModel.readTxt.observe(viewLifecycleOwner,{
//
//            binding.txtRead.append(it)
//
//            if ((binding.txtRead.measuredHeight - binding.scroller.scrollY) <=
//                (binding.scroller.height + binding.txtRead.lineHeight)) {
//                binding.scroller.post {
//                    binding.scroller.smoothScrollTo(0, binding.txtRead.bottom)
//                }
//            }
//
//        })
    }

//    private fun subscribeUi(adapter: ImageListAdapter) {
//        viewModel.resultList.observe(viewLifecycleOwner) { resultList ->
//            adapter.submitList(resultList)
//        }
//    }
//
//    private fun initView(title: String) {
//        binding.searchView.etSearch.hint = "$title Search"
//        binding.rvImageList.adapter = adapter
//    }

    override fun onResume() {
        super.onResume()
        // finish app if the BLE is not supported
        if (context!!.packageManager.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(activity, "Finish App!", Toast.LENGTH_SHORT).show()
        }
    }


    private val requestEnableBleResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            // do somthing after enableBleRequest
        }
    }

    /**
     * Request BLE enable
     */
    private fun requestEnableBLE() {
        val bleEnableIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
        requestEnableBleResult.launch(bleEnableIntent)
    }

    private fun hasPermissions(context: Context?, permissions: Array<String>): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
        }
        return true
    }
    // Permission check
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_ALL_PERMISSION -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(activity, "Permissions granted!", Toast.LENGTH_SHORT).show()
                } else {
                    requestPermissions(permissions, REQUEST_ALL_PERMISSION)
                    Toast.makeText(activity, "Permissions must be granted", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object {
        fun newInstance(title: String, key: String) = RealTimeDataFragment().apply {
            arguments = Bundle().apply {
                putString("title", title)
                putString("key", key)
            }
        }
    }
}