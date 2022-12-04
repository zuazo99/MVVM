package com.gzuazo.mvvm.data

import com.gzuazo.mvvm.data.model.QuoteModel
import com.gzuazo.mvvm.data.model.QuoteProvider
import com.gzuazo.mvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}