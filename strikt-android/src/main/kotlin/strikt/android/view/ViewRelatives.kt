package strikt.android.view

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import strikt.android.ext.simpleAssert
import strikt.api.Assertion

fun <T : View> Assertion.Builder<T>.hasParent(expected: View) =
    assert("has parent $expected", expected = expected) {
        val id = it.parent
        if (id == expected) pass() else fail()
    }

fun <T : ViewGroup> Assertion.Builder<T>.hasChild() =
    simpleAssert("has a child") { it.childCount > 0 }

fun <T : ViewGroup> Assertion.Builder<T>.hasChild(view: View) =
    simpleAssert("has child $view") { it.children.any { it == view } }

fun <E : View, T : ViewGroup> Assertion.Builder<T>.hasChild(clazz: Class<E>) =
    simpleAssert("has child with type $clazz") { it.children.any { clazz.isInstance(it) } }

fun <T : ViewGroup> Assertion.Builder<T>.hasChildCount(expected: Int) =
    assert("has $expected child", expected = expected) {
        val count = it.childCount
        if (count == expected) pass() else fail(actual = count)
    }

val <T : View> Assertion.Builder<T>.parent
    get() = get(View::getParent)

val <T : ViewGroup> Assertion.Builder<T>.children
    get() = get(ViewGroup::children)

