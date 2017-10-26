package com.zhou.gank.gank.m

import com.google.gson.annotations.SerializedName

/**
 * Created by zhou on 2017/10/26.
 */
data class IosBeanResult(@SerializedName("error") var error: Boolean, @SerializedName("results") var iosBeanList: List<IosBean>)

data class IosBean(@SerializedName("_id") var _id: String,
                   @SerializedName("createdAt") var createdAt: String,
                   @SerializedName("desc") var desc: String,
                   @SerializedName("publishedAt") var publishedAt: String,
                   @SerializedName("source") var source: String,
                   @SerializedName("type") var type: String,
                   @SerializedName("used") var used: String,
                   @SerializedName("who") var who: String,
                   @SerializedName("url") var url: String
)