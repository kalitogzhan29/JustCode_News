package com.example.tengrinews.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tengrinews.Database.Item

@Database(entities = [Item::class], version = 1)

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