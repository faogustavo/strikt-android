package strikt.android.uri

import android.net.Uri
import strikt.api.Assertion

@Suppress("UNCHECKED_CAST")
fun Assertion.Builder<String>.isUri(): Assertion.Builder<Uri> = assert("is Uri") {
    try {
        Uri.parse(it)
        pass()
    } catch (e: Exception) {
        fail("cannot parse to Uri")
    }
}.get { Uri.parse(this) }

fun Assertion.Builder<Uri>.hasScheme(
    scheme: String
): Assertion.Builder<Uri> = assert("has scheme %s", expected = scheme) { uri ->
    if (scheme == uri.scheme) {
        pass()
    } else {
        fail(description = "found ${uri.scheme}")
    }
}