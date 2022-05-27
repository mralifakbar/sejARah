package com.apps.sejarah.domain.model;

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KategoriKartu(
        val id: Int = 0,
        val title: String,
        val selesai: Int = 0,
        val jumlahMaks: Int = 0,
        val image: String
): Parcelable
