package com.think.domain.global

import com.think.domain.domain.wiseSaying.controller.WiseSayingController
import com.think.domain.domain.wiseSaying.repository.WiseSayingFileRepository
import com.think.domain.domain.wiseSaying.repository.WiseSayingMemRepository
import com.think.domain.domain.wiseSaying.service.WiseSayingService

object SingletonBean {
    val wiseSayingMemRepository by lazy { WiseSayingMemRepository() }
    val wiseSayingFileRepository by lazy { WiseSayingFileRepository() }
    val wiseSayingService by lazy { WiseSayingService(wiseSayingFileRepository) }
    val wiseSayingController by lazy { WiseSayingController(wiseSayingService) }
}