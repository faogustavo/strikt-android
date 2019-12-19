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

class ViewElevationTests : BaseTestClass() {

    @Test
    fun hasElevation_withSameElevation_shouldSucceed() {
        val value = 1.0f

        val view = mockView(value)

        expectThat(view).hasElevation(value)
    }

    @Test
    fun hasElevation_withOtherValue_shouldFail() {
        val view = mockView(1.0f)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has elevation 5.0 : found 1.0""".trimMargin()

        expectCatching { expectThat(view).hasElevation(5.0f) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasElevationGreaterThan_withSameElevation_shouldSucceed() {
        val view = mockView(5.0f)

        expectThat(view).hasElevationGreaterThan(1.0f)
    }

    @Test
    fun asElevationGreaterThan_withOtherValue_shouldFail() {
        val view = mockView(1.0f)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has elevation greater than 5.0 : found 1.0""".trimMargin()

        expectCatching { expectThat(view).hasElevationGreaterThan(5.0f) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasElevationLessThan_withSameElevation_shouldSucceed() {
        val view = mockView(1.0f)

        expectThat(view).hasElevationLessThan(5.0f)
    }

    @Test
    fun hasElevationLessThan_withOtherValue_shouldFail() {
        val view = mockView(5.0f)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has elevation less than 1.0 : found 5.0""".trimMargin()

        expectCatching { expectThat(view).hasElevationLessThan(1.0f) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    private fun mockView(
        elevation: Float = 1.0f
    ) = TestView(context).apply {
        this.elevation = elevation
    }
}