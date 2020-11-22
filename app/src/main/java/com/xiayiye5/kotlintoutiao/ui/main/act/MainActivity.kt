package com.xiayiye5.kotlintoutiao.ui.main.act

import android.util.Log
import android.widget.Toast
import com.xiayiye5.kotlintoutiao.R
import com.xiayiye5.kotlintoutiao.base.BaseActivity
import com.xiayiye5.kotlintoutiao.ui.main.presenter.MainPresenter
import com.xiayiye5.kotlintoutiao.ui.main.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun init() {
        clickMe.setOnClickListener {
            getPresenter()?.showToast("测试数据")
        }
    }

    override fun initData() {
    }

    override fun createPresenter() = MainPresenter()


    override fun <T> setData(data: T) {
        Toast.makeText(this, data as String, Toast.LENGTH_LONG).show()
        Log.e("打印数据", data.toString())
    }

    override fun setError(err: String) {

    }

}
