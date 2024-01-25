package com.example.foodrecipe.api

import android.os.Parcel
import android.os.Parcelable
import kotlinx.serialization.Serializable

@Serializable
data class DataModel(
    val id: Int,
    val title: String?,
    val image: String?,
    val imageType: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(title)
        dest.writeString(image)
        dest.writeString(imageType)
    }

    companion object CREATOR : Parcelable.Creator<DataModel> {
        override fun createFromParcel(parcel: Parcel): DataModel {
            return DataModel(parcel)
        }

        override fun newArray(size: Int): Array<DataModel?> {
            return arrayOfNulls(size)
        }
    }
}

@Serializable
data class RecipeDetailsModel<ExtendedIngredient>(
    val vegetarian: Boolean,
    val vegan: Boolean,
    val glutenFree: Boolean,
    val dairyFree: Boolean,
    val veryHealthy: Boolean,
    val cheap: Boolean,
    val veryPopular: Boolean,
    val sustainable: Boolean,
    val lowFodmap: Boolean,
    val weightWatcherSmartPoints: Int,
    val gaps: String?,
    val preparationMinutes: Int,
    val cookingMinutes: Int,
    val aggregateLikes: Int,
    val healthScore: Int,
    val creditsText: String?,
    val sourceName: String?,
    val pricePerServing: Double,
    val extendedIngredients: List<ExtendedIngredient>,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceUrl: String?,
    val summary: String?,
    val cuisines: List<String>,
    val dishTypes: List<String>,
    val diets: List<String>,
    val occasions: List<String>,
    val winePairing: String?,
    val instructions: String?,
    val analyzedInstructions: String?,
    val originalId: Int?,
    val spoonacularScore: Double,
    val spoonacularSourceUrl: String?
) : Parcelable {
    class ExtendedIngredient {

    }

    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.createTypedArrayList(ExtendedIngredient)!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.createStringArrayList()!!,
        parcel.createStringArrayList()!!,
        parcel.createStringArrayList()!!,
        parcel.createStringArrayList()!!,
        parcel.readParcelable(WinePairing::class.java.classLoader),
        parcel.readString(),
        parcel.createTypedArrayList(AnalyzedInstruction.CREATOR),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readDouble(),
        parcel.readString()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (vegetarian) 1 else 0)
        parcel.writeByte(if (vegan) 1 else 0)
        parcel.writeByte(if (glutenFree) 1 else 0)
        parcel.writeByte(if (dairyFree) 1 else 0)
        parcel.writeByte(if (veryHealthy) 1 else 0)
        parcel.writeByte(if (cheap) 1 else 0)
        parcel.writeByte(if (veryPopular) 1 else 0)
        parcel.writeByte(if (sustainable) 1 else 0)
        parcel.writeByte(if (lowFodmap) 1 else 0)
        parcel.writeInt(weightWatcherSmartPoints)
        parcel.writeString(gaps)
        parcel.writeInt(preparationMinutes)
        parcel.writeInt(cookingMinutes)
        parcel.writeInt(aggregateLikes)
        parcel.writeInt(healthScore)
        parcel.writeString(creditsText)
        parcel.writeString(sourceName)
        parcel.writeDouble(pricePerServing)
        parcel.writeTypedList(extendedIngredients)
        parcel.writeInt(readyInMinutes)
        parcel.writeInt(servings)
        parcel.writeString(sourceUrl)
        parcel.writeString(summary)
        parcel.writeStringList(cuisines)
        parcel.writeStringList(dishTypes)
        parcel.writeStringList(diets)
        parcel.writeStringList(occasions)
        parcel.writeParcelable(winePairing, flags)
        parcel.writeString(instructions)
        parcel.writeTypedList(analyzedInstructions)
        parcel.writeValue(originalId)
        parcel.writeDouble(spoonacularScore)
        parcel.writeString(spoonacularSourceUrl)
    }

    companion object CREATOR : Parcelable.Creator<RecipeDetailsModel<Any?>> {
        override fun createFromParcel(parcel: Parcel): RecipeDetailsModel<Any?> {
            return RecipeDetailsModel(parcel)
        }

        override fun newArray(size: Int): Array<RecipeDetailsModel<Any?>?> {
            return arrayOfNulls(size)
        }
    }
}

