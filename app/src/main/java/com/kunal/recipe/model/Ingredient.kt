package com.kunal.recipe.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by kunal on 2019-08-22.
 */
@Parcelize
data class Ingredient(
    @SerializedName("ingredient")
    val ingredient: String,
    @SerializedName("measure")
    val measure: String,
    @SerializedName("quantity")
    val quantity: Float
) : Parcelable