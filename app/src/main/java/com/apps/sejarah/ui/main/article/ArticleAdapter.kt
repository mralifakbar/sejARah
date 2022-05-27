package com.apps.sejarah.ui.main.article

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.apps.sejarah.databinding.RvArticleBinding
import com.apps.sejarah.domain.model.Article
import com.apps.sejarah.utils.ArticleDiffUtil
import com.bumptech.glide.Glide

class ArticleAdapter: RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private var articleList = ArrayList<Article>()

    inner class ArticleViewHolder(private val binding: RvArticleBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article){
            binding.apply {
                tvArticleTitle.text = article.title
                Glide.with(itemView.context)
                    .load(article.imageUrl)
                    .into(ivArticlePicture)
            }
            itemView.setOnClickListener {
//                Toast.makeText(itemView.context, "iww", Toast.LENGTH_SHORT).show()
//                val moveToDetail = Intent(itemView.context, DetailActivity::class.java)
//                moveToDetail.putExtra(DetailActivity.EXTRA_ENTITY, article)
//                itemView.context.startActivity(moveToDetail)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val itemBinding = RvArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = articleList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = articleList.size

    fun setData(newList: List<Article>){
        val diffUtil = ArticleDiffUtil(articleList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)

        this.articleList.clear()
        this.articleList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}