package com.example.algorithm.level2

/**
 * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
 * 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.

제한 조건
s는 길이 1 이상 200 이하인 문자열입니다.
s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
숫자는 단어의 첫 문자로만 나옵니다.
숫자로만 이루어진 단어는 없습니다.
공백문자가 연속해서 나올 수 있습니다.
첫 문자가 영문이 아닐때에는 이어지는 영문은 소문자로 씁니다. ( 첫번째 입출력 예 참고 )

입출력 예
s	return
"3people unFollowed me"	"3people Unfollowed Me"
"for the last week"	"For The Last Week"
 * */
class JadenCase {
    fun solution(s: String): String {
        /*var answer = ""

        val strArr = s.split(" ")
        strArr.forEachIndexed { index, string ->
            var changeStr = ""

            if (!string[0].isDigit())    {  //char[0]로 가져온 첫문자가 isDigit() == false  문자일 경우
                if (string[0].isLowerCase()){  //소문자일 시
                    changeStr = string.toLowerCase()       //전체 소문자 변환

                    val charArr = changeStr.toCharArray()
                    charArr[0] = charArr[0].toUpperCase() //첫번째 대문자로 변환
                    changeStr = String(charArr)
                }
            }else{ //첫문자 숫자일 경우
                changeStr = string.toLowerCase()
            }


            answer = if(index != strArr.size - 1){
                "$answer$changeStr "
            }else{
                "$answer$changeStr"
            }

        }
        return answer*/

        val lowerStr = s.toLowerCase()      //받아온 String 전부 소문자 전환
        val arr = lowerStr.split(" ")  //String을 공백문자를 기준으로 자른 후 배열로 만듬
        val computeStr = arr.joinToString(" "){   //joinToString()을 통하여 공백으로 문자열을 합침
            it.capitalize()  //각 항목의 String의 첫문자들을 대문자로 변환
        }
        //return computeStr

        return s.toLowerCase().split(" ").joinToString(" "){ it.capitalize() }
    }

}