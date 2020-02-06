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

fun Assertion.Builder<Uri>.hasAuthority(
    authority: String
): Assertion.Builder<Uri> = assert("has authority %s", expected = authority) { uri ->
    if (authority == uri.authority) {
        pass()
    } else {
        fail(description = "found ${uri.authority}")
    }
}

fun Assertion.Builder<Uri>.hasPathSegment(
    pathSegment: String
): Assertion.Builder<Uri> = assert("has path segment %s", expected = pathSegment) { uri ->
    if (pathSegment in uri.pathSegments) {
        pass()
    } else {
        fail(description = "found ${uri.pathSegments}")
    }
}