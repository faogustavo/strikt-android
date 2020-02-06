package strikt.android

import android.net.Uri
import org.junit.Test
import strikt.android.uri.isUri
import strikt.api.expectThat

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

    private fun mockUri(): Uri = Uri.EMPTY.buildUpon()
        .scheme("https")
        .authority("banana.net")
        .appendPath("coconunt")
        .appendPath("kiwi")
        .appendQueryParameter("size", "big")
        .appendQueryParameter("spice", "pepper")
        .build()

}