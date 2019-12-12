package strikt.android.ext

import android.view.View

fun Int.toViewVisibility() = when(this) {
    View.VISIBLE -> "VISIBLE"
    View.INVISIBLE -> "INVISIBLE"
    View.GONE -> "GONE"
    else -> "Unknown"
}