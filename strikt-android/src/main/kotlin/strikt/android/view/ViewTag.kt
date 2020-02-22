package strikt.android.view

import android.view.View
import strikt.api.Assertion

fun <T : View> Assertion.Builder<T>.hasTag(expected: Any?) =
    assert("has tag \"$expected\"", expected = expected) {
        val tag = it.tag
        if (tag == expected) pass() else fail(actual = tag)
    }

fun <T : View> Assertion.Builder<T>.hasTag(expected: Pair<Int, Any?>) =
    assert("has tag ${expected.first} with value \"${expected.second}\"", expected = expected) {
        val tag = it.getTag(expected.first)
        if (tag == expected.second) pass() else fail(actual = tag)
    }

val <T : View> Assertion.Builder<T>.tag
    get() = get(View::getTag)
