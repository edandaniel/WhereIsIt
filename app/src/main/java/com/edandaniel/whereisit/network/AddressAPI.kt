package com.edandaniel.whereisit.network

import com.edandaniel.whereisit.model.MyAddressClass
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressAPI{

    @GET("/ws/{cep}/json")
    fun search(@Path("cep") cep:String): Observable<MyAddressClass>
}