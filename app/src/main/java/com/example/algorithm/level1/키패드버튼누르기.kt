package com.example.algorithm.level1

import kotlin.math.abs

class 키패드버튼누르기 {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = StringBuilder() // 왼손 번호
        var lNum = 10 // 오른손 번호
        var rNum = 12
        numbers.forEach {
            val next = if (it == 0) 11 else it
            when (next % 3) {
                0 -> {
                    answer.append("R")
                    rNum = next
                }
                1 -> {
                    answer.append("L")
                    lNum = next
                }
                2 -> {
                    when (distance(lNum, next).compareTo(distance(rNum, next))) {
                        // 왼손과 눌러야 하는 번호의 거리 계산
                        -1 -> {
                            answer.append("L")
                            lNum = next
                        }
                        // 오른손과 눌러야 하는 번호의 거리 계산
                        1 -> {
                            answer.append("R")
                            rNum = next
                        }
                        //거리가 같으면 손잡이에 따른 answer추가
                        0 -> {
                            if (hand == "left") {
                                answer.append("L")
                                lNum = next
                            } else {
                                answer.append("R")
                                rNum = next
                            }
                        }
                    }
                }
            }
        }
        return answer.toString()
    }

    fun distance(now:Int, next:Int) = abs((now - 1) % 3 - (next - 1) % 3) + abs((now - 1) / 3 - (next - 1) / 3)
}