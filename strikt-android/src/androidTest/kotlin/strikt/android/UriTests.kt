package strikt.android

import android.net.Uri
import org.junit.Test
import strikt.android.uri.isUri
import strikt.api.expectThat

class UriTests {

    @Test
    fun stringIsUri_succeed() {
        val uri = mockUri().toString()

        expectThat(uri).isUri()
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