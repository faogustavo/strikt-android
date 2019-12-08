package strikt.android

import android.view.View
import strikt.android.ext.toViewVisibility
import strikt.api.Assertion

fun <T : View> Assertion.Builder<T>.isVisible() =
    assert("is visible") {
        val value = it.visibility
        if (value == View.VISIBLE) pass() else fail(actual = value.toViewVisibility())
    }

fun <T : View> Assertion.Builder<T>.isInvisible() =
    assert("is invisible") {
        val value = it.visibility
        if (value == View.INVISIBLE) pass() else fail(actual = value.toViewVisibility())
    }

fun <T : View> Assertion.Builder<T>.isGone() =
    assert("is gone") {
        val value = it.visibility
        if (value == View.GONE) pass() else fail(actual = value.toViewVisibility())
    }

fun <T : View> Assertion.Builder<T>.hasVisibility(expected: Int) {
    assert("has visibility", expected = expected.toViewVisibility()) {
        val value = it.visibility
        if (value == expected) pass() else fail(actual = value.toViewVisibility())
    }
}