package com.example.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*
import java.util.concurrent.TimeUnit

@Entity
data class User (
    @PrimaryKey
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("phone")
    var phone: String? ,
    @SerializedName("address")
    var address: String?,
    @SerializedName("avatar_url")
    var avatar_url: String,
    var lastRefreshed: Date
)
{
    /**
     * We consider that an [User] is outdated when the last time
     * we fetched it was more than 10 minutes
     */
    fun haveToRefreshFromNetwork() : Boolean
            = TimeUnit.MILLISECONDS.toMinutes(Date().time - lastRefreshed.time) >= 10
}