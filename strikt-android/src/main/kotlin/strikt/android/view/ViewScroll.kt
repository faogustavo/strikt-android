package strikt.android.view

import android.annotation.TargetApi
import android.os.Build
import android.view.View
import strikt.android.ext.toViewOverScroll
import strikt.api.Assertion

fun <T : View> Assertion.Builder<T>.hasOverScrollMode(expected: Int) =
    assert(
        "has over scroll mode \"${expected.toViewOverScroll()}\"",
        expected = expected
    ) {
        val overScrollMode = it.overScrollMode
        if (overScrollMode == expected) pass() else fail(actual = overScrollMode.toViewOverScroll())
    }

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
fun <T : View> Assertion.Builder<T>.hasScrollBarDefaultDelayBeforeFade(expected: Int) =
    assert(
        "has scroll bar default delay before fade $expected",
        expected = expected
    ) {
        val delay = it.scrollBarDefaultDelayBeforeFade
        if (delay == expected) pass() else fail(actual = delay)
    }

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
fun <T : View> Assertion.Builder<T>.hasScrollBarFadeDuration(expected: Int) =
    assert(
        "has scroll bar fade duration $expected",
        expected = expected
    ) {
        val duration = it.scrollBarFadeDuration
        if (duration == expected) pass() else fail(actual = duration)
    }

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
fun <T : View> Assertion.Builder<T>.hasScrollX(expected: Int) =
    assert(
        "has scroll X $expected",
        expected = expected
    ) {
        val scroll = it.scrollX
        if (scroll == expected) pass() else fail(actual = scroll)
    }

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
fun <T : View> Assertion.Builder<T>.hasScrollY(expected: Int) =
    assert(
        "has scroll Y $expected",
        expected = expected
    ) {
        val scroll = it.scrollY
        if (scroll == expected) pass() else fail(actual = scroll)
    }
