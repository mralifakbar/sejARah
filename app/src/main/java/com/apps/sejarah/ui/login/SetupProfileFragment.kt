package com.apps.sejarah.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.apps.sejarah.ui.main.MainActivity
import com.apps.sejarah.databinding.FragmentSetupProfileBinding


class SetupProfileFragment : Fragment() {

    private var _binding: FragmentSetupProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSetupProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            btnNext.setOnClickListener {
                val name = edtName.text.toString().trim()
                Log.e("MainActivity", name)
//                Toast.makeText(requireContext(), "Awww", Toast.LENGTH_SHORT).show()
                if (name.isEmpty()) {
                    edtName.error = "Nama tidak boleh kosong"
                } else if (name.length <= 2){
                    edtName.error = "Nama terlalu pendek"
                } else if (name.length > 20) {
                    edtName.error = "Nama terlalu panjang (Maks: 20 huruf)"
                }
                else {
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    intent.putExtra(MainActivity.EXTRA_NAME, name)
                    startActivity(intent)
//                val moveToDetail = Intent(itemView.context, DetailActivity::class.java)
//                moveToDetail.putExtra(DetailActivity.EXTRA_ENTITY, article)
//                itemView.context.startActivity(moveToDetail)
                }

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}