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

class ViewClickTests : BaseTestClass() {

    @Test
    fun isClickable_withClickableView_shouldSucceed() {
        val view = mockView()

        expectThat(view).isClickable()
    }

    @Test
    fun isClickable_withNotClickableView_shouldFail() {
        val view = mockView(isClickable = false)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ is clickable""".trimMargin()
        expectCatching { expectThat(view).isClickable() }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun isLongClickable_withClickableView_shouldSucceed() {
        val view = mockView()

        expectThat(view).isLongClickable()
    }

    @Test
    fun isLongClickable_withNotLongClickableView_shouldFail() {
        val view = mockView(isLongClickable = false)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ is long clickable""".trimMargin()
        expectCatching { expectThat(view).isLongClickable() }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    private fun mockView(
        isClickable: Boolean = true,
        isLongClickable: Boolean = true
    ) = TestView(context).apply {
        this.isClickable = isClickable
        this.isLongClickable = isLongClickable
    }
}