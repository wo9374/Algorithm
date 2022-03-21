package com.example.algorithm.고득점Kit.DFS_NFS_깊이_너비_우선탐색.level3

/**
 * 문제 설명
네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다. 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.

컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.

제한사항
컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
computer[i][i]는 항상 1입니다.

입출력 예
n	computers	return
3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
입출력 예 설명
 * */
class 네트워크 {
    val disconnected = mutableListOf<Int>()

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        for (i in 0 until n) disconnected.add(i)

        while (disconnected.size > 0) {
            // 새로운 네트워크
            answer++

            dfs(n, computers, disconnected.removeAt(0))
        }

        return answer
    }

    fun dfs(n: Int, computers: Array<IntArray>, computer: Int) {
        for (i in 0 until n) {
            // 두 컴퓨터가 연결되어 있는 경우
            if (disconnected.contains(i) && computers[computer][i] == 1) {
                // 네트워크에 속하게 되는 컴퓨터는 리스트에서 제거
                disconnected.remove(i)

                dfs(n, computers, i)
            }
        }
    }


    //모든 컴퓨터들을 disconnected 배열에 넣어 초기화.
    //disconnected 배열에 있는 컴퓨터가 없을 때까지 dfs로 연결된 모든 컴퓨터들을 확인한 후 disconnected 배열에서 제거.
    //disconnected 배열에 아무것도 존재하지 않으면 모든 컴퓨터가 네트워크에 연결된 것이므로 종료.
}