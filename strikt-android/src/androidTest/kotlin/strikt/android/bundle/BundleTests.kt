package strikt.android.bundle

import android.os.Bundle
import org.junit.Test
import strikt.api.expectCatching
import strikt.api.expectThat
import strikt.assertions.failed
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.message
import java.io.Serializable

class BundleTests {

    @Test
    fun hasKey_withKey_shouldSucceed() {
        val bundle = mockBundle(mapOf(
            "a" to "b"
        ))

        expectThat(bundle).hasKey("a")
    }


    @Test
    fun hasKey_withoutKey_shouldFail() {
        val bundle = mockBundle(mapOf(
            "a" to "b"
        ))

        val expectedMessage =
            """▼ Expect that Bundle[{a=b}]:
            |  ✗ has key c""".trimMargin()

        expectCatching { expectThat(bundle).hasKey("c") }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasKeyWithValue_withKeyAndValue_shouldSucceed() {
        val bundle = mockBundle(mapOf(
            "a" to "b"
        ))

        expectThat(bundle).hasKeyWithValue("a" to "b")
    }

    @Test
    fun hasKeyWithValue_withKeyAndWithoutValue_shouldFail() {
        val bundle = mockBundle(mapOf(
            "a" to "b"
        ))

        val expectedMessage =
            """▼ Expect that Bundle[{a=b}]:
            |  ✗ has key 'a' with value 'd' : found "b"""".trimMargin()

        expectCatching { expectThat(bundle).hasKeyWithValue("a" to "d") }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun hasKeyWithValue_withoutKey_shouldFail() {
        val bundle = mockBundle(mapOf(
            "a" to "b"
        ))

        val expectedMessage =
            """▼ Expect that Bundle[{a=b}]:
            |  ✗ has key 'c' with value 'd' : Key does not exists in the bundle""".trimMargin()

        expectCatching { expectThat(bundle).hasKeyWithValue("c" to "d") }
            .failed()
            .isA<AssertionError>()
            .message
            .isEqualTo(expectedMessage)
    }

    fun mockBundle(
        data: Map<String, Serializable>
    ) = Bundle().apply {
        data.forEach { key, value -> putSerializable(key, value) }
    }
}