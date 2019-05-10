package com.josegrillo.hastensports.views.models

import android.os.Parcel
import android.os.Parcelable

data class Player(val image: String,
                  val surName: String,
                  val name: String) : Parcelable {

    constructor(parcel: Parcel) : this(parcel.readString(), parcel.readString(), parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(image)
        parcel.writeString(surName)
        parcel.writeString(name)

    }

    override fun describeContents(): Int =
        0


    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    }

}