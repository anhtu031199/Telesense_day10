package com.example.common.datasets


import com.example.model.User
import java.util.*

object UserDataset {

    val DATE_REFRESH: Date = GregorianCalendar(2021, 7, 26).time
    val FAKE_USERS = listOf(
        User(id="Id_1", name = "Name_1", phone = "phone_1", address = "address_1", avatar_url = "avt_url_1", lastRefreshed = DATE_REFRESH),
        User(id="Id_2", name = "Name_2", phone = "phone_2", address = "address_2", avatar_url = "avt_url_2", lastRefreshed = DATE_REFRESH),
        User(id="Id_3", name = "Name_3", phone = "phone_3", address = "address_3", avatar_url = "avt_url_3", lastRefreshed = DATE_REFRESH)

    )
}