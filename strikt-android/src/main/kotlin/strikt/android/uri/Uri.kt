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
    schemeValue: String
): Assertion.Builder<Uri> = and {
    get { scheme }
        .describedAs("with scheme")
        .isEqualTo(schemeValue)
}

fun Assertion.Builder<Uri>.hasAuthority(
    authorityValue: String
): Assertion.Builder<Uri> =
    and {
        get { authority }
            .describedAs("with authority")
            .isEqualTo(authorityValue)
    }

fun Assertion.Builder<Uri>.hasPathSegment(
    pathSegment: String
): Assertion.Builder<Uri> = and {
    get { pathSegments }
        .describedAs("with path")
        .contains(pathSegment)
}

fun Assertion.Builder<Uri>.hasPath(
    pathValue: String
): Assertion.Builder<Uri> = and {
    get { path }
        .isEqualTo(pathValue)
}

fun Assertion.Builder<Uri>.hasFragment(
    fragmentValue: String
): Assertion.Builder<Uri> = and {
    get { fragment }
        .describedAs("with fragment")
        .isEqualTo(fragmentValue)
}

fun Assertion.Builder<Uri>.hasQueryParameter(
    queryParamName: String,
    queryParamValue: String? = null
): Assertion.Builder<Uri> = and {
    get { queryParameterNames }
        .describedAs("query parameters")
        .contains(queryParamName)
    if (queryParamValue != null) {
        get { getQueryParameter(queryParamName) }
            .describedAs("query parameter value")
            .isNotNull()
            .isEqualTo(queryParamValue)
    }
}
