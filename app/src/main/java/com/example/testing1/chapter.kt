package com.example.testing1

import android.os.Parcel
import android.os.Parcelable

data class chapter( val image:Int, val name:String, val desc:String) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(desc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<chapter> {
        override fun createFromParcel(parcel: Parcel): chapter {
            return chapter(parcel)
        }

        override fun newArray(size: Int): Array<chapter?> {
            return arrayOfNulls(size)
        }
    }
}
