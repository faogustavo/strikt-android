package strikt.android.sample

import org.junit.Test
import strikt.api.*
import strikt.assertions.*

class StriktAndroidTest {
    @Test
    fun name() {
        expectThat(1).isNotEqualTo(2)
    }
}