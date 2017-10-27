package com.zhou.gank.gank.m

import com.google.gson.annotations.SerializedName

/**com.zhou.gank.gank.m.SuggestBeanResult
 * Created by zhou on 2017/10/27.
 */
data class SuggestBeanResult (@SerializedName("error") var error : Boolean ,@SerializedName("results") var suggestBeanList:List<SuggestBean>)

data class SuggestBean(@SerializedName("desc") var desc:String,
                       @SerializedName("publishedAt") var publishedAt :String,
                       @SerializedName("url") var url :String
                       )