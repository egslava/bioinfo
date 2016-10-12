package ru.egslava.bio.genes

import java.security.InvalidAlgorithmParameterException
import java.security.InvalidParameterException
import java.util.*

/**
 * Created by egslava on 23/08/16.
 */

val now: Long get() = System.currentTimeMillis()
val random: Random get() = Random(now)
fun randomInt(min: Int, max: Int) = random.nextInt(max-min) + min
fun randomDna(size: Int) = String(CharArray(size) { "ACTG"[ random.nextInt(4)] })
fun randomDna(min: Int, max: Int) = String(CharArray(randomInt(min, max)) { "ACTG"[ random.nextInt(4)] })

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
 * This function implements Dynamic Programming algorithm for searching the longest commons substring.
 * https://en.wikipedia.org/wiki/Longest_common_substring_problem
 *
 * If this String = "string_stirling" and
 * @param other "substring"
 * @return "string"
 * @return null if no solution was found
 *
 */


// TODO: optimize when we're already near the right border and current max substring is longer than distance to right side:
// * - cur position. maxLength = 3. so in this pos we should go to short.length - maxLength
// --*-|
// ----|
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

val Char.complement2: Char get() = when (this){
    'A' -> 'T'
    'T' -> 'A'
    'G' -> 'C'
    'C' -> 'G'
    else -> throw InvalidParameterException("String contains invalid symbols")
}

//inline fun String.map( lambda: (Char) -> Char ) = String( CharArray(length) { lambda( this[it] ) } )


val complements = CharArray('Z'.toInt()){ when (it.toChar()){
    'A' -> 'T'
    'T' -> 'A'
    'G' -> 'C'
    'C' -> 'G'
    else -> '-'
}}

val Char.complement1: Char get() = complements[toInt()]

val String.reverseComplement3: String get() = String( CharArray(this.length) { this[this.length - it - 1].complement1 } )
val String.reverseComplement4: String get(){
    val thisLength = length
    return String( CharArray(thisLength) { this[thisLength - it - 1].complement1 })
}

val String.reverseComplement5: String get(){
    val thisLength = length - 1
    return String( CharArray(thisLength + 1) { this[thisLength - it].complement1 })
}

val String.reverseComplement6: String get(){
    val thisLength = length - 1
    val res = CharArray(thisLength + 1)
    for (i: Int in 0..(thisLength)){
        res[i] = this[thisLength - i].complement1
    }
    return String( res )
}
////

val String.reverseComplement7: String get() = String( CharArray(this.length) { this[this.length - it - 1].complement2 } )
val String.reverseComplement8: String get(){
    val thisLength = length
    return String( CharArray(thisLength) { this[thisLength - it - 1].complement2 })
}

val String.reverseComplement9: String get(){
    val thisLength = length - 1
    return String( CharArray(thisLength + 1) {
        this[thisLength - it].complement2
    })
}

val String.reverseComplement10: String get(){
    val thisLength = length
    val res = CharArray(thisLength)
    for (i: Int in 0..(thisLength -1)){
        res[i] = this[thisLength - i - 1].complement2
    }
    return String( res )
}

val String.reverseComplement11: String get(){
    val thisLength = length - 1
    return String( CharArray(thisLength + 1) {
        val complementedChar = this[thisLength - it].complement1
        if (complementedChar != '-') complementedChar else throw RuntimeException("${thisLength - 1} can not be in DNA")
    })
}

val String.reverseComplement14: String get(){
    val thisLength = length - 1
    return String( CharArray(thisLength + 1) { val complementedChar = this[thisLength - it].complement1; complementedChar})
}
/**
 *
 * This function implements Dynamic Programming algorithm for searching the longest commons subsequence.
 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 *
 * If this String = "submarine on ring" and
 * @param other "substring"
 * @return "string"
 * @return null if no solution was found
 *
 */
infix fun String.longestCommonSubsequence(other: String): String?{


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

    val result = StringBuilder(short.length)

    var maxLength = 0
    var maxIndexEnd = 0
    long.forEachIndexed { longIndex, longChar ->
        short.forEachIndexed { shortIndex, shortChar ->
            val lastLeft = if (shortIndex >= 1) lastGen[shortIndex - 1] else 0

            if (longChar != shortChar) {
                val nextLeft = if (shortIndex >= 1) nextGen[shortIndex - 1] else 0

                nextGen[shortIndex] = Math.max(nextLeft, lastGen[shortIndex])
                return@forEachIndexed
            }

            val currentLength = lastLeft + 1
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
