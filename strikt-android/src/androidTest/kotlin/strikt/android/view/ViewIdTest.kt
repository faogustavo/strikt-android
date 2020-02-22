package strikt.android.view

import org.junit.Test
import strikt.android.BaseTestClass
import strikt.api.expectCatching
import strikt.api.expectThat
import strikt.assertions.failed
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.message
import java.lang.AssertionError
import kotlin.random.Random

class ViewIdTest : BaseTestClass() {

    @Test
    fun hasId_withId_shouldSucceed() {
        val expectedValue = Random(System.currentTimeMillis()).nextInt()

        val view = mockView(expectedValue)

        expectThat(view).hasId(expectedValue)
    }

    @Test
    fun hasId_withOtherId_shouldFail() {
        val id = Random(System.currentTimeMillis()).nextInt()
        val view = mockView(id)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has id 12345 : found $id""".trimMargin()
        expectCatching { expectThat(view).hasId(12345) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun id_shouldReturnIdProperty() {
        val id = Random(System.currentTimeMillis()).nextInt()
        val view = mockView(id)

        expectThat(view)
            .id
            .isEqualTo(id)
    }

    private fun mockView(id: Int) = TestView(context).apply {
        this.id = id
    }
}
