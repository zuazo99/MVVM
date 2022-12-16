package com.gzuazo.mvvm.domain

import com.gzuazo.mvvm.data.QuoteRepository
import com.gzuazo.mvvm.data.model.QuoteModel
import com.gzuazo.mvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): Quote? {
        val quotes =  repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()){
            val randomNumber = (0..quotes.size - 1).random()
            return quotes[randomNumber]
        }
        return null
    }
}