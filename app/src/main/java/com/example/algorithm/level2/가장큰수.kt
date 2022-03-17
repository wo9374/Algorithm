package com.example.algorithm.level2

import android.util.Log

/**
 * 문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

입출력 예
numbers	            return
[6, 10, 2]	        "6210"
[3, 30, 34, 5, 9]	"9534330"

 * */

class 가장큰수 {
    fun solution(numbers: IntArray): String {
        var answer = ""

        //여기서 정렬 기준은 기존의 각 항목들이 큰지 비교하는 것이 아닌 두개를 붙였을 때 어떤게 더 큰지 비교해야한다
        //즉, 10과 2를 비교할 때 10 > 2이면 102로 정렬이 되기 때문에 안되고 102와 210을 비교

        //collection 객체에 sortedWith를 통해 정렬 기준을 부여
        numbers.sortedWith {
                s1, s2 -> "$s2$s1".compareTo("$s1$s2")
        }.forEach { answer+=it }

        if (answer.first() == '0') answer = "0"
        return answer
    }
}