package com.example.remote

import com.example.model.ApiResult
import com.example.model.User
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {

    @GET("getDemoData")
    fun fetchTopUsersAsync(): Deferred<ApiResult<User>>
    @GET("getDemoData")
    fun fetchUserDetailsAsync(): Deferred<User>
}