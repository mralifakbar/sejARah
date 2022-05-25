package com.apps.sejarah.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import com.apps.sejarah.R
import com.apps.sejarah.databinding.FragmentAuthenticationBinding
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode


class AuthenticationFragment : Fragment() {

    private var _binding: FragmentAuthenticationBinding? = null
    private val binding get() = _binding!!


    private lateinit var codeScanner: CodeScanner


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAuthenticationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCodeScanner()

        binding.btnDemoSkip.setOnClickListener {
            Navigation.findNavController(
                requireActivity(),
                R.id.nav_host_fragment_container_login
            ).navigate(R.id.navigateToSetupProfileFragment)
            Toast.makeText(requireContext(), "Ouch", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupCodeScanner() {
        codeScanner = CodeScanner(requireContext(), binding.scannerView)

        codeScanner.apply {
            camera = CodeScanner.CAMERA_BACK
            formats = CodeScanner.ALL_FORMATS

            autoFocusMode = AutoFocusMode.SAFE // autofocus at fixed intervals
            scanMode = ScanMode.CONTINUOUS // continuously try to scan and find the barcode

            isAutoFocusEnabled = true
            isFlashEnabled = false

            decodeCallback = DecodeCallback { result ->
                activity?.runOnUiThread {
                    Log.e("MainActivity", result.text.toString())
                    Log.e("MainActivity", result.text.toString())
                    binding.tvScanResult.text = result.text
                    if (result.text.equals("g*39Jfgaj(5Jdfhpifa#389aFJ0j*3OiJfi(jfd2*bm(30+2)#pf*#f9jfl")) {
                        Navigation.findNavController(
                            requireActivity(),
                            R.id.nav_host_fragment_container_login
                        ).navigate(R.id.navigateToSetupProfileFragment)
                    } else {
                        Toast.makeText(requireContext(), "Otentifikasi Gagal", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }

            errorCallback = ErrorCallback {
                activity?.runOnUiThread {
                    Log.e("MainActivity", "Camera initialization error: ${it.message}")
                }
            }
        }


        // start scanning on click
        // important if not using continuously scan mode
        binding.scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}