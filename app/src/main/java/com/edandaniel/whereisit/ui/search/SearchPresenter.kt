package com.edandaniel.whereisit.ui.search

import com.edandaniel.whereisit.base.BasePresenter
import com.edandaniel.whereisit.model.MyAddressClass
import com.edandaniel.whereisit.network.AddressAPI
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchPresenter (searchView: SearchView):BasePresenter<SearchView>(searchView){
    @Inject
    lateinit var addressAPI: AddressAPI
    private var subscription: Disposable? = null

    fun search(cep:String){

        view.showLoading()

        subscription = addressAPI
                .search(cep)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate{view.hideLoading()}
                .subscribe(
                        {address -> view.updateAddress(address)},
                        {view.showError("ERROR")})
    }
}