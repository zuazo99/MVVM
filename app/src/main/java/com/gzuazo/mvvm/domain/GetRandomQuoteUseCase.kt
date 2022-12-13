package com.gzuazo.mvvm.domain

import com.gzuazo.mvvm.data.QuoteRepository
import com.gzuazo.mvvm.data.model.QuoteModel
import com.gzuazo.mvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {

    operator fun invoke(): QuoteModel? {
        val quotes =  quoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomNumber = (0..quotes.size - 1).random()
            return quotes[randomNumber]
        }
        return null
    }
}