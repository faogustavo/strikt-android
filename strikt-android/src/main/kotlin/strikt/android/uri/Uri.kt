package strikt.android.uri

import android.net.Uri
import strikt.api.Assertion
import strikt.assertions.contains
import strikt.assertions.isEqualTo
import strikt.assertions.isNotNull

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

fun Assertion.Builder<Uri>.hasPath(
    path: String
): Assertion.Builder<Uri> = assert("has path %s", expected = path) { uri ->
    if (path == uri.path) {
        pass()
    } else {
        fail(description = "found ${uri.path}")
    }
}

fun Assertion.Builder<Uri>.hasFragment(
    fragment: String
): Assertion.Builder<Uri> = assert("has fragment %s", expected = fragment) { uri ->
    if (fragment == uri.fragment) {
        pass()
    } else {
        fail(description = "found ${uri.fragment}")
    }
}

fun Assertion.Builder<Uri>.hasQueryParameter(
    queryParamName: String,
    queryParamValue: String? = null
): Assertion.Builder<Uri> =
    compose("has query param %s", expected = queryParamName) {
        get { queryParameterNames }.contains(queryParamName)
        if (queryParamValue != null) {
            get { getQueryParameter(queryParamName) }.isNotNull().isEqualTo(queryParamValue)
        }
    } then {
        if (allPassed) {
            pass()
        } else {
            fail()
        }
    }
