package strikt.android

import android.net.Uri
import org.junit.Test
import strikt.android.uri.hasScheme
import strikt.android.uri.isUri
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
            "▼ Expect that \"https://banana.net/coconunt/kiwi?size=big&spice=pepper\":\n" +
                    "  ✓ is Uri\n" +
                    "  ▼ https://banana.net/coconunt/kiwi?size=big&spice=pepper:\n" +
                    "    ✗ has scheme \"http\" : found https"

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
            "▼ Expect that \"https://banana.net/coconunt/kiwi?size=big&spice=pepper\":\n" +
                    "  ✓ is Uri\n" +
                    "  ▼ https://banana.net/coconunt/kiwi?size=big&spice=pepper:\n" +
                    "    ✗ has scheme \"http\" : found https"

        expectCatching {
            expectThat(mockUri)
                .isUri()
                .hasAuthority("kiwi.net")
        }.failed()
            .message
            .isEqualTo(expectedMessage)

    }

    private fun mockUri(): Uri = Uri.EMPTY.buildUpon()
        .scheme("https")
        .authority("banana.net")
        .appendPath("coconunt")
        .appendPath("kiwi")
        .appendQueryParameter("size", "big")
        .appendQueryParameter("spice", "pepper")
        .build()

}