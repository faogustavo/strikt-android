package strikt.android.bundle

import android.os.Bundle
import strikt.api.Assertion

fun Assertion.Builder<Bundle>.hasKey(key: String) =
    assert("has key $key") { if (it.containsKey(key)) pass() else fail() }

fun Assertion.Builder<Bundle>.hasKeyWithValue(pair: Pair<String, Any?>) =
    assert("has key '${pair.first}' with value '${pair.second}'", expected = pair) {
        if (it.containsKey(pair.first)) {
            val value = it.get(pair.first)
            if (value == pair.second) {
                pass()
            } else {
                fail(actual = value)
            }
        } else {
            fail(description = "Key does not exists in the bundle")
        }
    }

fun Assertion.Builder<Bundle>.isEmpty() =
    assert("is empty") { if (it.isEmpty) pass() else fail() }

fun Assertion.Builder<Bundle>.hasSize(size: Int) =
    assert("has size $size", expected = size) {
        val currentSize = it.size()
        if (currentSize == size) pass() else fail(actual = currentSize)
    }