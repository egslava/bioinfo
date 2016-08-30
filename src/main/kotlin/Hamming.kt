/**
 * Created by egslava on 3/7/16.
 * http://rosalind.info/problems/list-view/
 */


object Hamming{
    val dataset = """
        ACATTTAAACTATGAGACGCGTAATGGAAATACATAAATATAATATTGGCCTGAAGAAATATAGCAAGATTGTCATGATAGTGCAGTACGCTGCTGAACAGTTGACCAAAGGATAGGTTGCGGTGTCTTCGCCGTACCACCATGATCTATTCCCGGTCCTGGTATATCGAGATGTGTGAAGTGCAGTCGATCCTCCCTCGAAATTTCCATTATATTCCTGACAACCTGTGGGCCCTACTAGTTATCGTAATTTTTTATGTACTTCAGGGCGCCCCGCAGACCCGGATATTGCGCAACCGGGGTTGTCCATTGCCCTTGATTCCAAAGCGTCGCGCCTGCGTCCCGTTCAGGGTCTATAGCGGTATCGGGCATACAGCCTTTTATGAACCCGGTTATCAAACATTCTACTGTGCATCAGTTCACGGCAAGAGATGCGAAGTATCTCGTCCTAAAAAGGTTGTACATAAAAGACCTTCCCCAGAAGTATCGTAACCGTATCACACTAGTGACCATAGCACGCTGAACCCCTGATTTATATTAACACAACATGGAAGCTAAGGCCACGTCGGACCCCCGCGTGACCGATCACATTTAAATACCACTTATTAGAAACGATAGCTGCAGCCGGACGAGCGTTGCACTGAGAACGGCTTCCGGAATGGGCGCCATGGTCCCAGGACTGTGGGGGATAGAGGGTCTTTCACGACAGCTATTGCTGGTTGCTCTGTCACACGATTTACAAGTGTCTCACTGGAACGATGCACAGAACCGATACAAACGGCGCACGTGTAGACCCTATGGCCCACGGATACGGAGTGACCTCCGCAAGACCGAGACATAGCTATGCTGGGGGGCGCTCCGACACCCCACCTAAAAGCCGTATCGGCACGAATTCAGTCCATGTGTAACGTAACGGGCCCCATTTTTATACACCCGTTGATTGACTATCGGACACCTAGTTGGAAGGACGGGGTCTTACGGCGA
        ACATTAGCTCTCAGAGAGGCCTAATGAGGCTATTCCATGAGCAGGCTGGTGATTGTTGCTCTCAAACCAAGTTGAGGAAAAGCTAGTACGCTGATTTACTCCAGAGGGTAAGTTGGGACACGGAGTATCAGCCGTACTGCATAAATCCACTACTGCGACTCGCTTATCGAAATGCCTAGAACTCGGACCCGACTCCACCTGTATGTAGTTCGCATTACTTTAAGGCCGCCGCATCTACTTGTGGCGGGACTTATTCATGGGTACCCATGGCACCTCGAATCCTGGAGGGAGCCCAACCGGCTGTGCCAATGCTACGCGCCAACAATGCCTGCAGGCCGTGTCCAGCCTACGTTTTACAGAAGTCCCGATCACACGGGCAGTTACTATCCTGATTAGGAAACAATCTAAGTTATAGCTAAACCCGGTAAGTCTCGAGAAATGGCGCATAAGAAAACGCAGCTATGTCGAAATCGTTGCCCAGAAGAATCGTCATATCCAAAGCCGAGCGAACATATGCCACATCTCGACTCCTTTAGAATGCACCCAGGAGGTGGAATAGGTAACAAGCGGCACCCTTCTGCTCAGTCACTGTGCAACTCCTCTTCTACTGGTCGGCAGCGTCAGCAACAGGTGTGTGATTCTGAGATACAAGTCCCAACTGGTCTCCTTGACATGCGAAATATCGCGTGTGATGTTGAATTCAATATAGCGAACCCTGGACGATTCTCGTCACTAGTTAAAACAGTTCCCAGGTTACCATGGATGGGACTACTTATAGGGTCCACACCGCCGACGCGATAGTAACGGGTCGAGCTGAGAACGCTCGAAGGACGCGAGATGCCTACGGAGGGGCATTCTCTCATAATCCGCTTTAGGGAACCAGGGTATTGCACCCACTCCATGAGACACCGTGATGAAGCCTTACCTATCCACACTTTTATTACCGATCGCACACCGTGTCGCCATTAATTGGCGTTACGGCGA
    """.trimIndent().trim().split("\n")

    infix fun String.hamming(other: String) = foldIndexed(0) {i, value, char -> value + if (char == other[i] ) 0 else 1 }


//    fun String.hamming(other: String) = compa
    @JvmStatic fun main(args: Array<String>) {
        println(dataset[0] hamming dataset[1])
//        dataset.forEachIndexed { i, c ->  }
//        println ("$a $c $g $t")
    }
}
