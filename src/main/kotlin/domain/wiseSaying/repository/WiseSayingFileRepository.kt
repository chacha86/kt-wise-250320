package com.think.domain.domain.wiseSaying.repository

import com.think.domain.domain.wiseSaying.entity.WiseSaying
import com.think.domain.global.AppConfig
import java.nio.file.Path

class WiseSayingFileRepository(
    private var lastId: Int = 0,
//    private val wiseSayings: MutableList<WiseSaying> = mutableListOf()
) : WiseSayingRepository {

    init {
        initDb()
    }

    val tableDirPath: Path
        get() = AppConfig.dbDirPath.resolve("wiseSaying")

    private fun saveOnDisk(wiseSaying: WiseSaying) {
        tableDirPath.resolve("${wiseSaying.id}.json").toFile().writeText(wiseSaying.jsonStr)
    }

    override fun save(wiseSaying: WiseSaying): WiseSaying {

        if (wiseSaying.isNew()) {
            val new = wiseSaying.copy(id = ++lastId)
            saveOnDisk(new)
            return new
        }

        saveOnDisk(wiseSaying)
        return wiseSaying
    }

    override fun findAll(): List<WiseSaying> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Int): WiseSaying? {
        TODO("Not yet implemented")
    }

    override fun delete(wiseSaying: WiseSaying) {
        TODO("Not yet implemented")
    }

    override fun clear() {
        tableDirPath.toFile().deleteRecursively()
    }

    override fun initDb() {
        tableDirPath.toFile().run {
            if (!exists()) {
                mkdirs()
            }
        }
    }
//
//    fun findAll(): List<WiseSaying> {
//        return wiseSayings.toList()
//    }
//
//    fun findById(id: Int): WiseSaying? {
//        return wiseSayings.find { it.id == id }
//    }
//
//    fun delete(wiseSaying: WiseSaying) {
//        wiseSayings.remove(wiseSaying)
//    }
//
//    fun clear() {
//        wiseSayings.clear()
//        lastId = 0
//    }

}