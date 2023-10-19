package com.example.lab01.DAO

import android.database.Cursor
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Insert
    fun insert(vararg users: User)

}
