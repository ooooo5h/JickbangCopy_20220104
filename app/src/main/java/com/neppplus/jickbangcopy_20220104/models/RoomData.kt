package com.neppplus.jickbangcopy_20220104.models

import java.io.Serializable
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class RoomData(
    val price : Int,
    val address : String,
    val floor : Int,
    val description : String,   // 파이썬과 같이, 추가로 들어올 파라미터가 없어도 ,로 마무리해도 됨
) : Serializable {

    fun getFormattedPrice() : String {

//        이 방의 가격이 1억 미만? 1억 이상? 따라 다른 문구 출력
//        1. 1억 미만이면 : 8,000만원 (숫자 세자리마다 컴마 - 구글링) + f'str 처럼 %{}이용해서 가공
        if (this.price < 10000) {

            return "${NumberFormat.getInstance().format(this.price)}만원"
        }

//        2. 그 외 : 2억 8,500만원 (숫자 세자리 컴마) + 억 단위로는 몇 억인지 f'str 처럼 %{}이용해서 가공
        else {

//            몇 억? 28500 => 2 : 28500을 10000으로 나눈 몫(Python : //)
            val uk = this.price / 10000    // 정수를 정수로 나누면, 코틀린이나 자바에서는 결과도 정수로 리턴(자동으로 소수점 버림)

//            천만원? => 컴마
//            28500 => 8500 : 28500을 10000으로 나눈 나머지(공통 : %)
            val rest = this.price % 10000

            return "${uk}억 ${NumberFormat.getInstance().format((rest))}만원"

        }
    }




    fun getFormattedFloor() : String {

        if (this.floor > 0) {
//             2층, 5층, 7층..
            return "${ this.floor }층"
        }
        else if (this.floor < 0) {
//            지하 -1층 -> 지하 1층
            return "지하 ${-this.floor}층"
        }
        else {
//            0은 반지하
            return "반지하"
        }

    }
}