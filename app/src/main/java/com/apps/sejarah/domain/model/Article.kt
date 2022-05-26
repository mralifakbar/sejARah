package com.apps.sejarah.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val id: Int = 0,
    val title: String,
    val content: String,
    val imageUrl: String
): Parcelable