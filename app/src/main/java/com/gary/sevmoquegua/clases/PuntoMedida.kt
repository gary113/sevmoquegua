package com.gary.sevmoquegua.clases

import android.os.Parcel
import android.os.Parcelable

data class PuntoMedida(val ab2:Double, var rho:Double):Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(ab2)
        parcel.writeDouble(rho)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PuntoMedida> {
        override fun createFromParcel(parcel: Parcel): PuntoMedida {
            return PuntoMedida(parcel)
        }

        override fun newArray(size: Int): Array<PuntoMedida?> {
            return arrayOfNulls(size)
        }
    }
}