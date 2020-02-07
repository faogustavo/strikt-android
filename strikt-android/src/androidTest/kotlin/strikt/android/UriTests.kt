package strikt.android

import android.net.Uri
import org.junit.Test
import strikt.android.uri.*
import strikt.api.expectCatching
import strikt.api.expectThat
import strikt.assertions.failed
import strikt.assertions.isEqualTo
import strikt.assertions.message

class UriTests {

    @Test
    fun stringIsUri_succeed() {
        val mockUri = mockUri().toString()

        expectThat(mockUri).isUri()
    }

    @Test
    fun stringUri_withScheme_shouldSucceed() {
        val mockUri = mockUri().toString()

        expectThat(mockUri)
            .isUri()
            .hasScheme("https")
    }

    @Test
    fun stringUri_withScheme_shouldFail() {
        val mockUri = mockUri().toString()

        val expectedMessage =
            """▼ Expect that "https://banana.net/coconut/kiwi?size=big&spice=pepper#green":
            |  ✓ is Uri
            |  ▼ https://banana.net/coconut/kiwi?size=big&spice=pepper#green:
            |    ▼ with scheme:
            |      ✗ is equal to "http" : found "https"""".trimMargin()

        expectCatching {
            expectThat(mockUri)
                .isUri()
                .hasScheme("http")
        }.failed()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun stringUri_withAuthority_shouldSucceed() {
        val mockUri = mockUri().toString()

        expectThat(mockUri)
            .isUri()
            .hasAuthority("banana.net")
    }

    @Test
    fun stringUri_withAuthority_shouldFail() {
        val mockUri = mockUri().toString()

        val expectedMessage =
            """▼ Expect that "https://banana.net/coconut/kiwi?size=big&spice=pepper#green":
            |  ✓ is Uri
            |  ▼ https://banana.net/coconut/kiwi?size=big&spice=pepper#green:
            |    ▼ with authority:
            |      ✗ is equal to "kiwi.net" : found "banana.net"""".trimMargin()

        expectCatching {
            expectThat(mockUri)
                .isUri()
                .hasAuthority("kiwi.net")
        }.failed()
            .message
            .isEqualTo(expectedMessage)

    }

    @Test
    fun stringUri_withPathSegment_shouldSucceed() {
        val mockUri = mockUri().toString()

        expectThat(mockUri)
            .isUri()
            .hasPathSegment("kiwi")
    }

    @Test
    fun stringUri_withMultiplePathSegments_shouldSucceed() {
        val mockUri = mockUri().toString()

        expectThat(mockUri)
            .isUri()
            .hasPathSegment("kiwi")
            .hasPathSegment("coconut")
    }

    @Test
    fun stringUri_withPathSegment_shouldFail() {
        val mockUri = mockUri().toString()

        val expectedMessage =
            """▼ Expect that "https://banana.net/coconut/kiwi?size=big&spice=pepper#green":
                |  ✓ is Uri
                |  ▼ https://banana.net/coconut/kiwi?size=big&spice=pepper#green:
                |    ▼ with path:
                |      ✗ contains "strawberry"""".trimMargin()

        expectCatching {
            expectThat(mockUri)
                .isUri()
                .hasPathSegment("strawberry")
        }.failed()
            .message
            .isEqualTo(expectedMessage)

    }

    @Test
    fun stringUri_withPath_shouldSucceed() {
        val mockUri = mockUri().toString()

        expectThat(mockUri)
            .isUri()
            .hasPath("/coconut/kiwi")
    }

    @Test
    fun stringUri_withPath_shouldFail() {
        val mockUri = mockUri().toString()

        val expectedMessage =
            """▼ Expect that "https://banana.net/coconut/kiwi?size=big&spice=pepper#green":
            |  ✓ is Uri
            |  ▼ https://banana.net/coconut/kiwi?size=big&spice=pepper#green:
            |    ▼ "/coconut/kiwi":
            |      ✗ is equal to "/kiwi/coconut" : found "/coconut/kiwi"""".trimMargin()

        expectCatching {
            expectThat(mockUri)
                .isUri()
                .hasPath("/kiwi/coconut")
        }.failed()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun stringUri_withQueryParameterName_shouldSucceed() {
        val mockUri = mockUri().toString()

        expectThat(mockUri)
            .isUri()
            .hasQueryParameter("size")
    }

    @Test
    fun stringUri_withQueryParameterName_shouldFail() {
        val mockUri = mockUri().toString()

        val expectedMessage =
            """▼ Expect that "https://banana.net/coconut/kiwi?size=big&spice=pepper#green":
            |  ✓ is Uri
            |  ▼ https://banana.net/coconut/kiwi?size=big&spice=pepper#green:
            |    ▼ query parameters:
            |      ✗ contains "quantity"""".trimMargin()

        expectCatching {
            expectThat(mockUri)
                .isUri()
                .hasQueryParameter("quantity")
        }
            .failed()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun stringUri_withQueryParameterNameAndValue_shouldSucceed() {
        val mockUri = mockUri().toString()

        expectThat(mockUri)
            .isUri()
            .hasQueryParameter("size", "big")
    }

    @Test
    fun stringUri_withMultipleQueryParameterNames_shouldSucceed() {
        val mockUri = mockUri().toString()

        expectThat(mockUri)
            .isUri()
            .hasQueryParameter("size")
            .hasQueryParameter("spice")
    }

    @Test
    fun stringUri_withMultipleQueryParameterNamesAndValues_shouldSucceed() {
        val mockUri = mockUri().toString()

        expectThat(mockUri)
            .isUri()
            .hasQueryParameter("size", "big")
            .hasQueryParameter("spice", "pepper")
    }

    @Test
    fun stringUri_withQueryParameterNameAndValue_shouldFail() {
        val mockUri = mockUri().toString()

        val expectedMessage =
            """▼ Expect that "https://banana.net/coconut/kiwi?size=big&spice=pepper#green":
            |  ✓ is Uri
            |  ▼ https://banana.net/coconut/kiwi?size=big&spice=pepper#green:
            |    ▼ query parameters:
            |      ✓ contains "spice"
            |    ▼ query parameter value:
            |      ✓ is not null
            |      ✗ is equal to "salt" : found "pepper"""".trimMargin()

        expectCatching {
            expectThat(mockUri)
                .isUri()
                .hasQueryParameter("spice", "salt")
        }.failed()
            .message
            .isEqualTo(expectedMessage)
    }

    @Test
    fun stringUri_withFragment_shouldSucceed() {
        val mockUri = mockUri().toString()

        expectThat(mockUri)
            .isUri()
            .hasFragment("green")
    }

    @Test
    fun stringUri_withFragment_shouldFail() {
        val mockUri = mockUri().toString()

        val expectedMessage =
            """▼ Expect that "https://banana.net/coconut/kiwi?size=big&spice=pepper#green":
            |  ✓ is Uri
            |  ▼ https://banana.net/coconut/kiwi?size=big&spice=pepper#green:
            |    ▼ with fragment:
            |      ✗ is equal to "size" : found "green"""".trimMargin()

        expectCatching {
            expectThat(mockUri)
                .isUri()
                .hasFragment("size")
        }.failed()
            .message
            .isEqualTo(expectedMessage)
    }


    @Test
    fun all_failures() {
        val mockUri = mockUri().toString()

        val expectedMessage =
            """▼ Expect that "https://banana.net/coconut/kiwi?size=big&spice=pepper#green":
            |  ✓ is Uri
            |  ▼ https://banana.net/coconut/kiwi?size=big&spice=pepper#green:
            |    ▼ with scheme:
            |      ✗ is equal to "http" : found "https"
            |    ▼ with authority:
            |      ✗ is equal to "kiwi.net" : found "banana.net"
            |    ▼ with path:
            |      ✗ contains "strawberry"
            |    ▼ "/coconut/kiwi":
            |      ✗ is equal to "/kiwi/coconut" : found "/coconut/kiwi"
            |    ▼ query parameters:
            |      ✗ contains "quantity"
            |    ▼ query parameters:
            |      ✓ contains "size"
            |    ▼ query parameter value:
            |      ✓ is not null
            |      ✗ is equal to "salt" : found "big"
            |    ▼ with fragment:
            |      ✗ is equal to "size" : found "green"""".trimMargin()

        expectCatching {
            expectThat(mockUri)
                .isUri().and {
                    hasScheme("http")
                    hasAuthority("kiwi.net")
                    hasPathSegment("strawberry")
                    hasPath("/kiwi/coconut")
                    hasQueryParameter("quantity")
                    hasQueryParameter("size", "salt")
                    hasFragment("size")
                }
        }.failed()
            .message
            .isEqualTo(expectedMessage)

    }

    @Test
    fun all_success() {
        val mockUri = mockUri().toString()

        expectThat(mockUri)
            .isUri().and {
                hasScheme("https")
                hasAuthority("banana.net")
                hasPathSegment("coconut")
                hasPath("/coconut/kiwi")
                hasQueryParameter("spice")
                hasQueryParameter("size", "big")
                hasFragment("green")
            }
    }

    private fun mockUri(): Uri = Uri.EMPTY.buildUpon()
        .scheme("https")
        .authority("banana.net")
        .fragment("green")
        .appendPath("coconut")
        .appendPath("kiwi")
        .appendQueryParameter("size", "big")
        .appendQueryParameter("spice", "pepper")
        .fragment("green")
        .build()

}