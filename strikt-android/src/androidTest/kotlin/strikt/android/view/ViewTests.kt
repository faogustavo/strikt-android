package strikt.android.view

import android.view.View
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import strikt.android.BaseTestClass
import strikt.api.expectCatching
import strikt.api.expectThat
import strikt.assertions.failed
import strikt.assertions.isA

@RunWith(AndroidJUnit4::class)
class ViewTests : BaseTestClass() {

    @Test
    fun isVisible_withVisibleView_shouldSucceed() {
        val subject = mockView(visibility = View.VISIBLE)

        expectThat(subject).isVisible()
    }

    @Test
    fun isVisible_withInvisibleView_shouldFail() {
        val subject = mockView(visibility = View.INVISIBLE)

        expectCatching { expectThat(subject).isVisible() }
            .failed()
            .isA<AssertionError>()
    }

    @Test
    fun isVisible_withGoneView_shouldFail() {
        val subject = mockView(visibility = View.GONE)

        expectCatching { expectThat(subject).isVisible() }
            .failed()
            .isA<AssertionError>()
    }

    @Test
    fun isInvisible_withVisibleView_shouldFail() {
        val subject = mockView(visibility = View.VISIBLE)

        expectCatching { expectThat(subject).isInvisible() }
            .failed()
            .isA<AssertionError>()
    }

    @Test
    fun isInvisible_withInvisibleView_shouldSucceed() {
        val subject = mockView(visibility = View.INVISIBLE)

        expectThat(subject).isInvisible()
    }

    @Test
    fun isInvisible_withGoneView_shouldFail() {
        val subject = mockView(visibility = View.GONE)

        expectCatching { expectThat(subject).isInvisible() }
            .failed()
            .isA<AssertionError>()
    }

    @Test
    fun isGone_withVisibleView_shouldFail() {
        val subject = mockView(visibility = View.VISIBLE)

        expectCatching { expectThat(subject).isGone() }
            .failed()
            .isA<AssertionError>()
    }

    @Test
    fun isGone_withInvisibleView_shouldFail() {
        val subject = mockView(visibility = View.INVISIBLE)

        expectCatching { expectThat(subject).isGone() }
            .failed()
            .isA<AssertionError>()
    }

    @Test
    fun isGone_withGoneView_shouldSucceed() {
        val subject = mockView(visibility = View.GONE)

        expectThat(subject).isGone()
    }

    @Test
    fun hasVisibility_withVisibility_shouldSuceed() {
        val subject = mockView(visibility = View.VISIBLE)

        expectThat(subject).hasVisibility(View.VISIBLE)
    }

    @Test
    fun hasVisibility_withoutVisibility_shouldFail() {
        val subject = mockView(visibility = View.VISIBLE)

        expectCatching { expectThat(subject).hasVisibility(View.GONE) }
            .failed()
            .isA<AssertionError>()
    }

    private fun mockView(
        visibility: Int
    ) = View(context).apply {
        this.visibility = visibility
    }
}
