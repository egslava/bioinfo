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
 * https://en.wikipedia.org/wiki/Hamming_distance
 * Strings should have the same length!
 * */
//infix fun String.levenstein(other: String): Int {
