package com.edandaniel.whereisit.base

import com.edandaniel.whereisit.injection.component.DaggerPresenterInjector
import com.edandaniel.whereisit.injection.component.PresenterInjector
import com.edandaniel.whereisit.injection.module.ContextModule
import com.edandaniel.whereisit.injection.module.NetworkModule
import com.edandaniel.whereisit.ui.search.SearchPresenter

abstract class BasePresenter<out V: BaseView>(protected val view:V){
    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init{
        inject()
    }

    open fun onViewCreate(){

    }

    open fun onViewDestroyed(){

    }

    private fun inject(){
        when(this){
            is SearchPresenter -> injector.inject(this)
        }
    }
}