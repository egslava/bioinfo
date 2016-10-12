package ru.egslava.bio.genes

import java.util.*

/**
 * Created by egslava on 23/08/16.
 */

object Fasta {

    fun parse(text: String) = text
        .substring(1)   // remove first ">"
        .split(">")
        .map {
            val strs = it.split("\n")
            val sequence = strs.takeLast(strs.size - 1).joinToString("")
            Record(strs[0], sequence, 100.0 * sequence.count { it == 'G' || it == 'C' } / sequence.length)
    }

    data class Record(
            val id: String,
            val sequence: CharSequence,
            val gcContent: Double
    ){
        fun renderAsResult() = String.format(Locale.US,  "%s\n%.5f", id, gcContent)
    }
}
