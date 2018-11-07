package com.edandaniel.whereisit.injection.module

import android.app.Application
import android.content.Context
import com.edandaniel.whereisit.base.BaseView
import dagger.Module
import dagger.Provides

@Module
object ContextModule{

    @Provides
    @JvmStatic
    fun provideContext(baseView: BaseView): Context {
        return baseView.getContext()
    }

    @Provides
    @JvmStatic
    fun provideApplication(context:Context):Application{
        return context.applicationContext as Application
    }
}