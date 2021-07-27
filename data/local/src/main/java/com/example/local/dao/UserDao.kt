package com.example.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.model.User
import java.util.*

@Dao
abstract class UserDao: BaseDao<User>() {

    @Query("SELECT * FROM User")
    abstract suspend fun getTopUsers(): List<User>

    @Query("SELECT * FROM User")
    abstract suspend fun getUser(): User

    // ---

    /**
     * Each time we save an user, we update its 'lastRefreshed' field
     * This allows us to know when we have to refresh its data
     */

    suspend fun save(user: User) {
        insert(user.apply { lastRefreshed = Date() })
    }

    suspend fun save(users: List<User>) {
        insert(users.apply { forEach { it.lastRefreshed = Date() } })
    }
}