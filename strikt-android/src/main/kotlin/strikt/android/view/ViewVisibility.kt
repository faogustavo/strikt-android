package strikt.android.view

import android.view.View
import strikt.android.ext.toViewVisibility
import strikt.api.Assertion

fun <T : View> Assertion.Builder<T>.isVisible() =
    assert("is visible", expected = View.VISIBLE) {
        val value = it.visibility
        if (value == View.VISIBLE) pass() else fail(actual = value.toViewVisibility())
    }

fun <T : View> Assertion.Builder<T>.isInvisible() =
    assert("is invisible", expected = View.INVISIBLE) {
        val value = it.visibility
        if (value == View.INVISIBLE) pass() else fail(actual = value.toViewVisibility())
    }

fun <T : View> Assertion.Builder<T>.isGone() =
    assert("is gone", expected = View.GONE) {
        val value = it.visibility
        if (value == View.GONE) pass() else fail(actual = value.toViewVisibility())
    }

fun <T : View> Assertion.Builder<T>.hasVisibility(expected: Int) {
    assert(
        description = "has visibility \"${expected.toViewVisibility()}\"",
        expected = expected
    ) {
        val value = it.visibility
        if (value == expected) pass() else fail(actual = value.toViewVisibility())
    }
}

val <T : View> Assertion.Builder<T>.visibility
    get() = get(View::getVisibility)
