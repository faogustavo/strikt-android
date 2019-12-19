package strikt.android.view

import android.content.Context
import android.view.View
import android.widget.LinearLayout

class TestContainer(context: Context, private val id: String = "") : LinearLayout(context) {
    override fun toString() = "TestContainer($id)"
}

class TestView(context: Context, private val id: String = "") : View(context) {
    override fun toString() = "TestView($id)"
}