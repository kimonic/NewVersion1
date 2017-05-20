package dingw.com.newversion

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Main22Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main22)
        println("hahaha"+sum(10,20))
    }

    fun sum(a: Int,b:Int):Int{
        return a+b
    }
}
