package com.sanxynet.currencyconverter.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.work.ListenableWorker
import com.sanxynet.currencyconverter.api.Resource
import com.sanxynet.currencyconverter.models.CurrencyRate

interface IRepository {

    fun getRates(ratesLiveData: MutableLiveData<Resource<List<CurrencyRate>>>)
    fun getRatesInBackground(): ListenableWorker.Result
    fun getHistoricalRates(numberOfDays: Int) : LiveData<Resource<MutableList<MutableMap<String, List<CurrencyRate>>>>>
}