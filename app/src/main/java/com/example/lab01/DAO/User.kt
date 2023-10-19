package com.example.lab01.DAO

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class User {

    @PrimaryKey(autoGenerate = true)
    var uid = 0

    @ColumnInfo(name = "user_name")
    var userName: String? = null

    @ColumnInfo(name = "number")
    var number = 0
}