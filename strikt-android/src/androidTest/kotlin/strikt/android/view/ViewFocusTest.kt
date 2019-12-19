package strikt.android.view

import org.junit.Assert.*
import org.junit.Test
import strikt.android.BaseTestClass
import strikt.api.expectCatching
import strikt.api.expectThat
import strikt.assertions.failed
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.message
import java.lang.AssertionError

class ViewFocusTest : BaseTestClass() {

    @Test
    fun isFocusable_withFocusableView_shouldSucceed() {
        val view = mockView()

        expectThat(view).isFocusable()
    }

    @Test
    fun isFocusable_withoutFocusableView_shouldSucceed() {
        val view = mockView(isFocusable = false)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ is focusable""".trimMargin()
        expectCatching { expectThat(view).isFocusable() }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun isFocused_withFocusedView_shouldSucceed() {
        val view = mockView()

        expectThat(view).isFocused()
    }

    @Test
    fun isFocused_withoutFocusedView_shouldSucceed() {
        val view = mockView(isFocused = false)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ is focused""".trimMargin()
        expectCatching { expectThat(view).isFocused() }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    fun mockView(
        isFocusable: Boolean = true,
        isFocused: Boolean = true
    ) = TestView(context).apply  {
        this.isFocusable = isFocusable
        if (isFocused) this.requestFocus()
    }
}