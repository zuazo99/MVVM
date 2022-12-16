package com.gzuazo.mvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gzuazo.mvvm.data.database.dao.QuoteDao
import com.gzuazo.mvvm.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao
}