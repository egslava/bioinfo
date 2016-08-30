package common

/**
 * Created by egslava on 23/08/16.
 */

object RnaCodonTable {
    fun getProt(codon: String) = when (codon.toUpperCase()) {
        "UUU", "UUC"                                -> 'F'
        "CUU", "UUA", "CUA", "CUC", "CUG", "UUG"    -> 'L'
        "AUU", "AUC", "AUA"                         -> 'I'
        "GUU", "GUC", "GUA", "GUG"                  -> 'V'
        "GCU", "GCC", "GCA", "GCG"                  -> 'A'
        "UGU", "UGC"                                -> 'C'
        "ACU", "ACC", "ACA", "ACG"                  -> 'T'
        "GGU", "GGC", "GGA", "GGG"                  -> 'G'
        "UCU", "UCC", "UCA", "UCG", "AGU", "AGC"    -> 'S'
        "CCU", "CCC", "CCA", "CCG"                  -> 'P'
        "CGU", "CGC", "CGA", "CGG", "AGA", "AGG"    -> 'R'
        "CAA", "CAG"                                -> 'Q'
        "UAU", "UAC"                                -> 'Y'
        "AUG"                                       -> 'M'
        "CAU", "CAC"                                -> 'H'
        "AAU", "AAC"                                -> 'N'
        "GAU", "GAC"                                -> 'D'
        "AAA", "AAG"                                -> 'K'
        "GAG", "GAA"                                -> 'E'

        "UAA", "UAG", "UGA" -> 0.toChar()
        "UGG" -> 'W'
        else -> throw RuntimeException("Invalid codon!")
    }

    fun rna2prot(rna: String) = rna.split(3).map{ getProt(it) }.joinToString("")
}