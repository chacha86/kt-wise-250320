package com.think.domain.domain.wiseSaying.service

import com.think.domain.domain.wiseSaying.entity.WiseSaying
import com.think.domain.domain.wiseSaying.repository.WiseSayingRepository
import com.think.domain.global.SingletonBean.wiseSayingMemRepository

class WiseSayingService(
    private val wiseSayingRepository: WiseSayingRepository
) {
    fun write(saying: String, author: String): WiseSaying {
        WiseSaying(saying = saying, author = author).let {
            return wiseSayingRepository.save(it)
        }
    }

    fun getItems(): List<WiseSaying> {
        return wiseSayingRepository.findAll()
    }

    fun getItem(id: Int): WiseSaying? {
        return wiseSayingRepository.findById(id)
    }

    fun delete(wiseSaying: WiseSaying) {
        wiseSayingRepository.delete(wiseSaying)
    }

    fun modify(wiseSaying: WiseSaying, saying: String, author: String): WiseSaying {
        return wiseSayingRepository.save(wiseSaying.copy(saying = saying, author = author))
    }
}