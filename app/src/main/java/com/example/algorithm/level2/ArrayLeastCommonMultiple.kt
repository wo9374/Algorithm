package com.example.algorithm.level2

/**
 * Common Multiple = 공배수
 *
 * 문제 설명
두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

제한 사항
arr은 길이 1이상, 15이하인 배열입니다.
arr의 원소는 100 이하인 자연수입니다.

입출력 예
arr	result
[2,6,8,14]	168
[1,2,3]	6
 * */

class ArrayLeastCommonMultiple {
    fun solution(arr: IntArray): Int {
        var gcd = GCD(arr[0], arr[1])    // [0], [1]의 최대 공약수 구하기
        var lcm = arr[0] * arr[1] / gcd  // [0], [1]의 최소 공배수 구하기

        //위에서 구한 최소 공배수와 [2]의 최대 공약수, 최소 공배수 구하기
        //최소공배수와 [i]의 최대 공약수와 최소 공배수를 배열이 끝날 때까지 반복한다.
        // 마지막으로 구해진 최소 공배수가 배열 모든 수의 최소 공배수이다.
        for (i in 2 until arr.size) {
            gcd = GCD(lcm, arr[i])
            lcm = lcm * arr[i] / gcd
        }
        return lcm
    }

    // 최대공약수를 반환하는 함수
    fun GCD(a: Int, b: Int): Int {
        return if (a % b == 0) b else GCD(b, a % b)
    }
}