package strikt.android.view

import android.widget.TextView
import org.junit.Before
import org.junit.Test
import strikt.android.BaseTestClass
import strikt.api.expectCatching
import strikt.api.expectThat
import strikt.assertions.*

class ViewRelativesTests : BaseTestClass() {

    private val parent = TestContainer(context, "parent")
    private val parentWithoutChild = TestContainer(context, "parent-no-child")
    private val child = TestView(context, "child")
    private val viewWithoutParent = TestView(context, "no-parent")

    @Before
    fun setUp() {
        parent.addView(child)
    }

    @Test
    fun hasParent_withParent_shouldSucceed() {
        expectThat(child).hasParent(parent)
        expectThat(viewWithoutParent).not().hasParent(parent)
    }

    @Test
    fun hasParent_withoutParent_shouldFail() {
        val expectedMessage =
            """▼ Expect that TestView(no-parent):
            |  ✗ has parent TestContainer(parent)""".trimMargin()

        expectCatching { expectThat(viewWithoutParent).hasParent(parent) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasChild_shouldSucceed() {
        expectThat(parent).hasChild()
    }

    @Test
    fun hasChild_withoutChild_shouldFail() {
        val expectedMessage =
            """▼ Expect that TestContainer(parent-no-child):
            |  ✗ has a child""".trimMargin()

        expectCatching { expectThat(parentWithoutChild).hasChild() }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasChildCount_shouldSucceed() {
        expectThat(parent).hasChildCount(1)
    }

    @Test
    fun hasChildCount_withWrongValue_shouldFail() {
        val expectedMessage =
            """▼ Expect that TestContainer(parent):
            |  ✗ has 6 child : found 1""".trimMargin()

        expectCatching { expectThat(parent).hasChildCount(6) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasChild_withView_shouldSucceed() {
        expectThat(parent).hasChild(child)
    }

    @Test
    fun hasChild_withOtherView_shouldFail() {
        val expectedMessage =
            """▼ Expect that TestContainer(parent):
            |  ✗ has child TestView(no-parent)""".trimMargin()

        expectCatching { expectThat(parent).hasChild(viewWithoutParent) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasChild_withType_shouldSucceed() {
        expectThat(parent).hasChild(TestView::class.java)
    }

    @Test
    fun hasChild_withoutType_shouldFail() {
        val expectedMessage =
            """▼ Expect that TestContainer(parent):
            |  ✗ has child with type class android.widget.TextView""".trimMargin()

        expectCatching { expectThat(parent).hasChild(TextView::class.java) }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun parent_returnsParentProperty() {
        expectThat(child)
            .parent
            .isNotNull()
            .isEqualTo(parent)

        expectThat(viewWithoutParent)
            .parent
            .isNull()
    }
}