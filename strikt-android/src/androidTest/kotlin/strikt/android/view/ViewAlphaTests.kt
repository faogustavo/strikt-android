package strikt.android.view

import org.junit.Test
import strikt.android.BaseTestClass
import strikt.api.expect
import strikt.api.expectCatching
import strikt.api.expectThat
import strikt.assertions.failed
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.message
import java.lang.AssertionError

class ViewAlphaTests : BaseTestClass() {

    @Test
    fun hasAlpha_withSameAlpha_shouldSucceed() {
        val value = 1.0f

        val view = mockView(value)

        expectThat(view).hasAlpha(value)
    }

    @Test
    fun hasAlpha_withOtherValue_shouldFail() {
        val view = mockView(1.0f)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has alpha 0.9 : found 1.0""".trimMargin()

        expectCatching { expectThat(view).hasAlpha(0.9f) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasAlphaGreaterThan_withSameAlpha_shouldSucceed() {
        val view = mockView(1.0f)

        expectThat(view).hasAlphaGreaterThan(0.5f)
    }

    @Test
    fun asAlphaGreaterThan_withOtherValue_shouldFail() {
        val view = mockView(0.5f)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has alpha greater than 1.0 : found 0.5""".trimMargin()

        expectCatching { expectThat(view).hasAlphaGreaterThan(1.0f) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasAlphaLessThan_withSameAlpha_shouldSucceed() {
        val view = mockView(0.5f)

        expectThat(view).hasAlphaLessThan(1.0f)
    }

    @Test
    fun hasAlphaLessThan_withOtherValue_shouldFail() {
        val view = mockView(1.0f)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has alpha less than 0.5 : found 1.0""".trimMargin()

        expectCatching { expectThat(view).hasAlphaLessThan(0.5f) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun alpha_shouldReturnAlphaProperty() {
        val alpha = 1.0f
        val view = mockView(alpha)

        expectThat(view)
            .alpha
            .isEqualTo(alpha)
    }

    private fun mockView(
        alpha: Float = 1.0f
    ) = TestView(context).apply {
        this.alpha = alpha
    }

}