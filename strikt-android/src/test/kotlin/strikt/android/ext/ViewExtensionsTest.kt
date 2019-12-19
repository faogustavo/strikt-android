package strikt.android.ext

import android.view.View
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class ViewExtensionsTest {

    @Test
    fun toViewVisibility_shouldMatch() {
        expectThat(View.VISIBLE.toViewVisibility())
            .isEqualTo(VIEW_VISIBLE)

        expectThat(View.INVISIBLE.toViewVisibility())
            .isEqualTo(VIEW_INVISIBLE)

        expectThat(View.GONE.toViewVisibility())
            .isEqualTo(VIEW_GONE)

        expectThat(7895.toViewVisibility())
            .isEqualTo(VIEW_UNKNOWNN)
    }

    @Test
    fun toViewOverScroll_shouldMatch() {
        expectThat(View.OVER_SCROLL_ALWAYS.toViewOverScroll())
            .isEqualTo(VIEW_OVER_SCROLL_ALWAYS)

        expectThat(View.OVER_SCROLL_IF_CONTENT_SCROLLS.toViewOverScroll())
            .isEqualTo(VIEW_OVER_SCROLL_IF_CONTENT_SCROLL)

        expectThat(View.OVER_SCROLL_NEVER.toViewOverScroll())
            .isEqualTo(VIEW_OVER_SCROLL_NEVER)

        expectThat(7895.toViewOverScroll())
            .isEqualTo(VIEW_UNKNOWNN)
    }
}