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

class ViewPaddingTest : BaseTestClass() {

    @Test
    fun hasLeftPadding_withCorrectPadding_shouldSucceed() {
        val expectedPadding = 16

        val view = mockView(
            left = expectedPadding
        )

        expectThat(view).hasLeftPadding(expectedPadding)
    }

    @Test
    fun hasLeftPadding_withIncorrectPadding_shouldFail() {
        val view = mockView(
            left = 8
        )

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has left padding 16 : found 8""".trimMargin()
        expectCatching { expectThat(view).hasLeftPadding(16) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasRightPadding_withCorrectPadding_shouldSucceed() {
        val expectedPadding = 16

        val view = mockView(
            right = expectedPadding
        )

        expectThat(view).hasRightPadding(expectedPadding)
    }

    @Test
    fun hasRightPadding_withIncorrectPadding_shouldFail() {
        val view = mockView(
            right = 8
        )

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has right padding 16 : found 8""".trimMargin()
        expectCatching { expectThat(view).hasRightPadding(16) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasTopPadding_withCorrectPadding_shouldSucceed() {
        val expectedPadding = 16

        val view = mockView(
            top = expectedPadding
        )

        expectThat(view).hasTopPadding(expectedPadding)
    }

    @Test
    fun hasTopPadding_withIncorrectPadding_shouldFail() {
        val view = mockView(
            top = 8
        )

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has top padding 16 : found 8""".trimMargin()
        expectCatching { expectThat(view).hasTopPadding(16) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasBottomPadding_withCorrectPadding_shouldSucceed() {
        val expectedPadding = 16

        val view = mockView(
            bottom = expectedPadding
        )

        expectThat(view).hasBottomPadding(expectedPadding)
    }

    @Test
    fun hasBottomPadding_withIncorrectPadding_shouldFail() {
        val view = mockView(
            bottom = 8
        )

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has bottom padding 16 : found 8""".trimMargin()
        expectCatching { expectThat(view).hasBottomPadding(16) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasStartPadding_withCorrectPadding_shouldSucceed() {
        val expectedPadding = 16

        val view = mockView(
            left = expectedPadding
        )

        expectThat(view).hasStartPadding(expectedPadding)
    }

    @Test
    fun hasStartPadding_withIncorrectPadding_shouldFail() {
        val view = mockView(
            left = 8
        )

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has start padding 16 : found 8""".trimMargin()
        expectCatching { expectThat(view).hasStartPadding(16) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasEndPadding_withCorrectPadding_shouldSucceed() {
        val expectedPadding = 16

        val view = mockView(
            right = expectedPadding
        )

        expectThat(view).hasEndPadding(expectedPadding)
    }

    @Test
    fun hasEndPadding_withIncorrectPadding_shouldFail() {
        val view = mockView(
            right = 8
        )

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has end padding 16 : found 8""".trimMargin()
        expectCatching { expectThat(view).hasEndPadding(16) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun paddingLeft_shouldReturnPaddingLeftProperty() {
        val padding = 8
        val view = mockView(left = padding)

        expectThat(view)
            .paddingLeft
            .isEqualTo(padding)
    }

    @Test
    fun paddingTop_shouldReturnPaddingTopProperty() {
        val padding = 8
        val view = mockView(top = padding)

        expectThat(view)
            .paddingTop
            .isEqualTo(padding)
    }

    @Test
    fun paddingBottom_shouldReturnPaddingBottomProperty() {
        val padding = 8
        val view = mockView(bottom = padding)

        expectThat(view)
            .paddingBottom
            .isEqualTo(padding)
    }

    @Test
    fun paddingRight_shouldReturnPaddingRightProperty() {
        val padding = 8
        val view = mockView(right = padding)

        expectThat(view)
            .paddingRight
            .isEqualTo(padding)
    }

    private fun mockView(
        left: Int = 0,
        top: Int = 0,
        right: Int = 0,
        bottom: Int = 0
    ) = TestView(context).apply {
        setPadding(left, top, right, bottom)
    }
}