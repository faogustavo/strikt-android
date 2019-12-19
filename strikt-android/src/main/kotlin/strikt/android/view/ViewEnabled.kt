package strikt.android.view

import android.view.View
import strikt.android.ext.simpleAssert
import strikt.api.Assertion

fun <T : View> Assertion.Builder<T>.isEnabled() =
    simpleAssert("is enabled") { it.isEnabled }

fun <T : View> Assertion.Builder<T>.isSoundEffectsEnabled() =
    simpleAssert("is sound effects enabled") { it.isSoundEffectsEnabled }

fun <T : View> Assertion.Builder<T>.isHapticFeedbackEnabled() =
    simpleAssert("is haptic feedback enabled") { it.isHapticFeedbackEnabled }