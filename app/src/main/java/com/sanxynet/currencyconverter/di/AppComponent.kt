package com.sanxynet.currencyconverter.di


import com.sanxynet.currencyconverter.CurrencyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: CurrencyApplication): Builder

        fun build(): AppComponent
    }

    fun inject(ccApp: CurrencyApplication)

}
