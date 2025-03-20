package domain.wiseSaying.repository

import com.think.domain.domain.wiseSaying.entity.WiseSaying
import com.think.domain.global.AppConfig
import com.think.domain.global.SingletonBean
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WiseSayingFileRepositoryTest {

    private val wiseSayingRepository = SingletonBean.wiseSayingFileRepository

    companion object {
        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            AppConfig.setTestMode()
        }
    }


    @BeforeEach
    fun setUp() {
        wiseSayingRepository.clear()
        wiseSayingRepository.initDb()
    }

    @Test
    fun `save`() {
        val wiseSaying = wiseSayingRepository
            .save(WiseSaying(saying = "인생은 짧고, 예술은 길다.", author = "헨리 장"))

        val filePath = wiseSayingRepository
            .tableDirPath
            .toFile()
            .listFiles()
            ?.find { it.name == "${wiseSaying.id}.json" }

        assertThat(filePath).isNotNull
    }
}