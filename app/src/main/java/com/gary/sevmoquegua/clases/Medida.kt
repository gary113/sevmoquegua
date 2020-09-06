package com.gary.sevmoquegua.clases

import android.os.Parcel
import android.os.Parcelable

data class Medida(val sp:Double,val pi:Double,val i:Double,val r:Double):Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeDouble(sp)
        p0?.writeDouble(pi)
        p0?.writeDouble(i)
        p0?.writeDouble(r)
    }

    companion object CREATOR : Parcelable.Creator<Medida> {
        override fun createFromParcel(parcel: Parcel): Medida {
            return Medida(parcel)
        }

        override fun newArray(size: Int): Array<Medida?> {
            return arrayOfNulls(size)
        }
    }

}