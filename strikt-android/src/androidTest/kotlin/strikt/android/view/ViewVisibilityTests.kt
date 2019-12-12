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

class ViewVisibilityTests : BaseTestClass() {

    @Test
    fun isVisible_withVisibleView_shouldSucceed() {
        val subject = mockView(visibility = View.VISIBLE)

        expectThat(subject).isVisible()
    }

    @Test
    fun isInvisible_withInvisibleView_shouldSucceed() {
        val subject = mockView(visibility = View.INVISIBLE)

        expectThat(subject).isInvisible()
    }

    @Test
    fun isGone_withGoneView_shouldSucceed() {
        val subject = mockView(visibility = View.GONE)

        expectThat(subject).isGone()
    }

    @Test
    fun hasVisibility_withRightVisibility_shouldSucceed() {
        val subject = mockView(visibility = View.VISIBLE)

        expectThat(subject).hasVisibility(View.VISIBLE)
    }

    @Test
    fun isVisible_withOtherVisibility_shouldFail() {
        val subject = mockView(visibility = View.GONE)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ is visible : found "GONE"""".trimMargin()

        expectCatching { expectThat(subject).isVisible() }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun isInvisible_withOtherVisibility_shouldFail() {
        val subject = mockView(visibility = View.VISIBLE)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ is invisible : found "VISIBLE"""".trimMargin()

        expectCatching { expectThat(subject).isInvisible() }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun isGone_withOtherVisibility_shouldFail() {
        val subject = mockView(visibility = View.INVISIBLE)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ is gone : found "INVISIBLE"""".trimMargin()

        expectCatching { expectThat(subject).isGone() }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasVisibility_withWrongVisibility_shouldFail() {
        val subject = mockView(visibility = View.INVISIBLE)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has visibility "VISIBLE" : found "INVISIBLE"""".trimMargin()

        expectCatching { expectThat(subject).hasVisibility(View.VISIBLE) }
            .failed()
            .isA<java.lang.AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    private fun mockView(
        visibility: Int = View.VISIBLE
    ) = TestView(context).apply {
        this.visibility = visibility
    }
}
