package com.kunal.recipe.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by kunal on 2019-08-22.
 */
@Parcelize
data class Recipe(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("ingredients")
    val ingredients: List<Ingredient>,
    @SerializedName("name")
    val name: String,
    @SerializedName("servings")
    val servings: Int,
    @SerializedName("steps")
    val steps: List<Step>
) : Parcelable