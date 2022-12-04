package com.gzuazo.mvvm.domain

import com.gzuazo.mvvm.data.QuoteRepository
import com.gzuazo.mvvm.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}