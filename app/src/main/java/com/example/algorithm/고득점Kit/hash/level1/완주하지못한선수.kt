package com.example.algorithm.고득점Kit.hash.level1

import android.os.Build
import java.util.HashMap

class 완주하지못한선수 {
    /**
     * 수많은 마라톤 선수들이 마라톤에 참여하였습니다.
     * 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
     *
     * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
     * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한사항
     * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
     * completion의completion의 길이는 participant의 길이보다 1 작습니다.
     * completion의참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
     * completion의참가자 중에는 동명이인이 있을 수 있습니다.
     *
     * 입출력 예
     * participant	              completion	                         return
     * ["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
     * ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
     * ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
     *
     * 입출력 예 설명
     * 예제 #1
     * "leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
     *
     * 예제 #2
     * "vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
     *
     * 예제 #3
     * "mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
     */
    fun solution(participant: Array<String>, completion: Array<String>): String {
        var answer = ""
        val hm = HashMap<String, Int>()

        for (player in participant) if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            hm[player] = hm.getOrDefault(player, 0) + 1
        }

        for (player in completion) hm[player] = hm[player]!! - 1

        for (key in hm.keys) {
            if (hm[key] != 0) {
                answer = key
                break
            }
        }
        return answer

        /*1. Map 은 <Key, Value> 형태로 들어가며 get(key)를 통해 Value 를 얻을 수 있습니다.

            getOrDefault(Key, default 값) / Key 값으로 Value 를 불러오며, Key 가 존재하지 않을 시 default 값으로 불러옴
            keySet() : Map 을 Key 값으로만 이루어진 Set 객체가 반환
            put(Key, Value) : Key 값으로 Value 를 불러옴
            get(Key) : Key 값으로 Value 를 불러옴*/

        /*2.첫번째 for 문으로 마라톤 참가자들의 Value 를 1로 넣어줌
            ex) [a=1, b=1, c=1] : HashMap 은 빈값이므로 모든 참가자가 getOrDefault(player, 0) + 1을 통해 1의 값을 가지게 되고,
            만약 동명이인이 있다면 2를 갖게 됌*/

        /*3.두번째 for 문으로 완주자들의 Value 를 -1씩 빼서 넣어줌.
            ex) [a=0, b=0, c=1] : Map 은 동일한 Key 가 있을 시, put 을 하게 되면 입력한 value 로 변경
            만약 완주 못한 참가자라면 0이 아닌 값을 가질 것, 동명이인 2명이 모두 완주했을 시 0, 1명이 완주했을 시에는 1을 갖게 됩니다.
            즉, 완주하지 못한 참가자는 무조건 0을 갖게 됩니다.*/

        /*4.세번째 for 문으로 keySet()으로 참가자들을 불러와 0이 아닌 인원 찾기
            찾은 후에는 break;으로 불필요한 검색을 최소화*/
    }
}