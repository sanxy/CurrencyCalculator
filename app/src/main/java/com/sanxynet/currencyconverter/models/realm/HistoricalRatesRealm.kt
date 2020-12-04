package com.sanxynet.currencyconverter.models.realm

import com.sanxynet.currencyconverter.models.CurrencyRate
import io.realm.annotations.PrimaryKey

open class HistoricalRatesRealm {

    @PrimaryKey
    lateinit var currencyCode: String
    lateinit var baseCurrencyCode: String
    var rate: Double = 0.0
    lateinit var date: String

    fun toRate(): CurrencyRate {
        return CurrencyRate(currencyCode, rate, baseCurrencyCode, date)
    }
}