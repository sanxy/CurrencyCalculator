

package com.sanxynet.currencyconverter.di


import com.sanxynet.currencyconverter.api.RatesService
import com.sanxynet.currencyconverter.repository.IRepository
import com.sanxynet.currencyconverter.repository.RepositoryImpl
import com.sanxynet.currencyconverter.CurrencyApplication
import dagger.Module
import dagger.Provides
import io.realm.Realm
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideRatesService(): RatesService {
        return Retrofit.Builder()
            .baseUrl("http://data.fixer.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RatesService::class.java)
    }

    @Singleton
    @Provides
    fun provideDb(app: CurrencyApplication): Realm {
        Realm.init(app.applicationContext)
        return Realm.getDefaultInstance()
    }

    @Singleton
    @Provides
    fun provideRepository(realmDb: Realm, ratesService: RatesService): IRepository {
        return RepositoryImpl(realmDb, ratesService)
    }
}
