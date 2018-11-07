package com.edandaniel.whereisit.ui.search

import com.edandaniel.whereisit.base.BaseView
import com.edandaniel.whereisit.model.MyAddressClass

interface SearchView: BaseView{
    fun updateAddress(address: MyAddressClass)
    fun showError(error:String)
    fun showLoading()
    fun hideLoading()
}