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
        val view = mockView(visibility = View.VISIBLE)

        expectThat(view).isVisible()
    }

    @Test
    fun isInvisible_withInvisibleView_shouldSucceed() {
        val view = mockView(visibility = View.INVISIBLE)

        expectThat(view).isInvisible()
    }

    @Test
    fun isGone_withGoneView_shouldSucceed() {
        val view = mockView(visibility = View.GONE)

        expectThat(view).isGone()
    }

    @Test
    fun hasVisibility_withRightVisibility_shouldSucceed() {
        val view = mockView(visibility = View.VISIBLE)

        expectThat(view).hasVisibility(View.VISIBLE)
    }

    @Test
    fun isVisible_withOtherVisibility_shouldFail() {
        val view = mockView(visibility = View.GONE)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ is visible : found "GONE"""".trimMargin()

        expectCatching { expectThat(view).isVisible() }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun isInvisible_withOtherVisibility_shouldFail() {
        val view = mockView(visibility = View.VISIBLE)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ is invisible : found "VISIBLE"""".trimMargin()

        expectCatching { expectThat(view).isInvisible() }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun isGone_withOtherVisibility_shouldFail() {
        val view = mockView(visibility = View.INVISIBLE)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ is gone : found "INVISIBLE"""".trimMargin()

        expectCatching { expectThat(view).isGone() }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun visibility_returnsVisibilityProperty() {
        val visibility = View.GONE
        val view = mockView(visibility = visibility)

        expectThat(view)
            .visibility
            .isEqualTo(visibility)
    }

    @Test
    fun hasVisibility_withWrongVisibility_shouldFail() {
        val view = mockView(visibility = View.INVISIBLE)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has visibility "VISIBLE" : found "INVISIBLE"""".trimMargin()

        expectCatching { expectThat(view).hasVisibility(View.VISIBLE) }
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
