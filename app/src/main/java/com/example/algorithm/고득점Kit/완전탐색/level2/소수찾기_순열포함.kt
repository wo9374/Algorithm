package com.example.algorithm.고득점Kit.완전탐색.level2

import android.util.Log

/**
 * 문제 설명
한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

입출력 예
numbers	return
"17"	3
"011"	2

입출력 예 설명

예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

11과 011은 같은 숫자로 취급합니다.
 * */
class 소수찾기_순열포함 {
    fun solution(numbers: String): Int {

        //글자 하나로 배열 생성
        val numList = numbers.toCharArray().map { it.toString() }   // [0,1,1]
        Log.d("글자 하나 배열", "$numList")

        //순열 생성 (글자로 만들수 있는 모든 조합)
        val soonyeol = combination(numList)                    //[0, 1, 1], [0, 1, 1], [1, 0, 1], [1, 1, 0], [1, 0, 1], [1, 1, 0]
        Log.d("순열 생성", "$soonyeol")

        //숫자 병합
        val finSoonyeol = soonyeol.map { it.fold("") { acc, s -> acc + s } }  //[011, 011, 101, 110, 101, 110]
        Log.d("순열 숫자 병합", "$finSoonyeol")

        //중복제거
        val dist = finSoonyeol.distinct().map { it.toInt() }   //[11, 101, 110]
        Log.d("중복제거 순열", "$dist")


        Log.d("소수 개수 ", "${dist.filter { isPrime(it) }.size}")

        // isPrime 함수로 소수 구한후 size (총 개수) return
        return dist.filter { isPrime(it) }.size
    }

    fun <T> combination(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el): List<List<T>> { //sub: List<T> = listOf()
        //el: 원본 데이터로서 변하지 않음  //지워도 무방 (중간 원본 데이터를 사용하여 처리할 경우를 생각한 파라미터)
        //fin: 원소를 담는 리스트로서 기본값은 listOf()로 빈 리스트
        //sub: fin이 담는 리스트라면 sub는 빼는 리스트 기본값은 el

        //sub의 있는 원소를 빼서 fin의 넣는 과정을 반복하여 sub가 비었을 때 fin을 반환
        return if (sub.isEmpty()) listOf(fin)
        else sub.flatMap { combination(el, fin + it, sub - it) }
    }

    fun isPrime(n: Int) = (2..Math.sqrt(n.toDouble()).toInt()).none { n % it == 0 }
}


class 소수찾기_combination {
    fun solution(numbers: String): Int {
        var answer = 0
        val numSet = HashSet<Int>()

        makeNumberSet("", numbers, numSet) // 모든 경우의 숫자 set을 생성


        while (numSet.iterator().hasNext()) {   // HashSet의 모든 항목을 반복

            val num = numSet.iterator().next()  // numSet항목을 꺼낸 후 제거
            numSet.remove(num)

            if (isPrime(num)) answer++          // 해당 숫자가 소수면 answer 증가
        }

        return answer
    }

    fun makeNumberSet(prefix: String, numbers: String, numSet: HashSet<Int>) {

        if (prefix != "")  // 저장할 값이 있을 경우 numSet에 추가
            numSet.add(prefix.toInt())

        for (i in numbers.indices) {
            // 현재 값에서 다음 값을 추가 후 numbers에서 추가한 값을 제외시킴
            makeNumberSet("$prefix${numbers[i]}", numbers.substring(0, i) + numbers.substring(i + 1), numSet)
        }
    }

    fun isPrime(num: Int): Boolean {
        if (num <= 1) return false // 1이하는 소수가 아님으로 false 반환

        // 소수를 판별할 숫자의 제곱근 까지 나누어서 나누어 떨어지지 않으면 해당 숫자는 소수임으로 none 으로 확인 후 결과 리턴
        return (2..Math.sqrt(num.toDouble()).toInt()).none { num % it == 0 }
    }
}
