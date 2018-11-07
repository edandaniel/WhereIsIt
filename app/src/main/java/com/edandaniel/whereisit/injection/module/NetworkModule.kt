package com.edandaniel.whereisit.injection.module

import com.edandaniel.whereisit.network.AddressAPI
import com.edandaniel.whereisit.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object NetworkModule{

    @Provides
    @JvmStatic
    @Reusable
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory
                        .createWithScheduler(Schedulers.io()))
                .build()
    }


    @Provides
    @JvmStatic
    @Reusable
    fun provideAPIAddress(retrofit: Retrofit):AddressAPI{
        return retrofit.create(AddressAPI::class.java)
    }
}