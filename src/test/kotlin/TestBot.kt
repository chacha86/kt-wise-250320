
import com.think.domain.App
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class TestBot {
    companion object {

        val originalIn = System.`in`
        val originalOut = System.out

        fun run(input: String): String {
            val formattedInput = input.trimIndent().plus("\n종료")

            return ByteArrayOutputStream().use { out ->
                try {
                    val testOut = PrintStream(out)
                    System.setIn(formattedInput.byteInputStream())
                    System.setOut(testOut)

                    App().run()

                } finally {
                    System.setIn(originalIn)
                    System.setOut(originalOut)
                }

                out.toString().trim().replace("\r\n", "\n")
            }
        }
    }
}