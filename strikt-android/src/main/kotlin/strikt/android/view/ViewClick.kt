package strikt.android.view

import android.view.View
import strikt.api.Assertion

fun <T : View> Assertion.Builder<T>.isClickable() =
    assert("is clickable") {
        if (it.isClickable) pass() else fail()
    }

fun <T : View> Assertion.Builder<T>.isLongClickable() =
    assert("is long clickable") {
        if (it.isLongClickable) pass() else fail()
    }
