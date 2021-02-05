package com.example.animals_with_tabs_kotlin.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Animal(val name: String, val imageId: Int ): Parcelable {

}