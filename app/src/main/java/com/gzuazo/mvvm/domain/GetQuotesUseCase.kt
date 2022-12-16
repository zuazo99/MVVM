package com.gzuazo.mvvm.domain

import com.gzuazo.mvvm.data.QuoteRepository
import com.gzuazo.mvvm.data.database.entities.toDatabase
import com.gzuazo.mvvm.data.model.QuoteModel
import com.gzuazo.mvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }
}