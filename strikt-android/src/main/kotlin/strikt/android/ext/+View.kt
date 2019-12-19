package strikt.android.ext

import android.view.View

const val VIEW_UNKNOWNN = "Unknown"

const val VIEW_VISIBLE = "VISIBLE"
const val VIEW_INVISIBLE = "INVISIBLE"
const val VIEW_GONE = "GONE"

const val VIEW_OVER_SCROLL_ALWAYS = "Always"
const val VIEW_OVER_SCROLL_IF_CONTENT_SCROLL = "If content scrolls"
const val VIEW_OVER_SCROLL_NEVER = "Never"

fun Int.toViewVisibility() = when(this) {
    View.VISIBLE -> VIEW_VISIBLE
    View.INVISIBLE -> VIEW_INVISIBLE
    View.GONE -> VIEW_GONE
    else -> VIEW_UNKNOWNN
}

fun Int.toViewOverScroll() = when (this) {
    View.OVER_SCROLL_ALWAYS -> VIEW_OVER_SCROLL_ALWAYS
    View.OVER_SCROLL_IF_CONTENT_SCROLLS -> VIEW_OVER_SCROLL_IF_CONTENT_SCROLL
    View.OVER_SCROLL_NEVER -> VIEW_OVER_SCROLL_NEVER
    else -> VIEW_UNKNOWNN
}