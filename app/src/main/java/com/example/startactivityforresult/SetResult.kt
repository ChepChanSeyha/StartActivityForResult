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
        val operationVal = intent.getStringExtra("ValueOfOperation")
        val numberB = intent.getIntExtra("ValueOfB", 0)

        val mTextViewA = findViewById<TextView>(R.id.TextViewA)
        val mOperation = findViewById<TextView>(R.id.TextViewOperation)
        val mTextViewB = findViewById<TextView>(R.id.TextViewB)
        val mResult = findViewById<TextView>(R.id.TextViewResult)

        val mBackResult = when (operationVal) {
            "+" -> numberA + numberB
            "-" -> numberA - numberB
            "*" -> numberA * numberB
            else -> numberA / numberB
        }

        mTextViewA.text = numberA.toString()
        mOperation.text = operationVal
        mTextViewB.text = numberB.toString()
        mResult.text = mBackResult.toString()

        back.setOnClickListener {

            val dataIntent = Intent(this, MainActivity::class.java)
            dataIntent.putExtra("ValueOfResult", mBackResult)
            setResult(Activity.RESULT_OK, dataIntent)
            finish()
        }

    }
}