package com.edandaniel.whereisit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.edandaniel.whereisit.base.BaseActivity
import com.edandaniel.whereisit.model.MyAddressClass
import com.edandaniel.whereisit.ui.search.SearchPresenter
import com.edandaniel.whereisit.ui.search.SearchView

class SearchActivity : BaseActivity<SearchPresenter>(), SearchView {
    override fun instantiatePresenter(): SearchPresenter {
        return SearchPresenter(this)
    }

    override fun updateAddress(address: MyAddressClass) {
        Toast.makeText(this,
                address.logradouro,
                Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: String) {
        Toast.makeText(this,
                "Errored",
                Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        Toast.makeText(this,
                "Loading",
                Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
        Toast.makeText(this,
                "Loaded",
                Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        presenter.search("04313110")
    }
}
