package jp.techacademy.shiori.tazawa.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // 算出結果を受け取る
        val valueKekka : Double = intent.getDoubleExtra("VALUE1",0.0)
        //Log.d("kotlintest",valueKekka.toString())

        // 算出結果を表示させる
        textView.text = valueKekka.toString()

        // 計算式を受け取る
        val valueKeisanShiki : String? = intent.getStringExtra("VALUE2")
        //Log.d("kotlintest",valueKeisanShiki.toString())

        // 計算式を表示させる
        textView2.text = valueKeisanShiki
    }
}