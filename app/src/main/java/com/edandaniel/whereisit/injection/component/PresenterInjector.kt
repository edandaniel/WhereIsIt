package com.edandaniel.whereisit.injection.component
import com.edandaniel.whereisit.base.BaseView
import com.edandaniel.whereisit.injection.module.ContextModule
import com.edandaniel.whereisit.injection.module.NetworkModule
import com.edandaniel.whereisit.ui.search.SearchPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {

    fun inject(searchPresenter: SearchPresenter)

    @Component.Builder
    interface Builder {

        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}


