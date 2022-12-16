package com.gzuazo.mvvm.data

import com.gzuazo.mvvm.data.database.dao.QuoteDao
import com.gzuazo.mvvm.data.database.entities.QuoteEntity
import com.gzuazo.mvvm.data.network.QuoteService
import com.gzuazo.mvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi() = api.getQuotes().map { it.toDomain() }

    suspend fun getAllQuotesFromDatabase() = quoteDao.getAllQuotes().map { it.toDomain() }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) = quoteDao.insertAll(quotes)

    suspend fun clearQuotes() = quoteDao.deleteAllQuotes()

}