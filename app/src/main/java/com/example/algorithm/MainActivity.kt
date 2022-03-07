package com.example.algorithm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.algorithm.level2.JadenCase

class MainActivity : AppCompatActivity() {
    lateinit var btn: Button

    //완주하지 못한 선수
    var participant = arrayOf("marina", "josipa", "nikola", "vinko", "filipa")
    var completion = arrayOf("josipa", "filipa", "marina", "nikola")

    //전화번호 목록 - 접두사 있는 경우 false
    var phone_book = arrayOf("119", "97674223", "1195524421")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.button)

        btn.setOnClickListener {
            /*Log.d("Hash 문제/완주하지못한선수", "루저 - " + 완주하지못한선수().solution(participant, completion))


            if (전화번호목록().solution(phone_book)) {
                Log.d("Hash 문제/전화번호목록", "접두사 없음")
            } else {
                Log.d("Hash 문제/전화번호목록", "접두사 존재")
            }*/

            JadenCase().solution("3people unFollowed me")
        }
    }
}