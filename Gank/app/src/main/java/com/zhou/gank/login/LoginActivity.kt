package com.zhou.gank.login

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import com.zhou.gank.MainActivity
import com.zhou.gank.R
import kotlinx.android.synthetic.main.acitivity_login.*

/**
 * Created by zhou on 2017/12/4.
 */
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_login)


        weixin_login.setOnClickListener({startActivity(Intent(this,MainActivity::class.java),ActivityOptionsCompat.makeBasic().toBundle()) })
    }
}