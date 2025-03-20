package com.think.domain

import com.think.domain.domain.wiseSaying.controller.WiseSayingController
import com.think.domain.global.Request
import com.think.domain.global.SingletonBean

class App(
    private val wiseSayingController: WiseSayingController = SingletonBean.wiseSayingController
) {

    fun run() {
        println("== 명언 앱 ==")
        while (true) {
            print("명령) ")
            val input = readlnOrNull() ?: ""

            val rq = Request(input)

            when (rq.actionName) {
                "종료" -> break
                "등록" -> wiseSayingController.write()
                "목록" -> wiseSayingController.list()
                "삭제" -> wiseSayingController.remove(rq)
                "수정" -> wiseSayingController.modify(rq)
                else -> println("알 수 없는 명령입니다.")
            }
        }
    }
}