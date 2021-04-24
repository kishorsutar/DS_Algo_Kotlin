package com.kishor.kotlin.algo.dp


fun isMatch(fileName: String, pattern: String): Boolean {
    val sLen = fileName.length
    val pLen = pattern.length

    // base cases
    if (pattern == fileName || pattern == "*") return true
    if (pattern.isEmpty() || fileName.isEmpty()) return false

    // init all matrix except [0][0] element as False
    val d = Array(pLen + 1) { BooleanArray(sLen + 1) }
    d[0][0] = true

    // DP compute
    for (pIdx in 1 until pLen + 1) {
        // the current character in the pattern is '*'
        if (pattern[pIdx - 1] == '*') {
            var sIdx = 1
            // d[p_idx - 1][s_idx - 1] is a string-pattern match
            // on the previous step, i.e. one character before.
            // Find the first idx in string with the previous math.
            while (!d[pIdx - 1][sIdx - 1] && sIdx < sLen + 1) sIdx++
            // If (string) matches (pattern),
            // when (string) matches (pattern)* as well
            d[pIdx][sIdx - 1] = d[pIdx - 1][sIdx - 1]
            // If (string) matches (pattern),
            // when (string)(whatever_characters) matches (pattern)* as well
            while (sIdx < sLen + 1) d[pIdx][sIdx++] = true
        } else if (pattern[pIdx - 1] == '?') {
            for (sIdx in 1 until sLen + 1) d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1]
        } else {
            for (sIdx in 1 until sLen + 1) {
                // Match is possible if there is a previous match
                // and current characters are the same
                d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1] &&
                        pattern[pIdx - 1] == fileName[sIdx - 1]
            }
        }
    }
    return d[pLen][sLen]
}
