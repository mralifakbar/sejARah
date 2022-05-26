package com.apps.sejarah.ui.main.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.apps.sejarah.domain.model.Article
import com.apps.sejarah.domain.usecase.SejarahUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val sejarahUseCase: SejarahUseCase): ViewModel() {

    fun getAllArticles(): LiveData<List<Article>>{
        return sejarahUseCase.getAllArticles().asLiveData()
    }

    fun insertArticleList(articleList: List<Article>){
        viewModelScope.launch {
            sejarahUseCase.insertArticleList(articleList)
        }
    }
}