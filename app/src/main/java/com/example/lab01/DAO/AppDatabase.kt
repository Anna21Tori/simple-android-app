package com.example.lab01.DAO

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    companion object {

        private var APPDATABASE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (APPDATABASE == null) {
                synchronized(AppDatabase::class) {
                    APPDATABASE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AppDatabase::class.java, "user.db"
                    ).allowMainThreadQueries()
                        .build()
                }
            }
            return APPDATABASE
        }
    }
}