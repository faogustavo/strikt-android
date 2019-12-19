package strikt.android.view

import android.view.View
import strikt.api.Assertion

fun <T : View> Assertion.Builder<T>.hasId(expected: Int) =
    assert("has id $expected", expected = expected) {
        val id = it.id
        if (id == expected) pass() else fail(actual = id)
    }