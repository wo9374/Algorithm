package com.example.algorithm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.algorithm.level1.숫자문자열과영단어
import com.example.algorithm.level1.신규아이디추천
import com.example.algorithm.level1.크레인인형뽑기게임
import com.example.algorithm.level2.문자열압축

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

            //JadenCase().solution("3people unFollowed me")

            //문자열압축().solution("aabbaccc")

            //Log.d("숫자 문자열과 영단어" , "${숫자문자열과영단어().solution("one4seveneight")}")

            val arr = arrayOf(
                intArrayOf(0,0,0,0,0),
                intArrayOf(0,0,1,0,3),
                intArrayOf(0,2,5,0,1),
                intArrayOf(4,2,4,4,2),
                intArrayOf(3,5,1,3,1)
            )

            val moves = intArrayOf(1,5,3,5,1,2,1,4)
            Log.d("크레인인형뽑기게임 터트려진 인형수" , "${크레인인형뽑기게임().solution(arr, moves)}")
        }
    }
}