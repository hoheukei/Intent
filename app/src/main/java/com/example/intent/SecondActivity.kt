package com.example.intent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message = intent.getStringExtra(MainActivity.KEY)
        textViewMessage.text = String.format("%s %s", getString(R.string.message), message)

        val lucky = intent.getIntExtra(MainActivity.LUCKY,0)
        textViewluckynumber.text = String.format("%s %d", getString(R.string.myluckynumber), lucky)

        buttonDone.setOnClickListener{
            if(!editTextReply.text.isEmpty()){
                val reply = editTextReply.text.toString()
                val intent = getIntent()
                intent.putExtra(MainActivity.REPLY, reply)
                setResult(Activity.RESULT_OK, intent)
            }else
                setResult(Activity.RESULT_CANCELED)

            finish()
        }
    }
}
