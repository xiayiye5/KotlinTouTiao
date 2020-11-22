package com.xiayiye5.kotlintoutiao.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.xiayiye5.kotlintoutiao.mvp.presenter.BasePresenter
import com.xiayiye5.kotlintoutiao.mvp.view.BaseView

/*
 * Copyright (c) 2020, smuyyh@gmail.com All Rights Reserved.
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG            #
 * #                                                   #
 */

/**
 * @author 下一页5（轻飞扬）
 * 创建时间：2020/11/16 21:45
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：KotlinTouTiao
 * 文件包名：com.xiayiye5.kotlintoutiao.base
 * 文件说明： 所有Activity 基类
 */
abstract class BaseActivity<V, P : BasePresenter<V>> : AppCompatActivity(), BaseView {
    private var mPresenter: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        if (null == mPresenter) {
            mPresenter = createPresenter()
        }
        //绑定View 视图
        mPresenter!!.bindView(this as V)
        init()
        initData()
    }

    //设置布局id 的方法
    abstract fun getLayoutId(): Int

    //初始化
    protected abstract fun init()

    //初始化数据
    protected abstract fun initData()

    /**
     * 创建P 层的方法
     * 21点52分
     */
    protected abstract fun createPresenter(): P

    //获取P 层的方法
    fun getPresenter() = mPresenter

    override fun onDestroy() {
        super.onDestroy()
        //解绑 View
        mPresenter?.unBindView()
    }
}