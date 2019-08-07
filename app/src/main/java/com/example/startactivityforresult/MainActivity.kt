package com.example.startactivityforresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var strOperation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val operationSpinner = arrayOf("+", "-", "*", "/")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, operationSpinner)
        SpinnerOperation.adapter = adapter

        // Set value when click specific position
        SpinnerOperation.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long){
                // Display the selected item text on text view
                strOperation = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callback
            }
        }

        val mEditTextA = findViewById<EditText>(R.id.EditTextA)
        val mEditTextB = findViewById<EditText>(R.id.EditTextB)

        calculate.setOnClickListener {

            val intent = Intent(this, SetResult::class.java)

            val mOperation = strOperation
            val numberA = Integer.parseInt(mEditTextA.text.toString())
            val numberB = Integer.parseInt(mEditTextB.text.toString())

            intent.putExtra("ValueOfA", numberA)
            intent.putExtra("ValueOfOperation", mOperation)
            intent.putExtra("ValueOfB", numberB)
            startActivityForResult(intent, 168)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 168) {
            if(resultCode == RESULT_OK){
                val result1 = data?.getIntExtra("ValueOfResult", 0)
                val mBackResult = findViewById<TextView>(R.id.TextViewBackResult)
                mBackResult.text = result1.toString()
            }
        }
    }
}
