package com.example.algorithm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.algorithm.고득점Kit.DFS_NFS_깊이_너비_우선탐색.level2.타겟넘버_DFS

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



           /* val arr = arrayOf(
                intArrayOf(0,0,0,0,0),
                intArrayOf(0,0,1,0,3),
                intArrayOf(0,2,5,0,1),
                intArrayOf(4,2,4,4,2),
                intArrayOf(3,5,1,3,1)
            )

            val moves = intArrayOf(1,5,3,5,1,2,1,4)
            Log.d("크레인인형뽑기게임 터트려진 인형수" , "${크레인인형뽑기게임().solution(arr, moves)}")
*/

//            val maxInt = intArrayOf(3,30,34,5,9)
//            Log.d("가장큰수", 가장큰수().solution(maxInt))



/*            val array = intArrayOf(1,5,2,6,3,7,4)
            val commands = arrayOf(
                intArrayOf(2,5,3),
                intArrayOf(4,4,1),
                intArrayOf(1,7,3)
            )
            Log.d("K번째 수", "${K번째_수().solution(array, commands)}")*/


          /*  val commands = arrayOf(
                arrayOf("yellow_hat", "headgear"),
                arrayOf("blue_sunglasses", "eyewear"),
                arrayOf("green_turban", "headgear"),
            )
            Log.d("위장", "${위장().solution(commands)}")*/


            /*val genres = arrayOf("classic", "pop", "classic", "classic", "pop")
            val plays = intArrayOf(500, 600, 150, 800, 2500)

            Log.d("베스트_앨범", "${베스트_앨범().solution(genres,plays)}")*/

            //소수찾기_순열포함().solution("17")


            //소수찾기_combination().solution("011") // 17, 011


            /*val numbers = intArrayOf(1, 1, 1, 1, 1)
            val target = 3
            타겟넘버_DFS().solution(numbers,target)*/



            val rounds = arrayOf(
                arrayOf("b", "a", "a", "d"),
                arrayOf("b", "c", "a", "c"),
                arrayOf("b", "a", "d", "c")
            )
            커플매칭().solution(rounds)
        }
    }
}