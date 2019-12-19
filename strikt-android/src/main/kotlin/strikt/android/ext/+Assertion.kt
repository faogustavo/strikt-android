package strikt.android.ext

import strikt.api.Assertion
import strikt.api.AtomicAssertion

fun <T> Assertion.Builder<T>.simpleAssert(
    description: String,
    check: AtomicAssertion.(T) -> Boolean
) = assert(description) { if (check(it)) pass() else fail() }