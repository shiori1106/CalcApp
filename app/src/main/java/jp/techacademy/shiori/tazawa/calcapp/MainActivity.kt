package jp.techacademy.shiori.tazawa.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import java.lang.Exception

class MainActivity : AppCompatActivity() , View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ボタンにOnClickListenerを設置
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    // ボタンをクリックしたときの処理
    override fun onClick(v: View) {

        try {

            // kekkaに結果を格納
            var kekka: Double = 0.0

            // ボタンによって結果を算出する
            when (v.id) {
                R.id.button1 -> kekka =
                    (editText1.text.toString().toDouble() + editText2.text.toString().toDouble())
                R.id.button2 -> kekka =
                    (editText1.text.toString().toDouble() - editText2.text.toString().toDouble())
                R.id.button3 -> kekka =
                    (editText1.text.toString().toDouble() * editText2.text.toString().toDouble())
                R.id.button4 -> kekka =
                    (editText1.text.toString().toDouble() / editText2.text.toString().toDouble())
            }
            // Log.d("kotlintest",kekka.toString())

            // keisanShikiに計算式を格納
            var keisanShiki: String = "計算式"

            // ボタンによって結果を算出する
            when (v.id) {
                R.id.button1 -> keisanShiki =
                    "${editText1.text.toString().toDouble()}" + " + " + "${editText2.text.toString()
                        .toDouble()}" + " ="
                R.id.button2 -> keisanShiki =
                    "${editText1.text.toString().toDouble()}" + " - " + "${editText2.text.toString()
                        .toDouble()}" + " ="
                R.id.button3 -> keisanShiki =
                    "${editText1.text.toString().toDouble()}" + " × " + "${editText2.text.toString()
                        .toDouble()}" + " ="
                R.id.button4 -> keisanShiki =
                    "${editText1.text.toString().toDouble()}" + " ÷ " + "${editText2.text.toString()
                        .toDouble()}" + " ="
            }
            //Log.d("kotlintest",keisanShiki.toString())

            val intent = Intent(this, SecondActivity::class.java)

            // 算出した結果を渡す
            intent.putExtra("VALUE1", kekka)

            // 計算式を渡す
            intent.putExtra("VALUE2", keisanShiki)

            startActivity(intent)

        // エラー時の処理
        } catch (e:Exception) {

             // 数字が入力されていなかったときにメッセージを出す
             if (editText1.text.isEmpty() || editText2.text.isEmpty()){
                Snackbar.make(findViewById<View>(android.R.id.content),"何か数字を入力してください",Snackbar.LENGTH_LONG)
                .show()}
            //Log.d("kotlintest",e.message.toString())
        }
    }

}