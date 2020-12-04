package com.sanxynet.currencyconverter.ui

import androidx.lifecycle.*

import com.sanxynet.currencyconverter.api.Resource
import com.sanxynet.currencyconverter.models.CurrencyRate
import com.sanxynet.currencyconverter.repository.IRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(val repository: IRepository) : ViewModel() {

    private val _ratesLiveData: MutableLiveData<Resource<List<CurrencyRate>>> = MutableLiveData()
    val ratesLiveData: LiveData<Resource<List<CurrencyRate>>>
        get() = _ratesLiveData

    private val _historicalRatesLiveData: MediatorLiveData<Result> = MediatorLiveData()
    val historicalRatesLiveData: LiveData<Result>
        get() = _historicalRatesLiveData

    init {
        getHistoricalRates(30)
        getHistoricalRates(90)
    }

    fun getRates() {
        repository.getRates(_ratesLiveData)
    }

    fun getHistoricalRates(numberOfDays: Int) {
        val result = repository.getHistoricalRates(numberOfDays)
        _historicalRatesLiveData.addSource(result)
         {
//            _historicalRatesLiveData.removeSource(result)
            _historicalRatesLiveData.value = Result(numberOfDays, it)
        }
    }
}

data class Result(val numberOfDays: Int, val data: Resource<MutableList<MutableMap<String, List<CurrencyRate>>>>)