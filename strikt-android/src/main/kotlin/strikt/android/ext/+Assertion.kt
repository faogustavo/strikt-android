package strikt.android.ext

import strikt.api.AtomicAssertion

fun Boolean.passIfTrue(assertion: AtomicAssertion) {
    if (this) assertion.pass() else assertion.fail()
}