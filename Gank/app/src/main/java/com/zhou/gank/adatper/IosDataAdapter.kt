package com.zhou.gank.adatper

import android.widget.TextView
import com.chad.library.adapter.base.baseAdapter.BaseQuickAdapter
import com.chad.library.adapter.base.baseAdapter.BaseViewHolder
import com.zhou.gank.R
import com.zhou.gank.gank.m.IosBean

/**
 * Created by zhou on 2017/10/26.
 */
class  IosDataAdapter (layoutResId: Int, data: List<IosBean>?) : BaseQuickAdapter<IosBean, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder?, item: IosBean?) {
        helper?.getView<TextView>(R.id.tv_desc)?.setText(item?.desc)
        helper?.getView<TextView>(R.id.tv_who)?.setText(item?.who)
        helper?.getView<TextView>(R.id.tv_who)?.setText(item?.publishedAt)
    }

}