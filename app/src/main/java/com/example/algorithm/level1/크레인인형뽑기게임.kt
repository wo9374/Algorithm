package com.example.algorithm.level1

class 크레인인형뽑기게임 {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val basket = arrayListOf<Int>() // 뽑은 인형 담을 바구니 배열
        var count = 0                   // 터트린 인형수

        moves.forEachIndexed { moveIndex, i ->
            board.forEach {
                if (it[(i-1)] != 0) {     //뽑기 위치의 인형이 존재할때
                    basket.add(it[(i-1)]) //바구니에 넣기
                    it[(i-1)] = 0         //뽑았으니 뽑기배열의 인형은 삭제( 0 )

                    if (basket.lastIndex != 0){    //바구니 인형이 하나 있지않고 여러개 있을때
                        if (basket[(basket.lastIndex-1)] == basket[basket.lastIndex]){  //전에 넣은 인형과 마지막으로 넣은 인형이 같을때
                            //인형 터트려짐. //직전 넣은 인형과 마지막 넣은 인형 삭제
                            basket.removeAt(basket.lastIndex-1)
                            basket.removeAt(basket.lastIndex)
                            count += 2
                        }
                    }
                    return@forEachIndexed
                }
            }
        }
        return count
    }
}