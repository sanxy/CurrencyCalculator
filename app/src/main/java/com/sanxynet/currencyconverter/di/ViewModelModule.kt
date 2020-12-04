
package com.sanxynet.currencyconverter.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


import com.sanxynet.currencyconverter.viewmodel.MainViewModelFactory
import com.sanxynet.currencyconverter.ui.MainViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindUserViewModel(mainViewModel: MainViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: MainViewModelFactory): ViewModelProvider.Factory
}
