package com.zhou.gank.adatper

import android.widget.TextView
import com.chad.library.adapter.base.baseAdapter.BaseQuickAdapter
import com.chad.library.adapter.base.baseAdapter.BaseViewHolder
import com.zhou.gank.R
import com.zhou.gank.gank.m.AndroidBean

/**
 * Created by zhou on 2017/10/26.
 */
class AndroidDataAdapter(layoutResId: Int, data: List<AndroidBean>?) : BaseQuickAdapter<AndroidBean, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder?, item: AndroidBean?) {
        helper?.getView<TextView>(R.id.tv_desc)?.setText(item?.desc)
        helper?.getView<TextView>(R.id.tv_who)?.setText("作者:${item?.who}")
        helper?.getView<TextView>(R.id.tv_publish)?.setText("发布时间:${item?.publishedAt}")
    }

}