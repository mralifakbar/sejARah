package com.apps.sejarah.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.apps.sejarah.databinding.RvArticleBinding
import com.apps.sejarah.databinding.RvKategoriKartuBinding
import com.apps.sejarah.domain.model.Article
import com.apps.sejarah.domain.model.KategoriKartu
import com.apps.sejarah.utils.ArticleDiffUtil
import com.bumptech.glide.Glide

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var kategoriKartuList = ArrayList<KategoriKartu>()

    inner class HomeViewHolder(private val binding: RvKategoriKartuBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(kategoriKartu: KategoriKartu){
            binding.apply {
                tvKategoriKartu.text = kategoriKartu.title
                tvProgress.text = "${kategoriKartu.selesai} / ${kategoriKartu.jumlahMaks}"
                Glide.with(itemView.context)
                    .load(kategoriKartu.image)
                    .into(ivIcon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemBinding = RvKategoriKartuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = kategoriKartuList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = kategoriKartuList.size

    fun setData(newList: List<Article>){
//        val diffUtil = KategoriKartu(kategoriKartuList, newList)
//        val diffResult = DiffUtil.calculateDiff(diffUtil)
//
//        this.articleList.clear()
//        this.articleList.addAll(newList)
//        diffResult.dispatchUpdatesTo(this)
    }
}