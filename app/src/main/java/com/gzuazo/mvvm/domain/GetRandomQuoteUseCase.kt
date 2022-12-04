package com.gzuazo.mvvm.domain

import com.gzuazo.mvvm.data.QuoteRepository
import com.gzuazo.mvvm.data.model.QuoteModel
import com.gzuazo.mvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel? {
        val quotes =  QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomNumber = (0..quotes.size - 1).random()
            return quotes[randomNumber]
        }
        return null
    }
}