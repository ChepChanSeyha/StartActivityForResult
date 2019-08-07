package com.example.startactivityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.IntegerRes
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_set_result.*

class SetResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_result)

        val changeNumber1 = intent.getIntExtra("ValueOfA", 0)
        val changeOperation = intent.getStringExtra("ValueOfOperation")
        val changeNumber2 = intent.getIntExtra("ValueOfB", 0)
        val changeResult = intent.getIntExtra("ValueOfResult", 0)

        val a = findViewById<TextView>(R.id.TextViewA)
        val opera = findViewById<TextView>(R.id.TextViewOperation)
        val b = findViewById<TextView>(R.id.TextViewB)
        val result = findViewById<TextView>(R.id.TextViewResult)

        a.text = changeNumber1.toString()
        opera.text = changeOperation.toString()
        b.text = changeNumber2.toString()
        result.text = changeResult.toString()

        back.setOnClickListener {

            val mBackResult = Integer.parseInt(result.text.toString())

            val dataIntent = Intent(this, MainActivity::class.java)
            dataIntent.putExtra("ValueOfBackResult", mBackResult)
            setResult(Activity.RESULT_OK, dataIntent)
            finish()
        }
    }
}
