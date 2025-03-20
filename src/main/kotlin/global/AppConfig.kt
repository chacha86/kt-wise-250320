package com.think.domain.global

import java.nio.file.Path

object AppConfig {
    private var mode = "dev"

    fun setTestMode() {
        mode = "test"
    }

    fun setDevMode() {
        mode = "dev"
    }

    val dbDirPath: Path
        get() = Path.of("data/db/${mode}")

}