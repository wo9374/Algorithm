package com.example.algorithm

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.HashMap

class 커플매칭 {
    @RequiresApi(Build.VERSION_CODES.N)
    fun solution(rounds: Array<Array<String>>): Int {
        var answer = 0
        val default = arrayOf("a", "b", "c", "d")

        val map = HashMap<String, String>()
        val coupleMap = HashMap<String, Boolean>()

        default.mapIndexed { index, s ->
            map[s] = s
            coupleMap[s] = false
        }

        rounds.forEachIndexed { idx, arrays ->
            arrays.forEachIndexed { index, s ->
                if (default[index] == s)  // 자기 자신 지목시 반칙
                    answer++


                if (coupleMap[default[index]] == true){
                    if (map[default[index]] == s)
                        answer++

                    coupleMap[default[index]] = false
                }

                map[default[index]] = s
            }

            default.forEach {
                if (map[map[it]] == it && map[it] != it) //서로 커플 지목 했을때 //자기자신 아닐떼
                    coupleMap[it] = true

            }
        }

        return answer
    }
}