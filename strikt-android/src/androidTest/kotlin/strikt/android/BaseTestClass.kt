package strikt.android

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry

open class BaseTestClass {
    val context: Context by lazy { InstrumentationRegistry.getInstrumentation().context }
}
