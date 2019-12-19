package strikt.android.view

import android.annotation.TargetApi
import android.os.Build
import android.view.View
import strikt.api.Assertion

fun <T : View> Assertion.Builder<T>.hasLeftPadding(expected: Int) =
    assert("has left padding $expected") {
        val padding = it.paddingLeft
        if (padding == expected) pass() else fail(actual = padding)
    }

fun <T : View> Assertion.Builder<T>.hasRightPadding(expected: Int) =
    assert("has right padding $expected") {
        val padding = it.paddingRight
        if (padding == expected) pass() else fail(actual = padding)
    }

fun <T : View> Assertion.Builder<T>.hasTopPadding(expected: Int) =
    assert("has top padding $expected") {
        val padding = it.paddingTop
        if (padding == expected) pass() else fail(actual = padding)
    }

fun <T : View> Assertion.Builder<T>.hasBottomPadding(expected: Int) =
    assert("has bottom padding $expected") {
        val padding = it.paddingBottom
        if (padding == expected) pass() else fail(actual = padding)
    }

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
fun <T : View> Assertion.Builder<T>.hasStartPadding(expected: Int) =
    assert("has start padding $expected") {
        val padding = it.paddingStart
        if (padding == expected) pass() else fail(actual = padding)
    }

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
fun <T : View> Assertion.Builder<T>.hasEndPadding(expected: Int) =
    assert("has end padding $expected") {
        val padding = it.paddingEnd
        if (padding == expected) pass() else fail(actual = padding)
    }