package com.example.algorithm.고득점Kit.greedy.level1

class 체육복 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {

        var answer = n      // 모두 체육복이 있다고 가정(나중에 없는 사람만 제외하는 방식을 위함)

        val lostSet = lost.sorted().toSet() - reserve.toSet()            // set을 사용하여 여벌옷이 있는 사람을 제외하고 추가

        val reserveSet = (reserve.toSet() - lost.toSet()) as MutableSet  // set을 사용하여 잃어버린 사람을 제외하고 추가

        for (l in lostSet) {
            when {
                l - 1 in reserveSet -> reserveSet.remove(l - 1)  // 이전 사람이 여벌옷이 있는 경우

                l + 1 in reserveSet -> reserveSet.remove(l + 1)  // 앞 사람이 여벌옷이 있는 경우

                else -> answer--                                         // 체육복을 구하지 못한경우 answer 감소
            }
        }
        return answer
    }
}