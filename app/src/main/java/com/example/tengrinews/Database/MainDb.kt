package com.example.tengrinews.Database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MainDb:RoomDatabase() {
    abstract fun getDao():UserDao
    companion object{
        fun getDb(context: Context):MainDb{
            return Room.databaseBuilder(
                context.applicationContext,
                MainDb::class.java,
                "test.db"
            ).build()
        }
    }
}