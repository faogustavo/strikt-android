package strikt.android.ext

import android.view.View

fun Int.toViewVisibility() = when(this) {
    View.VISIBLE -> "Visible"
    View.INVISIBLE -> "Invisible"
    View.GONE -> "Gone"
    else -> "Unknown"
}