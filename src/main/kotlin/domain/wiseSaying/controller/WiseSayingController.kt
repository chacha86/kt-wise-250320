package com.think.domain.domain.wiseSaying.controller

import com.think.domain.domain.wiseSaying.entity.WiseSaying
import com.think.domain.domain.wiseSaying.service.WiseSayingService
import com.think.domain.global.Request

class WiseSayingController(
    private val wiseSayingService: WiseSayingService
) {


    fun write(): WiseSaying {

        print("명언: ")
        val saying = readlnOrNull() ?: ""
        print("작가: ")
        val author = readlnOrNull() ?: ""

        return wiseSayingService.write(saying, author).also {
            println("${it.id}번 명언이 등록되었습니다.")
        }
    }

    fun list() {
        println("번호 / 작가 / 명언")
        println("----------------------")
        wiseSayingService.getItems().forEach {
            println("${it.id} / ${it.author} / ${it.saying}")
        }
    }

    fun remove(rq: Request) {
        val id = rq.getParam("id")?.toIntOrNull()

        if (id == null) {
            println("삭제할 명언의 번호를 입력해주세요.")
            return
        }

        wiseSayingService.getItem(id)?.let {
            wiseSayingService.delete(it)
            println("${id}번 명언을 삭제했습니다.")
        } ?: println("${id}번 명언은 존재하지 않습니다.")
    }


    fun modify(rq: Request) {
        val id = rq.getParam("id")?.toIntOrNull()

        if (id == null) {
            println("수정할 명언의 번호를 입력해주세요.")
            return
        }

        wiseSayingService.getItem(id)?.let {
            print("새로운 명언: ")
            val saying = readlnOrNull() ?: ""
            print("새로운 작가: ")
            val author = readlnOrNull() ?: ""

            wiseSayingService.modify(it, saying, author)
            println("${id}번 명언을 수정했습니다.")
        } ?: println("${id}번 명언은 존재하지 않습니다.")
    }
}