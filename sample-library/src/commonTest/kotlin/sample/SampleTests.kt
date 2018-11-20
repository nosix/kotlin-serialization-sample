package sample

import kotlin.test.Test
import kotlin.test.assertTrue

expect fun isWorking(): Boolean

class SampleTests {

    @Test
    fun testIsWorking() {
        assertTrue(isWorking())
    }
}
