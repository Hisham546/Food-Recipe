package com.example.foodrecipe.api

import android.os.Parcel
import android.os.Parcelable
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDetailsModel(
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
    val extendedIngredients: List<ExtendedIngredient>?,
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
    val analyzedInstructions: List<AnalyzedInstruction>?,
    val originalId: Int?,
    val spoonacularScore: Double,
    val spoonacularSourceUrl: String?
) : Parcelable {



    @Suppress("DEPRECATION")
    @Serializable
    data class ExtendedIngredient(
        val id: Int,
        val aisle: String?,
        val image: String?,
        val consistency: String?,
        val name: String?,
        val nameClean: String?,
        val original: String?,
        val originalName: String?,
        val amount: Double,
        val unit: String?,
        val meta: List<String>?,
        val measures: Measures?
    ) : Parcelable {

        constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readDouble(),
            parcel.readString(),
            parcel.createStringArrayList(),
            parcel.readParcelable(Measures::class.java.classLoader)
        )

        override fun describeContents(): Int = 0

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(id)
            parcel.writeString(aisle)
            parcel.writeString(image)
            parcel.writeString(consistency)
            parcel.writeString(name)
            parcel.writeString(nameClean)
            parcel.writeString(original)
            parcel.writeString(originalName)
            parcel.writeDouble(amount)
            parcel.writeString(unit)
            parcel.writeStringList(meta)
            parcel.writeParcelable(measures, flags)
        }

        companion object CREATOR : Parcelable.Creator<ExtendedIngredient> {
            override fun createFromParcel(parcel: Parcel): ExtendedIngredient {
                return ExtendedIngredient(parcel)
            }

            override fun newArray(size: Int): Array<ExtendedIngredient?> {
                return arrayOfNulls(size)
            }
        }
    }

    @Serializable
    data class Measures(
        val us: MeasureUnit?,
        val metric: MeasureUnit?
    ) : Parcelable {

        constructor(parcel: Parcel) : this(
            parcel.readParcelable(MeasureUnit::class.java.classLoader),
            parcel.readParcelable(MeasureUnit::class.java.classLoader)
        )

        override fun describeContents(): Int = 0

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeParcelable(us, flags)
            parcel.writeParcelable(metric, flags)
        }

        companion object CREATOR : Parcelable.Creator<Measures> {
            override fun createFromParcel(parcel: Parcel): Measures {
                return Measures(parcel)
            }

            override fun newArray(size: Int): Array<Measures?> {
                return arrayOfNulls(size)
            }
        }
    }

    @Serializable
    data class MeasureUnit(
        val amount: Double,
        val unitShort: String?,
        val unitLong: String?
    ) : Parcelable {

        constructor(parcel: Parcel) : this(
            parcel.readDouble(),
            parcel.readString(),
            parcel.readString()
        )

        override fun describeContents(): Int = 0

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeDouble(amount)
            parcel.writeString(unitShort)
            parcel.writeString(unitLong)
        }

        companion object CREATOR : Parcelable.Creator<MeasureUnit> {
            override fun createFromParcel(parcel: Parcel): MeasureUnit {
                return MeasureUnit(parcel)


            }

            override fun newArray(size: Int): Array<MeasureUnit?> {
                return arrayOfNulls(size)
            }
        }
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
        parcel.createTypedArrayList(ExtendedIngredient.CREATOR)?: emptyList(),
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
        parcel.readString(),
        parcel.readString(),
        parcel.readArrayList(AnalyzedInstruction::class.java.classLoader) as? List<*>,
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
        parcel.writeString(winePairing)
        parcel.writeString(instructions)
        parcel.writeList(analyzedInstructions)
        parcel.writeValue(originalId)
        parcel.writeDouble(spoonacularScore)
        parcel.writeString(spoonacularSourceUrl)
    }

    companion object CREATOR : Parcelable.Creator<RecipeDetailsModel> {
        override fun createFromParcel(parcel: Parcel): RecipeDetailsModel {
            return RecipeDetailsModel(parcel)
        }

        override fun newArray(size: Int): Array<RecipeDetailsModel?> {
            return arrayOfNulls(size)
        }
    }
}

@Serializable
data class AnalyzedInstruction(
    val name: String?,
    val steps: List<InstructionStep>?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createTypedArrayList(InstructionStep.CREATOR)
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeTypedList(steps)
    }

    companion object CREATOR : Parcelable.Creator<AnalyzedInstruction> {
        override fun createFromParcel(parcel: Parcel): AnalyzedInstruction {
            return AnalyzedInstruction(parcel)
        }

        override fun newArray(size: Int): Array<AnalyzedInstruction?> {
            return arrayOfNulls(size)
        }
    }
}

@Serializable
data class InstructionStep(
    val number: Int,
    val step: String?,
    val ingredients: List<Ingredient>?,
    val equipment: List<Equipment>?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.createTypedArrayList(Ingredient.CREATOR),
        parcel.createTypedArrayList(Equipment.CREATOR)
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(number)
        parcel.writeString(step)
        parcel.writeTypedList(ingredients)
        parcel.writeTypedList(equipment)
    }

    companion object CREATOR : Parcelable.Creator<InstructionStep> {
        override fun createFromParcel(parcel: Parcel): InstructionStep {
            return InstructionStep(parcel)
        }

        override fun newArray(size: Int): Array<InstructionStep?> {
            return arrayOfNulls(size)
        }
    }
}

@Serializable
data class Ingredient(
    val id: Int,
    val name: String?,
    val localizedName: String?,
    val image: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(localizedName)
        parcel.writeString(image)
    }

    companion object CREATOR : Parcelable.Creator<Ingredient> {
        override fun createFromParcel(parcel: Parcel): Ingredient {
            return Ingredient(parcel)
        }

        override fun newArray(size: Int): Array<Ingredient?> {
            return arrayOfNulls(size)
        }
    }
}

@Serializable
data class Equipment(
    val id: Int,
    val name: String?,
    val image: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(image)
    }

    companion object CREATOR : Parcelable.Creator<Equipment> {
        override fun createFromParcel(parcel: Parcel): Equipment {
            return Equipment(parcel)
        }

        override fun newArray(size: Int): Array<Equipment?> {
            return arrayOfNulls(size)
        }
    }
}

@Serializable
data class WinePairing(
    val pairedWines: List<String>?,
    val pairingText: String?,
    val productMatches: List<WineProductMatch>?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.createTypedArrayList(WineProductMatch.CREATOR)
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringList(pairedWines)
        parcel.writeString(pairingText)
        parcel.writeTypedList(productMatches)
    }

    companion object CREATOR : Parcelable.Creator<WinePairing> {
        override fun createFromParcel(parcel: Parcel): WinePairing {
            return WinePairing(parcel)
        }

        override fun newArray(size: Int): Array<WinePairing?> {
            return arrayOfNulls(size)
        }
    }
}

@Serializable
data class WineProductMatch(
    val id: Int,
    val title: String?,
    val description: String?,
    val price: String?,
    val imageUrl: String?,
    val averageRating: Double?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble()
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(description)

        parcel.writeString(price)
        parcel.writeString(imageUrl)
        parcel.writeDouble(averageRating ?: 0.0)
    }

    companion object CREATOR : Parcelable.Creator<WineProductMatch> {
        override fun createFromParcel(parcel: Parcel): WineProductMatch {
            return WineProductMatch(parcel)
        }

        override fun newArray(size: Int): Array<WineProductMatch?> {
            return arrayOfNulls(size)
        }
    }
}
