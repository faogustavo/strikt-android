package strikt.android.view

import android.view.View
import org.junit.Test
import strikt.android.BaseTestClass
import strikt.api.expectCatching
import strikt.api.expectThat
import strikt.assertions.failed
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.message

class ViewScrollTest : BaseTestClass() {

    @Test
    fun hasOverScrollMode_withCorrectScrollMode_shouldSucceed() {
        val expectedValue = View.OVER_SCROLL_ALWAYS

        val view = mockView(overScrollMode = expectedValue)

        expectThat(view).hasOverScrollMode(expectedValue)
    }

    @Test
    fun hasOverScrollMode_withIncorrectScrollMode_shouldFail() {
        val view = mockView(overScrollMode = View.OVER_SCROLL_NEVER)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has over scroll mode "Always" : found "Never"""".trimMargin()
        expectCatching { expectThat(view).hasOverScrollMode(View.OVER_SCROLL_ALWAYS) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasScrollBarDefaultDelayBeforeFade_withCorrectScrollMode_shouldSucceed() {
        val expectedValue = 300

        val view = mockView(scrollBarDefaultDelayBeforeFade = expectedValue)

        expectThat(view).hasScrollBarDefaultDelayBeforeFade(expectedValue)
    }

    @Test
    fun hasScrollBarDefaultDelayBeforeFade_withIncorrectScrollMode_shouldFail() {
        val view = mockView(scrollBarDefaultDelayBeforeFade = 100)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has scroll bar default delay before fade 300 : found 100""".trimMargin()
        expectCatching { expectThat(view).hasScrollBarDefaultDelayBeforeFade(300) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasScrollBarFadeDuration_withCorrectScrollMode_shouldSucceed() {
        val expectedValue = 300

        val view = mockView(scrollBarFadeDuration = expectedValue)

        expectThat(view).hasScrollBarFadeDuration(expectedValue)
    }

    @Test
    fun hasScrollBarFadeDuration_withIncorrectScrollMode_shouldFail() {
        val view = mockView(scrollBarFadeDuration = 200)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has scroll bar fade duration 100 : found 200""".trimMargin()
        expectCatching { expectThat(view).hasScrollBarFadeDuration(100) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasScrollX_withCorrectScrollMode_shouldSucceed() {
        val expectedValue = 50

        val view = mockView(scrollX = expectedValue)

        expectThat(view).hasScrollX(expectedValue)
    }

    @Test
    fun hasScrollX_withIncorrectScrollMode_shouldFail() {
        val view = mockView(scrollX = 100)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has scroll X 50 : found 100""".trimMargin()
        expectCatching { expectThat(view).hasScrollX(50) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasScrollY_withCorrectScrollMode_shouldSucceed() {
        val expectedValue = 50

        val view = mockView(scrollY = expectedValue)

        expectThat(view).hasScrollY(expectedValue)
    }

    @Test
    fun hasScrollY_withIncorrectScrollMode_shouldFail() {
        val view = mockView(scrollY = 100)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has scroll Y 50 : found 100""".trimMargin()
        expectCatching { expectThat(view).hasScrollY(50) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    private fun mockView(
        overScrollMode: Int = View.OVER_SCROLL_ALWAYS,
        scrollBarDefaultDelayBeforeFade: Int = 300,
        scrollBarFadeDuration: Int = 250,
        scrollX: Int = 100,
        scrollY: Int = 100
    ) = TestView(context).apply {
        this.overScrollMode = overScrollMode
        this.scrollBarDefaultDelayBeforeFade = scrollBarDefaultDelayBeforeFade
        this.scrollBarFadeDuration = scrollBarFadeDuration
        this.scrollX = scrollX
        this.scrollY = scrollY
    }
}