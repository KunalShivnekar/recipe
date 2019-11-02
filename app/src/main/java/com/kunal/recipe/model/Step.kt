package com.kunal.recipe.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by kunal on 2019-08-22.
 */
@Parcelize
data class Step(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("shortDescription")
    val shortDescription: String,
    @SerializedName("thumbnailURL")
    val thumbnailURL: String,
    @SerializedName("videoURL")
    val videoURL: String
) : Parcelable