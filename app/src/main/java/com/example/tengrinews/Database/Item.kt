package com.example.tengrinews.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Item(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name="email")
    var email:String,
    @ColumnInfo(name="password")
    var password:String,
)
