package com.zhou.gank.adatper

import android.widget.TableLayout
import android.widget.TextView
import com.chad.library.adapter.base.baseAdapter.BaseQuickAdapter
import com.chad.library.adapter.base.baseAdapter.BaseViewHolder
import com.chad.library.adapter.base.media.AndroidMediaController
import com.chad.library.adapter.base.media.IjkVideoView
import com.zhou.gank.R
import com.zhou.gank.gank.m.SuggestBean

/**
 * Created by zhou on 2017/10/27.
 */
class SuggestDataAdatper (layoutResId: Int, data: List<SuggestBean>?) : BaseQuickAdapter<SuggestBean, BaseViewHolder>(layoutResId, data) {
    var index :Int = 0
    override fun convert(helper: BaseViewHolder?, item: SuggestBean?) {
        var view = helper?.getView<IjkVideoView>(R.id.ij_vv)
        view?.setHudView(helper?.getView<TableLayout>(R.id.hud_view))
        view?.setVideoPath("http://192.168.10.126:9032/test.mp4")
        if (index == 0){

            view?.setMediaController(AndroidMediaController(mContext,false))
            view?.start()
        }
        index++
        helper?.getView<TextView>(R.id.tv_vedio_publish)?.setText(item?.publishedAt)
        helper?.getView<TextView>(R.id.tv_video_desc)?.setText(item?.desc)
    }
}