package common

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