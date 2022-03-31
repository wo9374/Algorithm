package com.example.algorithm.고득점Kit.DFS_NFS_깊이_너비_우선탐색.level3

/**
 * 문제 설명
주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.

항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
모든 공항은 알파벳 대문자 3글자로 이루어집니다.
주어진 공항 수는 3개 이상 10,000개 이하입니다.
tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
주어진 항공권은 모두 사용해야 합니다.
만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.

입출력 예
                    tickets	                                                             return
[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	                            ["ICN", "JFK", "HND", "IAD"]
[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]

입출력 예 설명

예제 #1
["ICN", "JFK", "HND", "IAD"] 순으로 방문할 수 있습니다.

예제 #2
["ICN", "SFO", "ATL", "ICN", "ATL", "SFO"] 순으로 방문할 수도 있지만 ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] 가 알파벳 순으로 앞섭니다.
 * */

class 여행경로 {
    lateinit var visit : MutableList<Boolean> // 티켓 사용 여부
    val answer = mutableListOf<String>() // 정답
    val temp = mutableListOf<String>() // 임시 저장용
    private lateinit var tickets_ : Array<Array<String>> // 티켓 전역변수

    fun solution(tickets: Array<Array<String>>): Array<String> {
        visit = MutableList(tickets.size) { false }
        tickets.sortBy { it[1] } // 알파벳 순서가 앞서는 경로 return 하기 위함
        tickets_ = tickets
        dfs("ICN",0)
        return answer.toTypedArray()
    }

    fun dfs(str : String , x : Int) : Boolean {
        temp.add(str)

        // 탐색이 무사히 성공했을 때
        if (x == tickets_.size){
            answer.addAll(temp)
            return true
        }

        for(i in tickets_.indices){
            // 현재 위치와 같고, 사용하지 않은 티켓일 때
            if (tickets_[i][0] == str && ! visit[i]){
                visit[i] = true
                if (dfs(tickets_[i][1], x + 1)) return true
                // 탐색 실패 시 방문 처리 취소
                visit[i] = false
            }
        }
        temp.removeAt(temp.size-1)
        return false
    }
}