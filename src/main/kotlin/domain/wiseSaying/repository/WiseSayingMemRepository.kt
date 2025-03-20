package com.think.domain.domain.wiseSaying.repository

import com.think.domain.domain.wiseSaying.entity.WiseSaying

class WiseSayingMemRepository(
    private var lastId: Int = 0,
    private val wiseSayings: MutableList<WiseSaying> = mutableListOf()
) : WiseSayingRepository {
    override fun save(wiseSaying: WiseSaying): WiseSaying {

        if(wiseSaying.isNew()) {
            val new = wiseSaying.copy(id = ++lastId)
            wiseSayings.add(new)
            return new
        }

        wiseSayings.indexOfFirst { it.id == wiseSaying.id }.let {
            wiseSayings[it] = wiseSaying
        }

        return wiseSaying
    }

    override fun findAll(): List<WiseSaying> {
        return wiseSayings.toList()
    }

    override fun findById(id: Int): WiseSaying? {
        return wiseSayings.find { it.id == id }
    }

    override fun delete(wiseSaying: WiseSaying) {
        wiseSayings.remove(wiseSaying)
    }

    override fun clear() {
        wiseSayings.clear()
        lastId = 0
    }

    override fun initDb() {
        clear()
    }
}