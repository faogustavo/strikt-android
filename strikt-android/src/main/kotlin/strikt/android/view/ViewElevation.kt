package strikt.android.view

import android.annotation.TargetApi
import android.os.Build
import android.view.View
import strikt.api.Assertion

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun <T : View> Assertion.Builder<T>.hasElevation(expected: Float) =
    assert("has elevation $expected", expected = expected) {
        val elevation = it.elevation
        if (elevation == expected) pass() else fail(actual = elevation)
    }

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun <T : View> Assertion.Builder<T>.hasElevationGreaterThan(expected: Float) =
    assert("has elevation greater than $expected", expected = expected) {
        val elevation = it.elevation
        if (elevation > expected) pass() else fail(actual = elevation)
    }

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
fun <T : View> Assertion.Builder<T>.hasElevationLessThan(expected: Float) =
    assert("has elevation less than $expected", expected = expected) {
        val elevation = it.elevation
        if (elevation < expected) pass() else fail(actual = elevation)
    }

val <T : View> Assertion.Builder<T>.elevation
    get() = get(View::getElevation)
