package com.apps.sejarah.ui.main.article

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.sejarah.R
import com.apps.sejarah.databinding.FragmentArticleBinding
import com.apps.sejarah.utils.DummyData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleFragment : Fragment() {

    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ArticleViewModel by viewModels()
    private val articleAdapter = ArticleAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvArticle.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = articleAdapter
        }

        getArticleList()
        binding.swipeToRefresh.setOnRefreshListener {
            getArticleList()
        }
    }

    private fun getArticleList() {
        viewModel.getAllArticles().observe(viewLifecycleOwner) {
            Log.e("ArticleFragment", it.toString())
            Log.e("ArticleFragment", it.size.toString())
            Log.e("ArticleFragment", it.size.toString())
            binding.swipeToRefresh.isRefreshing = false
            if (it.isEmpty() || it == null) {
                viewModel.insertArticleList(DummyData.provideArticleList())
            } else {
                articleAdapter.setData(it)

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}