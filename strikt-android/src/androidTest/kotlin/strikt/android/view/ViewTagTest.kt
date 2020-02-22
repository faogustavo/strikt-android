package strikt.android.view

import org.junit.Test
import strikt.android.BaseTestClass
import strikt.android.R
import strikt.api.expectCatching
import strikt.api.expectThat
import strikt.assertions.failed
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.message

class ViewTagTest : BaseTestClass() {

    @Test
    fun hasTag_withTag_shouldSucceed() {
        val expectedValue = "Hello World"

        val view = mockView(tag = expectedValue)

        expectThat(view).hasTag(expectedValue)
    }

    @Test
    fun hasTag_withoutTag_shouldFail() {
        val view = mockView()

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has tag "Hello World" : found null""".trimMargin()
        expectCatching { expectThat(view).hasTag("Hello World") }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasTag_withKeyAndTag_shouldSucceed() {
        val tagWithKey = R.string.app_name to "Hello World"

        val view = mockView(tagWithKey = tagWithKey)

        expectThat(view).hasTag(tagWithKey)
    }

    @Test
    fun hasTag_withKeyAndWithoutTag_shouldFail() {
        val key = R.string.app_name
        val view = mockView(
            tagWithKey = key to "Hello World"
        )

        val expectedMessage =
            """▼ Expect that TestView():
            |  ✗ has tag $key with value "Other Tag" : found "Hello World"""".trimMargin()
        expectCatching { expectThat(view).hasTag(key to "Other Tag") }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun tag_shouldReturnTagProperty() {
        val tag = "Hello World"
        val view = mockView(tag = tag)

        expectThat(view)
            .tag
            .isEqualTo(tag)
    }

    fun mockView(
        tag: Any? = null,
        tagWithKey: Pair<Int, Any>? = null
    ) = TestView(context).apply {
        tag?.let { this.tag = it }
        tagWithKey?.let { this.setTag(it.first, it.second) }
    }
}