package strikt.android.view

import org.junit.Test
import strikt.android.BaseTestClass
import strikt.api.expectCatching
import strikt.api.expectThat
import strikt.assertions.failed
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.message
import java.lang.AssertionError

class ViewEnabledTest : BaseTestClass() {

    @Test
    fun isEnable_withEnabledView_shouldSucceed() {
        val view = mockView()

        expectThat(view).isEnabled()
    }

    @Test
    fun isEnable_withDisabledView_shouldFail() {
        val view = mockView(isEnabled = false)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ is enabled""".trimMargin()
        expectCatching { expectThat(view).isEnabled() }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun isSoundEffectsEnabled_withEnabledView_shouldSucceed() {
        val view = mockView()

        expectThat(view).isSoundEffectsEnabled()
    }

    @Test
    fun isSoundEffectsEnabled_withDisabledSoundEffects_shouldFail() {
        val view = mockView(isSoundEffectsEnabled = false)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ is sound effects enabled""".trimMargin()
        expectCatching { expectThat(view).isSoundEffectsEnabled() }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun isHapticFeedbackEnabled_withEnabledView_shouldSucceed() {
        val view = mockView()

        expectThat(view).isHapticFeedbackEnabled()
    }

    @Test
    fun isHapticFeedbackEnabled_withDisabledHapticFeedback_shouldFail() {
        val view = mockView(isHapticFeedbackEnabled = false)

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ is haptic feedback enabled""".trimMargin()
        expectCatching { expectThat(view).isHapticFeedbackEnabled() }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }



    private fun mockView(
        isEnabled: Boolean = true,
        isSoundEffectsEnabled: Boolean = true,
        isHapticFeedbackEnabled: Boolean = true
    ) = TestView(context).apply {
        this.isEnabled = isEnabled
        this.isSoundEffectsEnabled = isSoundEffectsEnabled
        this.isHapticFeedbackEnabled = isHapticFeedbackEnabled
    }
}