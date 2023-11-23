package com.example.tengrinews.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao

interface UserDao {
    @Insert
    fun insertItem(item: Item)

    @Query("SELECT * FROM users")
    fun getAllItem(): Flow<List<Item>>

}