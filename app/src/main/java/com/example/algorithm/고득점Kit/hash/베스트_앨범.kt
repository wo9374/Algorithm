package com.example.algorithm.고득점Kit.hash

import android.util.Log

/**
 * 문제 설명
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

제한사항
genres[i]는 고유번호가 i인 노래의 장르입니다.
plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
장르 종류는 100개 미만입니다.
장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
모든 장르는 재생된 횟수가 다릅니다.

입출력 예
                        genres	                        plays	            return
["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]

입출력 예 설명
classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.

고유 번호 3: 800회 재생
고유 번호 0: 500회 재생
고유 번호 2: 150회 재생
pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.

고유 번호 4: 2,500회 재생
고유 번호 1: 600회 재생
따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 * */
class 베스트_앨범 {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {

        //노래의 고유 번호가 필요하므로, withIndex() 메소드를 사용하여 index를 사용해 plays와 genres를 매칭
        return plays.withIndex().groupBy { genres[it.index] }.values         //groupBy() 메소드로 {장르: [노래, ...], ...}와 같은 데이터를 완성
            .sortedByDescending { it -> it.sumBy { it.value } }       //이후 이를 sumBy, 즉 장르를 재생한 시간을 기준으로 큰 순으로 정렬
            .map { v -> v.sortedByDescending { it.value }.map { it.index } }  //장르 내에서 많이 재생된 노래 순으로 다시 정렬
            .fold(intArrayOf()) { acc, v -> acc + v.subList(0, Math.min(2, v.size)) }
        /*
        이제 각 장르 별로 두 곡 씩 앨범에 수록해야함. 장르에 속한 곡이 하나라면, 하나의 곡만 선택
        .fold() 메소드를 통해 초기값을 지정하여 reduce를 실행,
        .subList 메소드의 경우 범위를 넘어서는 인덱스를 입력하면 Out Of Bounds 에러를 발생시키니 min을 활용하여 에러 발생 요소를 원천 차단
        */
    }

    fun solution2(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices.groupBy { genres[it] }
            .toList()
            .sortedByDescending { it.second.sumBy { plays[it] } }
            .map { it.second.sortedByDescending { plays[it] }.take(2) }
            .flatten()
            .toIntArray()
    }
}