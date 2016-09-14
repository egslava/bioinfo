package common

import java.security.InvalidAlgorithmParameterException

/**
 * Created by egslava on 23/08/16.
 */

fun String.split(size: Int) = Array( length / size){
    substring (it * size, (it+1)* size )
}

fun String.split2(size: Int) = Array( (length + size - 1)/ size){
    substring (it * size, Math.min ( (it+1)* size, length ) )
}

fun String.findWithOverlaps(substring: String) = "(?=${substring})".toRegex().findAll(this)

/**
 * https://en.wikipedia.org/wiki/Hamming_distance
 * Remeber: strings should have the same length!
 * */
infix fun String.hamming(other: String): Int {
    if (length != other.length) throw InvalidAlgorithmParameterException("Can not calculate hamming distance! Strings '$this' and '$other' have different length")

    return foldIndexed(0) { i, value, char ->
        value + if (char == other[i]) 0 else 1
    }
}

/**
 *
 * That function implements Dynamic Programming algorithm for searching the longest commons substring.
 * https://en.wikipedia.org/wiki/Longest_common_substring_problem
 *
 * If this String = "string_stirling" and
 * @param other "substring"
 * @return "string"
 * @return null if no solution was found
 *
 */
infix fun String.longestCommonSubstring(other: String): String?{


    if (this.isEmpty() || other.isEmpty()) return null

    val short: String  // short then long
    val long: String  // long then short

    if (length > other.length){
        short = other
        long = this
    } else {
        short = this
        long = other
    }

    var lastGen = IntArray(short.length)
    var nextGen = IntArray(short.length)
    fun swapGens() {
        var forSwap: IntArray = lastGen
        lastGen = nextGen
        nextGen = forSwap
    }

    var maxLength = 0
    var maxIndexEnd = 0
    long.forEachIndexed { longIndex, longChar ->
        short.forEachIndexed { shortIndex, shortChar ->
            if (longChar != shortChar) {
                nextGen[shortIndex] = 0
                return@forEachIndexed
            }

            val currentLength =
                    if (shortIndex >= 1)
                        lastGen[shortIndex - 1] + 1
                    else 1
            nextGen[shortIndex] = currentLength

            if (currentLength > maxLength) {
                maxLength = currentLength
                maxIndexEnd = shortIndex
            }
        }

        swapGens()
    }

    if (maxLength == 0) {
        return null
    } else {
        return short.substring(maxIndexEnd + 1 - maxLength, maxIndexEnd + 1)
    }


}

/**
 * https://en.wikipedia.org/wiki/Hamming_distance
 * Strings should have the same length!
 * */
//infix fun String.levenstein(other: String): Int {
