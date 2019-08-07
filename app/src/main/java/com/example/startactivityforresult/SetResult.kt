package com.example.startactivityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_set_result.*

class SetResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_result)

        val numberA = intent.getIntExtra("ValueOfA", 0)
        val numberB = intent.getIntExtra("ValueOfB", 0)

        val mTextViewA = findViewById<TextView>(R.id.TextViewA)
        val mTextViewB = findViewById<TextView>(R.id.TextViewB)

        mTextViewA.text = numberA.toString()
        mTextViewB.text = numberB.toString()

        back.setOnClickListener {
            val result = numberA + numberB

            val dataIntent = Intent(this, MainActivity::class.java)
            dataIntent.putExtra("ValueOfResult", result)
            setResult(Activity.RESULT_OK, dataIntent)
            finish()
        }

    }
}