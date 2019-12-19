package strikt.android.view

import android.view.View
import strikt.android.ext.simpleAssert
import strikt.api.Assertion

fun <T : View> Assertion.Builder<T>.isFocusable() =
    simpleAssert("is focusable") { it.isFocusable }

fun <T : View> Assertion.Builder<T>.isFocused() =
    simpleAssert("is focused") { it.isFocused }