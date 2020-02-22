package strikt.android.view

import android.view.View
import strikt.api.Assertion
import strikt.api.expect

fun <T : View> Assertion.Builder<T>.hasAlpha(expected: Float) =
    assert("has alpha $expected", expected = expected) {
        val alpha = it.alpha
        if (alpha == expected) pass() else fail(actual = alpha)
    }

fun <T : View> Assertion.Builder<T>.hasAlphaGreaterThan(expected: Float) =
    assert("has alpha greater than $expected", expected = expected) {
        val alpha = it.alpha
        if (alpha > expected) pass() else fail(actual = alpha)
    }

fun <T : View> Assertion.Builder<T>.hasAlphaLessThan(expected: Float) =
    assert("has alpha less than $expected", expected = expected) {
        val alpha = it.alpha
        if (alpha < expected) pass() else fail(actual = alpha)
    }

val <T : View> Assertion.Builder<T>.alpha
    get() = get(View::getAlpha)