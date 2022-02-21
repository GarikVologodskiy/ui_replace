package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.addTextChangedListener(object: TextWatcher {
            var count: Int = 0

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                var text = s.toString()
                when {
                    text.contains("question") -> {
                        text = text.replaceFirst("question","answer")
                        editText.setText(text)
                        editText.setSelection(text.length)
                        count++
                        textView.text = "$count"
                    }

                    text.contains("request") -> {
                        text = text.replaceFirst("request","response")
                        count++
                        textView.text = "$count"

                        editText.setText(text)
                        editText.setSelection(text.length)
                    }

                    text.contains("problem") -> {
                        text = text.replaceFirst("problem","task")
                        count++
                        textView.text = "$count"

                        editText.setText(text)
                        editText.setSelection(text.length)
                    }

                }
            }
        })
    }
}