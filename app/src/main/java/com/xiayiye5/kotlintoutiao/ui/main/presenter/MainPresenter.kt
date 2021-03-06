package com.xiayiye5.kotlintoutiao.ui.main.presenter

import android.widget.Toast
import com.xiayiye5.kotlintoutiao.http.HttpUtils
import com.xiayiye5.kotlintoutiao.http.ResponseListener
import com.xiayiye5.kotlintoutiao.http.UserApi
import com.xiayiye5.kotlintoutiao.mvp.model.BaseModel
import com.xiayiye5.kotlintoutiao.mvp.presenter.BasePresenter
import com.xiayiye5.kotlintoutiao.ui.main.model.MainModel
import com.xiayiye5.kotlintoutiao.ui.main.view.MainView

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
 * 创建时间：2020/11/16 21:59
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：KotlinTouTiao
 * 文件包名：com.xiayiye5.kotlintoutiao.ui.main.presenter
 * 文件说明：
 */
class MainPresenter : BasePresenter<MainView>() {
    fun showToast(data: String) {
        getBaseView()!!.setData(data)
    }

    fun getTest() {
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java).getTest(),
            object : ResponseListener<BaseModel<MainModel>> {
                override fun onSuccess(data: BaseModel<MainModel>) {
                    getBaseView()!!.setData(data)
                }

                override fun onFail(error: String) {
                    getBaseView()!!.setError(error)
                }
            })
    }
}
